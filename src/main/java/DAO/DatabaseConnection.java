package DAO;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnection {

    private static HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/bancodb");
        config.setUsername("postgres");
        config.setPassword("123456");
        config.setMaximumPoolSize(5);
        config.setDriverClassName("org.postgresql.Driver");
        dataSource = new HikariDataSource(config);
    }

    // Método para obtener una conexión a la base de datos
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
