# Sistema Bancario

## Descripción

Simulacion de sistema bancario desarrollado en Java que proporciona funcionalidades completas para la gestión de cuentas bancarias y transacciones. Incluye autenticación segura, hashing de contraseñas, y una gestión de roles diferenciada para administradores y usuarios. El sistema utiliza HikariCP para optimizar el rendimiento y la accesibilidad a la base de datos.

## Funcionalidades

### Autenticación
- **Autenticación de usuarios**: Permite el acceso seguro al sistema.
- **Hashing y salt de contraseñas**: Utiliza el algoritmo criptografico SHA-256 para asegurar las contraseñas.

### Roles
- **Administrador**:
  - Agregar nuevos administradores.
  - Eliminar clientes.
  - Modificar datos de clientes (nombre, correo, teléfono).
  - Cerrar sesión.

- **Usuario**:
  - Depositar dinero en cuentas propias.
  - Retirar dinero de cuentas propias.
  - Transferir dinero entre cuentas propias y de otros clientes.
  - Ver transacciones en formato de tabla, con detalles como fecha, tipo, monto, descripción e ID de cuenta.
  - Consultar saldos de todas las cuentas asociadas.
  - Abrir nuevas cuentas bancarias.
  - Cerrar cuentas bancarias, eliminando también sus transacciones.
  - Cerrar sesión.

### Características
- **HikariCP**: Se utiliza para hacer un pool de conexiones para mejorar el rendimiento de acceso a la base de datos.
- **Patrón Singleton**: Se utiliza para gestionar la sesión del usuario, asegurando que solo haya una instancia de la sesión activa en cualquier momento.
- **Ordenamiento de tablas**: Permite ordenar las tablas haciendo clic en las columnas.
- **Eliminación de transacciones**: Los usuarios pueden eliminar todas sus transacciones.
- **Edición de datos de usuario**: Los usuarios pueden editar sus datos personales, excepto nombre de usuario, contraseña e ID de cliente.
- **Interfaz gráfica**: Implementada utilizando Swing para una experiencia de usuario intuitiva.

### Base de Datos
- **Tablas**:
  - `cliente`: Información de los clientes del banco.
  - `usuario`: Información de los usuarios del sistema.
  - `cuentaBancaria`: Información sobre las cuentas bancarias.
  - `transaccion`: Registro de todas las transacciones realizadas.

- **Relaciones**:
  - Cada `cliente` puede tener múltiples `cuentasBancarias`.
  - Cada `cuentaBancaria` puede tener múltiples `transacciones`.
  - Cada `usuario` está asociado a un único `cliente`.

## Requisitos

- **Java JDK 17 o superior**
- **PostgreSQL 16.3 o superior**
- **Librerías de terceros**:
  - HikariCP
  - JDBC
  - Swing para la interfaz gráfica
