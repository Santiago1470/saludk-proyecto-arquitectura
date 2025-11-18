package com.saludk.api.domain.suscripcion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanSuscripcionRepository extends JpaRepository<PlanSuscripcion, Long> {}
