package org.example.homeworks.homework7.task1;
import lombok.*;

@Getter
public class Student {
    int id;
    String firstName;
    String lastName;
    double gpa;

    public Student() {
    }

    public Student(int id, String firstName, String lastName, double gpa) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gpa = gpa;
    }
}
