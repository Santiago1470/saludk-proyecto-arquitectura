package com.saludk.api.domain.medico;

public record DatosRegistroMedico(
        String nombre,
        String apellido,
        String email,
        String clave,
        String especialidad
) {}
