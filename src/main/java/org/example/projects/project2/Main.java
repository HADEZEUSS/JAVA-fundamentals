package org.example.projects.project2;

import org.example.projects.project2.model.Course;
import org.example.projects.project2.model.Lecturer;
import org.example.projects.project2.model.Student;
import org.example.projects.project2.service.University;
import org.example.projects.project2.util.JsonUtil;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        University university = new University();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to University Management System (Console Version)");
        System.out.println("---------------------------------------------------------");

        boolean running = true;

        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1️⃣ Add Student");
            System.out.println("2️⃣ Add Lecturer");
            System.out.println("3️⃣ Add Course");
            System.out.println("4️⃣ Enroll Student to Course");
            System.out.println("5️⃣ Assign Lecturer to Course");
            System.out.println("6️⃣ Generate Reports");
            System.out.println("7️⃣ Import Students from JSON file");
            System.out.println("0️⃣ Exit");

            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter Student ID: ");
                        Long sId = scanner.nextLong();
                        scanner.nextLine();
                        System.out.print("Enter First Name: ");
                        String sFname = scanner.nextLine();
                        System.out.print("Enter Last Name: ");
                        String sLname = scanner.nextLine();
                        System.out.print("Enter Email: ");
                        String email = scanner.nextLine();

                        Student student = new Student(sId, sFname, sLname, email);
                        university.addStudent(student);
                    }

                    case 2 -> {
                        System.out.print("Enter Lecturer ID: ");
                        Long lId = scanner.nextLong();
                        scanner.nextLine();
                        System.out.print("Enter First Name: ");
                        String lFname = scanner.nextLine();
                        System.out.print("Enter Last Name: ");
                        String lLname = scanner.nextLine();
                        System.out.print("Enter Email: ");
                        String email = scanner.nextLine();

                        Lecturer lecturer = new Lecturer(lId, lFname, lLname, email);
                        university.addLecturer(lecturer);
                    }

                    case 3 -> {
                        System.out.print("Enter Course ID: ");
                        Long cId = scanner.nextLong();
                        scanner.nextLine();
                        System.out.print("Enter Course Name: ");
                        String cName = scanner.nextLine();

                        Course course = new Course(cId, cName, null, new java.util.ArrayList<>());
                        university.addCourse(course);
                    }

                    case 4 -> {
                        System.out.print("Enter Student ID: ");
                        Long sid = scanner.nextLong();
                        System.out.print("Enter Course ID: ");
                        Long cid = scanner.nextLong();
                        university.enrollStudentInCourse(sid, cid);
                    }

                    case 5 -> {
                        System.out.print("Enter Course ID: ");
                        Long cid = scanner.nextLong();
                        System.out.print("Enter Lecturer ID: ");
                        Long lid = scanner.nextLong();
                        university.assignLecturerToCourse(cid, lid);
                    }

                    case 6 -> university.generateReports();

                    // NEW: Import Students from JSON file
                    case 7 -> {
                        System.out.print("Enter JSON file path (e.g. students.json): ");
                        String path = scanner.nextLine();

                        List<Student> imported = JsonUtil.readStudentsFromFile(path);
                        imported.forEach(university::addStudent);
                        System.out.println("Imported " + imported.size() + " students from " + path);
                    }

                    case 0 -> {
                        System.out.println("Exiting the system...");
                        running = false;
                    }

                    default -> System.out.println("Invalid choice. Try again!");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
