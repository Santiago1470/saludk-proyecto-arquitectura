package com.saludk.api.domain.notificacion;

import com.saludk.api.domain.historial.HistorialMedico;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "log_notificacion")
public class LogNotificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_log")
    private Long idLog;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alerta", nullable = false)
    private HistorialMedico historialMedico;  // 🔗 relación directa

    @Column(name = "canal", length = 50)
    private String canal;

    @Column(name = "fecha_envio")
    private LocalDateTime fechaEnvio;

    @Column(name = "resultado", length = 50)
    private String resultado;

    @Column(name = "mensaje_error", columnDefinition = "TEXT")
    private String mensajeError;

    public LogNotificacion() {}

    public LogNotificacion(HistorialMedico historialMedico, String canal, String resultado, String mensajeError) {
        this.historialMedico = historialMedico;
        this.canal = canal;
        this.fechaEnvio = LocalDateTime.now();
        this.resultado = resultado;
        this.mensajeError = mensajeError;
    }

    // Getters y setters
    public Long getIdLog() { return idLog; }
    public void setIdLog(Long idLog) { this.idLog = idLog; }
    public HistorialMedico getHistorialMedico() { return historialMedico; }
    public void setHistorialMedico(HistorialMedico historialMedico) { this.historialMedico = historialMedico; }
    public String getCanal() { return canal; }
    public void setCanal(String canal) { this.canal = canal; }
    public LocalDateTime getFechaEnvio() { return fechaEnvio; }
    public void setFechaEnvio(LocalDateTime fechaEnvio) { this.fechaEnvio = fechaEnvio; }
    public String getResultado() { return resultado; }
    public void setResultado(String resultado) { this.resultado = resultado; }
    public String getMensajeError() { return mensajeError; }
    public void setMensajeError(String mensajeError) { this.mensajeError = mensajeError; }
}
