package com.saludk.api.controller;

import com.saludk.api.application.historial.HistorialMedicoService;
import com.saludk.api.domain.historial.HistorialMedico;
import com.saludk.api.domain.historial.TipoEvento;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historial")
// @SecurityRequirement(name = "bearer-key")
public class HistorialMedicoController {

    @Autowired
    private HistorialMedicoService historialService;

    @PostMapping("/registrar")
    public ResponseEntity<HistorialMedico> registrarEvento(
            @RequestParam Long idPaciente,
            @RequestParam TipoEvento tipo,
            @RequestParam String descripcion,
            @RequestParam(required = false) String resultados,
            @RequestParam(defaultValue = "false") boolean valorCritico,
            @RequestParam(required = false) String medicoResponsable
    ) {
        HistorialMedico nuevo = historialService.registrarEvento(idPaciente, tipo, descripcion, resultados, valorCritico, medicoResponsable);
        return ResponseEntity.ok(nuevo);
    }

    @GetMapping("/paciente/{idPaciente}")
    public ResponseEntity<List<HistorialMedico>> obtenerHistorialPorPaciente(@PathVariable Long idPaciente) {
        List<HistorialMedico> historial = historialService.obtenerHistorialPorPaciente(idPaciente);
        return ResponseEntity.ok(historial);
    }

    @GetMapping("/alertas")
    public ResponseEntity<List<HistorialMedico>> obtenerAlertasCriticas() {
        List<HistorialMedico> alertas = historialService.obtenerAlertasCriticas();
        return ResponseEntity.ok(alertas);
    }
}
