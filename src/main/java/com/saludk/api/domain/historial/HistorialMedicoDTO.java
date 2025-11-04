package com.saludk.api.domain.historial;
import java.time.LocalDateTime;

public record HistorialMedicoDTO(
        Long id,
        String tipoEvento,
        String descripcion,
        String resultados,
        LocalDateTime fechaRegistro,
        Boolean valorCritico
) {
    public static HistorialMedicoDTO from(HistorialMedico entity) {
        return new HistorialMedicoDTO(
                entity.getId(),
                entity.getTipoEvento().name(),
                entity.getDescripcion(),
                entity.getResultados(),
                entity.getFechaRegistro(),
                entity.getValorCritico()
        );
    }
}
