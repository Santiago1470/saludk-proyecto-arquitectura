package com.saludk.api.domain.producto;

public record ProductoDTO(Long id, String nombre, Double precio, String ingredientes, String efectosSecundarios) {
    public static ProductoDTO from(Producto p) {
        return new ProductoDTO(p.getId(), p.getNombre(), p.getPrecio(), p.getIngredientes(), p.getEfectosSecundarios());
    }
}