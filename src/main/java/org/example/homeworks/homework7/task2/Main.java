package org.example.homeworks.homework7.task2;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {
        String json = "{" + "\"title\": \"ვეფხისტყაოსანი\", " + "\"author\": \"შოთა რუსთაველი\", " + "\"publicationYear\": 1200" + "}";
//დესერიალიზაცია
        ObjectMapper mapper = new ObjectMapper();
        try {
            Book book = mapper.readValue(json, Book.class);
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Year: " + book.getPublicationYear());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
