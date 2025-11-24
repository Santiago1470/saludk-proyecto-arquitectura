package com.saludk.api.controller;

import com.saludk.api.domain.historial.HistorialMedicoService;
import com.saludk.api.domain.historial.CrearHistorialMedicoDTO;
import com.saludk.api.domain.historial.HistorialMedico;
import com.saludk.api.domain.historial.HistorialMedicoDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historial")
@SecurityRequirement(name = "bearer-key")
@Secured({"ROLE_MEDICO", "ROLE_PACIENTE"})
public class HistorialMedicoController {

    @Autowired
    private HistorialMedicoService historialService;

    @PostMapping("/registrar")
    public ResponseEntity<HistorialMedicoDTO> registrarEvento(@RequestBody CrearHistorialMedicoDTO historialDTO) {
        HistorialMedico nuevo = historialService.registrarEvento(
                historialDTO.idPaciente(),
                historialDTO.tipo(),
                historialDTO.descripcion(),
                historialDTO.resultados(),
                historialDTO.valorCritico(),
                historialDTO.medicoResponsable());
        return ResponseEntity.ok(HistorialMedicoDTO.from(nuevo));
    }

    @GetMapping("/paciente/{idPaciente}")
    public ResponseEntity<List<HistorialMedicoDTO>> obtenerHistorialPorPaciente(@PathVariable Long idPaciente) {
        var historial = historialService.obtenerHistorialPorPaciente(idPaciente)
                .stream()
                .map(HistorialMedicoDTO::from)
                .toList();
        return ResponseEntity.ok(historial);
    }

    @GetMapping("/alertas")
    @Secured("ROLE_MEDICO")
    public ResponseEntity<List<HistorialMedicoDTO>> obtenerAlertasCriticas() {
        return ResponseEntity.ok(
                historialService.obtenerAlertasCriticas()
                        .stream()
                        .map(HistorialMedicoDTO::from)
                        .toList()
        );
    }

    @GetMapping("/alertas/{idPaciente}")
    public ResponseEntity<List<HistorialMedicoDTO>> obtenerAlertasCriticasPorPaciente(@PathVariable Long idPaciente) {
        return ResponseEntity.ok(
                historialService.obtenerAlertasCriticasPorPaciente(idPaciente)
                        .stream()
                        .map(HistorialMedicoDTO::from)
                        .toList()
        );
    }
}
