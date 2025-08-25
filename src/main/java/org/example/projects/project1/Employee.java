package org.example.projects.project1;

import java.sql.SQLOutput;

public abstract class Employee {
    private final int id;
    private final String name;
    private double baseSalary;

    //Constructor
    public Employee(int id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    //Displays general information about the employee
    public void displayInfo() {
        System.out.printf("ID: %d, Name: %s, Base Salary: %.2f%n", id, name, baseSalary);
    }

    //Calculates the final salary of the employee
    public abstract double calculateSalary();

}


