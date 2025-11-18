package com.saludk.api.domain.cita;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Long> {

    List<Cita> findByMedicoIdAndFechaBetween(Long idMedico, LocalDateTime inicio, LocalDateTime fin);
}
