package org.example.projects.project1;

public class Manager extends Employee implements IReportable {
    private double bonusPercentage;

    //Constructor
    public Manager(int id, String name, double baseSalary, double bonusPercentage) {
        super(id, name, baseSalary);
        this.bonusPercentage = bonusPercentage;
    }

    //Getter
    public double getBonusPercentage() {
        return bonusPercentage;
    }

    //Manager's final salary: baseSalary + (baseSalary * bonusPercentage / 100)
    @Override
    public double calculateSalary() {
        return getBaseSalary() + (getBaseSalary() * bonusPercentage / 100);
    }

    //Manager's report
    @Override
    public void generateReport() {
        System.out.printf("Manager %s wisely juggles tasks and motivates the team. %s also ensures projects move forward while occasionally surviving endless meetings without losing sanity.%n", getName(), getName());
    }
}
