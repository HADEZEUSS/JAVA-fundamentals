package org.example.projects.project3.db;

import org.example.projects.project3.inMemoryDb.JsonDataLoader;
import org.example.projects.project3.inMemoryDb.JsonProduct;
import org.example.projects.project3.inMemoryDb.JsonUser;
import org.example.projects.project3.model.Product;
import org.example.projects.project3.service.OrderService;
import org.example.projects.project3.service.OrderServiceImpl;
import org.example.projects.project3.service.ProductService;
import org.example.projects.project3.service.UserService;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;

public class DatabaseRepository {

    private static boolean postgresMode = false;

    private static ProductService productRepo;
    private static UserService userRepo;
    private static OrderService orderRepo;

    private static HikariDataSource ds;

    public static void init(String jdbcUrl, String username, String password, String jsonPath) {
        try {
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(jdbcUrl);
            config.setUsername(username);
            config.setPassword(password);
            ds = new HikariDataSource(config);

            try (Connection c = ds.getConnection()) {
                System.out.println("Connected to PostgreSQL");
            }

            postgresMode = true;
            productRepo = new PostgresProducts(ds);
            userRepo = new PostgresUser(ds);
            orderRepo = new PostgresOrder(ds);

            // Load JSON products into DB if DB is empty
            List<Product> products = JsonDataLoader.loadProducts(jsonPath);
            if (productRepo.getAllProducts().isEmpty() && products != null) {
                for (Product p : products) {
                    productRepo.addProduct(p);
                }
                System.out.println("Products loaded into PostgreSQL from JSON (" + products.size() + ")");
            }

        } catch (Exception e) {
            System.err.println("PostgreSQL not available — switching to JSON/InMemory mode: " + e.getMessage());
            postgresMode = false;

            // Fallback to JSON
            JsonProduct jsonRepo = new JsonProduct(jsonPath);
            List<Product> products = JsonDataLoader.loadProducts(jsonPath);
            if (products != null && !products.isEmpty()) {
                for (Product p : products) {
                    jsonRepo.addProduct(p);
                }
                System.out.println("Loaded " + products.size() + " products from JSON (fallback mode)");
            } else {
                System.err.println("No products found in JSON file: " + jsonPath);
            }

            productRepo = jsonRepo;
            userRepo = new JsonUser();
            orderRepo = new OrderServiceImpl(productRepo); // Use full order logic in fallback
        }
    }

    public static boolean isPostgresMode() {
        return postgresMode;
    }

    public static ProductService getProductRepo() {
        return productRepo;
    }

    public static UserService getUserRepo() {
        return userRepo;
    }

    public static OrderService getOrderRepo() {
        return orderRepo;
    }

    public static void close() {
        if (ds != null) ds.close();
    }

}
