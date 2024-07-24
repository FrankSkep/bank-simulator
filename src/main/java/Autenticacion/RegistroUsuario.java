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
            return false;
        }

        // Registrar el nuevo usuario administrador
        return usuarioDAO.registrarUsuario(username, password, "ADMIN");
    }

    // Método para registrar un nuevo usuario y cliente
    public boolean registrarClienteYUsuario(String username, String password, Cliente cliente) {

        // Validar si el nombre de usuario esta disponible
        if (usuarioDAO.usernameExiste(username)) {
            return false;
        }

        // Registrar el nuevo cliente
        boolean clienteRegistrado = clienteDAO.registrarCliente(cliente);

        if (!clienteRegistrado) {
            return false;
        }

        // Registrar el nuevo usuario y asociarlo al cliente
        return usuarioDAO.registrarUsuario(username, password, cliente.getID(), "USER");
    }
}
