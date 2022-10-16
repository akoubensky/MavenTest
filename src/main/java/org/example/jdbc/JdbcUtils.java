package org.example.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
    private static final Properties jdbcProperties = new Properties();
    private static final Connection jdbcConnection = buildConnection();

    private static Connection buildConnection() {
        try {
            jdbcProperties.load(JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            return DriverManager.getConnection(
                    jdbcProperties.getProperty("jdbc.url"),
                    jdbcProperties.getProperty("jdbc.username"),
                    jdbcProperties.getProperty("jdbc.password")
            );
        } catch (IOException | SQLException e) {
            System.out.println("Cannot create connection due to [" + e.getMessage() + "]");
            return null;
        }
    }

    public static Connection getConnection() {
        return jdbcConnection;
    }
}
