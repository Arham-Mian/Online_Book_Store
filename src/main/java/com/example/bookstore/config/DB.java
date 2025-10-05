package com.example.bookstore.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    // Explicitly load MySQL JDBC driver (helps with quirky classpaths)
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL driver not found on classpath. Did Maven import the dependency?", e);
        }
    }

    // ---------- Configuration ----------
    // You can override these via environment variables: DB_URL, DB_USER, DB_PASS
    private static final String DEFAULT_URL  =
            "jdbc:mysql://localhost:3306/bookstore?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String DEFAULT_USER = "bookapp";      // <-- recommended app user
    private static final String DEFAULT_PASS = "Book@1234";    // <-- set the same as you created above

    private static final String URL  = valueOrEnv("DB_URL",  DEFAULT_URL);
    private static final String USER = valueOrEnv("DB_USER", DEFAULT_USER);
    private static final String PASS = valueOrEnv("DB_PASS", DEFAULT_PASS);
    // -----------------------------------

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    private static String valueOrEnv(String envKey, String fallback) {
        String v = System.getenv(envKey);
        return (v == null || v.isBlank()) ? fallback : v;
    }
}
