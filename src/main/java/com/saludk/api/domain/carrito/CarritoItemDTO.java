package com.saludk.api.domain.carrito;

public record CarritoItemDTO(Long idItem, Long idProducto, Integer cantidad) {
    public static CarritoItemDTO from(com.saludk.api.domain.carrito.CarritoItem i) {
        return new CarritoItemDTO(i.getId(), i.getIdProducto(), i.getCantidad());
    }
}