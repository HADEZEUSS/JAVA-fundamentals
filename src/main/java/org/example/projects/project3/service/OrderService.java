package org.example.projects.project3.service;

import org.example.projects.project3.exceptions.EmptyCartException;
import org.example.projects.project3.exceptions.InsufficientStockException;
import org.example.projects.project3.model.Order;
import org.example.projects.project3.model.ShoppingCart;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order placeOrder(ShoppingCart cart) throws EmptyCartException, InsufficientStockException;

    Optional<Order> findById(Long id);

    List<Order> listOrders();
}
