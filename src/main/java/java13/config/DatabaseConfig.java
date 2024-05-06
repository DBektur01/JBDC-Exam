package java13.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Author: Bektur Duyshenbek uulu
 */
public class DatabaseConfig {

    public static Connection getConnection() {
        try {
            System.out.println("Connected to PostgreSQL database");

            return   DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    "postgres"
            );

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}
