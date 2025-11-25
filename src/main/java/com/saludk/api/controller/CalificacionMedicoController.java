package com.saludk.api.controller;

import com.saludk.api.domain.calificacion.CalificacionMedicoService;
import com.saludk.api.domain.calificacion.DatosCalificarMedico;
import com.saludk.api.domain.calificacion.CalificacionMedico;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calificaciones-medico")
@SecurityRequirement(name = "bearer-key")
public class CalificacionMedicoController {

    @Autowired
    private CalificacionMedicoService service;

    @PostMapping
    public DatosCalificarMedico calificarMedico(@RequestBody DatosCalificarMedico datos) {
        return service.calificar(datos);
    }
}
