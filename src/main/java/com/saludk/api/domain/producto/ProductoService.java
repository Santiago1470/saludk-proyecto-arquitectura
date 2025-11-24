package com.saludk.api.domain.producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository repo;

    public Producto crear(CrearProductoDTO dto) {
        Producto p = new Producto();
        p.setNombre(dto.nombre());
        p.setPrecio(dto.precio());
        p.setIngredientes(dto.ingredientes());
        p.setEfectosSecundarios(dto.efectosSecundarios());
        return repo.save(p);
    }

    public List<Producto> listar() { return repo.findAll(); }

    public Producto obtener(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    public Producto actualizar(Long id, CrearProductoDTO dto) {
        var p = obtener(id);
        p.setNombre(dto.nombre());
        p.setPrecio(dto.precio());
        p.setIngredientes(dto.ingredientes());
        p.setEfectosSecundarios(dto.efectosSecundarios());
        return repo.save(p);
    }

    public void borrar(Long id) {
        repo.deleteById(id);
    }
}
