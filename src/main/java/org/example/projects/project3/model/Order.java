package org.example.projects.project3.model;

import lombok.*;
import org.example.projects.project3.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long orderId;
    private Long userId;
    private Map<Product, Integer> orderedProducts;
    private Double totalAmount;
    private LocalDateTime orderDate;
    private OrderStatus status;
}
