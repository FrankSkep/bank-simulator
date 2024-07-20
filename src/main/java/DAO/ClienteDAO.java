package DAO;

import Modelos.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClienteDAO {

    // Metodo para registrar un cliente
    public boolean registrarCliente(Cliente cliente) {
        String query = "INSERT INTO Cliente (nombre, correo, telefono) VALUES (?, ?, ?)";

        try (Connection conexion = DBConexion.getConnection(); PreparedStatement st = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            st.setString(1, cliente.getNombre());
            st.setString(2, cliente.getCorreo());
            st.setString(3, cliente.getTelefono());

            int affectedRows = st.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = st.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        cliente.setID(generatedKeys.getInt(1));
                        return true;
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error : " + e.toString(), "Operacion fallida", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }

    // Metodo para actualizar datos de un cliente
    public boolean actualizarCliente(Cliente cliente, int clienteId) {
        String query = "UPDATE Cliente SET nombre = ?, correo = ?, telefono = ? WHERE id = ?";
        try (Connection connection = DBConexion.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getCorreo());
            statement.setString(3, cliente.getTelefono());
            statement.setInt(4, clienteId);

            int rowsAffected = statement.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error : " + e.toString(), "Operacion fallida", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }

    // Método para eliminar un cliente, su usuario, cuentas bancarias y transacciones asociadas
    public boolean eliminarClienteCompleto(int clienteId) {
        String queryUsuario = "DELETE FROM Usuario WHERE cliente_id = ?";
        String queryCuentas = "DELETE FROM CuentaBancaria WHERE cliente_id = ?";
        String queryCliente = "DELETE FROM Cliente WHERE id = ?";

        Connection connection = null;
        PreparedStatement stUsuario = null;
        PreparedStatement stCuentas = null;
        PreparedStatement stCliente = null;

        try {
            connection = DBConexion.getConnection();
            connection.setAutoCommit(false); // Iniciar transacción

            // Eliminar usuario asociado
            stUsuario = connection.prepareStatement(queryUsuario);
            stUsuario.setInt(1, clienteId);
            stUsuario.executeUpdate();

            // Eliminar cuentas bancarias asociadas (esto eliminará también las transacciones asociadas debido a ON DELETE CASCADE)
            stCuentas = connection.prepareStatement(queryCuentas);
            stCuentas.setInt(1, clienteId);
            stCuentas.executeUpdate();

            // Eliminar cliente
            stCliente = connection.prepareStatement(queryCliente);
            stCliente.setInt(1, clienteId);
            int affectedRowsCliente = stCliente.executeUpdate();

            // Verificar que la eliminación del cliente fue exitosa
            if (affectedRowsCliente > 0) {
                connection.commit(); // Confirmar la transacción
                return true;
            } else {
                throw new SQLException("No se pudo eliminar el cliente.");
            }

        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback(); // Revertir la transacción en caso de error
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Detalles del error : " + ex.toString(), "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
            JOptionPane.showMessageDialog(null, "Detalles del error : " + e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
            return false;

        } finally {
            // Cerrar recursos
            try {
                if (stUsuario != null) {
                    stUsuario.close();
                }
                if (stCuentas != null) {
                    stCuentas.close();
                }
                if (stCliente != null) {
                    stCliente.close();
                }
                if (connection != null) {
                    connection.setAutoCommit(true); // Restaurar el modo de auto-commit
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para obtener todos los clientes
    public List<Cliente> obtenerTodosLosClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String query = "SELECT id, nombre, correo, telefono FROM Cliente";

        try (Connection connection = DBConexion.getConnection(); PreparedStatement statement = connection.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String correo = resultSet.getString("correo");
                String telefono = resultSet.getString("telefono");

                Cliente cliente = new Cliente(nombre, correo, telefono);
                cliente.setID(id);
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Detalles del error : " + e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
        }

        return clientes;
    }

    public boolean obtenerCliente(int idBuscado) {
        String query = "SELECT * FROM Cliente WHERE id = ?";

        try (Connection connection = DBConexion.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, idBuscado);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Detalles del error : " + e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }

    // Método para obtener el ID del cliente por su nombre
    public int obtenerIdPorNombre(String nombre) {
        String query = "SELECT id FROM Cliente WHERE nombre = ?";
        try (Connection connection = DBConexion.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, nombre);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("id");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Detalles del error : " + e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        return -1; // Retorna -1 si el cliente no se encuentra
    }

}
