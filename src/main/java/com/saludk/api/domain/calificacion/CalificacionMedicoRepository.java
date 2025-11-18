package com.saludk.api.domain.calificacion;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CalificacionMedicoRepository extends JpaRepository<CalificacionMedico, Long> {

    List<CalificacionMedico> findByMedicoId(Long idMedico);
}
