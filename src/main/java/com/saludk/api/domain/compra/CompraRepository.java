package com.saludk.api.domain.compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

    @Query("SELECT SUM(c.total) FROM Compra c")
    Double kpiIngresosTotales();
}