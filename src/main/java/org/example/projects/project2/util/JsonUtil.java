package org.example.projects.project2.util;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.projects.project2.model.Student;

import java.io.File;
import java.io.IOException;
import java.util.List;

//Utility class for working with JSON data (students import/export).
public class JsonUtil {
    private static final ObjectMapper MAPPER = new ObjectMapper();

//Parse a single student from a JSON string.

    public static Student parseStudent(String json) throws IOException {
        return MAPPER.readValue(json, Student.class);
    }


    //     Read a list of students from a JSON file.
    public static List<Student> readStudentsFromFile(String filePath) throws IOException {
        return MAPPER.readValue(new File(filePath), new TypeReference<List<Student>>() {
        });
    }

    //Save a list of students into a JSON file.
    public static void writeStudentsToFile(String filePath, List<Student> students) throws IOException {
        MAPPER.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), students);
    }
}
