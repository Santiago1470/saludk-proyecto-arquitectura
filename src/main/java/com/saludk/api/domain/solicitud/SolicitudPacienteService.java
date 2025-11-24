package com.saludk.api.domain.solicitud;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class SolicitudPacienteService {

    @Autowired
    private SolicitudPacienteRepository repository;

    public SolicitudPaciente crearSolicitud(DatosCrearSolicitud datos) {

        SolicitudPaciente solicitud = new SolicitudPaciente();
        solicitud.setIdPaciente(datos.idPaciente());
        solicitud.setMotivo(datos.motivo());
        solicitud.setEstado("PENDIENTE");

        return repository.save(solicitud);
    }
}

