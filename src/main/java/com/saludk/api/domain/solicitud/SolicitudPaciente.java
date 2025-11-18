package com.saludk.api.domain.solicitud;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "solicitud_paciente")
public class SolicitudPaciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitud")
    private Long idSolicitud;

    @Column(nullable = false)
    private Long idPaciente;

    private String estado;

    @Column(columnDefinition = "TEXT")
    private String motivo;

    @Column(name = "fecha_solicitud", insertable = false, updatable = false)
    private Timestamp fechaSolicitud;

    public SolicitudPaciente() {}

    public SolicitudPaciente(Long idSolicitud, Long idPaciente, String estado, String motivo, Timestamp fechaSolicitud) {
        this.idSolicitud = idSolicitud;
        this.idPaciente = idPaciente;
        this.estado = estado;
        this.motivo = motivo;
        this.fechaSolicitud = fechaSolicitud;
    }

    // ===== GETTERS Y SETTERS =====

    public Long getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Long idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Timestamp getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Timestamp fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }
}
