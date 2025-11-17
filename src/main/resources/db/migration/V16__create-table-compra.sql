CREATE TABLE compra (
    id_compra BIGINT PRIMARY KEY AUTO_INCREMENT,
    id_paciente BIGINT NOT NULL,
    total DECIMAL(10,2) NOT NULL,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    metodo_pago VARCHAR(50),
    FOREIGN KEY (id_paciente) REFERENCES paciente(id_paciente)
);