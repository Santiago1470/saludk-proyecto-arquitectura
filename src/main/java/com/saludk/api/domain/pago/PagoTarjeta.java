package com.saludk.api.domain.pago;

public class PagoTarjeta implements MetodoPago {
    @Override
    public void procesarPago(Double total) {
        System.out.println("Procesando pago con tarjeta por: " + total);
    }
}
