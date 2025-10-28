package org.example.projects.project3.inMemoryDb;

import org.example.projects.project3.model.Order;
import org.example.projects.project3.model.ShoppingCart;
import org.example.projects.project3.service.OrderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JsonOrder implements OrderService {

    @Override
    public Optional<Order> findById(Long id) {
        return Optional.ofNullable(InMemoryDatabase.getOrders().get(id));
    }

    @Override
    public List<Order> listOrders() {
        return new ArrayList<>(InMemoryDatabase.getOrders().values());
    }

    @Override
    public Order placeOrder(ShoppingCart cart) {
        throw new UnsupportedOperationException("Use OrderServiceImpl for order placement in fallback mode.");
    }
}
