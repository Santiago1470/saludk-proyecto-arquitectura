CREATE TABLE medico (
    id_medico BIGINT PRIMARY KEY AUTO_INCREMENT,
    id_usuario BIGINT NOT NULL,
    especialidad VARCHAR(100),
    calificacion_promedio DECIMAL(3,2) DEFAULT 0,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id)
);