package org.example.projects.project2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lecturer extends Person {


    @Builder.Default
    private List<Course> courses = new ArrayList<>();


    public Lecturer(Long id, String firstName, String lastName, String email) {
        super(id, firstName, lastName, email);
    }
}