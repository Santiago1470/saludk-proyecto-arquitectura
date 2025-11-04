CREATE TABLE historial_medico (
  id_historial BIGINT PRIMARY KEY AUTO_INCREMENT,
  id_paciente BIGINT NOT NULL,
  fecha_registro DATETIME DEFAULT CURRENT_TIMESTAMP,
  tipo_evento ENUM('CONSULTA', 'EXAMEN', 'MEDICAMENTO', 'ALERTA') NOT NULL,
  descripcion TEXT,
  resultados TEXT,
  medico_responsable VARCHAR(100),
  archivo_url VARCHAR(255),
  valor_critico BOOLEAN DEFAULT FALSE,
  tipo_alerta VARCHAR(100),
  FOREIGN KEY (id_paciente) REFERENCES paciente(id_paciente)
);
