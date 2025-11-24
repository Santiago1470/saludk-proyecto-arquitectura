package com.saludk.api.domain.calificacion;

import com.saludk.api.domain.medico.Medico;
import com.saludk.api.domain.medico.MedicoRepository;
import com.saludk.api.domain.paciente.Paciente;
import com.saludk.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalificacionMedicoService {

    @Autowired
    private CalificacionMedicoRepository calificacionRepo;

    @Autowired
    private MedicoRepository medicoRepo;

    @Autowired
    private PacienteRepository pacienteRepo;

    public CalificacionMedico calificar(DatosCalificarMedico datos) {

        Paciente paciente = pacienteRepo.findById(datos.idPaciente())
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        Medico medico = medicoRepo.findById(datos.idMedico())
                .orElseThrow(() -> new RuntimeException("Médico no encontrado"));

        if (datos.puntaje() < 1 || datos.puntaje() > 10) {
            throw new RuntimeException("El puntaje debe ser entre 1 y 10");
        }

        CalificacionMedico calificacion = new CalificacionMedico(
                medico, paciente, datos.puntaje(), datos.comentario()
        );

        calificacionRepo.save(calificacion);

        recalcularPromedio(medico);

        return calificacion;
    }

    private void recalcularPromedio(Medico medico) {
        List<CalificacionMedico> calificaciones = calificacionRepo.findByMedicoId(medico.getId());

        double promedio = calificaciones.stream()
                .mapToInt(CalificacionMedico::getPuntaje)
                .average()
                .orElse(0.0);

        medico.setCalificacionPromedio(promedio);
        medicoRepo.save(medico);
    }
}
