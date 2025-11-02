package org.example.projects.project2.service;

import org.example.projects.project2.data.HashMapDb;
import org.example.projects.project2.exception.CourseNotFoundException;
import org.example.projects.project2.exception.LecturerNotFoundException;
import org.example.projects.project2.model.Course;
import org.example.projects.project2.model.Lecturer;
import org.example.projects.project2.model.Student;

import java.util.ArrayList;
import java.util.List;

public class CourseService implements CourseServiceInterface {

    //Add a new course
    @Override
    public void addCourse(Course course) {
        if (course == null || course.getCourseId() == null) throw new IllegalArgumentException("Invalid course data");
        HashMapDb.courses.put(course.getCourseId(), course);
        System.out.println("Course added: " + course.getCourseName());
    }

    //Update existing course
    @Override
    public void updateCourse(Course updatedCourse) {
        if (!HashMapDb.courses.containsKey(updatedCourse.getCourseId()))
            throw new CourseNotFoundException("Course not found");
        HashMapDb.courses.put(updatedCourse.getCourseId(), updatedCourse);
        System.out.println("Course updated: " + updatedCourse.getCourseName());
    }

    //Delete course by ID
    @Override
    public void deleteCourse(Long courseId) {
        if (!HashMapDb.courses.containsKey(courseId)) throw new CourseNotFoundException("Course not found");
        HashMapDb.courses.remove(courseId);
        System.out.println("Course deleted (ID: " + courseId + ")");
    }

    //Assign lecturer to a course
    @Override
    public void assignLecturerToCourse(Long courseId, Long lecturerId) {
        Course course = HashMapDb.courses.get(courseId);
        Lecturer lecturer = HashMapDb.lecturers.get(lecturerId);

        if (course == null) throw new CourseNotFoundException("Course not found");
        if (lecturer == null) throw new LecturerNotFoundException("Lecturer not found");

        course.setLecturer(lecturer);
        lecturer.getCourses().add(course);
        System.out.println("Lecturer " + lecturer.getFirstName() + " assigned to course " + course.getCourseName());
    }

    // Get list of students enrolled in a course
    @Override
    public List<Student> getStudentsInCourse(Long courseId) {
        Course course = HashMapDb.courses.get(courseId);
        if (course == null) throw new CourseNotFoundException("Course not found");
        return course.getEnrolledStudents() != null ? course.getEnrolledStudents() : new ArrayList<>();
    }

    @Override
    public List<Course> getAllCourses() {
        return List.of();
    }
}
