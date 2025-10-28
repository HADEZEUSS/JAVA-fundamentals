package org.example.projects.project3.db;

import org.example.projects.project3.enums.OrderStatus;
import org.example.projects.project3.enums.ProductCategory;
import org.example.projects.project3.model.Order;
import org.example.projects.project3.model.Product;
import org.example.projects.project3.model.ShoppingCart;
import org.example.projects.project3.service.OrderService;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;

public class PostgresOrder implements OrderService {
    private final DataSource ds;

    public PostgresOrder(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public Order placeOrder(ShoppingCart cart) {
        if (cart == null || cart.isEmpty()) {
            throw new IllegalArgumentException("Cart is empty");
        }

        String insertOrder = """
                    INSERT INTO orders (user_id, total_amount, order_date, status)
                    VALUES (?, ?, ?, ?)
                    RETURNING order_id
                """;

        String insertItem = """
                    INSERT INTO order_items (order_id, product_id, quantity, price)
                    VALUES (?, ?, ?, ?)
                """;

        try (Connection conn = ds.getConnection()) {
            conn.setAutoCommit(false);

            Long orderId;
            try (PreparedStatement ps = conn.prepareStatement(insertOrder)) {
                ps.setLong(1, cart.getUser().getUserId());
                ps.setDouble(2, cart.calculateTotal());
                ps.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
                ps.setString(4, OrderStatus.COMPLETED.name());

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        orderId = rs.getLong("order_id");
                    } else {
                        conn.rollback();
                        throw new SQLException("Failed to insert order");
                    }
                }
            }

            try (PreparedStatement ps = conn.prepareStatement(insertItem)) {
                for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
                    ps.setLong(1, orderId);
                    ps.setLong(2, entry.getKey().getProductId());
                    ps.setInt(3, entry.getValue());
                    ps.setDouble(4, entry.getKey().getPrice());
                    ps.addBatch();
                }
                ps.executeBatch();
            }

            conn.commit();

            // Build the order object
            Order order = Order.builder().orderId(orderId).userId(cart.getUser().getUserId()).orderedProducts(new HashMap<>(cart.getItems())).totalAmount(cart.calculateTotal()).orderDate(LocalDateTime.now()).status(OrderStatus.COMPLETED).build();

            cart.clear();
            return order;

        } catch (SQLException e) {
            throw new RuntimeException("Failed to place order: " + e.getMessage(), e);
        }
    }

    @Override
    public Optional<Order> findById(Long id) {
        String qOrder = "SELECT order_id, user_id, total_amount, order_date, status FROM orders WHERE order_id = ?";
        String qItems = "SELECT product_id, quantity, price FROM order_items WHERE order_id = ?";

        try (Connection c = ds.getConnection(); PreparedStatement psOrder = c.prepareStatement(qOrder)) {

            psOrder.setLong(1, id);

            try (ResultSet rsOrder = psOrder.executeQuery()) {
                if (!rsOrder.next()) return Optional.empty();

                Long orderId = rsOrder.getLong("order_id");
                Long userId = rsOrder.getLong("user_id");
                Double total = rsOrder.getDouble("total_amount");
                LocalDateTime date = rsOrder.getTimestamp("order_date").toLocalDateTime();
                OrderStatus status = OrderStatus.valueOf(rsOrder.getString("status"));

                Map<Product, Integer> items = new LinkedHashMap<>();

                try (PreparedStatement psItems = c.prepareStatement(qItems)) {
                    psItems.setLong(1, orderId);

                    try (ResultSet rsItems = psItems.executeQuery()) {
                        while (rsItems.next()) {
                            Long pid = rsItems.getLong("product_id");
                            int qty = rsItems.getInt("quantity");
                            double price = rsItems.getDouble("price");

                            // Try to load full product details
                            Product p;
                            try (PreparedStatement psProd = c.prepareStatement("SELECT name, category, stock_quantity FROM products WHERE product_id = ?")) {
                                psProd.setLong(1, pid);
                                try (ResultSet rsProd = psProd.executeQuery()) {
                                    if (rsProd.next()) {
                                        String categoryStr = rsProd.getString("category");
                                        ProductCategory category = categoryStr != null ? ProductCategory.valueOf(categoryStr) : null;
                                        p = Product.builder().productId(pid).name(rsProd.getString("name")).price(price).category(category).stockQuantity(rsProd.getInt("stock_quantity")).build();
                                    } else {
                                        // Fallback if product record is missing
                                        p = Product.builder().productId(pid).name("Unknown Product " + pid).price(price).build();
                                    }
                                }
                            }
                            items.put(p, qty);
                        }
                    }
                }

                return Optional.of(Order.builder().orderId(orderId).userId(userId).orderedProducts(items).totalAmount(total).orderDate(date).status(status).build());
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error loading order " + id, e);
        }
    }

    @Override
    public List<Order> listOrders() {
        String q = "SELECT order_id FROM orders ORDER BY order_date DESC";
        List<Order> orders = new ArrayList<>();

        try (Connection c = ds.getConnection(); PreparedStatement ps = c.prepareStatement(q); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                findById(rs.getLong("order_id")).ifPresent(orders::add);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to list orders", e);
        }

        //Make the console output
        if (orders.isEmpty()) {
            System.out.println("No orders found.");
        } else {
            System.out.println("\n=== Order History ===");
            for (Order o : orders) {
                System.out.printf("Order #%d | User ID: %d | Status: %s | Total: %.2f | Date: %s%n", o.getOrderId(), o.getUserId(), o.getStatus(), o.getTotalAmount(), o.getOrderDate());

                System.out.println("  Items:");
                o.getOrderedProducts().forEach((p, qty) -> {
                    System.out.printf("    - %-20s (x%d)  %.2f₾%n", p.getName(), qty, p.getPrice());
                });
                System.out.println();
            }
        }

        return orders;
    }
}
