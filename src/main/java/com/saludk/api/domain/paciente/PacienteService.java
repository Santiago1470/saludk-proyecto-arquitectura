package com.saludk.api.domain.paciente;

import com.saludk.api.domain.usuario.Usuario;
import com.saludk.api.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Paciente registrarPaciente(Long idUsuario, String cedula, String telefono,
                                      String direccion, String tipoSangre, String alergias) {

        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + idUsuario));

        Paciente paciente = new Paciente();
        paciente.setUsuario(usuario);
        paciente.setCedula(cedula);
        paciente.setTelefono(telefono);
        paciente.setDireccion(direccion);
        paciente.setTipoSangre(tipoSangre);
        paciente.setAlergias(alergias);
        paciente.setEstadoRegistro("Activo");

        return pacienteRepository.save(paciente);
    }


    public List<Paciente> listarPacientes() {
        return pacienteRepository.findAll();
    }

    public Paciente obtenerPorCedula(String cedula) {
        return pacienteRepository.findByCedula(cedula)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado con cédula: " + cedula));
    }

    public Paciente actualizarPaciente(Long id, String telefono, String direccion, String tipoSangre, String alergias) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado con id: " + id));

        paciente.setTelefono(telefono);
        paciente.setDireccion(direccion);
        paciente.setTipoSangre(tipoSangre);
        paciente.setAlergias(alergias);

        return pacienteRepository.save(paciente);
    }

    public void cambiarEstado(Long id, String nuevoEstado) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado con id: " + id));

        paciente.setEstadoRegistro(nuevoEstado);
        pacienteRepository.save(paciente);
    }
}
