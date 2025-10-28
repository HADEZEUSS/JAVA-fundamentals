package org.example.projects.project3.command;

import org.example.projects.project3.model.ShoppingCart;
import org.example.projects.project3.service.*;

public class CommandHandler {
    private final CommandExecutor executor;

    public CommandHandler(ProductService productService, OrderService orderService, ShoppingCart cart) {
        this.executor = new CommandExecutor(productService, orderService, cart);
    }

    public void handle(String input) {
        executor.execute(input);
    }

    public void printHelp() {
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
    }
}
