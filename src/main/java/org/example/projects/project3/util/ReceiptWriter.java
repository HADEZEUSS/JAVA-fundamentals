package org.example.projects.project3.util;

import org.example.projects.project3.model.Order;
import org.example.projects.project3.model.Product;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {

    public static void writeReceipt(Order order) {
        String folder = "src/main/java/org/example/projects/project3/receipts";
        new File(folder).mkdirs();

        String fileName = folder + "/order_" + order.getOrderId() + ".txt";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try (PrintWriter out = new PrintWriter(new FileWriter(fileName))) {
            out.println("===== ORDER RECEIPT =====");
            out.println("Order ID: " + order.getOrderId());
            out.println("Date: " + order.getOrderDate().format(formatter));
            out.println("User ID: " + order.getUserId());
            out.println();
            out.println("Products:");
            for (var e : order.getOrderedProducts().entrySet()) {
                Product p = e.getKey();
                int qty = e.getValue();
                out.printf("- %s (x%d): $%.2f%n", p.getName(), qty, p.getPrice() * qty);
            }
            out.println();
            out.printf("TOTAL: $%.2f%n", order.getTotalAmount());
            out.println("=========================");
            System.out.println("Receipt written to: " + fileName);
        } catch (Exception e) {
            System.err.println("Failed to write receipt: " + e.getMessage());
        }
    }
}

