package org.example.projects.project3;

import org.example.projects.project3.command.CommandHandler;
import org.example.projects.project3.db.DatabaseRepository;
import org.example.projects.project3.model.ShoppingCart;
import org.example.projects.project3.model.User;
import org.example.projects.project3.service.OrderService;
import org.example.projects.project3.service.ProductService;
import org.example.projects.project3.service.UserService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Initialize DB or JSON fallback
        DatabaseRepository.init(
                "jdbc:postgresql://localhost:5433/main_db",
                "postgres",
                "kali",
                "src/main/java/org/example/projects/project3/jsons/products.json"
        );

        ProductService productService = DatabaseRepository.getProductRepo();
        OrderService orderService = DatabaseRepository.getOrderRepo();
        UserService userService = DatabaseRepository.getUserRepo();

        //Demo user & cart
        User user = new User(null, "alice", "alice@example.com");
        user = userService.save(user);
        ShoppingCart cart = new ShoppingCart(user);

        CommandHandler handler = new CommandHandler(productService, orderService, cart);

        System.out.println("Welcome to the E-Commerce Management System!");
        handler.printHelp();

        //CLI loop
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("\nE-Commerce Management System > ");
                String input = scanner.nextLine();
                if (input == null || input.equalsIgnoreCase("exit")) break;

                handler.handle(input.trim());
            }
        }

        DatabaseRepository.close();
        System.out.println("Session ended. Goodbye!");
    }
}
