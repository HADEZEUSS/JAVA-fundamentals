package org.example.projects.project3.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

public class DBManager {
    private static HikariDataSource ds;

    public static DataSource tryInit(String jdbcUrl, String user, String pass) {
        try {
            HikariConfig cfg = new HikariConfig();
            cfg.setJdbcUrl(jdbcUrl != null ? jdbcUrl : "jdbc:postgresql://localhost:5433/main_db");
            cfg.setUsername(user != null ? user : "postgres");
            cfg.setPassword(pass != null ? pass : "kali");
            cfg.setMaximumPoolSize(5);

            ds = new HikariDataSource(cfg);

            try (Connection c = ds.getConnection()) {
                if (c == null || c.isClosed()) throw new RuntimeException("Connection invalid");
            }

            System.out.println("Connected to PostgreSQL");
            return ds;

        } catch (Exception ex) {
            System.err.println("Failed to connect to PostgreSQL: " + ex.getMessage());
            if (ds != null) {
                try {
                    ds.close();
                } catch (Exception ignore) {
                }
            }
            ds = null;
            return null;
        }
    }

    public static void close() {
        if (ds != null) ds.close();
    }
}
