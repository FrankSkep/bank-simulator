package Entidades;

import java.util.Objects;

public class Cliente {

    private int id;
    private String nombre;
    private String correo;
    private String telefono;

    // Constructor
    public Cliente(String nombre, String correo, String telefono) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }

    // Getters y setters
    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Cliente cliente = (Cliente) o;

        return id == cliente.id
                && nombre.equals(cliente.nombre)
                && correo.equals(cliente.correo)
                && telefono.equals(cliente.telefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, correo, telefono);
    }
}
