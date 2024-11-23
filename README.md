# Bank Management System

## Descripción

Sistema de Gestión de banco, desarrollado en Java. Cuenta con funcionalidades para la gestión de clientes, cuentas bancarias y transacciones. Incluye autenticación segura, hashing de contraseñas, y una gestión de roles diferenciada para administradores y usuarios. El sistema utiliza HikariCP para optimizar el rendimiento y la accesibilidad a la base de datos.

* ### [Screenshots](https://github.com/FrankSkep/Bank_System/blob/main/assets/views.md)

## Funcionalidades

### Autenticación
- **Autenticación de usuarios**: Permite el acceso seguro al sistema.
- **Hash y salt de contraseñas**: Utiliza el algoritmo criptográfico SHA-256 para asegurar las contraseñas, guardando un hash de la contraseña en lugar de texto plano.

### Roles
- **Administrador**:
  - Agregar nuevos administradores.
  - Eliminar clientes.
  - Modificar datos de clientes.
  - Cerrar sesión.

- **Usuario**:
  - Depositar dinero en cuentas propias.
  - Retirar dinero de cuentas propias.
  - Transferir dinero entre cuentas propias y de otros clientes.
  - Ver historial de transacciones en formato de tabla, con detalles como fecha, tipo, monto, descripción y número de cuenta.
  - Eliminar transacciones.
  - Consultar saldos de todas las cuentas propias.
  - Abrir nuevas cuentas bancarias.
  - Cerrar cuentas bancarias (Esto también elimina las transacciones de la cuenta eliminada).
  - Ver y editar sus datos.
  - Eliminar su cuenta y datos.
  - Cerrar sesión.

### Características

- **HikariCP**: Implementación de un pool de conexiones para mejorar significativamente el rendimiento de acceso a la base de datos.
- **Patrón Singleton**: Gestión eficiente de la sesión del usuario, garantizando que solo una instancia de la sesión esté activa en cualquier momento.
- **Ordenamiento de tablas**: Funcionalidad que permite ordenar las tablas dinámicamente al hacer clic en los encabezados de las columnas.
- **Validaciones de entrada**: Incluye validaciones para asegurar que se ingresen datos válidos (correo, teléfono, contraseñas, etc).
- **Interfaz gráfica**: Diseñada con Swing para ofrecer una experiencia de usuario intuitiva y amigable.

### Base de Datos
A continuación se muestra el diagrama entidad-relación (ERD) que representa la estructura de la base de datos:
![Diagrama entidad relación](assets/images/diagrama_ER.png)

- **Relaciones**:
  - Cada `cliente` puede tener múltiples `cuentasBancarias`.
  - Cada `cuentaBancaria` puede tener múltiples `transacciones`.
  - Cada `usuario` está asociado a un único `cliente`.

## Tecnologías Utilizadas

- **Java JDK 17 o superior**
- **Maven 3.9.8**
- **PostgreSQL 16.3 o superior**
- **Librerías de terceros**:
  - HikariCP 5.1.0
  - JDBC
  - Swing

## Licencia

**Este proyecto está licenciado bajo la [GNU Affero General Public License v3.0](https://www.gnu.org/licenses/agpl-3.0.html).**

© 2024 FrankSkep. Para más detalles, consulte el archivo completo [LICENSE](LICENSE).
