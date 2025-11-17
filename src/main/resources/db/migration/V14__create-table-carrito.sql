CREATE TABLE carrito (
    id_carrito BIGINT PRIMARY KEY AUTO_INCREMENT,
    id_paciente BIGINT NOT NULL,
    creado TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_paciente) REFERENCES paciente(id_paciente)
);