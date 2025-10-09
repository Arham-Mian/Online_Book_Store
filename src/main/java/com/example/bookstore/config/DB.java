package com.example.bookstore.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Central DB config.
 * Resolution order for credentials:
 *   1) JVM system properties:  -Ddb.url=..  -Ddb.user=..  -Ddb.pass=..
 *   2) Environment variables:  DB_URL / DB_USER / DB_PASS
 *   3) Local defaults (good for dev)
 */
public final class DB {

    private DB() {}

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL driver not found on the classpath.", e);
        }
    }

    // --- Local defaults (DEV) ---
    private static final String DEFAULT_URL =
            "jdbc:mysql://localhost:3306/bookstore?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String DEFAULT_USER = "bookapp";
    private static final String DEFAULT_PASS = "BookApp@123";

    // Resolve with priority: system property -> env var -> default
    private static String resolve(String propKey, String envKey, String defVal) {
        String v = System.getProperty(propKey);
        if (v != null && !v.isBlank()) return v.trim();
        v = System.getenv(envKey);
        if (v != null && !v.isBlank()) return v.trim();
        return defVal;
    }

    private static final String URL  = resolve("db.url",  "DB_URL",  DEFAULT_URL);
    private static final String USER = resolve("db.user", "DB_USER", DEFAULT_USER);
    private static final String PASS = resolve("db.pass", "DB_PASS", DEFAULT_PASS);

    public static Connection getConnection() throws SQLException {
        try {
            Connection c = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("✅ DB connected as '" + USER + "'");
            System.out.println("✅ DB URL in use: " + URL + sourceNote());
            // Optional: print active catalog (schema) once per JVM
            try {
                String catalog = c.getCatalog();
                System.out.println("✅ Active schema (catalog): " + catalog);
            } catch (SQLException ignored) {}
            return c;
        } catch (SQLException e) {
            System.err.println("❌ DB connect failed. URL in use: " + URL + sourceNote());
            throw e;
        }
    }

    private static String sourceNote() {
        // Helpful hint about where the URL came from
        String src = (System.getProperty("db.url") != null) ? " (from -Ddb.url)"
                : (System.getenv("DB_URL") != null) ? " (from env DB_URL)"
                : " (default)";
        return src;
    }
}
