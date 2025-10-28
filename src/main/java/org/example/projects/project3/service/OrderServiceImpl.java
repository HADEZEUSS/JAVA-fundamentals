package org.example.projects.project3.service;

import org.example.projects.project3.enums.OrderStatus;
import org.example.projects.project3.exceptions.InsufficientStockException;
import org.example.projects.project3.model.Order;
import org.example.projects.project3.model.Product;
import org.example.projects.project3.model.ShoppingCart;
import org.example.projects.project3.util.ReceiptWriter;

import java.time.LocalDateTime;
import java.util.*;

public class OrderServiceImpl implements OrderService {

    private final ProductService productService;
    private final List<Order> orderHistory = new ArrayList<>();
    private long nextOrderId = 1;

    public OrderServiceImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public Order placeOrder(ShoppingCart cart) {
        Map<Product, Integer> items = cart.getItems();
        if (items.isEmpty()) throw new IllegalStateException("Cart is empty.");

        // Check stock
        for (var e : items.entrySet()) {
            Product p = productService.findProductById(e.getKey().getProductId()).orElseThrow(() -> new IllegalStateException("Product not found: " + e.getKey().getProductId()));
            if (p.getStockQuantity() < e.getValue()) {
                throw new InsufficientStockException("Not enough stock for: " + p.getName());
            }
        }

        // Deduct stock
        for (var e : items.entrySet()) {
            Product p = productService.findProductById(e.getKey().getProductId()).get();
            p.setStockQuantity(p.getStockQuantity() - e.getValue());
            productService.updateProduct(p.getProductId(), p);
        }

        // Create order
        double total = items.entrySet().stream().mapToDouble(i -> i.getKey().getPrice() * i.getValue()).sum();
        Order order = Order.builder().orderId(nextOrderId++).userId(cart.getUser().getUserId()).orderedProducts(new HashMap<>(items)).totalAmount(total).orderDate(LocalDateTime.now()).status(OrderStatus.COMPLETED).build();

        orderHistory.add(order);

        //Clear cart
        cart.clear();

        //Generate receipt
        ReceiptWriter.writeReceipt(order);

        return order;
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderHistory.stream().filter(o -> o.getOrderId().equals(id)).findFirst();
    }

    @Override
    public List<Order> listOrders() {
        List<Order> sorted = new ArrayList<>(orderHistory);
        sorted.sort(Comparator.comparing(Order::getOrderDate).reversed());
        return sorted;
    }
}
