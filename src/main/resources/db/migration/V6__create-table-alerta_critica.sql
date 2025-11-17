CREATE TABLE alerta_critica (
    id_alerta BIGINT PRIMARY KEY AUTO_INCREMENT,
    id_historial BIGINT NOT NULL,
    nivel VARCHAR(50) NOT NULL,
    descripcion TEXT NOT NULL,
    estado VARCHAR(50),
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_resolucion TIMESTAMP NULL,
    FOREIGN KEY (id_historial) REFERENCES historial_medico(id_historial)
        ON DELETE CASCADE
);