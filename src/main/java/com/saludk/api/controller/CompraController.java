package com.saludk.api.controller;

import com.saludk.api.domain.compra.CompraService;
import com.saludk.api.domain.compra.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compra")
@SecurityRequirement(name = "bearer-key")
public class CompraController {

    @Autowired
    private CompraService service;

    @PostMapping("/checkout")
    public ResponseEntity<CompraResumenDTO> checkout(@RequestBody CheckoutDTO dto) {
        var compra = service.realizarCheckout(dto.idPaciente(), dto.metodoPago());
        return ResponseEntity.ok(new CompraResumenDTO(compra.getId(), compra.getIdPaciente(), compra.getTotal()));
    }

    @GetMapping("/{idCompra}/items")
    public ResponseEntity<?> items(@PathVariable Long idCompra) {
        return ResponseEntity.ok(service.obtenerItemsCompra(idCompra));
    }
}
