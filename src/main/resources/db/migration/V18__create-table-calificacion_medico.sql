CREATE TABLE calificacion_medico (
    id_calificacion BIGINT PRIMARY KEY AUTO_INCREMENT,
    id_medico BIGINT NOT NULL,
    id_paciente BIGINT NOT NULL,
    puntaje INT CHECK(puntaje BETWEEN 1 AND 10),
    comentario TEXT,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_medico) REFERENCES medico(id_medico),
    FOREIGN KEY (id_paciente) REFERENCES paciente(id_paciente)
);