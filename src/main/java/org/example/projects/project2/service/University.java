package org.example.projects.project2.service;

import org.example.projects.project2.model.Course;
import org.example.projects.project2.model.Lecturer;
import org.example.projects.project2.model.Student;

//Implements all main features defined in UniversityManagement
public class University implements UniversityManagement {

    private final StudentsService studentService = new StudentsService();
    private final LecturerService lecturerService = new LecturerService();
    private final CourseService courseService = new CourseService();
    private final ReportService reportService = new ReportService();

    @Override
    public void addStudent(Student student) {
        studentService.addStudent(student);
    }

    @Override
    public void addLecturer(Lecturer lecturer) {
        lecturerService.addLecturer(lecturer);
    }

    @Override
    public void addCourse(Course course) {
        courseService.addCourse(course);
    }

    @Override
    public void enrollStudentInCourse(Long studentId, Long courseId) {
        studentService.enrollStudentToCourse(studentId, courseId);
    }

    @Override
    public void assignLecturerToCourse(Long courseId, Long lecturerId) {
        courseService.assignLecturerToCourse(courseId, lecturerId);
    }

    @Override
    public void generateReports() {
        reportService.listAllStudents();
        reportService.listAllLecturers();
        reportService.listAllCourses();
    }
}
