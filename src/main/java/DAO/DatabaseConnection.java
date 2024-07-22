package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Instancia única de DatabaseConnection
    private static DatabaseConnection instance;

    // URL de conexión a la base de datos
    private static final String URL = "jdbc:postgresql://localhost:5432/bancodb";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123456";

    // Constructor privado para evitar instanciación externa
    private DatabaseConnection() {
        try {
            // Registrar el driver de la base de datos
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: " + e.toString());
        }
    }

    // Método para obtener la instancia única de DatabaseConnection
    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    // Método para obtener una conexión a la base de datos
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
