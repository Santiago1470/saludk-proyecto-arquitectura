package com.saludk.api.domain.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public Usuario crearUsuarioPaciente(String nombre, String apellido, String email, String clave) {

        if (usuarioRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("El correo electrónico ya está registrado.");
        }

        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setEmail(email);
        usuario.setClave(encoder.encode(clave));
        usuario.setRol(Rol.PACIENTE);

        return usuarioRepository.save(usuario);
    }

    public Usuario crearUsuarioMedico(String nombre, String apellido, String email, String clave) {

        if (usuarioRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("El correo electrónico ya está registrado.");
        }

        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setEmail(email);
        usuario.setClave(encoder.encode(clave));
        usuario.setRol(Rol.MEDICO);

        return usuarioRepository.save(usuario);
    }

}
