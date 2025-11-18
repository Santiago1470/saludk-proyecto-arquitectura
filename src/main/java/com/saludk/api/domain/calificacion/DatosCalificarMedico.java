package com.saludk.api.domain.calificacion;

public record DatosCalificarMedico(
        Long idMedico,
        Long idPaciente,
        int puntaje,
        String comentario
) {}
