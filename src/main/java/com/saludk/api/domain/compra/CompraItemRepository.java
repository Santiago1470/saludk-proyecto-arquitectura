package com.saludk.api.domain.compra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraItemRepository extends JpaRepository<CompraItem, Long> {
    List<CompraItem> findByIdCompra(Long idCompra);

    @Query("SELECT p.nombre AS producto, SUM(i.cantidad) AS total " +
            "FROM CompraItem i JOIN i.producto p " +
            "GROUP BY p.id ORDER BY total DESC")
    List<Object[]> kpiProductosMasVendidos();
}
