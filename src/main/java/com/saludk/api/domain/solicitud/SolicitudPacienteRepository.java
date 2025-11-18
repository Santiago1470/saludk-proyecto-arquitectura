package com.saludk.api.domain.solicitud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitudPacienteRepository extends JpaRepository<SolicitudPaciente, Long> {
}
