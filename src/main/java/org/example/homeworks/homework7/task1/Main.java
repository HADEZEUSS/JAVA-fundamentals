package org.example.homeworks.homework7.task1;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

public class Main {
    public static void main(String[] args) {
//        Serialize (Java → JSON)
        Student student1 = new Student(1, "Pablo", "Escobar", 3.5);
        ObjectMapper mapper = new ObjectMapper();

        try {
            String json = mapper.writeValueAsString(student1);
            System.out.println("JSON: " + json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}