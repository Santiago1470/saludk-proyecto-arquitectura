package com.saludk.api.application.registro;

import com.saludk.api.application.paciente.PacienteService;
import com.saludk.api.application.usuario.UsuarioService;
import com.saludk.api.domain.paciente.Paciente;
import com.saludk.api.domain.paciente.dto.DatosRegistroPaciente;
import com.saludk.api.domain.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistroPacienteFacade {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PacienteService pacienteService;

    public Paciente registrarNuevoPaciente(DatosRegistroPaciente datos) {
        Usuario usuario = usuarioService.crearUsuarioPaciente(datos.nombre(), datos.email(), datos.clave());

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
