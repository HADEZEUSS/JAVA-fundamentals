package org.example.projects.project3.util;

import org.example.projects.project3.model.Order;
import org.example.projects.project3.model.Product;
import org.example.projects.project3.model.ShoppingCart;

import java.util.List;
//Utility class for printing user-friendly outputs in the console.

public class ConsolePrinter {
    //Prints a formatted list of all orders to the console.
    public static void printOrders(List<Order> orders) {
        if (orders.isEmpty()) {
            System.out.println("No orders found.");
            return;
        }
        System.out.println("\n=== Order History ===");

        for (Order o : orders) {
            // Display only up to minutes (YYYY-MM-DDTHH:mm)
            String date = o.getOrderDate() != null ? o.getOrderDate().toString().substring(0, 16) : "N/A";
            // Print general order information
            System.out.printf("Order #%d | User ID: %d | Status: %s | Total: %.2f₾ | Date: %s%n", o.getOrderId(), o.getUserId(), o.getStatus(), o.getTotalAmount(), date);
            System.out.println("  Items:");
            // Print each ordered product
            o.getOrderedProducts().forEach((Product p, Integer qty) -> System.out.printf("    - %-20s (x%d)  %.2f₾%n", p.getName(), qty, p.getPrice()));
            System.out.println();
        }
    }

    //Prints the contents of the user's shopping cart.
    public static void printCart(ShoppingCart cart) {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        System.out.println("\n=== Shopping Cart ===");
        cart.getItems().forEach((p, q) -> System.out.printf("%d - %-20s x%d (%.2f₾)%n", p.getProductId(), p.getName(), q, p.getPrice() * q));
        System.out.printf("Total: %.2f₾%n", cart.calculateTotal());
    }
}
