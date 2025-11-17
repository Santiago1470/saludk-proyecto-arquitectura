CREATE TABLE solicitud_paciente (
    id_solicitud BIGINT PRIMARY KEY AUTO_INCREMENT,
    id_paciente BIGINT NOT NULL,
    fecha_solicitud TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado VARCHAR(50),
    motivo TEXT,
    FOREIGN KEY (id_paciente) REFERENCES paciente(id_paciente)
);