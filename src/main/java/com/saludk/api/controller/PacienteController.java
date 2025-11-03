package com.saludk.api.controller;

import com.saludk.api.application.paciente.PacienteService;
import com.saludk.api.application.registro.RegistroPacienteFacade;
import com.saludk.api.domain.paciente.Paciente;
import com.saludk.api.domain.paciente.dto.DatosRegistroPaciente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final RegistroPacienteFacade registroPacienteFacade;
    private final PacienteService pacienteService;

    public PacienteController(RegistroPacienteFacade registroPacienteFacade, PacienteService pacienteService) {
        this.registroPacienteFacade = registroPacienteFacade;
        this.pacienteService = pacienteService;
    }

    // Facade para crear usuario y paciente
    @PostMapping("/registro")
    public ResponseEntity<Paciente> registrarNuevoPaciente(@RequestBody DatosRegistroPaciente datos) {
        Paciente nuevo = registroPacienteFacade.registrarNuevoPaciente(datos);
        return ResponseEntity.ok(nuevo);
    }

    // POST: para crear paciente con usuario ya existente
    @PostMapping
    public ResponseEntity<Paciente> registrarPaciente(
            @RequestParam Long idUsuario,
            @RequestParam String cedula,
            @RequestParam(required = false) String telefono,
            @RequestParam(required = false) String direccion,
            @RequestParam(required = false) String tipoSangre,
            @RequestParam(required = false) String alergias) {

        Paciente nuevo = pacienteService.registrarPaciente(idUsuario, cedula, telefono, direccion, tipoSangre, alergias);
        return ResponseEntity.ok(nuevo);
    }

    /**
     * 🔹 Obtener todos los pacientes
     */
    @GetMapping
    public ResponseEntity<List<Paciente>> listarPacientes() {
        return ResponseEntity.ok(pacienteService.listarPacientes());
    }

    /**
     * 🔹 Buscar paciente por cédula
     */
    @GetMapping("/{cedula}")
    public ResponseEntity<Paciente> obtenerPorCedula(@PathVariable String cedula) {
        return ResponseEntity.ok(pacienteService.obtenerPorCedula(cedula));
    }

    /**
     * 🔹 Actualizar datos del paciente
     */
    @PutMapping("/{id}")
    public ResponseEntity<Paciente> actualizarPaciente(
            @PathVariable Long id,
            @RequestParam(required = false) String telefono,
            @RequestParam(required = false) String direccion,
            @RequestParam(required = false) String tipoSangre,
            @RequestParam(required = false) String alergias) {

        return ResponseEntity.ok(pacienteService.actualizarPaciente(id, telefono, direccion, tipoSangre, alergias));
    }

    /**
     * 🔹 Cambiar estado de registro del paciente
     */
    @PatchMapping("/{id}/estado")
    public ResponseEntity<Void> cambiarEstado(@PathVariable Long id, @RequestParam String nuevoEstado) {
        pacienteService.cambiarEstado(id, nuevoEstado);
        return ResponseEntity.noContent().build();
    }
}

