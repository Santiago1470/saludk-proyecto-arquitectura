CREATE TABLE cita (
    id_cita BIGINT PRIMARY KEY AUTO_INCREMENT,
    id_paciente BIGINT NOT NULL,
    id_medico BIGINT NOT NULL,
    fecha DATETIME NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    estado VARCHAR(50),
    FOREIGN KEY (id_paciente) REFERENCES paciente(id_paciente),
    FOREIGN KEY (id_medico) REFERENCES medico(id_medico)
);