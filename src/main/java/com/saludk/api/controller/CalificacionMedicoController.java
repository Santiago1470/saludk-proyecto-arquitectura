package com.saludk.api.controller;

import com.saludk.api.domain.calificacion.CalificacionMedicoService;
import com.saludk.api.domain.calificacion.DatosCalificarMedico;
import com.saludk.api.domain.calificacion.CalificacionMedico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calificaciones-medico")
public class CalificacionMedicoController {

    @Autowired
    private CalificacionMedicoService service;

    @PostMapping
    public CalificacionMedico calificarMedico(@RequestBody DatosCalificarMedico datos) {
        return service.calificar(datos);
    }
}
