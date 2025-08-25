package org.example.projects.project1;

import java.util.Objects;

public class Company {
    private Employee[] employees = new Employee[10];
    private int count = 0;

    // Add new employee
    public void addEmployee(Employee employee) {
        if (count < employees.length) {
            employees[count] = employee;
            count++;
        } else {
            System.out.println("Company is full, cannot add more employees.");
        }
    }

    // Display all employees
    public void displayAllEmployees() {
        for (int i = 0; i < count; i++) {
            employees[i].displayInfo();
        }
    }

    // Calculate total payroll
    public double calculateTotalPayroll() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += employees[i].calculateSalary();
        }
        return total;
    }

    // Find employee by ID
    public Employee findEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getId() == id) {
                return employees[i];
            }
        }
        return null;
    }

    // Find employee by name
    public Employee findEmployee(String name) {
        for (int i = 0; i < count; i++) {
            if (Objects.equals(employees[i].getName(), name)) {
                return employees[i];
            }
        }
        return null;
    }

    //Employee Reports
    public void generateAllReports() {
        System.out.println("\n--- Employee Reports ---");
        for (int i = 0; i < count; i++) {
            Employee emp = employees[i];
            if (emp instanceof IReportable reportableEmployee) {
                reportableEmployee.generateReport();
            }
        }
    }
}
