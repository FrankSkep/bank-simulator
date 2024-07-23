package DAO;

import Entidades.Cliente;
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

        try (Connection conexion = DatabaseConnection.getConnection(); PreparedStatement st = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

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
            JOptionPane.showMessageDialog(null, "Detalles : " + e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }

    // Metodo para actualizar datos de un cliente
    public boolean actualizarCliente(Cliente cliente, int clienteId) {
        String query = "UPDATE Cliente SET nombre = ?, correo = ?, telefono = ? WHERE id = ?";
        try (Connection conexion = DatabaseConnection.getConnection(); PreparedStatement st = conexion.prepareStatement(query)) {

            st.setString(1, cliente.getNombre());
            st.setString(2, cliente.getCorreo());
            st.setString(3, cliente.getTelefono());
            st.setInt(4, clienteId);

            int rowsAffected = st.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Detalles : " + e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }

    // Método para eliminar un cliente, su usuario, cuentas bancarias y transacciones asociadas
    public boolean eliminarClienteCompleto(int clienteId) {
        String queryUsuario = "DELETE FROM Usuario WHERE cliente_id = ?";
        String queryCuentas = "DELETE FROM CuentaBancaria WHERE cliente_id = ?";
        String queryCliente = "DELETE FROM Cliente WHERE id = ?";

        Connection conexion = null;
        PreparedStatement stUsuario = null;
        PreparedStatement stCuentas = null;
        PreparedStatement stCliente = null;

        try {
            conexion = DatabaseConnection.getConnection();
            conexion.setAutoCommit(false); // Iniciar transacción

            // Eliminar usuario asociado
            stUsuario = conexion.prepareStatement(queryUsuario);
            stUsuario.setInt(1, clienteId);
            stUsuario.executeUpdate();

            // Eliminar cuentas bancarias asociadas (esto eliminará también las transacciones asociadas debido a ON DELETE CASCADE)
            stCuentas = conexion.prepareStatement(queryCuentas);
            stCuentas.setInt(1, clienteId);
            stCuentas.executeUpdate();

            // Eliminar cliente
            stCliente = conexion.prepareStatement(queryCliente);
            stCliente.setInt(1, clienteId);
            int affectedRowsCliente = stCliente.executeUpdate();

            // Verificar que la eliminación del cliente fue exitosa
            if (affectedRowsCliente > 0) {
                conexion.commit(); // Confirmar la transacción
                return true;
            } else {
                throw new SQLException("No se pudo eliminar el cliente.");
            }

        } catch (SQLException e) {
            if (conexion != null) {
                try {
                    conexion.rollback(); // Revertir la transacción en caso de error
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Detalles : " + e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
            JOptionPane.showMessageDialog(null, "Detalles : " + e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
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
                if (conexion != null) {
                    conexion.setAutoCommit(true); // Restaurar el modo de auto-commit
                    conexion.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Detalles : " + e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    // Método para obtener todos los clientes
    public List<Cliente> obtenerTodosLosClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String query = "SELECT id, nombre, correo, telefono FROM Cliente";

        try (Connection conexion = DatabaseConnection.getConnection(); PreparedStatement st = conexion.prepareStatement(query); ResultSet resultSet = st.executeQuery()) {

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
            JOptionPane.showMessageDialog(null, "Detalles : " + e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
        }

        return clientes;
    }
}
