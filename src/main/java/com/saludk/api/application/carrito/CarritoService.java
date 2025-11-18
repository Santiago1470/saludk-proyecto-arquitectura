package com.saludk.api.application.carrito;

import com.saludk.api.domain.carrito.*;
import com.saludk.api.domain.producto.Producto;
import com.saludk.api.domain.producto.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarritoService {

    @Autowired
    private CarritoRepository carritoRepo;

    @Autowired
    private CarritoItemRepository itemRepo;

    @Autowired
    private ProductoRepository productoRepo;

    public Carrito obtenerOCrearCarrito(Long idPaciente) {
        return carritoRepo.findByIdPaciente(idPaciente).orElseGet(() -> {
            Carrito c = new Carrito();
            c.setIdPaciente(idPaciente);
            return carritoRepo.save(c);
        });
    }

    @Transactional
    public CarritoItem agregarItem(Long idPaciente, Long idProducto, Integer cantidad) {
        Producto producto = productoRepo.findById(idProducto)
                .orElseThrow(() -> new RuntimeException("Producto no existe"));

        Carrito carrito = obtenerOCrearCarrito(idPaciente);

        List<CarritoItem> items = itemRepo.findByIdCarrito(carrito.getId());
        for (CarritoItem it : items) {
            if (it.getIdProducto().equals(idProducto)) {
                it.setCantidad(it.getCantidad() + (cantidad != null ? cantidad : 1));
                return itemRepo.save(it);
            }
        }

        CarritoItem nuevo = new CarritoItem();
        nuevo.setIdCarrito(carrito.getId());
        nuevo.setIdProducto(idProducto);
        nuevo.setCantidad(cantidad == null ? 1 : cantidad);
        return itemRepo.save(nuevo);
    }

    public List<CarritoItem> listarItems(Long idPaciente) {
        Carrito carrito = carritoRepo.findByIdPaciente(idPaciente).orElse(null);
        if (carrito == null) return List.of();
        return itemRepo.findByIdCarrito(carrito.getId());
    }

    @Transactional
    public void removerItem(Long idPaciente, Long idProducto) {
        Carrito carrito = carritoRepo.findByIdPaciente(idPaciente)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado"));
        itemRepo.deleteByIdCarritoAndIdProducto(carrito.getId(), idProducto);
    }

    @Transactional
    public void vaciarCarrito(Long idPaciente) {
        Carrito carrito = carritoRepo.findByIdPaciente(idPaciente)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado"));
        var items = itemRepo.findByIdCarrito(carrito.getId());
        itemRepo.deleteAll(items);
    }
}
