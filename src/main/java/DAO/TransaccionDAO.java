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

    private static TransaccionDAO instance;

    private TransaccionDAO() {
    }

    public static synchronized TransaccionDAO getInstance() {
        if (instance == null) {
            instance = new TransaccionDAO();
        }
        return instance;
    }

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

    // Obtener todas las transacciones de una cuenta bancaria
    public List<Transaccion> obtenerTransacciones(int idCuentaBancaria) {
        List<Transaccion> transacciones = new ArrayList<>();

        String query = "SELECT fecha, tipo, monto, descripcion FROM Transaccion WHERE cuentaBancaria_id = ?";

        try (Connection conexion = DatabaseConnection.getConnection(); PreparedStatement st = conexion.prepareStatement(query)) {

            st.setInt(1, idCuentaBancaria);
            ResultSet resultSet = st.executeQuery();

            while (resultSet.next()) {
                LocalDateTime fecha = resultSet.getObject("fecha", LocalDateTime.class);
                String tipo = resultSet.getString("tipo");
                double monto = resultSet.getDouble("monto");
                String descripcion = resultSet.getString("descripcion");

                Transaccion transaccion = new Transaccion(idCuentaBancaria, fecha, tipo, monto, descripcion);
                transacciones.add(transaccion);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Detalles : " + e.toString(), "Ocurrio un error", JOptionPane.WARNING_MESSAGE);
        }
        return transacciones;
    }

}
