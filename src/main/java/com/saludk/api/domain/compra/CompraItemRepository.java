package com.saludk.api.domain.compra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraItemRepository extends JpaRepository<CompraItem, Long> {
    List<CompraItem> findByIdCompra(Long idCompra);

    @Query(value = """
    SELECT p.nombre AS producto, SUM(i.cantidad) AS total
    FROM compra_item i
    JOIN producto_farmaceutico p ON p.id_producto = i.id_producto
    GROUP BY p.id_producto, p.nombre
    ORDER BY total DESC
""", nativeQuery = true)
    List<Object[]> kpiProductosMasVendidos();
}
