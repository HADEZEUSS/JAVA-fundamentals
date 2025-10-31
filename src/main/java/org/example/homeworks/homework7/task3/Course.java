package org.example.homeworks.homework7.task3;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    String courseName;
    int credits;
    Lecturer lecturer;

}
