package Autenticacion;

import Modelos.Usuario;

public class SessionInstance {

    private static SessionInstance instance;
    private Usuario usuario;

    private SessionInstance() {
    }

    public static SessionInstance getInstance() {
        if (instance == null) {
            instance = new SessionInstance();
        }
        return instance;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getUsername() {
        return this.usuario.getUsername();
    }

    public void cerrarSesion() {
        if (this.usuario != null) {
            this.usuario = null;
        }
    }
}
