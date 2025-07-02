class Employee {
    protected String name;
    protected int id;
    protected double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: " + salary);
    }
}

class Manager extends Employee {
    private int teamSize;
    public Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Manager");
        System.out.println("Team Size: " + teamSize);
    }
}

class Developer extends Employee {
    private String programmingLanguage;
    public Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Developer");
        System.out.println("Programming Language: " + programmingLanguage);
    }
}

class Intern extends Employee {
    private String school;
    public Intern(String name, int id, double salary, String school) {
        super(name, id, salary);
        this.school = school;
    }
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Intern");
        System.out.println("School: " + school);
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Employee[] employees = {
            new Manager("Alice", 1, 90000, 5),
            new Developer("Bob", 2, 80000, "Java"),
            new Intern("Charlie", 3, 20000, "XYZ University")
        };
        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println();
        }
    }
} 