package Entidades;

public class Usuario {

    private int id;
    private String username;
    private String password;
    private Integer clienteId;
    private String role;

    // Constructor
    public Usuario(int id, String username, String password, Integer clienteId, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.clienteId = clienteId;
        this.role = role;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
