CREATE TABLE carrito_item (
    id_item BIGINT PRIMARY KEY AUTO_INCREMENT,
    id_carrito BIGINT NOT NULL,
    id_producto BIGINT NOT NULL,
    cantidad INT DEFAULT 1,
    FOREIGN KEY (id_carrito) REFERENCES carrito(id_carrito),
    FOREIGN KEY (id_producto) REFERENCES producto_farmaceutico(id_producto)
);