package com.saludk.api.domain.usuario;

public record UsuarioDTO(
        Long id,
        String nombre,
        String apellido,
        String email,
        String rol
) {}
