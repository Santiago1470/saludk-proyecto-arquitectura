package com.saludk.api.domain.cita;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import java.time.LocalTime;

public record DatosCrearCita(

        @Schema(example = "1")
        Long idPaciente,

        @Schema(example = "5")
        Long idMedico,

        @Schema(example = "2025-11-23")
        LocalDate fecha,

        @Schema(example = "08:30")
        LocalTime hora,

        @Schema(example = "Consulta General")
        String tipo
) { }
