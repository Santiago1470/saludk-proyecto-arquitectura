package com.saludk.api.domain.historial;

import com.saludk.api.domain.observer.Sujeto;
import com.saludk.api.domain.paciente.Paciente;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "historial_medico")
public class HistorialMedico extends Sujeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historial")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_evento", nullable = false)
    private TipoEvento tipoEvento;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(columnDefinition = "TEXT")
    private String resultados;

    @Column(name = "medico_responsable", length = 100)
    private String medicoResponsable;

    @Column(name = "archivo_url", length = 255)
    private String archivoUrl;

    @Column(name = "valor_critico")
    private Boolean valorCritico = false;

    @Column(name = "tipo_alerta", length = 100)
    private String tipoAlerta;

    public HistorialMedico() {}

    public void setValorCritico(Boolean valorCritico) {
        this.valorCritico = valorCritico;
        if (Boolean.TRUE.equals(valorCritico)) {
            notificarObservadores("Valor crítico detectado en el historial del paciente "
                    + paciente.getId() + " (" + tipoAlerta + ")");
        }
    }

    public void registrarEvento(String descripcion) {
        this.descripcion = descripcion;
        notificarObservadores("Nuevo evento registrado para paciente " + paciente.getId() + ": " + descripcion);
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }
    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDateTime fechaRegistro) { this.fechaRegistro = fechaRegistro; }
    public TipoEvento getTipoEvento() { return tipoEvento; }
    public void setTipoEvento(TipoEvento tipoEvento) { this.tipoEvento = tipoEvento; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getResultados() { return resultados; }
    public void setResultados(String resultados) { this.resultados = resultados; }
    public String getMedicoResponsable() { return medicoResponsable; }
    public void setMedicoResponsable(String medicoResponsable) { this.medicoResponsable = medicoResponsable; }
    public String getArchivoUrl() { return archivoUrl; }
    public void setArchivoUrl(String archivoUrl) { this.archivoUrl = archivoUrl; }
    public String getTipoAlerta() { return tipoAlerta; }
    public void setTipoAlerta(String tipoAlerta) { this.tipoAlerta = tipoAlerta; }
}
