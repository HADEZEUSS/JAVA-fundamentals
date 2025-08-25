package org.example.projects.project1;

//Employee Management System
public class Main {
    public static void main(String[] args) {
        Company company = new Company();

        Employee developerJames = new Developer(1, "James", 100000, "Java");
        Employee developerSnowden = new Developer(2, "Snowden", 200000, "Java");
        Employee developerApollo = new Developer(3, "Apollo", 5000000, "Python");

        Employee managerZeus = new Manager(4, "Zeus", 100000, 40);
        Employee managerHades = new Manager(5, "Hades", 200000, 20);
        Employee managerGalileo = new Manager(6, "Galileo", 150000, 10);


        // Add employees to the company
        company.addEmployee(developerJames);
        company.addEmployee(developerSnowden);
        company.addEmployee(developerApollo);
        company.addEmployee(managerZeus);
        company.addEmployee(managerHades);
        company.addEmployee(managerGalileo);

        System.out.println("\n--- All Employees ---");
        company.displayAllEmployees();

        System.out.println("\n--- Total Payroll ---");
        System.out.println(company.calculateTotalPayroll());

        System.out.println("\n--- Find an employee ---");
        displayEmployee(company.findEmployee(2));
        displayEmployee(company.findEmployee("Zeus"));
        displayEmployee(company.findEmployee("Athena"));

        company.generateAllReports();
    }

    // Displays information about employee
    public static void displayEmployee(Employee emp) {
        if (emp != null) {
            emp.displayInfo();
        } else {
            System.out.println("Employee not found");
        }
    }

}
