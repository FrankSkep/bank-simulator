package DAO_DB;

import Modelos.Transaccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class TransaccionDAO {

    // Metodo para registrar una transaccion
    public boolean registrarTransaccion(Transaccion transaccion) {
        String query = "INSERT INTO Transaccion (fecha, tipo, monto, descripcion, cuentabancaria_id) ? VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DBConexion.getConnection(); PreparedStatement st = connection.prepareStatement(query)) {

            st.setTimestamp(1, new java.sql.Timestamp(transaccion.getFecha().getTime()));
            st.setString(2, transaccion.getTipo());
            st.setDouble(3, transaccion.getMonto());
            st.setString(4, transaccion.getDescripcion());
            st.setLong(5, transaccion.getNumCuenta());

            int rowsAffected = st.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al realizar la transaccion : " + e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }

    // Metodo para obtener las transacciones de una cuenta bancaria
    public List<Transaccion> obtenerTransacciones(long idCuentaBancaria) {
        List<Transaccion> transacciones = new ArrayList<>();

        String query = "SELECT id, fecha, tipo, monto, descripcion, cuentaBancaria_id FROM Transaccion WHERE cuentaBancaria_id = ?";

        try (Connection connection = DBConexion.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, idCuentaBancaria);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                Date fecha = resultSet.getTimestamp("fecha");
                String tipo = resultSet.getString("tipo");
                double monto = resultSet.getDouble("monto");
                String descripcion = resultSet.getString("descripcion");
                long cuentaId = resultSet.getLong("cuentaBancaria_id");

                Transaccion transaccion = new Transaccion(id, cuentaId, fecha, tipo, monto, descripcion);
                transacciones.add(transaccion);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error : " + e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        return transacciones;
    }

}
