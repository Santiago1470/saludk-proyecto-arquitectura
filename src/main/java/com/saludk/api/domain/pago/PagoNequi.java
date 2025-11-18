package com.saludk.api.domain.pago;

public class PagoNequi implements MetodoPago {
    @Override
    public void procesarPago(Double total) {
        System.out.println("Procesando pago con Nequi por: " + total);
    }
}
