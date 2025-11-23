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
