CREATE TABLE log_notificacion (
  id_log BIGINT PRIMARY KEY AUTO_INCREMENT,
  id_historial BIGINT NOT NULL,
  canal VARCHAR(50),
  fecha_envio TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  resultado VARCHAR(50),
  mensaje_error TEXT,
  FOREIGN KEY (id_historial) REFERENCES historial_medico(id_historial)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);
