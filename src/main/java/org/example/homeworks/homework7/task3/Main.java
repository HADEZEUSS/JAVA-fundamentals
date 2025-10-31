package org.example.homeworks.homework7.task3;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {
    Lecturer lecturer1 = new Lecturer(1, "Griselda");
    Course course1 = new Course("Java", 5, lecturer1);

        ObjectMapper mapper = new ObjectMapper();
        try{
            String json = mapper.writeValueAsString(course1);
            System.out.println("JSON: " + json);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
