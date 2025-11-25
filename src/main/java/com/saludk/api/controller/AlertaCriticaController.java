package com.saludk.api.controller;

import com.saludk.api.domain.alerta.AlertaCriticaDTO;
import com.saludk.api.domain.alerta.AlertaCriticaService;
import com.saludk.api.domain.alerta.AlertaCritica;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alertas")
@SecurityRequirement(name = "bearer-key")
public class AlertaCriticaController {

    private final AlertaCriticaService alertaService;

    public AlertaCriticaController(AlertaCriticaService alertaService) {
        this.alertaService = alertaService;
    }

//    @PostMapping("/crear")
//    public ResponseEntity<AlertaCriticaDTO> crearAlerta(
//            @RequestParam Long idHistorial,
//            @RequestParam String nivel,
//            @RequestParam String descripcion
//    ) {
//        return ResponseEntity.ok(alertaService.crearAlerta(idHistorial, nivel, descripcion));
//    }

    @PatchMapping("/resolver/{idAlerta}")
    public ResponseEntity<AlertaCriticaDTO> resolver(@PathVariable Long idAlerta) {
        return ResponseEntity.ok(alertaService.resolverAlerta(idAlerta));
    }

    @GetMapping("/activas")
    public List<AlertaCriticaDTO> listar() {
        return alertaService.obtenerAlertasActivas();
    }
}
