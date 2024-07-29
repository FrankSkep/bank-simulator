-- Este archivo contiene el codigo necesario para la creacion de las tablas de la base de datos correspondiente a este sistema.

-- Creacion de tabla Cliente
CREATE TABLE Cliente (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    correo VARCHAR(255),
    telefono VARCHAR(20)
);

-- Creacion de tabla Usuario con referencia a Cliente.id
CREATE TABLE Usuario (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL,
    salt VARCHAR(255) NOT NULL,
    cliente_id INT,
    role VARCHAR(50),
    FOREIGN KEY (cliente_id) REFERENCES Cliente(id) ON DELETE CASCADE
);

-- Creacion de tabla CuentaBancaria con referencia a Cliente.id
CREATE TABLE CuentaBancaria (
    numerocuenta SERIAL PRIMARY KEY,
    saldo NUMERIC(15, 2) NOT NULL,
    cliente_id INT NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES Cliente(id) ON DELETE CASCADE
);

-- Creacion de tabla Transaccion con referencia a CuentaBancaria.numerocuenta
CREATE TABLE Transaccion (
    id SERIAL PRIMARY KEY,
    fecha TIMESTAMP NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    monto NUMERIC(15, 2) NOT NULL,
    descripcion VARCHAR(255) NOT NULL,
    cuentaBancaria_id BIGINT,
    FOREIGN KEY (cuentaBancaria_id) REFERENCES CuentaBancaria(numerocuenta) ON DELETE CASCADE
);
