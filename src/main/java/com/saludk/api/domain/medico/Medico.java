package com.saludk.api.domain.medico;

import com.saludk.api.domain.usuario.Usuario;
import jakarta.persistence.*;

@Entity
@Table(name = "medico")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medico")
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Column(length = 100)
    private String especialidad;

    @Column(name = "calificacion_promedio", precision = 3, scale = 2)
    private Double calificacionPromedio = 0.0;

    public Medico() {}

    public Medico(Usuario usuario, String especialidad) {
        this.usuario = usuario;
        this.especialidad = especialidad;
        this.calificacionPromedio = 0.0;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Double getCalificacionPromedio() {
        return calificacionPromedio;
    }

    public void setCalificacionPromedio(Double calificacionPromedio) {
        this.calificacionPromedio = calificacionPromedio;
    }
}
