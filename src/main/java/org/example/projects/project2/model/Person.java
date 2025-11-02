package org.example.projects.project2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Person {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
