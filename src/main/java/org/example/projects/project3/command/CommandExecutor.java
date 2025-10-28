package org.example.projects.project3.command;

import org.example.projects.project3.enums.ProductCategory;
import org.example.projects.project3.model.Product;
import org.example.projects.project3.model.ShoppingCart;
import org.example.projects.project3.service.*;
import org.example.projects.project3.util.ConsolePrinter;
import org.example.projects.project3.util.ReceiptWriter;

import java.util.List;

public class CommandExecutor {
    private final ProductService productService;
    private final OrderService orderService;
    private final ShoppingCart cart;
    private boolean adminMode = false;

    public CommandExecutor(ProductService productService, OrderService orderService, ShoppingCart cart) {
        this.productService = productService;
        this.orderService = orderService;
        this.cart = cart;
    }

    public void execute(String cmd) {
        try {
            if (cmd.equals("help")) {
                System.out.println("""
                        Available Commands:
                              help                                - Show this help menu
                              admin on/off                        - Enable or disable admin mode
                              list                                - List all products
                              add product name|price|CATEGORY|qty - Add a new product (admin only)
                              delete product productId            - Delete a product (admin only)
                              update stock productId|newQty       - Update product stock (admin only)
                              search <term>                       - Search products by name
                              filter price min|max                - Filter products by price range
                              filter category CATEGORY            - Filter by product category
                              filter available                    - Only products in stock
                              add productId|qty                   - Add product to cart
                              remove productId                    - Remove product from cart
                              cart                                - View cart contents
                              checkout                            - Complete order
                              orders                              - List order history
                              exit                                - Quit the program
                        """);
                return;
            }


            //Admin Mode
            if (cmd.equals("admin on")) {
                adminMode = true;
                System.out.println("Admin mode enabled.");
                return;
            }

            if (cmd.equals("admin off")) {
                adminMode = false;
                System.out.println("Admin mode disabled.");
                return;
            }

            if (cmd.equals("list")) {
                List<Product> products = productService.getAllProducts();
                if (products.isEmpty()) System.out.println("No products available.");
                else products.forEach(System.out::println);
                return;
            }

            if (cmd.equals("filter available")) {
                List<Product> available = productService.filterAvailableProducts();
                if (available.isEmpty()) {
                    System.out.println("No products currently in stock.");
                } else {
                    available.forEach(System.out::println);
                }
                return;
            }


            if (cmd.startsWith("add product ")) {
                if (!adminMode) {
                    System.out.println("Only admins can add products. Use 'admin on' first.");
                    return;
                }

                String[] parts = cmd.substring("add product ".length()).split("\\|");
                if (parts.length < 4) {
                    System.out.println("Usage: add product name|price|CATEGORY|qty");
                    return;
                }

                Product product = Product.builder().name(parts[0].trim()).price(Double.parseDouble(parts[1].trim())).category(ProductCategory.valueOf(parts[2].trim().toUpperCase())).stockQuantity(Integer.parseInt(parts[3].trim())).build();

                productService.addProduct(product);
                System.out.println("Product added: " + product.getName());
                return;
            }

            if (cmd.startsWith("delete product ")) {
                if (!adminMode) {
                    System.out.println("Only admins can add products. Use 'admin on' first.");
                    return;
                }
                String[] parts = cmd.substring("delete product ".length()).split("\\|");
                if (parts.length < 1) {
                    System.out.println("Usage: delete product productId");
                    return;
                }
                long productId = Long.parseLong(parts[0].trim());
                productService.deleteProduct(productId);
                return;
            }




            if (cmd.startsWith("search ")) {
                String term = cmd.substring("search ".length()).trim();
                List<Product> results = productService.findProductByName(term);
                if (results.isEmpty()) System.out.println("No products found for: " + term);
                else results.forEach(System.out::println);
                return;
            }

            if (cmd.startsWith("filter price ")) {
                String[] parts = cmd.substring("filter price ".length()).split("\\|");
                if (parts.length < 2) {
                    System.out.println("Usage: filter price min|max");
                    return;
                }
                double min = Double.parseDouble(parts[0].trim());
                double max = Double.parseDouble(parts[1].trim());
                productService.filterByPriceRange(min, max).forEach(System.out::println);
                return;
            }

            if (cmd.startsWith("filter category ")) {
                String category = cmd.substring("filter category ".length()).trim();
                productService.filterByCategory(category).forEach(System.out::println);
                return;
            }

            // === Add to Cart ===
            if (cmd.startsWith("add ")) {
                String[] parts = cmd.substring("add ".length()).split("\\|");
                if (parts.length < 2) {
                    System.out.println("Usage: add productId|qty");
                    return;
                }

                long productId = Long.parseLong(parts[0].trim());
                int qty = Integer.parseInt(parts[1].trim());

                Product product = productService.findProductById(productId).orElse(null);
                if (product == null) {
                    System.out.println("Product not found with ID: " + productId);
                    return;
                }

                cart.addProduct(product, qty);
                System.out.printf("Added: %s (x%d)%n", product.getName(), qty);
                return;
            }

            if (cmd.startsWith("remove ")) {
                long productId = Long.parseLong(cmd.substring("remove ".length()).trim());
                cart.getItems().keySet().stream().filter(p -> p.getProductId().equals(productId)).findFirst().ifPresent(cart::removeProduct);
                System.out.println("Removed product ID: " + productId);
                return;
            }

            if (cmd.equals("cart")) {
                ConsolePrinter.printCart(cart);
                return;
            }

            // === Checkout ===
            if (cmd.equals("checkout")) {
                var order = orderService.placeOrder(cart);
                System.out.printf("Order #%d placed successfully! Total: %.2f₾%n", order.getOrderId(), order.getTotalAmount());
                ReceiptWriter.writeReceipt(order);
                return;
            }

            // === Order History ===
            if (cmd.equals("orders")) {
                ConsolePrinter.printOrders(orderService.listOrders());
                return;
            }

            // === Update Stock (Admin Only) ===
            if (cmd.startsWith("update stock ")) {
                if (!adminMode) {
                    System.out.println("Only admins can update product stock. Use 'admin on' first.");
                    return;
                }

                String[] parts = cmd.substring("update stock ".length()).split("\\|");
                if (parts.length < 2) {
                    System.out.println("Usage: update stock productId|newQty");
                    return;
                }

                long productId = Long.parseLong(parts[0].trim());
                int newQty = Integer.parseInt(parts[1].trim());

                productService.updateProductStock(productId, newQty);
                System.out.printf("Stock updated for product #%d → %d units%n", productId, newQty);
                return;
            }

            System.out.println("Unknown command. Type 'help' for list of commands.");

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
