package com.saludk.api.domain.calificacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalificacionService {

    @Autowired
    private CalificacionProductoRepository repo;

    public CalificacionProducto calificar(Long idPaciente, Long idProducto, Integer puntaje, String comentario) {
        if (puntaje == null || puntaje < 1 || puntaje > 10) {
            throw new RuntimeException("Puntaje debe ser entre 1 y 10");
        }

        CalificacionProducto c = new CalificacionProducto();
        c.setIdPaciente(idPaciente);
        c.setIdProducto(idProducto);
        c.setPuntaje(puntaje);
        c.setComentario(comentario);
        return repo.save(c);
    }

    public List<CalificacionProducto> listarPorProducto(Long idProducto) {
        return repo.findByIdProducto(idProducto);
    }
}
