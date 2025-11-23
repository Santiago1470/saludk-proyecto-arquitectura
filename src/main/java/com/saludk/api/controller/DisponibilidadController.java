package com.saludk.api.controller;

import com.saludk.api.application.disponibilidad.DisponibilidadService;
import com.saludk.api.domain.disponibilidad.DatosCrearDisponibilidad;
import com.saludk.api.domain.disponibilidad.DisponibilidadMedico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disponibilidades")
public class DisponibilidadController {

    @Autowired
    private DisponibilidadService disponibilidadService;

    @PostMapping
    public ResponseEntity<DisponibilidadMedico> crear(@RequestBody DatosCrearDisponibilidad datos) {
        var disponibilidad = disponibilidadService.crear(datos);
        return ResponseEntity.ok(disponibilidad);
    }

    @GetMapping("/medico/{idMedico}")
    public ResponseEntity<List<DisponibilidadMedico>> listar(@PathVariable Long idMedico) {
        return ResponseEntity.ok(disponibilidadService.listarPorMedico(idMedico));
    }
}
