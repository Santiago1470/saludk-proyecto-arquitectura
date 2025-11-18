package com.saludk.api.domain.compra;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "compra")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Long id;

    @Column(name = "id_paciente", nullable = false)
    private Long idPaciente;

    private Double total;

    @Column(insertable = false, updatable = false)
    private Timestamp fecha;

    @Column(name = "metodo_pago", length = 50)
    private String metodoPago;

    public Compra() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getIdPaciente() { return idPaciente; }
    public void setIdPaciente(Long idPaciente) { this.idPaciente = idPaciente; }

    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }

    public Timestamp getFecha() { return fecha; }
    public void setFecha(Timestamp fecha) { this.fecha = fecha; }

    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }
}
