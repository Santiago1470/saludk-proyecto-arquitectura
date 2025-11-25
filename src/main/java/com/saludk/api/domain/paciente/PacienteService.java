package com.saludk.api.domain.paciente;

import com.saludk.api.domain.usuario.Usuario;
import com.saludk.api.domain.usuario.UsuarioDTO;
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

    private PacienteDTO convertirAPacienteDTO(Paciente paciente) {

        Usuario usuario = paciente.getUsuario();

        UsuarioDTO usuarioDTO = null;

        if (usuario != null) {
            usuarioDTO = new UsuarioDTO(
                    usuario.getId(),
                    usuario.getNombre(),
                    usuario.getApellido(),
                    usuario.getEmail(),
                    usuario.getRol().toString()
            );
        }

        return new PacienteDTO(
                paciente.getId(),
                paciente.getCedula(),
                paciente.getTelefono(),
                paciente.getDireccion(),
                paciente.getTipoSangre(),
                paciente.getAlergias(),
                paciente.getEstadoRegistro(),
                usuarioDTO
        );
    }

    public PacienteDTO registrarPaciente(Long idUsuario, String cedula, String telefono,
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

        Paciente guardado = pacienteRepository.save(paciente);
        return convertirAPacienteDTO(guardado);
    }


    public List<PacienteDTO> listarPacientes() {
        return pacienteRepository.findAll()
                .stream()
                .map(this::convertirAPacienteDTO)
                .toList();
    }

    public PacienteDTO obtenerPorCedula(String cedula) {
        Paciente paciente = pacienteRepository.findByCedula(cedula)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado con cédula: " + cedula));

        return convertirAPacienteDTO(paciente);
    }

    public PacienteDTO actualizarPaciente(Long id, String telefono, String direccion, String tipoSangre, String alergias) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado con id: " + id));

        paciente.setTelefono(telefono);
        paciente.setDireccion(direccion);
        paciente.setTipoSangre(tipoSangre);
        paciente.setAlergias(alergias);

        Paciente guardado = pacienteRepository.save(paciente);

        return convertirAPacienteDTO(guardado);

    }

    public void cambiarEstado(Long id, String nuevoEstado) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado con id: " + id));

        paciente.setEstadoRegistro(nuevoEstado);
        pacienteRepository.save(paciente);
    }
}
