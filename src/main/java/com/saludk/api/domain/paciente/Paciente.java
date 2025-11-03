package com.saludk.api.domain.paciente;

import com.saludk.api.domain.usuario.Usuario;
import jakarta.persistence.*;

@Entity(name = "Paciente")
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id", nullable = false)
    private Usuario usuario;

    @Column(nullable = false, unique = true, length = 20)
    private String cedula;

    @Column(length = 15)
    private String telefono;

    @Column(length = 255)
    private String direccion;

    @Column(name = "tipo_sangre", length = 10)
    private String tipoSangre;

    @Column(columnDefinition = "TEXT")
    private String alergias;

    @Column(name = "estado_registro", length = 20)
    private String estadoRegistro;

    public Paciente() {}

    public Paciente(Long id, Usuario usuario, String cedula, String telefono,
                    String direccion, String tipoSangre, String alergias, String estadoRegistro) {
        this.id = id;
        this.usuario = usuario;
        this.cedula = cedula;
        this.telefono = telefono;
        this.direccion = direccion;
        this.tipoSangre = tipoSangre;
        this.alergias = alergias;
        this.estadoRegistro = estadoRegistro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long idPaciente) {
        this.id = idPaciente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getEstadoRegistro() {
        return estadoRegistro;
    }

    public void setEstadoRegistro(String estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }
}
