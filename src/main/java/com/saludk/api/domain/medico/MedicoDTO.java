package com.saludk.api.domain.medico;

import com.saludk.api.domain.usuario.UsuarioDTO;

public record MedicoDTO(
        Long id,
        String especialidad,
        UsuarioDTO usuario
) {}
