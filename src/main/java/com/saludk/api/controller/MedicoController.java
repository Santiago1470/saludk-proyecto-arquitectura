package com.saludk.api.controller;

import com.saludk.api.application.medico.MedicoService;
import com.saludk.api.domain.medico.Medico;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
@SecurityRequirement(name = "bearer-key")
public class MedicoController {

    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @PostMapping
    public ResponseEntity<Medico> registrarMedico(
            @RequestParam Long idUsuario,
            @RequestParam String especialidad
    ) {
        return ResponseEntity.ok(
                medicoService.registrarMedico(idUsuario, especialidad)
        );
    }

    @GetMapping
    public ResponseEntity<List<Medico>> listarMedicos() {
        return ResponseEntity.ok(medicoService.listarMedicos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> obtenerMedico(@PathVariable Long id) {
        return ResponseEntity.ok(medicoService.obtenerMedico(id));
    }
}
