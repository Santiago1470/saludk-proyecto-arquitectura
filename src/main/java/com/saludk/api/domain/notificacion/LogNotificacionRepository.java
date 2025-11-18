package com.saludk.api.domain.notificacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogNotificacionRepository extends JpaRepository<LogNotificacion, Long> {
}
