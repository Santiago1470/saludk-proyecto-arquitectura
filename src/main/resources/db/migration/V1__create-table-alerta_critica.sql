CREATE TABLE alerta_critica (
  id_alerta INT PRIMARY KEY AUTO_INCREMENT,
  id_paciente INT,
  nivel VARCHAR(20),
  descripcion TEXT,
  fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  estado VARCHAR(20),
  FOREIGN KEY (id_paciente) REFERENCES paciente(id_paciente)
);