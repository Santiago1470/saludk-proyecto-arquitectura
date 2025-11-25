package com.saludk.api.domain.registro;

import com.saludk.api.domain.paciente.PacienteDTO;
import com.saludk.api.domain.paciente.PacienteService;
import com.saludk.api.domain.usuario.UsuarioService;
import com.saludk.api.domain.paciente.Paciente;
import com.saludk.api.domain.paciente.DatosRegistroPaciente;
import com.saludk.api.domain.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistroPacienteFacade {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PacienteService pacienteService;

    public PacienteDTO registrarNuevoPaciente(DatosRegistroPaciente datos) {
        Usuario usuario = usuarioService.crearUsuarioPaciente(
                datos.nombre(),
                datos.apellido(),
                datos.email(),
                datos.clave()
        );

        return pacienteService.registrarPaciente(
                usuario.getId(),
                datos.cedula(),
                datos.telefono(),
                datos.direccion(),
                datos.tipoSangre(),
                datos.alergias()
        );
    }
}
