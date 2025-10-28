package org.example.projects.project3.service;

import org.example.projects.project3.db.DatabaseRepository;
import org.example.projects.project3.enums.ProductCategory;
import org.example.projects.project3.inMemoryDb.InMemoryDatabase;
import org.example.projects.project3.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {

    // The active repository (PostgreSQL or JSON fallback)
    private final ProductService productRepo;

    public ProductServiceImpl() {
        this.productRepo = DatabaseRepository.getProductRepo();
    }

    // Add product
    @Override
    public void addProduct(Product product) {
        try {
            productRepo.addProduct(product);
        } catch (Exception e) {
            // fallback to in-memory
            System.err.println("DB addProduct failed, saving to memory: " + e.getMessage());
            InMemoryDatabase.saveProduct(product);
        }
    }

    // Delete product by ID
    @Override
    public void deleteProduct(Long productId) {
        try {
            productRepo.deleteProduct(productId); // works in Postgres or JSON repo
            System.out.println("✅ Product deleted: ID " + productId);
        } catch (Exception e) {
            System.err.println("⚠️ Failed to delete product: " + e.getMessage());
        }
    }


    // Delete product by object
    @Override
    public void deleteProduct(Product product) {
        try {
            productRepo.deleteProduct(product);
        } catch (Exception e) {
            if (product != null && product.getProductId() != null) {
                InMemoryDatabase.getProducts().remove(product.getProductId());
            }
        }
    }

    // Delete all products
    @Override
    public void deleteAllProducts() {
        try {
            productRepo.deleteAllProducts();
        } catch (Exception e) {
            System.err.println("DB deleteAllProducts failed: " + e.getMessage());
            InMemoryDatabase.getProducts().clear();
        }
    }

    // Find product by ID
    @Override
    public Optional<Product> findProductById(Long id) {
        try {
            return productRepo.findProductById(id);
        } catch (Exception e) {
            return Optional.ofNullable(InMemoryDatabase.getProducts().get(id));
        }
    }

    // Find products by name (case-insensitive)
    @Override
    public List<Product> findProductByName(String name) {
        try {
            return productRepo.findProductByName(name);
        } catch (Exception e) {
            String term = (name == null ? "" : name.toLowerCase());
            return InMemoryDatabase.getProducts().values().stream().filter(p -> p.getName() != null && p.getName().toLowerCase().contains(term)).collect(Collectors.toList());
        }
    }

    // Get all products
    @Override
    public List<Product> getAllProducts() {
        try {
            return productRepo.getAllProducts();
        } catch (Exception e) {
            return new ArrayList<>(InMemoryDatabase.getProducts().values());
        }
    }

    // Update product completely
    @Override
    public void updateProduct(Long productId, Product updatedProduct) {
        try {
            productRepo.updateProduct(productId, updatedProduct);
        } catch (Exception e) {
            System.err.println("DB updateProduct failed: " + e.getMessage());
            InMemoryDatabase.getProducts().put(productId, updatedProduct);
        }
    }

    // Filter by price
    @Override
    public List<Product> filterByPriceRange(double min, double max) {
        try {
            return productRepo.filterByPriceRange(min, max);
        } catch (Exception e) {
            return InMemoryDatabase.getProducts().values().stream().filter(p -> p.getPrice() != null && p.getPrice() >= min && p.getPrice() <= max).collect(Collectors.toList());
        }
    }

    // Filter by enum category
    @Override
    public List<Product> filterByCategory(ProductCategory category) {
        try {
            return productRepo.filterByCategory(category);
        } catch (Exception e) {
            return InMemoryDatabase.getProducts().values().stream().filter(p -> p.getCategory() == category).collect(Collectors.toList());
        }
    }

    // Filter by string category
    @Override
    public List<Product> filterByCategory(String category) {
        try {
            return productRepo.filterByCategory(category);
        } catch (Exception e) {
            if (category == null || category.isBlank()) return new ArrayList<>();
            String c = category.trim().toUpperCase();
            return InMemoryDatabase.getProducts().values().stream().filter(p -> p.getCategory() != null && p.getCategory().name().equalsIgnoreCase(c)).collect(Collectors.toList());
        }
    }

    // Update only stock quantity
    @Override
    public void updateProductStock(Long productId, int newQuantity) {
        try {
            productRepo.updateProductStock(productId, newQuantity);
        } catch (Exception e) {
            System.err.println("DB updateProductStock failed: " + e.getMessage());
            Product p = InMemoryDatabase.getProducts().get(productId);
            if (p != null) p.setStockQuantity(newQuantity);
            else System.err.println("Product not found in memory for ID: " + productId);
        }
    }

    // Filter products in stock only
    @Override
    public List<Product> filterAvailableProducts() {
        try {
            return productRepo.filterAvailableProducts();
        } catch (Exception e) {
            return InMemoryDatabase.getProducts().values().stream().filter(p -> p.getStockQuantity() != null && p.getStockQuantity() > 0).collect(Collectors.toList());
        }
    }
}
