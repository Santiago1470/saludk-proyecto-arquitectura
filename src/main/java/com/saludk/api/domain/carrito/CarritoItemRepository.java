package com.saludk.api.domain.carrito;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarritoItemRepository extends JpaRepository<CarritoItem, Long> {
    List<CarritoItem> findByIdCarrito(Long idCarrito);
    void deleteByIdCarritoAndIdProducto(Long idCarrito, Long idProducto);

    @Query("SELECT p.nombre AS producto, SUM(i.cantidad) AS total " +
            "FROM CompraItem i JOIN i.producto p " +
            "GROUP BY p.id ORDER BY total DESC")
    List<Object[]> kpiProductosMasVendidos();
}