package com.saludk.api.domain.paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Optional<Paciente> findByCedula(String cedula);

    Optional<Paciente> findByUsuarioId(Long usuarioId);

    Optional<Paciente> findByPacienteId(Long pacienteId);

}
