package com.saludk.api.domain.observer;

import com.saludk.api.domain.historial.HistorialMedico;

public interface Observador {
    void actualizar(String mensaje, HistorialMedico historial);
}