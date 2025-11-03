CREATE TABLE paciente (
  id_paciente INT PRIMARY KEY AUTO_INCREMENT,
  id_usuario INT,
  cedula VARCHAR(20) UNIQUE,
  telefono VARCHAR(15),
  direccion VARCHAR(255),
  tipo_sangre VARCHAR(10),
  alergias TEXT,
  estado_registro VARCHAR(20),
  FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);