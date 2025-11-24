package com.saludk.api.domain.cita;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Long> {

    List<Cita> findByMedicoIdAndFechaBetween(Long idMedico, LocalDateTime inicio, LocalDateTime fin);

    @Query("SELECT c.tipo AS tipo, COUNT(c) AS total " +
            "FROM Cita c GROUP BY c.tipo ORDER BY total DESC")
    List<Object[]> kpiConsultasMasDemandadas();

    @Query("SELECT c.medico.id AS medicoId, COUNT(c) AS total " +
            "FROM Cita c GROUP BY c.medico.id ORDER BY total DESC")
    List<Object[]> kpiMedicosMasSolicitados();

    @Query("SELECT c.paciente.id AS pacienteId, COUNT(c) AS total " +
            "FROM Cita c GROUP BY c.paciente.id HAVING COUNT(c) > 1")
    List<Object[]> kpiPacientesRecurrentes();
}
