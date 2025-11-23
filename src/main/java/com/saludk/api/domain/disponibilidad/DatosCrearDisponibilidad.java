package com.saludk.api.domain.disponibilidad;

import java.time.LocalDate;
import java.time.LocalTime;
import io.swagger.v3.oas.annotations.media.Schema;

public record DatosCrearDisponibilidad(

        @Schema(example = "1")
        Long idMedico,

        @Schema(example = "2025-11-23")
        LocalDate fecha,

        @Schema(example = "08:00")
        LocalTime horaInicio,

        @Schema(example = "12:00")
        LocalTime horaFin
) {}

