package DAO;

import Entidades.Transaccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class TransaccionDAO {

    // Registrar una transaccion
    public void registrarTransaccion(Transaccion transaccion) throws SQLException {
        String query = "INSERT INTO Transaccion (fecha, tipo, monto, descripcion, cuentabancaria_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection conexion = DatabaseConnection.getConnection(); PreparedStatement st = conexion.prepareStatement(query)) {

            st.setObject(1, transaccion.getFecha());
            st.setString(2, transaccion.getTipo());
            st.setDouble(3, transaccion.getMonto());
            st.setString(4, transaccion.getDescripcion());
            st.setInt(5, transaccion.getNumCuenta());

            st.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Detalles : " + e.toString(), "Ocurrio un error", JOptionPane.WARNING_MESSAGE);
            throw e;
        }
    }

    // Eliminar todas las transacciones asociadas a un cliente
    public boolean eliminarTransacciones(int clienteId) {
        String query = "DELETE FROM Transaccion WHERE cuentabancaria_id IN (SELECT numeroCuenta FROM CuentaBancaria WHERE cliente_id = ?)";

        try (Connection conexion = DatabaseConnection.getConnection(); PreparedStatement st = conexion.prepareStatement(query)) {
            st.setInt(1, clienteId);
            int affectedRows = st.executeUpdate();
            if (affectedRows > 0) {
                return true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al eliminar las transacciones: " + e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }

    // Obtener todas las transacciones de un cliente
    public List<Transaccion> obtenerTransaccionesCliente(int clienteId) {
        List<Transaccion> transaccionesList = new ArrayList<>();

        String query = "SELECT * FROM Transaccion WHERE cuentabancaria_id IN (SELECT numeroCuenta FROM CuentaBancaria WHERE cliente_id = ?)";

        try (Connection conexion = DatabaseConnection.getConnection(); PreparedStatement st = conexion.prepareStatement(query)) {
            st.setInt(1, clienteId);

            ResultSet resultSet = st.executeQuery();

            while (resultSet.next()) {
                LocalDateTime fecha = resultSet.getObject("fecha", LocalDateTime.class);
                String tipo = resultSet.getString("tipo");
                double monto = resultSet.getDouble("monto");
                String descripcion = resultSet.getString("descripcion");
                int numCuenta = resultSet.getInt("cuentabancaria_id");

                Transaccion transaccion = new Transaccion(numCuenta, fecha, tipo, monto, descripcion);
                transaccionesList.add(transaccion);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al eliminar las transacciones: " + e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        return transaccionesList;
    }
}
