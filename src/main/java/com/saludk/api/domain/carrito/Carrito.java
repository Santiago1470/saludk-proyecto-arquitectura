package com.saludk.api.domain.carrito;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "carrito")
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrito")
    private Long id;

    @Column(name = "id_paciente", nullable = false)
    private Long idPaciente;

    @Column(insertable = false, updatable = false)
    private Timestamp creado;

    public Carrito() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getIdPaciente() { return idPaciente; }
    public void setIdPaciente(Long idPaciente) { this.idPaciente = idPaciente; }

    public Timestamp getCreado() { return creado; }
    public void setCreado(Timestamp creado) { this.creado = creado; }
}
