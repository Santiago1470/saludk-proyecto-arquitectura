package com.saludk.api.domain.historial;

import com.saludk.api.domain.alerta.AlertaCriticaService;
import com.saludk.api.domain.medico.Medico;
import com.saludk.api.domain.medico.MedicoRepository;
import com.saludk.api.domain.observer.Observador;
import com.saludk.api.domain.paciente.Paciente;
import com.saludk.api.domain.paciente.PacienteRepository;
import com.saludk.api.domain.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class HistorialMedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private AlertaCriticaService alertaService;

    @Autowired
    private HistorialMedicoRepository historialRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private Observador notificacionService;

    public HistorialMedico registrarEvento(Long idPaciente, TipoEvento tipo, String descripcion, String resultados, boolean valorCritico, Long idMedico) {

        Paciente paciente = pacienteRepository.findById(idPaciente)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado con id: " + idPaciente));
        Medico medico = null;

        if (idMedico != null) {
            medico = medicoRepository.findById(idMedico)
                    .orElseThrow(() -> new RuntimeException("Médico no encontrado con id: " + idMedico));
        }

        HistorialMedico registro = new HistorialMedico();
        registro.setPaciente(paciente);
        registro.setTipoEvento(tipo);
        registro.setDescripcion(descripcion);
        registro.setResultados(resultados);
        registro.setFechaRegistro(LocalDateTime.now());
        registro.setMedicoResponsable(medico);

        registro.agregarObservador(notificacionService);

        registro.registrarEvento("Nuevo evento médico registrado: " + descripcion, registro);

        if (valorCritico) {
            registro.setValorCritico(true);
            registro.setTipoAlerta("ALERTA: Resultado fuera de rango");

            historialRepository.save(registro);

            alertaService.crearAlerta(
                    registro.getId(),
                    "ALTA",
                    "Resultado crítico detectado: " + descripcion
            );
        }


        return historialRepository.save(registro);
    }

    public List<HistorialMedico> obtenerHistorialPorPaciente(Long idPaciente) {
        return historialRepository.findByPacienteId(idPaciente);
    }

    public List<HistorialMedico> obtenerAlertasCriticas() {
        return historialRepository.findByValorCriticoTrue();
    }

    public List<HistorialMedico> obtenerAlertasCriticasPorPaciente(Long idPaciente) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Long idLogueado = ((Usuario)auth.getPrincipal()).getId();
        Paciente paciente = pacienteRepository.findById(idPaciente)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado con id: " + idPaciente));

        if (!idLogueado.equals(paciente.getUsuario().getId())) {
            throw new AccessDeniedException("Acceso no autorizado");
        }
        return historialRepository.findByValorCriticoTrueAndPacienteId(paciente.getId());
    }
}
