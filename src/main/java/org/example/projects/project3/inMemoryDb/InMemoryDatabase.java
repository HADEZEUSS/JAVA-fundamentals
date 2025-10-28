package org.example.projects.project3.inMemoryDb;

import org.example.projects.project3.model.Order;
import org.example.projects.project3.model.Product;
import org.example.projects.project3.model.User;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryDatabase {
    private static final Map<Long, Product> products = new HashMap<>();
    private static final Map<Long, User> users = new HashMap<>();
    private static final Map<Long, Order> orders = new HashMap<>();

    private static final AtomicLong productSeq = new AtomicLong(1000);
    private static final AtomicLong userSeq = new AtomicLong(10000);
    private static final AtomicLong orderSeq = new AtomicLong(50000);

    public static Map<Long, Product> getProducts() {
        return products;
    }

    public static Map<Long, User> getUsers() {
        return users;
    }

    public static Map<Long, Order> getOrders() {
        return orders;
    }

    public static long nextProductId() {
        return productSeq.incrementAndGet();
    }

    public static long nextUserId() {
        return userSeq.incrementAndGet();
    }

    public static long nextOrderId() {
        return orderSeq.incrementAndGet();
    }

    public static Product saveProduct(Product p) {
        if (p.getProductId() == null) p.setProductId(nextProductId());
        products.put(p.getProductId(), p);
        return p;
    }

    public static User saveUser(User u) {
        if (u.getUserId() == null) u.setUserId(nextUserId());
        users.put(u.getUserId(), u);
        return u;
    }

    public static Order saveOrder(Order o) {
        if (o.getOrderId() == null) o.setOrderId(nextOrderId());
        orders.put(o.getOrderId(), o);
        return o;
    }
}
