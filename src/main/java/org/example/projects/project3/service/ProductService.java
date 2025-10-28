package org.example.projects.project3.service;

import org.example.projects.project3.enums.ProductCategory;
import org.example.projects.project3.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    void addProduct(Product product);

    void deleteProduct(Long productId);

    void deleteProduct(Product product);

    void deleteAllProducts();

    Optional<Product> findProductById(Long id);

    List<Product> findProductByName(String name);

    List<Product> getAllProducts();

    void updateProduct(Long productId, Product updatedProduct);

    List<Product> filterByPriceRange(double min, double max);

    List<Product> filterByCategory(ProductCategory category);

    List<Product> filterByCategory(String category);

    void updateProductStock(Long productId, int newStock);

    List<Product> filterAvailableProducts();

}
