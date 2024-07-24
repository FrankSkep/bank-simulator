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

    public void cerrarSesion() {
        if (this.usuario != null) {
            this.usuario = null;
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
