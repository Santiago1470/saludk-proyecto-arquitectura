package com.saludk.api.domain.observer;

import com.saludk.api.domain.historial.HistorialMedico;

import java.util.ArrayList;
import java.util.List;

public abstract class Sujeto {

    private final List<Observador> observadores = new ArrayList<>();

    public void agregarObservador(Observador observador) {
        observadores.add(observador);
    }

    public void eliminarObservador(Observador observador) {
        observadores.remove(observador);
    }

    public void notificarObservadores(String mensaje, HistorialMedico historial) {
        for (Observador obs : observadores) {
            obs.actualizar(mensaje, historial);
        }
    }
}
