package org.example.homeworks.homework7.task4;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String json = "[" + "{ \"title\":\"The Catcher in the Rye\", \"author\":\"J.D. Salinger\", \"publicationYear\":1951 }," + "{ \"title\":\"To Kill a Mockingbird\", \"author\":\"Harper Lee\", \"publicationYear\":1960 }," + "{ \"title\":\"1984\", \"author\":\"George Orwell\", \"publicationYear\":1949 }" + "]";

        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Book> books = mapper.readValue(json, new TypeReference<List<Book>>() {
            });
            for (Book b : books) {
                System.out.println(b.getTitle());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
