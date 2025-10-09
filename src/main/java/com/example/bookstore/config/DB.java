package com.example.bookstore.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Handles all database connections for the Online Bookstore.
 * Uses MySQL JDBC driver with support for environment overrides.
 *
 * Priority:
 *   1. Environment variables (DB_URL, DB_USER, DB_PASS)
 *   2. Default hardcoded values (for local development)
 */
public class DB {

    static {
        try {
            // ✅ Explicitly load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("❌ MySQL driver not found! Check Maven dependency or classpath.", e);
        }
    }

    // ---------- Default Configuration (Local Dev) ----------
    private static final String DEFAULT_URL  =
            "jdbc:mysql://localhost:3306/bookstore_fresh?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String DEFAULT_USER = "bookapp";       // ✅ app-specific user (not root)
    private static final String DEFAULT_PASS = "BookApp@123";   // ✅ your chosen app password
    // -------------------------------------------------------

    // Allow overriding via environment variables (for Jenkins / cloud / prod)
    private static final String URL  = getEnvOrDefault("DB_URL",  DEFAULT_URL);
    private static final String USER = getEnvOrDefault("DB_USER", DEFAULT_USER);
    private static final String PASS = getEnvOrDefault("DB_PASS", DEFAULT_PASS);

    /**
     * Establishes a new MySQL connection.
     *
     * @return Connection object to interact with MySQL DB
     * @throws SQLException if database is unreachable or credentials invalid
     */
    public static Connection getConnection() throws SQLException {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("✅ Connected to MySQL successfully as user: " + USER);
            return conn;
        } catch (SQLException e) {
            System.err.println("❌ Failed to connect to database. Check credentials and server.");
            System.err.println("URL: " + URL);
            throw e;
        }
    }

    /**
     * Helper method to read environment variable (if exists) else use fallback.
     */
    private static String getEnvOrDefault(String key, String fallback) {
        String value = System.getenv(key);
        return (value != null && !value.isBlank()) ? value : fallback;
    }
}
