package com.saludk.api.domain.paciente;

import com.saludk.api.domain.usuario.UsuarioDTO;

public record PacienteDTO(
        Long id,
        String cedula,
        String telefono,
        String direccion,
        String tipoSangre,
        String alergias,
        String estadoRegistro,
        UsuarioDTO usuario
) {}
