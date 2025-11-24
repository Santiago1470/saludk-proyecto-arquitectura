package com.saludk.api.domain;

import com.saludk.api.domain.usuario.Usuario;
import com.saludk.api.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AutenticacionService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    public String autenticarUsuario(String login, String clave) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(login, clave);
        Authentication usuarioAutenticado = authenticationManager.authenticate(authToken);
        Usuario usuario = (Usuario) usuarioAutenticado.getPrincipal();
        return tokenService.generarToken(usuario);
    }
}