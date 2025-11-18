package com.saludk.api.domain.pago;

public class MetodoPagoFactory {

    public static MetodoPago crear(String metodo) {
        return switch (metodo.toUpperCase()) {
            case "TARJETA" -> new PagoTarjeta();
            case "NEQUI" -> new PagoNequi();
            default -> throw new RuntimeException("Método de pago no soportado");
        };
    }
}
