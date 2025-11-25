package com.saludk.api.controller;

import com.saludk.api.domain.producto.ProductoService;
import com.saludk.api.domain.producto.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/productos")
@SecurityRequirement(name = "bearer-key")
public class ProductoController {

    @Autowired
    private ProductoService service;

    @PostMapping
    public ResponseEntity<ProductoDTO> crear(@RequestBody CrearProductoDTO dto) {
        var p = service.crear(dto);
        return ResponseEntity.ok(ProductoDTO.from(p));
    }

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> listar() {
        System.out.println("Aqui entre en producto");
        var list = service.listar().stream().map(ProductoDTO::from).collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(ProductoDTO.from(service.obtener(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDTO> actualizar(@PathVariable Long id, @RequestBody CrearProductoDTO dto) {
        return ResponseEntity.ok(ProductoDTO.from(service.actualizar(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable Long id) {
        service.borrar(id);
        return ResponseEntity.noContent().build();
    }
}
