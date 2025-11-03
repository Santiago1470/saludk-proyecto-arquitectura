package com.saludk.api.controller;

import com.saludk.api.application.registro.RegistroPacienteFacade;
import com.saludk.api.domain.paciente.Paciente;
import com.saludk.api.domain.paciente.dto.DatosRegistroPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/registro")
public class RegistroController {

    @Autowired
    private RegistroPacienteFacade registroFacade;

    @PostMapping("/paciente")
    public ResponseEntity<Paciente> registrarNuevoPaciente(@Valid @RequestBody DatosRegistroPaciente datos) {
        Paciente paciente = registroFacade.registrarNuevoPaciente(datos);
        return ResponseEntity.ok(paciente);
    }
}
