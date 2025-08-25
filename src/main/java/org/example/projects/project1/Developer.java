package org.example.projects.project1;

public class Developer extends Employee implements IReportable {
    private String programmingLanguage;

    //Constructor
    public Developer(int id, String name, double baseSalary, String programmingLanguage) {
        super(id, name, baseSalary);
        this.programmingLanguage = programmingLanguage;
    }

    //Getter
    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    //Manager's final salary: baseSalary * 1.2
    @Override
    public double calculateSalary() {
        return getBaseSalary() * 1.2;
    }

    //Add programming language to employee information
    @Override
    public void displayInfo() {
        System.out.printf("ID: %d, Name: %s, Base Salary: %.2f, Programming Language: %s%n", getId(), getName(), getBaseSalary(), programmingLanguage);
    }

    //Developer's report
    @Override
    public void generateReport() {
        System.out.printf("Developer %s fearlessly tackles bugs and crafts code in %s. %s also heroically pushes commits to %s, sometimes even without breaking production (miracles do happen!).%n", getName(), programmingLanguage, getName(), programmingLanguage);
    }
}
