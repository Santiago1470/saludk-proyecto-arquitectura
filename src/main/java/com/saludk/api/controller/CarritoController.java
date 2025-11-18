package com.saludk.api.controller;

import com.saludk.api.application.carrito.CarritoService;
import com.saludk.api.domain.carrito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/carrito")
public class CarritoController {

    @Autowired
    private CarritoService service;

    @PostMapping("/agregar")
    public ResponseEntity<CarritoItemDTO> agregar(@RequestBody AgregarACarritoDTO dto) {
        var item = service.agregarItem(dto.idPaciente(), dto.idProducto(), dto.cantidad() == null ? 1 : dto.cantidad());
        return ResponseEntity.ok(CarritoItemDTO.from(item));
    }

    @GetMapping("/{idPaciente}")
    public ResponseEntity<List<CarritoItemDTO>> verCarrito(@PathVariable Long idPaciente) {
        var items = service.listarItems(idPaciente).stream().map(CarritoItemDTO::from).collect(Collectors.toList());
        return ResponseEntity.ok(items);
    }

    @DeleteMapping("/{idPaciente}/producto/{idProducto}")
    public ResponseEntity<Void> eliminarItem(@PathVariable Long idPaciente, @PathVariable Long idProducto) {
        service.removerItem(idPaciente, idProducto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{idPaciente}/vaciar")
    public ResponseEntity<Void> vaciar(@PathVariable Long idPaciente) {
        service.vaciarCarrito(idPaciente);
        return ResponseEntity.noContent().build();
    }
}
