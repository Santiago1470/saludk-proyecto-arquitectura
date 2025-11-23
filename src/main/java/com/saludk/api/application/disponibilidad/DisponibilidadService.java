package com.saludk.api.application.disponibilidad;

import com.saludk.api.domain.disponibilidad.DatosCrearDisponibilidad;
import com.saludk.api.domain.disponibilidad.DisponibilidadMedico;
import com.saludk.api.domain.disponibilidad.DisponibilidadMedicoRepository;
import com.saludk.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisponibilidadService {

    @Autowired
    private DisponibilidadMedicoRepository disponibilidadRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    public DisponibilidadMedico crear(DatosCrearDisponibilidad datos) {

        var medico = medicoRepository.findById(datos.idMedico())
                .orElseThrow(() -> new RuntimeException("Médico no encontrado"));

        if (!datos.horaInicio().isBefore(datos.horaFin())) {
            throw new RuntimeException("La hora de inicio debe ser menor que la hora de fin");
        }

        var disponibilidadesExistentes = disponibilidadRepository
                .findByMedicoIdAndFecha(medico.getId(), datos.fecha());

        boolean seSolapa = disponibilidadesExistentes.stream().anyMatch(d ->
                datos.horaInicio().isBefore(d.getHoraFin()) &&
                        d.getHoraInicio().isBefore(datos.horaFin())
        );

        if (seSolapa) {
            throw new RuntimeException("El rango de horas se solapa con una disponibilidad ya registrada");
        }

        boolean duplicadaExacta = disponibilidadesExistentes.stream().anyMatch(d ->
                d.getHoraInicio().equals(datos.horaInicio()) &&
                        d.getHoraFin().equals(datos.horaFin())
        );

        if (duplicadaExacta) {
            throw new RuntimeException("Esta disponibilidad ya está registrada");
        }

        DisponibilidadMedico disponibilidad = new DisponibilidadMedico();
        disponibilidad.setMedico(medico);
        disponibilidad.setFecha(datos.fecha());
        disponibilidad.setHoraInicio(datos.horaInicio());
        disponibilidad.setHoraFin(datos.horaFin());

        return disponibilidadRepository.save(disponibilidad);
    }

    public List<DisponibilidadMedico> listarPorMedico(Long idMedico) {
        return disponibilidadRepository.findByMedicoId(idMedico);
    }
}
