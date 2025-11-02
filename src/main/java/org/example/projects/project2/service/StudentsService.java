package org.example.projects.project2.service;


import org.example.projects.project2.data.HashMapDb;
import org.example.projects.project2.exception.CourseNotFoundException;
import org.example.projects.project2.exception.StudentNotFoundException;
import org.example.projects.project2.model.Course;
import org.example.projects.project2.model.Student;

import java.util.ArrayList;
import java.util.List;

//Implementation of StudentsServiceInterface.
public class StudentsService implements StudentsServiceInterface {


    // Add a student to the in-memory DB
    @Override
    public void addStudent(Student student) {
        if (student == null || student.getId() == null) {
            throw new IllegalArgumentException("Invalid student data");
        }
        HashMapDb.students.put(student.getId(), student);
        System.out.println("Added student: " + student.getFirstName());
    }


    // Get student by id
    @Override
    public Student getStudentById(Long id) {
        Student s = HashMapDb.students.get(id);
        if (s == null) throw new StudentNotFoundException("Student with ID " + id + " not found");
        return s;
    }

    // Update student information
    @Override
    public void updateStudent(Student student) {
        if (student == null || student.getId() == null) throw new IllegalArgumentException("Invalid student");
        if (!HashMapDb.students.containsKey(student.getId())) throw new StudentNotFoundException("Student not found");
        HashMapDb.students.put(student.getId(), student);
        System.out.println("Updated student: " + student.getId());
    }


    // Delete student from DB and from any enrolled courses
    @Override
    public void deleteStudent(Long id) {
        Student s = HashMapDb.students.remove(id);
        if (s == null) throw new StudentNotFoundException("Student with ID " + id + " not found");


// Remove student from any courses they were enrolled in
        HashMapDb.courses.values().forEach(c -> c.getEnrolledStudents().removeIf(st -> st.getId().equals(id)));
        System.out.println("Deleted student: " + id);
    }


    // Enroll student to course (updates both sides)
    @Override
    public void enrollStudentToCourse(Long studentId, Long courseId) {
        Student s = HashMapDb.students.get(studentId);
        if (s == null) throw new StudentNotFoundException("Student not found");
        Course c = HashMapDb.courses.get(courseId);
        if (c == null) throw new CourseNotFoundException("Course not found");


        if (!c.getEnrolledStudents().contains(s)) {
            c.getEnrolledStudents().add(s);
        }
        if (!s.getCourses().contains(c)) {
            s.getCourses().add(c);
        }
        System.out.println("Enrolled student " + studentId + " to course " + courseId);
    }


    // Remove student from course (updates both sides)
    @Override
    public void removeStudentFromCourse(Long studentId, Long courseId) {
        Student s = HashMapDb.students.get(studentId);
        if (s == null) throw new StudentNotFoundException("Student not found");
        Course c = HashMapDb.courses.get(courseId);
        if (c == null) throw new CourseNotFoundException("Course not found");


        c.getEnrolledStudents().removeIf(st -> st.getId().equals(studentId));
        s.getCourses().removeIf(course -> course.getCourseId().equals(courseId));
        System.out.println("Removed student " + studentId + " from course " + courseId);
    }


    // Get list of all students
    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(HashMapDb.students.values());
    }
}