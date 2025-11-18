package com.saludk.api.domain.carrito;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarritoItemRepository extends JpaRepository<CarritoItem, Long> {
    List<CarritoItem> findByIdCarrito(Long idCarrito);
    void deleteByIdCarritoAndIdProducto(Long idCarrito, Long idProducto);
}