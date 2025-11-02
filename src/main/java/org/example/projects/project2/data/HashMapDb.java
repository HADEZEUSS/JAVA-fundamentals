package org.example.projects.project2.data;

import org.example.projects.project2.model.Course;
import org.example.projects.project2.model.Lecturer;
import org.example.projects.project2.model.Student;

import java.util.HashMap;
import java.util.Map;


//Simple in-memory storage for the application.

public class HashMapDb {
    public static final Map<Long, Student> students = new HashMap<>();
    public static final Map<Long, Lecturer> lecturers = new HashMap<>();
    public static final Map<Long, Course> courses = new HashMap<>();
}