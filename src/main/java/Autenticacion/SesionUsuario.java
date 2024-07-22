package Autenticacion;

import Entidades.Usuario;

public class SesionUsuario {

    private static SesionUsuario instance;
    private Usuario usuario;

    private SesionUsuario() {}

    public static SesionUsuario getInstance() {
        if (instance == null) {
            instance = new SesionUsuario();
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
