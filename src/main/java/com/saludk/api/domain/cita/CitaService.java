package com.saludk.api.domain.cita;

import com.saludk.api.domain.disponibilidad.DisponibilidadMedicoRepository;
import com.saludk.api.domain.medico.MedicoRepository;
import com.saludk.api.domain.paciente.PacienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    @Autowired
    private DisponibilidadMedicoRepository disponibilidadRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    public Cita agendarCita(DatosCrearCita datos) {

        var paciente = pacienteRepository.findById(datos.idPaciente())
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        var medico = medicoRepository.findById(datos.idMedico())
                .orElseThrow(() -> new RuntimeException("Médico no encontrado"));

        LocalDateTime fechaCita = LocalDateTime.of(datos.fecha(), datos.hora());

        LocalDate date = fechaCita.toLocalDate();

        var disponibilidades = disponibilidadRepository
                .findByMedicoIdAndFecha(medico.getId(), date);
        System.out.println(disponibilidades);
        if (disponibilidades.isEmpty()) {
            throw new RuntimeException("El médico no tiene disponibilidad ese día");
        }

        boolean horaValida = disponibilidades.stream()
                .anyMatch(d ->
                        fechaCita.toLocalTime().isAfter(d.getHoraInicio()) &&
                                fechaCita.toLocalTime().isBefore(d.getHoraFin())
                );

        if (!horaValida) {
            throw new RuntimeException("La hora no está dentro de la disponibilidad del médico");
        }

        var citaExistente = citaRepository.findByMedicoIdAndFechaBetween(
                medico.getId(),
                fechaCita,
                fechaCita.plusMinutes(30) // duración promedio de una cita médica
        );

        if (!citaExistente.isEmpty()) {
            throw new RuntimeException("La hora ya está reservada");
        }

        Cita cita = new Cita();
        cita.setPaciente(paciente);
        cita.setMedico(medico);
        cita.setFecha(fechaCita);
        cita.setTipo(datos.tipo());
        cita.setEstado("PROGRAMADA");

        return citaRepository.save(cita);
    }
}
