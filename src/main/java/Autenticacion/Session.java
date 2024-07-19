package Autenticacion;

import Modelos.Usuario;

public class Session {

    private static Session instance;
    private Usuario usuario;

    private Session() {
    }

    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void cerrarSesion() {
        if (this.usuario != null) {
            this.usuario = null;
        }
    }
}
