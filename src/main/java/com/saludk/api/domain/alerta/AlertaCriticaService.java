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

    public AlertaCritica crearAlerta(Long idHistorial, String nivel, String descripcion) {
        HistorialMedico historial = historialRepo.findById(idHistorial)
                .orElseThrow(() -> new RuntimeException("Historial no encontrado"));

        AlertaCritica alerta = new AlertaCritica();
        alerta.setHistorial(historial);
        alerta.setNivel(nivel);
        alerta.setDescripcion(descripcion);
        alerta.setEstado("ACTIVA");

        return alertaRepo.save(alerta);
    }

    public AlertaCritica resolverAlerta(Long idAlerta) {
        AlertaCritica alerta = alertaRepo.findById(idAlerta)
                .orElseThrow(() -> new RuntimeException("Alerta no encontrada"));

        alerta.setEstado("RESUELTA");
        alerta.setFechaResolucion(LocalDateTime.now());

        return alertaRepo.save(alerta);
    }

    public List<AlertaCritica> obtenerAlertasActivas() {
        return alertaRepo.findByEstado("ACTIVA");
    }
}
