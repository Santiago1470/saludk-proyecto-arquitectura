package com.saludk.api.domain.compra;

import com.saludk.api.domain.carrito.*;
import com.saludk.api.domain.pago.MetodoPago;
import com.saludk.api.domain.pago.MetodoPagoFactory;
import com.saludk.api.domain.producto.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepo;

    @Autowired
    private CompraItemRepository compraItemRepo;

    @Autowired
    private CarritoRepository carritoRepo;

    @Autowired
    private CarritoItemRepository carritoItemRepo;

    @Autowired
    private ProductoRepository productoRepo;

    @Transactional
    public Compra realizarCheckout(Long idPaciente, String metodoPago) {
        Carrito carrito = carritoRepo.findByIdPaciente(idPaciente)
                .orElseThrow(() -> new RuntimeException("Carrito vacío o no existe"));

        List<CarritoItem> items = carritoItemRepo.findByIdCarrito(carrito.getId());
        if (items.isEmpty()) throw new RuntimeException("Carrito vacío");

        double total = 0.0;
        Compra compra = new Compra();
        compra.setIdPaciente(idPaciente);
        compra.setMetodoPago(metodoPago);
        compra.setTotal(0.0);
        compra = compraRepo.save(compra);

        for (CarritoItem ci : items) {
            var prod = productoRepo.findById(ci.getIdProducto())
                    .orElseThrow(() -> new RuntimeException("Producto no existe: " + ci.getIdProducto()));

            double subtotal = prod.getPrecio() * ci.getCantidad();

            CompraItem ciCompra = new CompraItem();
            ciCompra.setIdCompra(compra.getId());
            ciCompra.setIdProducto(prod.getId());
            ciCompra.setCantidad(ci.getCantidad());
            ciCompra.setSubtotal(subtotal);

            compraItemRepo.save(ciCompra);
            total += subtotal;
        }

        compra.setTotal(total);
        compra = compraRepo.save(compra);

        MetodoPago metodo = MetodoPagoFactory.crear(metodoPago);
        metodo.procesarPago(total);

        carritoItemRepo.deleteAll(items);

        return compra;
    }

    public List<CompraItem> obtenerItemsCompra(Long idCompra) {
        return compraItemRepo.findByIdCompra(idCompra);
    }
}
