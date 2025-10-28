package org.example.projects.project3.inMemoryDb;

import org.example.projects.project3.enums.ProductCategory;
import org.example.projects.project3.model.Product;
import org.example.projects.project3.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class JsonProduct implements ProductService {

    // Load initial products from JSON into memory if empty
    public JsonProduct(String jsonPath) {
        if (InMemoryDatabase.getProducts().isEmpty()) {
            JsonDataLoader.loadProducts(jsonPath);
        }
    }

    // Add a product to in-memory DB
    @Override
    public void addProduct(Product product) {
        InMemoryDatabase.saveProduct(product);
    }

    // Delete product by ID
    @Override
    public void deleteProduct(Long productId) {
        if (productId != null) {
            InMemoryDatabase.getProducts().remove(productId);
        }
    }

    // Delete product by object
    @Override
    public void deleteProduct(Product product) {
        if (product != null && product.getProductId() != null) {
            InMemoryDatabase.getProducts().remove(product.getProductId());
        }
    }

    // Clear all products
    @Override
    public void deleteAllProducts() {
        InMemoryDatabase.getProducts().clear();
    }

    // Find product by ID
    @Override
    public Optional<Product> findProductById(Long id) {
        return Optional.ofNullable(InMemoryDatabase.getProducts().get(id));
    }

    // Search products by name (case-insensitive)
    @Override
    public List<Product> findProductByName(String name) {
        if (name == null || name.isBlank()) return new ArrayList<>();
        String term = name.toLowerCase();
        return InMemoryDatabase.getProducts().values().stream().filter(p -> p.getName() != null && p.getName().toLowerCase().contains(term)).collect(Collectors.toList());
    }

    // Get all products
    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(InMemoryDatabase.getProducts().values());
    }

    // Update product details
    @Override
    public void updateProduct(Long productId, Product updatedProduct) {
        if (productId == null || updatedProduct == null) return;
        updatedProduct.setProductId(productId); // ensure ID is preserved
        InMemoryDatabase.getProducts().put(productId, updatedProduct);
    }

    // Filter products by price range
    @Override
    public List<Product> filterByPriceRange(double min, double max) {
        return InMemoryDatabase.getProducts().values().stream().filter(p -> p.getPrice() != null && p.getPrice() >= min && p.getPrice() <= max).collect(Collectors.toList());
    }

    // Filter products by enum category
    @Override
    public List<Product> filterByCategory(ProductCategory category) {
        if (category == null) return new ArrayList<>();
        return InMemoryDatabase.getProducts().values().stream().filter(p -> p.getCategory() == category).collect(Collectors.toList());
    }

    // Filter products by category name (string)
    public List<Product> filterByCategory(String category) {
        if (category == null || category.isBlank()) return new ArrayList<>();
        String c = category.trim().toUpperCase();
        return InMemoryDatabase.getProducts().values().stream().filter(p -> p.getCategory() != null && p.getCategory().name().equalsIgnoreCase(c)).collect(Collectors.toList());
    }

    // Update stock quantity of product
    @Override
    public void updateProductStock(Long productId, int newStock) {
        Product product = findProductById(productId).orElseThrow(() -> new RuntimeException("❌ Product not found: " + productId));
        product.setStockQuantity(newStock);
        updateProduct(productId, product); // persist changes
    }

    // Get only products that are in stock
    @Override
    public List<Product> filterAvailableProducts() {
        return getAllProducts().stream().filter(p -> p.getStockQuantity() != null && p.getStockQuantity() > 0).collect(Collectors.toList());
    }

}
