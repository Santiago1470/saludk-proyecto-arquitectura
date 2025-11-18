package com.saludk.api.domain.compra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraItemRepository extends JpaRepository<CompraItem, Long> {
    List<CompraItem> findByIdCompra(Long idCompra);
}
