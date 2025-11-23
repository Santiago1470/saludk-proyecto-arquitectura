package com.saludk.api.domain.disponibilidad;

import java.time.LocalDate;
import java.time.LocalTime;

public record DatosCrearDisponibilidad(
        Long idMedico,
        LocalDate fecha,
        LocalTime horaInicio,
        LocalTime horaFin
) {}

