CREATE TABLE log_notificacion (
  id_log INT PRIMARY KEY AUTO_INCREMENT,
  id_alerta INT,
  canal VARCHAR(50),
  fecha_envio TIMESTAMP,
  resultado VARCHAR(50),
  mensaje_error TEXT,
  FOREIGN KEY (id_alerta) REFERENCES alerta_critica(id_alerta)
);