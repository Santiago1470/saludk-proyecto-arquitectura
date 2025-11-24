package com.saludk.api.domain.historial;

import org.springframework.web.bind.annotation.RequestParam;

public record CrearHistorialMedicoDTO(
        Long idPaciente,
        TipoEvento tipo,
        String descripcion,
        String resultados,
        boolean valorCritico,
        Long medicoResponsable
) {
}
