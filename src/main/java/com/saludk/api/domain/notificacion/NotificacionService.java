package com.saludk.api.domain.notificacion;

import com.saludk.api.domain.historial.HistorialMedico;
import com.saludk.api.domain.observer.Observador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class NotificacionService implements Observador {

    @Autowired
    private LogNotificacionRepository logRepository;

    @Async
    @Override
    public void actualizar(String mensaje, HistorialMedico historial) {
        try {
            Thread.sleep(1000);
            System.out.println("(ASÍNCRONO) Notificación enviada: " + mensaje);

            logRepository.save(new LogNotificacion(
                    historial,
                    "Sistema interno",
                    "Éxito",
                    null
            ));

        } catch (Exception e) {
            logRepository.save(new LogNotificacion(
                    historial,
                    "Sistema interno",
                    "Error",
                    e.getMessage()
            ));
            Thread.currentThread().interrupt();
        }
    }
}
