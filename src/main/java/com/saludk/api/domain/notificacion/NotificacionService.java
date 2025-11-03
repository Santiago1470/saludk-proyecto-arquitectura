package com.saludk.api.domain.notificacion;

import com.saludk.api.domain.observer.Observador;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class NotificacionService implements Observador {

    @Async
    @Override
    public void actualizar(String mensaje) {
        try {
            // Por ahora por consola, se puede con SMS, correo, etc.
            Thread.sleep(1000); // procesamiento asíncrono (~1s máximo)
            System.out.println("(ASÍNCRONO) Notificación enviada: " + mensaje);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Error al enviar notificación: " + e.getMessage());
        }
    }
}
