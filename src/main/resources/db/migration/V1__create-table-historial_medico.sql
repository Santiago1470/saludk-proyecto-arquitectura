CREATE TABLE historial_medico (
  id_historial INT PRIMARY KEY AUTO_INCREMENT,
  id_paciente INT,
  descripcion TEXT,
  archivo_url VARCHAR(255),
  fecha_registro DATE,
  FOREIGN KEY (id_paciente) REFERENCES paciente(id_paciente)
);