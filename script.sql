-- Crear base de datos
CREATE DATABASE bancodb;

-- Crear tabla Cliente
CREATE TABLE Cliente (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    correo VARCHAR(255),
    telefono VARCHAR(20)
);

-- Crear tabla Usuario con referencia a Cliente
CREATE TABLE Usuario (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL,
    salt VARCHAR(255) NOT NULL,
    cliente_id INT,
    role VARCHAR(50),
    FOREIGN KEY (cliente_id) REFERENCES Cliente(id) ON DELETE CASCADE
);

-- Crear tabla CuentaBancaria con referencia a Cliente
CREATE TABLE CuentaBancaria (
    numerocuenta SERIAL PRIMARY KEY,
    saldo NUMERIC(15, 2) NOT NULL,
    cliente_id INT NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES Cliente(id) ON DELETE CASCADE
);

-- Crear tabla Transaccion con referencia a CuentaBancaria
CREATE TABLE Transaccion (
    id SERIAL PRIMARY KEY,
    fecha TIMESTAMP NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    monto NUMERIC(15, 2) NOT NULL,
    descripcion VARCHAR(255) NOT NULL,
    cuentaBancaria_id BIGINT,
    FOREIGN KEY (cuentaBancaria_id) REFERENCES CuentaBancaria(numeroCuenta) ON DELETE CASCADE
);
