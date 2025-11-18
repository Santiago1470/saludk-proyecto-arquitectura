package com.saludk.api.domain.calificacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalificacionProductoRepository extends JpaRepository<CalificacionProducto, Long> {
    List<CalificacionProducto> findByIdProducto(Long idProducto);
}
