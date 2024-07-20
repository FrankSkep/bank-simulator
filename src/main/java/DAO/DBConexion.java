package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConexion {

    private static final String URL = "jdbc:postgresql://localhost:5432/bancodb";
    private static final String USER = "postgres";
    private static final String PASSWORD = "skeptic";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
