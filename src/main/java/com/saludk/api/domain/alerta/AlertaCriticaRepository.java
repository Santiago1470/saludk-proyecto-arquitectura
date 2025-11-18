package com.saludk.api.domain.alerta;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlertaCriticaRepository extends JpaRepository<AlertaCritica, Long> {
    List<AlertaCritica> findByEstado(String estado);
}
