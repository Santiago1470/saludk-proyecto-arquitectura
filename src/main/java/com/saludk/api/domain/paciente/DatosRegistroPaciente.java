package com.saludk.api.domain.paciente.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosRegistroPaciente(
        @NotBlank String nombre,
        @Email String email,
        @NotBlank String clave,
        @NotBlank String cedula,
        String telefono,
        String direccion,
        String tipoSangre,
        String alergias
) {}
