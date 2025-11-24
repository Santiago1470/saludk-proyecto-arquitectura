package com.saludk.api.controller;

import com.saludk.api.domain.solicitud.SolicitudPacienteService;
import com.saludk.api.domain.solicitud.DatosCrearSolicitud;
import com.saludk.api.domain.solicitud.SolicitudPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/solicitudes")
public class SolicitudPacienteController {

    @Autowired
    private SolicitudPacienteService solicitudService;

    @PostMapping
    public ResponseEntity<SolicitudPaciente> crearSolicitud(@RequestBody DatosCrearSolicitud datos) {
        var solicitud = solicitudService.crearSolicitud(datos);
        return ResponseEntity.ok(solicitud);
    }

}
