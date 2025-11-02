package org.example.projects.project2.service;

import org.example.projects.project2.model.Student;

import java.util.List;


public interface StudentsServiceInterface {
    void addStudent(Student student);

    Student getStudentById(Long id);

    void updateStudent(Student student);

    void deleteStudent(Long id);

    void enrollStudentToCourse(Long studentId, Long courseId);

    void removeStudentFromCourse(Long studentId, Long courseId);

    List<Student> getAllStudents();
}