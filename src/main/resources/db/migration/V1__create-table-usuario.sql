CREATE TABLE usuario (
  id_usuario INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(100),
  correo VARCHAR(150) UNIQUE,
  password VARCHAR(255),
  rol VARCHAR(30)
);