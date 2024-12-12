-- CREACIÓN DE CATEGORIAS
INSERT INTO categoria (nombre, status) VALUES ('Electrónica', 'HABILITAR');
INSERT INTO categoria (nombre, status) VALUES ('Ropa', 'HABILITAR');
INSERT INTO categoria (nombre, status) VALUES ('Deportes', 'HABILITAR');
INSERT INTO categoria (nombre, status) VALUES ('Hogar', 'HABILITAR');

-- CREACIÓN DE PRODUCTOS
INSERT INTO producto (nombre, precio, status, id_categoria) VALUES ('Smartphone', 500.00, 'HABILITAR', 1);
INSERT INTO producto (nombre, precio, status, id_categoria) VALUES ('Auriculares Bluetooth', 50.00, 'DESHABILITAR', 1);
INSERT INTO producto (nombre, precio, status, id_categoria) VALUES ('Tablet', 300.00, 'HABILITAR', 1);

INSERT INTO producto (nombre, precio, status, id_categoria) VALUES ('Camiseta', 25.00, 'HABILITAR', 2);
INSERT INTO producto (nombre, precio, status, id_categoria) VALUES ('Pantalones', 35.00, 'HABILITAR', 2);
INSERT INTO producto (nombre, precio, status, id_categoria) VALUES ('Zapatos', 45.00, 'HABILITAR', 2);

INSERT INTO producto (nombre, precio, status, id_categoria) VALUES ('Balón de Fútbol', 20.00, 'HABILITAR', 3);
INSERT INTO producto (nombre, precio, status, id_categoria) VALUES ('Raqueta de Tenis', 80.00, 'DESHABILITAR', 3);

INSERT INTO producto (nombre, precio, status, id_categoria) VALUES ('Aspiradora', 120.00, 'HABILITAR', 4);
INSERT INTO producto (nombre, precio, status, id_categoria) VALUES ('Licuadora', 50.00, 'HABILITAR', 4);