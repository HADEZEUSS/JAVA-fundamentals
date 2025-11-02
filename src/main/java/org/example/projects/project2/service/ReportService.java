package org.example.projects.project2.service;

import org.example.projects.project2.data.HashMapDb;
import org.example.projects.project2.model.Course;

import java.util.List;
import java.util.stream.Collectors;

//Generates reports and summaries of the data
public class ReportService {

    //List all students
    public void listAllStudents() {
        System.out.println("All Students:");
        HashMapDb.students.values().forEach(s -> System.out.println(" - " + s.getId() + ": " + s.getFirstName() + " " + s.getLastName()));
    }

    // 🎓 List all lecturers
    public void listAllLecturers() {
        System.out.println("All Lecturers:");
        HashMapDb.lecturers.values().forEach(l -> System.out.println(" - " + l.getId() + ": " + l.getFirstName() + " " + l.getLastName()));
    }

    //List all courses
    public void listAllCourses() {
        System.out.println("All Courses:");
        HashMapDb.courses.values().forEach(c -> System.out.println(" - " + c.getCourseId() + ": " + c.getCourseName()));
    }

    //List all courses a student is enrolled in
    public void listCoursesOfStudent(Long studentId) {
        List<Course> enrolledCourses = HashMapDb.courses.values().stream().filter(c -> c.getEnrolledStudents() != null && c.getEnrolledStudents().stream().anyMatch(s -> s.getId().equals(studentId))).collect(Collectors.toList());

        System.out.println("Courses for student ID " + studentId + ":");
        enrolledCourses.forEach(c -> System.out.println(" - " + c.getCourseName()));
    }

    //List all courses taught by a specific lecturer
    public void listCoursesOfLecturer(Long lecturerId) {
        List<Course> lecturerCourses = HashMapDb.courses.values().stream().filter(c -> c.getLecturer() != null && c.getLecturer().getId().equals(lecturerId)).collect(Collectors.toList());

        System.out.println("Courses taught by lecturer ID " + lecturerId + ":");
        lecturerCourses.forEach(c -> System.out.println(" - " + c.getCourseName()));
    }
}
