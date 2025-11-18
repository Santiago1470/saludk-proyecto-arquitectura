package com.saludk.api.controller;

import com.saludk.api.application.cita.CitaService;
import com.saludk.api.domain.cita.Cita;
import com.saludk.api.domain.cita.DatosCrearCita;
import com.saludk.api.domain.cita.DatosRespuestaCita;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/citas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @PostMapping
    public ResponseEntity<DatosRespuestaCita> agendar(@RequestBody DatosCrearCita datos) {

        Cita cita = citaService.agendarCita(datos);

        return ResponseEntity.ok(new DatosRespuestaCita(
                cita.getId(),
                "Cita agendada correctamente"
        ));
    }
}
