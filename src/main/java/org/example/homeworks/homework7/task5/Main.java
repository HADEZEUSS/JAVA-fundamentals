package org.example.homeworks.homework7.task5;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {
    Product product1 = new Product(1, "pen", 2.5, "pen1");
        ObjectMapper mapper = new ObjectMapper();

        try{
            String json = mapper.writeValueAsString(product1);
            System.out.println(json);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
