CREATE TABLE calificacion_producto (
    id_calificacion BIGINT PRIMARY KEY AUTO_INCREMENT,
    id_producto BIGINT NOT NULL,
    id_paciente BIGINT NOT NULL,
    puntaje INT CHECK(puntaje BETWEEN 1 AND 10),
    comentario TEXT,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_producto) REFERENCES producto_farmaceutico(id_producto),
    FOREIGN KEY (id_paciente) REFERENCES paciente(id_paciente)
);