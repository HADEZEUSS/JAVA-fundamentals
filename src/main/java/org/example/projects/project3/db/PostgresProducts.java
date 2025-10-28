package org.example.projects.project3.db;

import org.example.projects.project3.enums.ProductCategory;
import org.example.projects.project3.model.Product;
import org.example.projects.project3.service.ProductService;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PostgresProducts implements ProductService {

    private final DataSource ds;

    public PostgresProducts(DataSource ds) {
        this.ds = ds;
    }

    private Product mapRow(ResultSet rs) throws SQLException {
        Long id = rs.getLong("product_id");
        String name = rs.getString("name");
        Double price = rs.getDouble("price");
        String cat = rs.getString("category");
        int stock = rs.getInt("stock_quantity");

        ProductCategory category = null;
        if (cat != null) {
            try {
                category = ProductCategory.valueOf(cat);
            } catch (Exception ignored) {
            }
        }

        return Product.builder().productId(id).name(name).price(price).category(category).stockQuantity(stock).build();
    }

    @Override
    public void addProduct(Product product) {
        String sql = "INSERT INTO products(name, price, category, stock_quantity) VALUES (?, ?, ?, ?) RETURNING product_id";
        try (Connection c = ds.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setString(3, product.getCategory() != null ? product.getCategory().name() : null);
            ps.setInt(4, product.getStockQuantity() != null ? product.getStockQuantity() : 0);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) product.setProductId(rs.getLong("product_id"));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Failed to add product", e);
        }
    }

    @Override
    public void deleteProduct(Long productId) {
        String sql = "DELETE FROM products WHERE product_id = ?";
        try (Connection c = ds.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, productId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to delete product", e);
        }
    }

    @Override
    public void deleteProduct(Product product) {
        if (product != null && product.getProductId() != null) deleteProduct(product.getProductId());
    }

    @Override
    public void deleteAllProducts() {
        try (Connection c = ds.getConnection(); PreparedStatement ps = c.prepareStatement("DELETE FROM products")) {
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to delete all products", e);
        }
    }

    @Override
    public Optional<Product> findProductById(Long id) {
        String sql = "SELECT * FROM products WHERE product_id = ?";
        try (Connection c = ds.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return Optional.of(mapRow(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find product by id", e);
        }
        return Optional.empty();
    }

    @Override
    public List<Product> findProductByName(String name) {
        String sql = "SELECT * FROM products WHERE LOWER(name) LIKE LOWER(?)";
        try (Connection c = ds.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, "%" + name + "%");
            try (ResultSet rs = ps.executeQuery()) {
                List<Product> out = new ArrayList<>();
                while (rs.next()) out.add(mapRow(rs));
                return out;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find product by name", e);
        }
    }

    @Override
    public List<Product> getAllProducts() {
        try (Connection c = ds.getConnection(); PreparedStatement ps = c.prepareStatement("SELECT * FROM products"); ResultSet rs = ps.executeQuery()) {

            List<Product> out = new ArrayList<>();
            while (rs.next()) out.add(mapRow(rs));
            return out;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to get all products", e);
        }
    }

    @Override
    public void updateProduct(Long productId, Product updatedProduct) {
        String sql = "UPDATE products SET name=?, price=?, category=?, stock_quantity=? WHERE product_id=?";
        try (Connection c = ds.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, updatedProduct.getName());
            ps.setDouble(2, updatedProduct.getPrice());
            ps.setString(3, updatedProduct.getCategory() != null ? updatedProduct.getCategory().name() : null);
            ps.setInt(4, updatedProduct.getStockQuantity() != null ? updatedProduct.getStockQuantity() : 0);
            ps.setLong(5, productId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to update product", e);
        }
    }

    @Override
    public List<Product> filterByPriceRange(double min, double max) {
        String sql = "SELECT * FROM products WHERE price BETWEEN ? AND ?";
        try (Connection c = ds.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setDouble(1, min);
            ps.setDouble(2, max);
            try (ResultSet rs = ps.executeQuery()) {
                List<Product> out = new ArrayList<>();
                while (rs.next()) out.add(mapRow(rs));
                return out;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to filter by price range", e);
        }
    }

    @Override
    public List<Product> filterByCategory(ProductCategory category) {
        String sql = "SELECT * FROM products WHERE category = ?";
        try (Connection c = ds.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, category.name());
            try (ResultSet rs = ps.executeQuery()) {
                List<Product> out = new ArrayList<>();
                while (rs.next()) out.add(mapRow(rs));
                return out;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to filter by category", e);
        }
    }

    @Override
    public List<Product> filterByCategory(String category) {
        // fallback method for interface
        return filterByCategory(ProductCategory.valueOf(category.toUpperCase()));
    }

    @Override
    public void updateProductStock(Long productId, int newStock) {
        String sql = "UPDATE products SET stock_quantity = ? WHERE product_id = ?";
        try (Connection c = ds.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, newStock);
            ps.setLong(2, productId);
            int updated = ps.executeUpdate();
            if (updated == 0) {
                throw new RuntimeException("Product not found with ID: " + productId);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to update product stock: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Product> filterAvailableProducts() {
        return getAllProducts().stream().filter(p -> p.getStockQuantity() != null && p.getStockQuantity() > 0).collect(Collectors.toList());
    }

}
