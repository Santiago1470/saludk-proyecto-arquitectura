package com.saludk.api.domain.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosUsuarioAuth(
        @NotNull
        @NotBlank
        String login,

        @NotNull
        @NotBlank
        String clave
) {
}
