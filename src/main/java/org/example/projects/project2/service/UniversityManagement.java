package org.example.projects.project2.service;

import org.example.projects.project2.model.Course;
import org.example.projects.project2.model.Lecturer;
import org.example.projects.project2.model.Student;

// This interface defines high-level methods for managing the university
public interface UniversityManagement {
    void addStudent(Student student);

    void addLecturer(Lecturer lecturer);

    void addCourse(Course course);

    void enrollStudentInCourse(Long studentId, Long courseId);

    void assignLecturerToCourse(Long courseId, Long lecturerId);

    void generateReports();
}
