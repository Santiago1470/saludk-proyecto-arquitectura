package com.saludk.api.domain.suscripcion;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "suscripcion_paciente")
public class SuscripcionPaciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_suscripcion")
    private Long id;

    @Column(name = "id_paciente", nullable = false)
    private Long idPaciente;

    @ManyToOne
    @JoinColumn(name = "id_plan", referencedColumnName = "id_plan", nullable = false)
    private PlanSuscripcion plan;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin", nullable = false)
    private LocalDate fechaFin;

    @Column(length = 50)
    private String estado; // ACTIVA, VENCIDA, CANCELADA

    public SuscripcionPaciente() {}

    public SuscripcionPaciente(Long id, Long idPaciente, PlanSuscripcion plan,
                               LocalDate fechaInicio, LocalDate fechaFin, String estado) {
        this.id = id;
        this.idPaciente = idPaciente;
        this.plan = plan;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }

    // getters / setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getIdPaciente() { return idPaciente; }
    public void setIdPaciente(Long idPaciente) { this.idPaciente = idPaciente; }

    public PlanSuscripcion getPlan() { return plan; }
    public void setPlan(PlanSuscripcion plan) { this.plan = plan; }

    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }

    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
