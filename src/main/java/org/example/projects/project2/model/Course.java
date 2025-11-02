package org.example.projects.project2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.projects.project2.enums.WeekDays;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//Represents a course with lecturer and enrolled students.

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private Long courseId;
    private String courseName;
    private Lecturer lecturer;

    @Builder.Default
    private List<Student> enrolledStudents = new ArrayList<>();

    private LocalDate startDate;
    private LocalDate endDate;
    private WeekDays weekDays;

    //  constructor used in Main
    public Course(Long courseId, String courseName, Lecturer lecturer, List<Student> enrolledStudents) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.lecturer = lecturer;
        this.enrolledStudents = enrolledStudents;
    }
}
