package com.saludk.api.domain.historial;
import com.saludk.api.domain.medico.Medico;
import com.saludk.api.domain.medico.MedicoDTO;
import com.saludk.api.domain.paciente.Paciente;
import com.saludk.api.domain.paciente.PacienteDTO;
import com.saludk.api.domain.usuario.Usuario;
import com.saludk.api.domain.usuario.UsuarioDTO;

import java.time.LocalDateTime;

public record HistorialMedicoDTO(
        Long id,
        LocalDateTime fechaRegistro,
        String tipoEvento,
        String descripcion,
        String resultados,
        Boolean valorCritico,
        String tipoAlerta,
        String archivoUrl,
        PacienteDTO paciente,
        MedicoDTO medico
) {

    public static HistorialMedicoDTO from(HistorialMedico h) {
        return new HistorialMedicoDTO(
                h.getId(),
                h.getFechaRegistro(),
                h.getTipoEvento().name(),
                h.getDescripcion(),
                h.getResultados(),
                h.getValorCritico(),
                h.getTipoAlerta(),
                h.getArchivoUrl(),
                toPaciente(h.getPaciente()),
                toMedico(h.getMedicoResponsable())
        );
    }

    private static PacienteDTO toPaciente(Paciente p) {
        if (p == null) return null;
        return new PacienteDTO(
                p.getId(),
                p.getCedula(),
                p.getTelefono(),
                p.getDireccion(),
                p.getTipoSangre(),
                p.getAlergias(),
                p.getEstadoRegistro(),
                toUsuario(p.getUsuario())
        );
    }

    private static MedicoDTO toMedico(Medico m) {
        if (m == null) return null;
        return new MedicoDTO(
                m.getId(),
                m.getEspecialidad(),
                toUsuario(m.getUsuario())
        );
    }

    private static UsuarioDTO toUsuario(Usuario u) {
        if (u == null) return null;
        return new UsuarioDTO(
                u.getId(),
                u.getNombre(),
                u.getApellido(),
                u.getEmail(),
                u.getRol().name()
        );
    }
}
