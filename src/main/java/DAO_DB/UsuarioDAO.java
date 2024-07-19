package DAO_DB;

import Modelos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    // Método para registrar un nuevo usuario
    public boolean registrarUsuario(String username, String password, int clienteId) {
        String salt = PasswordUtils.getSalt();
        String hashedPassword = PasswordUtils.hashPassword(password, salt);
        String query = "INSERT INTO Usuario (username, password, salt, cliente_id) VALUES (?, ?, ?, ?)";
        try (Connection connection = DBConexion.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, username);
            statement.setString(2, hashedPassword);
            statement.setString(3, salt);
            statement.setInt(4, clienteId);

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error : " + e.toString(), "Operacion fallida", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }

    // Método para verificar las credenciales de usuario
    public Usuario autenticar(String username, String password) {
        String query = "SELECT id, username, password, salt, cliente_id FROM Usuario WHERE username = ?";
        try (Connection connection = DBConexion.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String storedPassword = resultSet.getString("password");
                String storedSalt = resultSet.getString("salt"); // Recupera el salt de la base de datos
                String hashedPassword = PasswordUtils.hashPassword(password, storedSalt);

                // Compara la contraseña hasheada con la almacenada en la base de datos
                if (storedPassword.equals(hashedPassword)) {
                    int id = resultSet.getInt("id");
                    int clienteId = resultSet.getInt("cliente_id");
                    return new Usuario(id, username, storedPassword, clienteId);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error : " + e.toString(), "Operacion fallida", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }

    // Método para verificar si el nombre de usuario ya existe
    public boolean usernameExiste(String username) {
        String query = "SELECT 1 FROM Usuario WHERE username = ?";
        try (Connection connection = DBConexion.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, username);
            return statement.executeQuery().next();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error : " + e.toString(), "Operacion fallida", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }
}
