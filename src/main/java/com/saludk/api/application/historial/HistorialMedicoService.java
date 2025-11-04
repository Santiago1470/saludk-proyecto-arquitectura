package com.saludk.api.application.historial;

import com.saludk.api.domain.historial.*;
import com.saludk.api.domain.notificacion.NotificacionService;
import com.saludk.api.domain.observer.Observador;
import com.saludk.api.domain.paciente.Paciente;
import com.saludk.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class HistorialMedicoService {

    @Autowired
    private HistorialMedicoRepository historialRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private Observador notificacionService;

    public HistorialMedico registrarEvento(Long idPaciente, TipoEvento tipo, String descripcion, String resultados, boolean valorCritico, String medicoResponsable) {

        Paciente paciente = pacienteRepository.findById(idPaciente)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado con id: " + idPaciente));

        HistorialMedico registro = new HistorialMedico();
        registro.setPaciente(paciente);
        registro.setTipoEvento(tipo);
        registro.setDescripcion(descripcion);
        registro.setResultados(resultados);
        registro.setFechaRegistro(LocalDateTime.now());
        registro.setMedicoResponsable(medicoResponsable);

        registro.agregarObservador(notificacionService);

        registro.registrarEvento("Nuevo evento médico registrado: " + descripcion, registro);

        if (valorCritico) {
            registro.setValorCritico(true);
            registro.setTipoAlerta("ALERTA: Resultado fuera de rango");
        }

        return historialRepository.save(registro);
    }

    public List<HistorialMedico> obtenerHistorialPorPaciente(Long idPaciente) {
        return historialRepository.findByPacienteId(idPaciente);
    }

    public List<HistorialMedico> obtenerAlertasCriticas() {
        return historialRepository.findByValorCriticoTrue();
    }
}
