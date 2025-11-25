package com.saludk.api.controller;

import com.saludk.api.domain.paciente.PacienteDTO;
import com.saludk.api.domain.registro.RegistroMedicoFacade;
import com.saludk.api.domain.registro.RegistroPacienteFacade;
import com.saludk.api.domain.medico.DatosRegistroMedico;
import com.saludk.api.domain.medico.Medico;
import com.saludk.api.domain.paciente.Paciente;
import com.saludk.api.domain.paciente.DatosRegistroPaciente;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/registro")
@SecurityRequirement(name = "bearer-key")
public class RegistroController {

    @Autowired
    private RegistroPacienteFacade registroPacienteFacade;

    @Autowired
    private RegistroMedicoFacade registroMedicoFacade;

    @PostMapping("/paciente")
    public ResponseEntity<PacienteDTO> registrarNuevoPaciente(
            @Valid @RequestBody DatosRegistroPaciente datos) {

        PacienteDTO paciente = registroPacienteFacade.registrarNuevoPaciente(datos);
        return ResponseEntity.ok(paciente);
    }

    @PostMapping("/medico")
    public ResponseEntity<Medico> registrarNuevoMedico(
            @Valid @RequestBody DatosRegistroMedico datos) {

        Medico medico = registroMedicoFacade.registrarNuevoMedico(datos);
        return ResponseEntity.ok(medico);
    }
}

