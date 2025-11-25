package com.saludk.api.domain.alerta;

import com.saludk.api.domain.historial.HistorialMedico;
import com.saludk.api.domain.historial.HistorialMedicoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AlertaCriticaService {

    private final AlertaCriticaRepository alertaRepo;
    private final HistorialMedicoRepository historialRepo;

    public AlertaCriticaService(AlertaCriticaRepository alertaRepo,
                                HistorialMedicoRepository historialRepo) {
        this.alertaRepo = alertaRepo;
        this.historialRepo = historialRepo;
    }

    private AlertaCriticaDTO convertirADTO(AlertaCritica alerta) {
        var historial = alerta.getHistorial();
        var paciente = historial.getPaciente();
        var usuario = paciente.getUsuario();

        return new AlertaCriticaDTO(
                alerta.getId(),
                alerta.getNivel(),
                alerta.getDescripcion(),
                alerta.getEstado(),
                alerta.getFechaCreacion(),
                alerta.getFechaResolucion(),
                historial.getId(),
                paciente.getId(),
                usuario.getId()
        );
    }

    public AlertaCriticaDTO crearAlerta(Long idHistorial, String nivel, String descripcion) {
        HistorialMedico historial = historialRepo.findById(idHistorial)
                .orElseThrow(() -> new RuntimeException("Historial no encontrado"));

        AlertaCritica alerta = new AlertaCritica();
        alerta.setHistorial(historial);
        alerta.setNivel(nivel);
        alerta.setDescripcion(descripcion);
        alerta.setEstado("ACTIVA");

        AlertaCritica guardada = alertaRepo.save(alerta);

        return convertirADTO(guardada);
    }

    public AlertaCriticaDTO resolverAlerta(Long idAlerta) {
        AlertaCritica alerta = alertaRepo.findById(idAlerta)
                .orElseThrow(() -> new RuntimeException("Alerta no encontrada"));

        alerta.setEstado("RESUELTA");
        alerta.setFechaResolucion(LocalDateTime.now());

        AlertaCritica guardada = alertaRepo.save(alerta);

        return convertirADTO(guardada);
    }

    public List<AlertaCriticaDTO> obtenerAlertasActivas() {
        return alertaRepo.findByEstado("ACTIVA")
                .stream()
                .map(this::convertirADTO)
                .toList();
    }
}
