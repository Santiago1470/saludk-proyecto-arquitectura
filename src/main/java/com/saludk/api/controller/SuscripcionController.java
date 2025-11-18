package com.saludk.api.controller;

import com.saludk.api.application.suscripcion.SuscripcionService;
import com.saludk.api.domain.suscripcion.DatosCrearSuscripcion;
import com.saludk.api.domain.suscripcion.SuscripcionPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/suscripcion")
public class SuscripcionController {

    @Autowired
    private SuscripcionService service;

    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody DatosCrearSuscripcion datos) {
        try {
            SuscripcionPaciente suscripcion = service.crearSuscripcion(datos);
            return ResponseEntity.ok(suscripcion);

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/activa/{idPaciente}")
    public ResponseEntity<?> obtenerActiva(@PathVariable Long idPaciente) {

        SuscripcionPaciente suscripcion = service.obtenerSuscripcionActiva(idPaciente);

        if (suscripcion == null) {
            return ResponseEntity.ok("El paciente no tiene una suscripción activa.");
        }

        return ResponseEntity.ok(suscripcion);
    }

    @PostMapping("/cancelar/{idSuscripcion}")
    public ResponseEntity<?> cancelar(@PathVariable Long idSuscripcion) {

        try {
            SuscripcionPaciente sus = service.cancelarSuscripcion(idSuscripcion);
            return ResponseEntity.ok(sus);

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
