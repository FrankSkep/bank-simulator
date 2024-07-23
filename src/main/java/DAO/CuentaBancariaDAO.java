package DAO;

import Entidades.CuentaBancaria;
import Entidades.Transaccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CuentaBancariaDAO {

    private TransaccionDAO transDAO;

    public CuentaBancariaDAO() {
        transDAO = new TransaccionDAO();
    }

    // Método para guardar cuenta en la base de datos
    public void guardarCuenta(CuentaBancaria cuenta) {
        String query = "INSERT INTO CuentaBancaria (saldo, cliente_id) VALUES (?, ?)";

        try (Connection conexion = DatabaseConnection.getConnection(); PreparedStatement st = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            st.setDouble(1, cuenta.getSaldo());
            st.setInt(2, cuenta.getClienteId());

            int affectedRows = st.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = st.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        cuenta.setNumeroCuenta(generatedKeys.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al guardar la cuenta : " + e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Método para transferir dinero
    public boolean transferir(int numeroCuentaOrigen, int numeroCuentaDestino, double monto, int clienteId) {
        if (!esPropietarioDeCuenta(numeroCuentaOrigen, clienteId)) {
            JOptionPane.showMessageDialog(null, "No eres propietario de la cuenta origen " + clienteId, "Operacion fallida", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        Connection conexion = null;
        try {
            conexion = DatabaseConnection.getConnection();
            conexion.setAutoCommit(false);

            // Retirar del origen
            if (!retirar(numeroCuentaOrigen, monto, clienteId, true)) {
                conexion.rollback();
                return false;
            }

            // Depositar en el destino
            if (!depositar(numeroCuentaDestino, monto, clienteId, true)) {
                conexion.rollback();
                return false;
            }

            conexion.commit();

            // Registrar la transacción bancaria
            LocalDateTime fechaTransaccion = LocalDateTime.now();

            Transaccion transaccionOrigen = new Transaccion(numeroCuentaOrigen, fechaTransaccion, "Transferencia", monto, "Transferencia a cuenta " + numeroCuentaDestino);
            transDAO.registrarTransaccion(transaccionOrigen);

            Transaccion transaccionDestino = new Transaccion(numeroCuentaDestino, fechaTransaccion, "Transferencia", monto, "Transferencia desde cuenta " + numeroCuentaOrigen);
            transDAO.registrarTransaccion(transaccionDestino);

            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al transferir: " + e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
            if (conexion != null) {
                try {
                    conexion.rollback();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Ocurrio un error al hacer rollback: " + ex.toString(), "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        } finally {
            if (conexion != null) {
                try {
                    conexion.setAutoCommit(true);
                    conexion.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Ocurrio un error al cerrar la conexión: " + e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        return false;
    }

    // Método para depositar saldo a una cuenta con conexión externa
    public boolean depositar(int numeroCuenta, double monto, int clienteId, boolean esTransferencia) {
        if (!esTransferencia && !esPropietarioDeCuenta(numeroCuenta, clienteId)) {
            JOptionPane.showMessageDialog(null, "No eres propietario de la cuenta origen " + clienteId, "Operacion fallida", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        String query = "UPDATE CuentaBancaria SET saldo = saldo + ? WHERE numeroCuenta = ?";
        try (Connection conexion = DatabaseConnection.getConnection(); PreparedStatement st = conexion.prepareStatement(query);) {
            st.setDouble(1, monto);
            st.setInt(2, numeroCuenta);
            st.executeUpdate();

            // Registrar la transacción
            if (!esTransferencia) {
                LocalDateTime fechaTransaccion = LocalDateTime.now();
                Transaccion transaccionOrigen = new Transaccion(numeroCuenta, fechaTransaccion, "Deposito", monto, "Deposito a mi cuenta numero : " + numeroCuenta);
                transDAO.registrarTransaccion(transaccionOrigen);
            }
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al depositar: " + e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }

    // Método para retirar saldo de una cuenta con conexión externa
    public boolean retirar(int numeroCuenta, double monto, int clienteId, boolean esTransferencia) {
        if (!esPropietarioDeCuenta(numeroCuenta, clienteId)) {
            JOptionPane.showMessageDialog(null, "No eres propietario de la cuenta origen (" + numeroCuenta + ")", "Operacion fallida", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        String query = "UPDATE CuentaBancaria SET saldo = saldo - ? WHERE numeroCuenta = ?";
        try (Connection conexion = DatabaseConnection.getConnection(); PreparedStatement st = conexion.prepareStatement(query);) {
            st.setDouble(1, monto);
            st.setInt(2, numeroCuenta);
            st.executeUpdate();

            // Registrar la transacción
            if (!esTransferencia) {
                LocalDateTime fechaTransaccion = LocalDateTime.now();
                Transaccion transaccionOrigen = new Transaccion(numeroCuenta, fechaTransaccion, "Retiro", monto, "Retiro de mi cuenta numero : " + numeroCuenta);
                transDAO.registrarTransaccion(transaccionOrigen);
            }
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al retirar: " + e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }

    // Metodo para consultar saldo de una cuenta
    public double consultarSaldo(int numCuenta, int clienteId) {
        if (!esPropietarioDeCuenta(numCuenta, clienteId)) {
            JOptionPane.showMessageDialog(null, "No eres propietario de la cuenta " + numCuenta, "Operacion fallida", JOptionPane.WARNING_MESSAGE);
            return Double.NaN;
        }

        String query = "SELECT saldo FROM CuentaBancaria WHERE numeroCuenta = ?";

        try (Connection conexion = DatabaseConnection.getConnection(); PreparedStatement st = conexion.prepareStatement(query)) {

            st.setLong(1, numCuenta);
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next()) {
                return resultSet.getDouble("saldo");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Detalles : " + e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        return 0;
    }

    // Metodo para verificar si una cuenta le pertenece a un cliente
    public boolean esPropietarioDeCuenta(int numeroCuenta, int clienteId) {
        String query = "SELECT cliente_id FROM CuentaBancaria WHERE numeroCuenta = ?";
        try (Connection conexion = DatabaseConnection.getConnection(); PreparedStatement st = conexion.prepareStatement(query)) {

            st.setLong(1, numeroCuenta);
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("cliente_id") == clienteId;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Detalles : " + e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }

    // Método para obtener todas las cuentas bancarias asociadas a un cliente   
    public List<CuentaBancaria> obtenerCuentasCliente(int idCliente) {

        List<CuentaBancaria> cuentas = new ArrayList<>();
        String query = "SELECT numeroCuenta, saldo FROM CuentaBancaria WHERE cliente_id = ?";

        try (Connection conexion = DatabaseConnection.getConnection(); PreparedStatement st = conexion.prepareStatement(query);) {

            st.setInt(1, idCliente);

            ResultSet resultSet = st.executeQuery();

            while (resultSet.next()) {
                // Guardar datos de la cuenta leida
                int numeroCuenta = resultSet.getInt("numeroCuenta");
                double saldo = resultSet.getDouble("saldo");

                CuentaBancaria cuenta = new CuentaBancaria(saldo, idCliente);
                cuenta.setNumeroCuenta(numeroCuenta);
                cuentas.add(cuenta);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Detalles : " + e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        return cuentas;
    }

    // Metodo para obtener los ID de todas las cuentas de un cliente
    public List<Integer> obtenerNUMsCuentas(int idCliente) {
        List<Integer> numerosCuenta = new ArrayList<>();

        String query = "SELECT numeroCuenta FROM CuentaBancaria WHERE cliente_id = ?";

        try (Connection conexion = DatabaseConnection.getConnection(); PreparedStatement st = conexion.prepareStatement(query);) {

            st.setInt(1, idCliente);

            ResultSet resultSet = st.executeQuery();

            while (resultSet.next()) {
                // Guardar datos de la cuenta leida
                int numeroCuenta = resultSet.getInt("numeroCuenta");
                numerosCuenta.add(numeroCuenta);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Detalles : " + e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        return numerosCuenta;
    }

    // Metodo para obtener el id del cliente propietario de una cuenta bancaria
    public Integer getIDcliente_CuentaB(int numcuenta) {
        String query = "SELECT cliente_id FROM CuentaBancaria WHERE numeroCuenta = ?";
        try (Connection conexion = DatabaseConnection.getConnection(); PreparedStatement st = conexion.prepareStatement(query)) {

            st.setInt(1, numcuenta);
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("cliente_id");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Detalles : " + e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }

    // Metodo para eliminar una cuenta bancaria
    public boolean eliminarCuenta(int numCuenta, int clienteId) {

        if (!esPropietarioDeCuenta(numCuenta, clienteId)) {
            JOptionPane.showMessageDialog(null, "No eres propietario de la cuenta " + numCuenta, "Operacion fallida", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        String query = "DELETE FROM CuentaBancaria WHERE numeroCuenta = ?";

        try (Connection conexion = DatabaseConnection.getConnection(); PreparedStatement st = conexion.prepareStatement(query);) {

            st.setInt(1, numCuenta);
            int affectedRows = st.executeUpdate();
            return affectedRows > 0;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Detalles : " + e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }

}
