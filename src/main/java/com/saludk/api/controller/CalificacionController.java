package com.saludk.api.controller;

import com.saludk.api.application.calificacion.CalificacionService;
import com.saludk.api.domain.calificacion.CalificacionDTO;
import com.saludk.api.domain.calificacion.CalificacionProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calificaciones")
public class CalificacionController {

    @Autowired
    private CalificacionService service;

    @PostMapping
    public ResponseEntity<CalificacionProducto> calificar(@RequestBody CalificacionDTO dto) {
        var c = service.calificar(dto.idPaciente(), dto.idProducto(), dto.puntaje(), dto.comentario());
        return ResponseEntity.ok(c);
    }

    @GetMapping("/producto/{idProducto}")
    public ResponseEntity<?> porProducto(@PathVariable Long idProducto) {
        return ResponseEntity.ok(service.listarPorProducto(idProducto));
    }
}
