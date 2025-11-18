package com.saludk.api.domain.calificacion;

import com.saludk.api.domain.medico.Medico;
import com.saludk.api.domain.paciente.Paciente;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "calificacion_medico")
public class CalificacionMedico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_calificacion")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_medico", nullable = false)
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    @Column(nullable = false)
    private int puntaje;

    @Column(columnDefinition = "TEXT")
    private String comentario;

    @Column(nullable = false)
    private LocalDateTime fecha = LocalDateTime.now();

    public CalificacionMedico() {}

    public CalificacionMedico(Medico medico, Paciente paciente, int puntaje, String comentario) {
        this.medico = medico;
        this.paciente = paciente;
        this.puntaje = puntaje;
        this.comentario = comentario;
        this.fecha = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public Medico getMedico() { return medico; }
    public Paciente getPaciente() { return paciente; }
    public int getPuntaje() { return puntaje; }
    public String getComentario() { return comentario; }
    public LocalDateTime getFecha() { return fecha; }
}
