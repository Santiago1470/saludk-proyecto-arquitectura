package com.saludk.api.domain.disponibilidad;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface DisponibilidadMedicoRepository extends JpaRepository<DisponibilidadMedico, Long> {

    List<DisponibilidadMedico> findByMedicoIdAndFecha(Long idMedico, LocalDate fecha);
}
