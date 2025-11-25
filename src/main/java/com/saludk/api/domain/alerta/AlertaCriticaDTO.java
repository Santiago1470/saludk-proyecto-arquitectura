package com.saludk.api.domain.alerta;

import java.time.LocalDateTime;

public record AlertaCriticaDTO(
        Long id,
        String nivel,
        String descripcion,
        String estado,
        LocalDateTime fechaCreacion,
        LocalDateTime fechaResolucion,
        Long historialId,
        Long pacienteId,
        Long usuarioId
) {}
