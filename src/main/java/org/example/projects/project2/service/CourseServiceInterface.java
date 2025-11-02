package org.example.projects.project2.service;


import org.example.projects.project2.model.Course;
import org.example.projects.project2.model.Student;

import java.util.List;


public interface CourseServiceInterface {
    void addCourse(Course course);

    void updateCourse(Course course);

    void deleteCourse(Long courseId);

    void assignLecturerToCourse(Long courseId, Long lecturerId);

    List<Student> getStudentsInCourse(Long courseId);

    List<Course> getAllCourses();
}