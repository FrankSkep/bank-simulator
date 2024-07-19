package Autenticacion;

import DAO_DB.ClienteDAO;
import DAO_DB.UsuarioDAO;
import Modelos.Cliente;

public class Registro {

    private UsuarioDAO usuarioDAO;
    private ClienteDAO clienteDAO;

    public Registro() {
        usuarioDAO = new UsuarioDAO();
        clienteDAO = new ClienteDAO();
    }

    // Método para registrar un nuevo cliente y usuario
    public boolean registrarClienteYUsuario(String username, String password, Cliente cliente) {

        // Validar si el nombre de usuario esta disponible
        if (usuarioDAO.usernameExiste(username)) {
            return false; // El nombre de usuario ya existe
        }

        // 1. Registrar el nuevo cliente
        boolean clienteRegistrado = clienteDAO.registrarCliente(cliente);

        if (!clienteRegistrado) {
            return false; // Si no se pudo registrar
        }

        // Obtener el ID del cliente recién registrado
        int clienteId = clienteDAO.obtenerIdPorNombre(cliente.getNombre()); // Implementa este método en ClienteDAO

        // 2. Registrar el nuevo usuario
        return usuarioDAO.registrarUsuario(username, password, clienteId);
    }
}
