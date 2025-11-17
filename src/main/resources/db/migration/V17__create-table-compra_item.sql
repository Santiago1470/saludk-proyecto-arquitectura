CREATE TABLE compra_item (
    id_item BIGINT PRIMARY KEY AUTO_INCREMENT,
    id_compra BIGINT NOT NULL,
    id_producto BIGINT NOT NULL,
    cantidad INT NOT NULL,
    subtotal DECIMAL(10,2),
    FOREIGN KEY (id_compra) REFERENCES compra(id_compra),
    FOREIGN KEY (id_producto) REFERENCES producto_farmaceutico(id_producto)
);