package com.saludk.api.domain.cita;

import java.time.LocalDateTime;

public record DatosCrearCita(
        Long idPaciente,
        Long idMedico,
        LocalDateTime fecha,
        String tipo
) { }
