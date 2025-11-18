package com.saludk.api.application.registro;

import com.saludk.api.application.medico.MedicoService;
import com.saludk.api.application.usuario.UsuarioService;
import com.saludk.api.domain.medico.DatosRegistroMedico;
import com.saludk.api.domain.medico.Medico;
import com.saludk.api.domain.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistroMedicoFacade {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private MedicoService medicoService;

    public Medico registrarNuevoMedico(DatosRegistroMedico datos) {

        Usuario usuario = usuarioService.crearUsuarioMedico(
                datos.nombre(),
                datos.apellido(),
                datos.email(),
                datos.clave()
        );

        return medicoService.registrarMedico(
                usuario.getId(),
                datos.especialidad()
        );
    }
}
