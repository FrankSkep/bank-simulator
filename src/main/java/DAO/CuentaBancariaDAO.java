package DAO;

import Modelos.CuentaBancaria;
import Modelos.Transaccion;
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

    // Metodo para guardar cuenta en la base de datos
    public void guardarCuenta(CuentaBancaria cuenta) {
        String query = "INSERT INTO CuentaBancaria (saldo, cliente_id) VALUES (?, ?)";

        try (Connection connection = DBConexion.getConnection(); PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            statement.setDouble(1, cuenta.getSaldo());
            statement.setInt(2, cuenta.getClienteId());

            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        cuenta.setNumeroCuenta(generatedKeys.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al guardar la cuenta : " + e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Metodo para depositar saldo a una cuenta
    public boolean depositar(int numeroCuenta, double monto, int clienteId, boolean esTransferencia) {

        if (!esTransferencia) {
            if (!esPropietarioDeCuenta(numeroCuenta, clienteId)) {
                JOptionPane.showMessageDialog(null, "No existe esa cuenta para el cliente con ID " + clienteId, "Operacion fallida", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }

        String query = "UPDATE CuentaBancaria SET saldo = saldo + ? WHERE numeroCuenta = ?";
        try (Connection connection = DBConexion.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setDouble(1, monto);
            statement.setInt(2, numeroCuenta);
            statement.executeUpdate();

            if (!esTransferencia) {
                // Registrar la transacción
                LocalDateTime fechaTransaccion = LocalDateTime.now();
                Transaccion transaccionOrigen = new Transaccion(numeroCuenta, fechaTransaccion, "Deposito", monto, "Deposito a mi cuenta numero : " + numeroCuenta);
                transDAO.registrarTransaccion(transaccionOrigen);
            }

            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error : " + e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }

    // Metodo para retirar saldo de una cuenta
    public void retirar(int numeroCuenta, double monto, int clienteId, boolean esTransferencia) {
        if (!esPropietarioDeCuenta(numeroCuenta, clienteId)) {
            JOptionPane.showMessageDialog(null, "No existe esa cuenta para el cliente con ID " + clienteId, "Operacion fallida", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String query = "UPDATE CuentaBancaria SET saldo = saldo - ? WHERE numeroCuenta = ?";
        try (Connection connection = DBConexion.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setDouble(1, monto);
            statement.setLong(2, numeroCuenta);
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error : " + e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
        }

        if (!esTransferencia) {
            // Registrar la transacción
            LocalDateTime fechaTransaccion = LocalDateTime.now();
            Transaccion transaccionOrigen = new Transaccion(numeroCuenta, fechaTransaccion, "Retiro", monto, "Retiro de mi cuenta numero : " + numeroCuenta);
            transDAO.registrarTransaccion(transaccionOrigen);
        }
    }

    // Método para transferir dinero
    public void transferir(int numeroCuentaOrigen, int numeroCuentaDestino, double monto, int clienteId) {
        if (!esPropietarioDeCuenta(numeroCuentaOrigen, clienteId)) {
            System.out.println("El cliente no es propietario de la cuenta origen.");
            return;
        }

        Connection connection = null;
        try {
            connection = DBConexion.getConnection();
            connection.setAutoCommit(false);

            // Retirar del origen
            retirar(numeroCuentaOrigen, monto, clienteId, true);

            // Depositar en el destino
            depositar(numeroCuentaDestino, monto, clienteId, true);

            connection.commit();

//            // Registrar la transacción
//            LocalDateTime fechaTransaccion = LocalDateTime.now();
//            Transaccion transaccionOrigen = new Transaccion(numeroCuentaOrigen, fechaTransaccion, "Transferencia", monto, "Transferencia a cuenta " + numeroCuentaDestino);
//            transDAO.registrarTransaccion(transaccionOrigen);
//
//            Transaccion transaccionDestino = new Transaccion(numeroCuentaDestino, fechaTransaccion, "Transferencia", monto, "Transferencia desde cuenta " + numeroCuentaOrigen);
//            transDAO.registrarTransaccion(transaccionDestino);
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Ocurrio un error : " + ex.toString(), "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
            JOptionPane.showMessageDialog(null, "Ocurrio un error : " + e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
        } finally {
            if (connection != null) {
                try {
                    connection.setAutoCommit(true);
                    connection.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Ocurrio un error : " + e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }

    // Metodo para consultar saldo de una cuenta
    public double consultarSaldo(int numCuenta, int clienteId) {
        if (!esPropietarioDeCuenta(numCuenta, clienteId)) {
            JOptionPane.showMessageDialog(null, "No existe esa cuenta para el cliente con ID " + clienteId, "Operacion fallida", JOptionPane.WARNING_MESSAGE);
            return Double.NaN;
        }

        String query = "SELECT saldo FROM CuentaBancaria WHERE numeroCuenta = ?";

        try (Connection connection = DBConexion.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, numCuenta);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getDouble("saldo");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error : " + e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        return 0;
    }

    // Metodo para verificar si una cuenta le pertenece a un cliente
    public boolean esPropietarioDeCuenta(int numeroCuenta, int clienteId) {
        String query = "SELECT cliente_id FROM CuentaBancaria WHERE numeroCuenta = ?";
        try (Connection connection = DBConexion.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, numeroCuenta);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("cliente_id") == clienteId;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error : " + e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }

    // Metodo para obtener id cliente, mediante numero de cuenta
    public Integer getIDporNumCuenta(int numcuenta) {
        String query = "SELECT cliente_id FROM CuentaBancaria WHERE numeroCuenta = ?";
        try (Connection connection = DBConexion.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, numcuenta);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("cliente_id");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error : " + e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }

    // Método para obtener todas las cuentas bancarias asociadas a un cliente   
    public List<CuentaBancaria> obtenerCuentasCliente(int idCliente) {
        List<CuentaBancaria> cuentas = new ArrayList<>();
        String query = "SELECT numeroCuenta, saldo FROM CuentaBancaria WHERE cliente_id = ?";

        try (Connection connection = DBConexion.getConnection(); PreparedStatement statement = connection.prepareStatement(query);) {

            statement.setInt(1, idCliente);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                // Guardar datos de la cuenta leida
                int numeroCuenta = resultSet.getInt("numeroCuenta");
                double saldo = resultSet.getDouble("saldo");

                CuentaBancaria cuenta = new CuentaBancaria(saldo, idCliente);
                cuenta.setNumeroCuenta(numeroCuenta);
                cuentas.add(cuenta);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Detalles del error : " + e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
        }

        return cuentas;
    }

}
