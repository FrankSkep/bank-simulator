package DAO;

import Autenticacion.HashPassword;
import Entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    // Método para registrar un nuevo usuario comun
    public boolean registrarUsuario(String username, String password, Integer clienteId, String role) {
        String salt = HashPassword.getSalt();
        String hashedPassword = HashPassword.hashPassword(password, salt);
        String query = "INSERT INTO Usuario (username, password, salt, cliente_id, role) VALUES (?, ?, ?, ?, ?)";
        try (Connection conexion = DatabaseConnection.getConnection(); PreparedStatement statement = conexion.prepareStatement(query)) {

            statement.setString(1, username);
            statement.setString(2, hashedPassword);
            statement.setString(3, salt);

            if (role.equals("ADMIN")) {
                statement.setNull(4, java.sql.Types.INTEGER);
            } else {
                statement.setInt(4, clienteId);
            }

            statement.setString(5, role);

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Detalles : " + e.toString(), "Ocurrio un error", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }

    // Sobrecarga de metodo, para registrar usuario administrador
    public boolean registrarUsuario(String username, String password, String role) {
        return registrarUsuario(username, password, null, role); // Llama al método principal con clienteId como null
    }

    // Método para verificar las credenciales de usuario
    public Usuario autenticar(String username, String password) {
        String query = "SELECT id, username, password, salt, cliente_id, role FROM Usuario WHERE username = ?";
        try (Connection conexion = DatabaseConnection.getConnection(); PreparedStatement statement = conexion.prepareStatement(query)) {

            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String storedPassword = resultSet.getString("password");
                String storedSalt = resultSet.getString("salt"); // Recupera el salt de la base de datos
                String hashedPassword = HashPassword.hashPassword(password, storedSalt);

                // Compara la contraseña hasheada con la almacenada en la base de datos
                if (storedPassword.equals(hashedPassword)) {
                    int id = resultSet.getInt("id");
                    Integer clienteId = resultSet.getInt("cliente_id");
                    String role = resultSet.getString("role");
                    return new Usuario(id, username, storedPassword, clienteId, role);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Detalles : " + e.toString(), "Ocurrio un error", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }

    // Método para verificar si el nombre de usuario ya existe
    public boolean usernameExiste(String username) {
        String query = "SELECT 1 FROM Usuario WHERE username = ?";
        try (Connection conexion = DatabaseConnection.getConnection(); PreparedStatement statement = conexion.prepareStatement(query)) {

            statement.setString(1, username);
            return statement.executeQuery().next();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Detalles : " + e.toString(), "Ocurrio un error", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }
}
