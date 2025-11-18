package com.saludk.api.application.suscripcion;

import com.saludk.api.domain.suscripcion.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class SuscripcionService {

    @Autowired
    private SuscripcionPacienteRepository suscripcionRepository;

    @Autowired
    private PlanSuscripcionRepository planRepository;

    public SuscripcionPaciente crearSuscripcion(DatosCrearSuscripcion datos) {

        Optional<SuscripcionPaciente> susActiva =
                suscripcionRepository.findByIdPacienteAndEstado(datos.idPaciente(), "ACTIVA");

        if (susActiva.isPresent()) {
            throw new RuntimeException("El paciente ya tiene una suscripción activa.");
        }

        PlanSuscripcion plan = planRepository.findById(datos.idPlan())
                .orElseThrow(() -> new RuntimeException("Plan no encontrado"));

        SuscripcionPaciente suscripcion = new SuscripcionPaciente();
        suscripcion.setIdPaciente(datos.idPaciente());
        suscripcion.setPlan(plan);
        suscripcion.setFechaInicio(LocalDate.now());
        suscripcion.setFechaFin(LocalDate.now().plusMonths(1));
        suscripcion.setEstado("ACTIVA");

        return suscripcionRepository.save(suscripcion);
    }

    public SuscripcionPaciente cancelarSuscripcion(Long idSuscripcion) {

        SuscripcionPaciente suscripcion = suscripcionRepository.findById(idSuscripcion)
                .orElseThrow(() -> new RuntimeException("Suscripción no encontrada"));

        if (!suscripcion.getEstado().equals("ACTIVA")) {
            throw new RuntimeException("Solo se pueden cancelar suscripciones activas.");
        }

        suscripcion.setEstado("CANCELADA");
        return suscripcionRepository.save(suscripcion);
    }

    public void verificarVencimiento(Long idPaciente) {

        Optional<SuscripcionPaciente> susActiva =
                suscripcionRepository.findByIdPacienteAndEstado(idPaciente, "ACTIVA");

        if (susActiva.isPresent()) {

            SuscripcionPaciente suscripcion = susActiva.get();

            if (suscripcion.getFechaFin().isBefore(LocalDate.now())) {
                suscripcion.setEstado("VENCIDA");
                suscripcionRepository.save(suscripcion);
            }
        }
    }

    public SuscripcionPaciente obtenerSuscripcionActiva(Long idPaciente) {
        return suscripcionRepository.findByIdPacienteAndEstado(idPaciente, "ACTIVA")
                .orElse(null);
    }
}
