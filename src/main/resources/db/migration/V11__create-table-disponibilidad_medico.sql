CREATE TABLE disponibilidad_medico (
    id_disponibilidad BIGINT PRIMARY KEY AUTO_INCREMENT,
    id_medico BIGINT NOT NULL,
    fecha DATE NOT NULL,
    hora_inicio TIME NOT NULL,
    hora_fin TIME NOT NULL,
    FOREIGN KEY (id_medico) REFERENCES medico(id_medico)
);