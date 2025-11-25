package com.saludk.api.controller;

import com.saludk.api.domain.paciente.PacienteDTO;
import com.saludk.api.domain.paciente.PacienteService;
import com.saludk.api.domain.registro.RegistroPacienteFacade;
import com.saludk.api.domain.paciente.Paciente;
import com.saludk.api.domain.paciente.DatosRegistroPaciente;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
@SecurityRequirement(name = "bearer-key")
public class PacienteController {

    private final RegistroPacienteFacade registroPacienteFacade;
    private final PacienteService pacienteService;

    public PacienteController(RegistroPacienteFacade registroPacienteFacade, PacienteService pacienteService) {
        this.registroPacienteFacade = registroPacienteFacade;
        this.pacienteService = pacienteService;
    }

//    @PostMapping("/registro")
//    public ResponseEntity<PacienteDTO> registrarNuevoPaciente(@RequestBody DatosRegistroPaciente datos) {
//        PacienteDTO nuevo = registroPacienteFacade.registrarNuevoPaciente(datos);
//        return ResponseEntity.ok(nuevo);
//    }

    @PostMapping
    public ResponseEntity<PacienteDTO> registrarPaciente(
            @RequestParam Long idUsuario,
            @RequestParam String cedula,
            @RequestParam(required = false) String telefono,
            @RequestParam(required = false) String direccion,
            @RequestParam(required = false) String tipoSangre,
            @RequestParam(required = false) String alergias) {

        PacienteDTO nuevo = pacienteService.registrarPaciente(idUsuario, cedula, telefono, direccion, tipoSangre, alergias);
        return ResponseEntity.ok(nuevo);
    }

    @GetMapping
    public ResponseEntity<List<PacienteDTO>> listarPacientes() {
        return ResponseEntity.ok(pacienteService.listarPacientes());
    }

    @GetMapping("/{cedula}")
    public ResponseEntity<PacienteDTO> obtenerPorCedula(@PathVariable String cedula) {
        return ResponseEntity.ok(pacienteService.obtenerPorCedula(cedula));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteDTO> actualizarPaciente(
            @PathVariable Long id,
            @RequestParam(required = false) String telefono,
            @RequestParam(required = false) String direccion,
            @RequestParam(required = false) String tipoSangre,
            @RequestParam(required = false) String alergias) {

        return ResponseEntity.ok(
                pacienteService.actualizarPaciente(id, telefono, direccion, tipoSangre, alergias)
        );
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<Void> cambiarEstado(@PathVariable Long id, @RequestParam String nuevoEstado) {
        pacienteService.cambiarEstado(id, nuevoEstado);
        return ResponseEntity.noContent().build();
    }
}
