package com.saludk.api.controller;

import com.saludk.api.application.AutenticacionService;
import com.saludk.api.domain.usuario.DatosUsuarioAuth;
import com.saludk.api.infra.security.DatosJWTtoken;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AutenticacionService autenticacionService;

    @PostMapping
    public ResponseEntity<DatosJWTtoken> iniciarSesion(@RequestBody @Valid DatosUsuarioAuth datosUsuarioAuth) {
        String token = autenticacionService.autenticarUsuario(
                datosUsuarioAuth.login(),
                datosUsuarioAuth.clave()
        );
        return ResponseEntity.ok(new DatosJWTtoken(token));
    }
}
