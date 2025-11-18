package com.saludk.api.domain.suscripcion;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SuscripcionPacienteRepository extends JpaRepository<SuscripcionPaciente, Long> {

    Optional<SuscripcionPaciente> findByIdPacienteAndEstado(Long idPaciente, String estado);
}
