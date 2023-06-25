drop database napoliPizz;
create database napoliPizz;

use napoliPizz;
-- Crear la tabla de usuarios
CREATE TABLE usuarios (
                          id_usuario INT PRIMARY KEY AUTO_INCREMENT,
                          nombre VARCHAR(50) NOT NULL,
                          correo_electronico VARCHAR(50) NOT NULL UNIQUE,
                          contrasenia VARCHAR(300) NOT NULL,
                          fecha_registro DATETIME DEFAULT NOW(),
                          activo tinyint DEFAULT NULL
);

-- Crear la tabla de pedidos
CREATE TABLE pedidos (
                         id_pedido INT PRIMARY KEY AUTO_INCREMENT,
                         id_usuario INT NOT NULL,
                         fecha_pedido DATETIME DEFAULT NOW(),
                         estado_pedido VARCHAR(20) NOT NULL,
                         FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

-- Crear la tabla de pizzas
CREATE TABLE pizzas (
                        id_pizza INT PRIMARY KEY AUTO_INCREMENT,
                        nombre VARCHAR(50) NOT NULL,
                        descripcion VARCHAR(100),
                        precio DECIMAL(5, 2) NOT NULL
);
INSERT INTO pizzas (nombre, descripcion, precio) VALUES
    ('Pizza Margarita', 'Tomate, mozzarella y albahaca fresca', 36.97),
    ('Pizza Pepperoni', 'Salsa de tomate, queso mozzarella y pepperoni', 39.97),
    ('Pizza Hawaiana', 'Salsa de tomate, queso mozzarella, jamón y piña', 41.97),
    ('Pizza Barbacoa', 'Salsa barbacoa, pollo a la parrilla, cebolla y maíz', 43.97),
    ('Pizza Cuatro Quesos', 'Mozzarella, queso azul, queso de cabra y queso parmesano', 41.97),
    ('Pizza Vegetariana', 'Salsa de tomate, queso mozzarella, champiñones, pimientos y aceitunas', 41.97),
    ('Pizza Mexicana', 'Salsa de tomate, queso mozzarella, carne molida, jalapeños y guacamole', 43.97),
    ('Pizza Diavola', 'Salsa de tomate, queso mozzarella, salami picante y aceitunas negras', 41.97),
    ('Pizza Caprese', 'Tomate, mozzarella fresca, albahaca y aceite de oliva', 39.97),
    ('Pizza Napolitana', 'Salsa de tomate, queso mozzarella, anchoas y aceitunas', 41.97),
    ('Pizza Marinera', 'Salsa de tomate, queso mozzarella, camarones, mejillones y almejas', 45.97),
    ('Pizza Prosciutto', 'Salsa de tomate, queso mozzarella y jamón serrano', 41.97),
    ('Pizza Calzone', 'Salsa de tomate, queso mozzarella, pepperoni y champiñones, cerrada en forma de empanada', 43.97);

-- Crear la tabla de pedidos_pizzas
CREATE TABLE pedidos_pizzas (
                                id_pedido INT NOT NULL,
                                id_pizza INT NOT NULL,
                                cantidad INT NOT NULL,
                                PRIMARY KEY (id_pedido, id_pizza),
                                FOREIGN KEY (id_pedido) REFERENCES pedidos(id_pedido),
                                FOREIGN KEY (id_pizza) REFERENCES pizzas(id_pizza)
);

-- Crear la tabla de mesas
CREATE TABLE mesas (
                       id_mesa INT PRIMARY KEY AUTO_INCREMENT,
                       capacidad INT NOT NULL,
                       disponible BOOLEAN NOT NULL DEFAULT true
);

-- Crear la tabla de reservas
CREATE TABLE reservas (
                          id_reserva INT PRIMARY KEY AUTO_INCREMENT,
                          id_usuario INT NOT NULL,
                          id_mesa INT NOT NULL,
                          fecha_reserva DATETIME NOT NULL,
                          estado_reserva VARCHAR(20) NOT NULL,
                          FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario),
                          FOREIGN KEY (id_mesa) REFERENCES mesas(id_mesa)
);
INSERT INTO mesas (id_mesa, capacidad, disponible) VALUES
    (1, 4, true),
    (2, 2, true),
    (3, 6, true),
    (4, 8, true),
    (5, 3, true),
    (6, 5, true),
    (7, 4, true);

CREATE TABLE rol (
                     idrol INT auto_increment NOT NULL,
                     nomrol varchar(300) NULL,
                     CONSTRAINT roles_pk PRIMARY KEY (idrol)
);


CREATE TABLE usuario_rol (
                             id_usuario INT NOT NULL,
                             idrol INT NOT NULL,
                             CONSTRAINT user_role_pk PRIMARY KEY (id_usuario, idrol),
                             CONSTRAINT user_role_FK FOREIGN KEY (id_usuario) REFERENCES napolipizz.usuarios(id_usuario),
                             CONSTRAINT user_role_FK_1 FOREIGN KEY (idrol) REFERENCES napolipizz.rol(idrol)
);


INSERT INTO rol (`idrol`, `nomrol`) VALUES
                                          (1, 'ADMIN'),
                                          (2, 'CLIENT'),
                                          (3, 'USER');

INSERT INTO usuarios values (null,'usuario','usuario@gmail.com','contranoencriptada',now(),1);
INSERT INTO reservas values (null,1,1,now(),"REGISTRADO");


-- Sin esto no funciona bien xd
create trigger eltrigger_insert2 BEFORE insert on pedidos
    FOR EACH ROW set NEW.fecha_pedido = NOW();
