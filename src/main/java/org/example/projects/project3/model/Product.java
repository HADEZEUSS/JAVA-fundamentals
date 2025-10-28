package org.example.projects.project3.model;

import lombok.*;
import org.example.projects.project3.enums.ProductCategory;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long productId;
    private String name;
    private Double price;
    private ProductCategory category;
    private Integer stockQuantity;
}
