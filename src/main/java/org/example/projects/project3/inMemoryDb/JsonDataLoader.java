package org.example.projects.project3.inMemoryDb;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.projects.project3.model.Product;

import java.io.File;
import java.util.Collections;
import java.util.List;

public class JsonDataLoader {

    public static List<Product> loadProducts(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                System.err.println("products.json not found: " + file.getAbsolutePath());
                return Collections.emptyList();
            }

            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(file, new TypeReference<List<Product>>() {
            });
        } catch (Exception e) {
            System.err.println("Failed to read products JSON: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}
