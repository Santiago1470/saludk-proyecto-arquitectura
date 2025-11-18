package com.saludk.api.domain.solicitud;

import java.sql.Timestamp;

public record DatosRespuestaSolicitud(
        Long idSolicitud,
        Long idPaciente,
        Timestamp fechaSolicitud,
        String estado,
        String motivo
) {}
