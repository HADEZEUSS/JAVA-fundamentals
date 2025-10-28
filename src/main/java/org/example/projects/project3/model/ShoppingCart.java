package org.example.projects.project3.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ShoppingCart {
    private final User user;
    private final Map<Product, Integer> items = new HashMap<>();

    public void addProduct(Product product, int quantity) {
        if (product == null || quantity <= 0) return;
        items.merge(product, quantity, Integer::sum);
    }

    public void removeProduct(Product product) {
        items.remove(product);
    }

    public double calculateTotal() {
        return items.entrySet().stream().mapToDouble(e -> e.getKey().getPrice() * e.getValue()).sum();
    }

    public void clear() {
        items.clear();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
