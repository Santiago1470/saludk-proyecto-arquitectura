package com.saludk.api.controller;

import com.saludk.api.domain.alerta.AlertaCriticaService;
import com.saludk.api.domain.alerta.AlertaCritica;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alertas")
public class AlertaCriticaController {

    private final AlertaCriticaService alertaService;

    public AlertaCriticaController(AlertaCriticaService alertaService) {
        this.alertaService = alertaService;
    }

    @PostMapping("/crear")
    public ResponseEntity<AlertaCritica> crearAlerta(
            @RequestParam Long idHistorial,
            @RequestParam String nivel,
            @RequestParam String descripcion
    ) {
        return ResponseEntity.ok(alertaService.crearAlerta(idHistorial, nivel, descripcion));
    }

    @PatchMapping("/resolver/{idAlerta}")
    public ResponseEntity<AlertaCritica> resolver(@PathVariable Long idAlerta) {
        return ResponseEntity.ok(alertaService.resolverAlerta(idAlerta));
    }

    @GetMapping("/activas")
    public ResponseEntity<List<AlertaCritica>> activas() {
        return ResponseEntity.ok(alertaService.obtenerAlertasActivas());
    }
}
