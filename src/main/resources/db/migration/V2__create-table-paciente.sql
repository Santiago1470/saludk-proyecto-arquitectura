CREATE TABLE paciente (
  id_paciente BIGINT PRIMARY KEY AUTO_INCREMENT,
  id_usuario BIGINT NOT NULL,
  cedula VARCHAR(20) UNIQUE NOT NULL,
  telefono VARCHAR(15),
  direccion VARCHAR(255),
  tipo_sangre VARCHAR(10),
  alergias TEXT,
  estado_registro VARCHAR(20),
  FOREIGN KEY (id_usuario) REFERENCES usuario(id)
);
