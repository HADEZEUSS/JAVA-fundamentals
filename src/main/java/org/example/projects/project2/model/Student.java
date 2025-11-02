package org.example.projects.project2.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;

//Keeps list of enrolled courses.
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student extends Person {


    @Builder.Default
    private List<Course> courses = new ArrayList<>();


    public Student(Long id, String firstName, String lastName, String email) {
        super(id, firstName, lastName, email);
    }
}