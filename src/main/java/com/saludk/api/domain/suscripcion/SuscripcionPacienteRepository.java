package com.saludk.api.domain.suscripcion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SuscripcionPacienteRepository extends JpaRepository<SuscripcionPaciente, Long> {

    Optional<SuscripcionPaciente> findByIdPacienteAndEstado(Long idPaciente, String estado);

    @Query("SELECT COUNT(s) FROM SuscripcionPaciente s")
    Long cantidadSuscripciones();
}
