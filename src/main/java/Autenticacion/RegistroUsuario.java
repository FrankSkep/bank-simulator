package Autenticacion;

import DAO.ClienteDAO;
import DAO.UsuarioDAO;
import Entidades.Cliente;

public class RegistroUsuario {

    private UsuarioDAO usuarioDAO;
    private ClienteDAO clienteDAO;

    public RegistroUsuario() {
        usuarioDAO = new UsuarioDAO();
        clienteDAO = new ClienteDAO();
    }

    public boolean registrarAdmin(String username, String password) {
        // Validar si el nombre de usuario esta disponible
        if (usuarioDAO.usernameExiste(username)) {
            return false; // El nombre de usuario ya existe
        }

        // 2. Registrar el nuevo usuario administrador
        return usuarioDAO.registrarUsuario(username, password, "ADMIN");
    }

    // Método para registrar un nuevo usuario y cliente
    public boolean registrarClienteYUsuario(String username, String password, Cliente cliente) {

        // Validar si el nombre de usuario esta disponible
        if (usuarioDAO.usernameExiste(username)) {
            return false; // El nombre de usuario ya existe
        }

        // 1. Registrar el nuevo cliente
        boolean clienteRegistrado = clienteDAO.registrarCliente(cliente);

        if (!clienteRegistrado) {
            return false; // Si fallo el registro
        }

        // Obtener el ID del cliente recién registrado
        int clienteId = clienteDAO.obtenerIdPorNombre(cliente.getNombre()); // Implementa este método en ClienteDAO

        // 2. Registrar el nuevo usuario y asociarlo al cliente
        return usuarioDAO.registrarUsuario(username, password, clienteId, "USER");
    }
}
