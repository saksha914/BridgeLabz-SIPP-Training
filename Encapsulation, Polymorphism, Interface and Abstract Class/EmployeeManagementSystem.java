// Employee Management System
// Demonstrates: Abstract Classes, Interfaces, Encapsulation, Polymorphism

// Interface for Department functionality
interface Department {
    void assignDepartment(String department);
    String getDepartmentDetails();
}

// Abstract class Employee with encapsulation
abstract class Employee {
    // Private fields - Encapsulation
    private int employeeId;
    private String name;
    private double baseSalary;
    private String department;
    
    // Constructor
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }
    
    // Getter methods - Encapsulation
    public int getEmployeeId() {
        return employeeId;
    }
    
    public String getName() {
        return name;
    }
    
    public double getBaseSalary() {
        return baseSalary;
    }
    
    public String getDepartment() {
        return department;
    }
    
    // Setter methods with validation - Encapsulation
    public void setEmployeeId(int employeeId) {
        if (employeeId > 0) {
            this.employeeId = employeeId;
        } else {
            System.out.println("Invalid employee ID");
        }
    }
    
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Name cannot be empty");
        }
    }
    
    public void setBaseSalary(double baseSalary) {
        if (baseSalary >= 0) {
            this.baseSalary = baseSalary;
        } else {
            System.out.println("Base salary cannot be negative");
        }
    }
    
    public void setDepartment(String department) {
        if (department != null && !department.trim().isEmpty()) {
            this.department = department;
        } else {
            System.out.println("Department cannot be empty");
        }
    }
    
    // Abstract method - must be implemented by subclasses
    public abstract double calculateSalary();
    
    // Concrete method - shared implementation
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: $" + baseSalary);
        System.out.println("Department: " + (department != null ? department : "Not assigned"));
        System.out.println("Calculated Salary: $" + calculateSalary());
        System.out.println("------------------------");
    }
}

// FullTimeEmployee class extending Employee
class FullTimeEmployee extends Employee implements Department {
    private int workHours;
    private double hourlyRate;
    
    public FullTimeEmployee(int employeeId, String name, double baseSalary, int workHours, double hourlyRate) {
        super(employeeId, name, baseSalary);
        this.workHours = workHours;
        this.hourlyRate = hourlyRate;
    }
    
    // Getter and setter methods
    public int getWorkHours() {
        return workHours;
    }
    
    public void setWorkHours(int workHours) {
        if (workHours >= 0 && workHours <= 168) { // Max hours in a week
            this.workHours = workHours;
        } else {
            System.out.println("Invalid work hours");
        }
    }
    
    public double getHourlyRate() {
        return hourlyRate;
    }
    
    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate >= 0) {
            this.hourlyRate = hourlyRate;
        } else {
            System.out.println("Hourly rate cannot be negative");
        }
    }
    
    // Implementation of abstract method
    @Override
    public double calculateSalary() {
        return getBaseSalary() + (workHours * hourlyRate);
    }
    
    // Implementation of Department interface methods
    @Override
    public void assignDepartment(String department) {
        setDepartment(department);
        System.out.println("Full-time employee " + getName() + " assigned to " + department);
    }
    
    @Override
    public String getDepartmentDetails() {
        return "Full-time employee in " + getDepartment() + " department";
    }
}

// PartTimeEmployee class extending Employee
class PartTimeEmployee extends Employee implements Department {
    private int workHours;
    private double hourlyRate;
    
    public PartTimeEmployee(int employeeId, String name, double baseSalary, int workHours, double hourlyRate) {
        super(employeeId, name, baseSalary);
        this.workHours = workHours;
        this.hourlyRate = hourlyRate;
    }
    
    // Getter and setter methods
    public int getWorkHours() {
        return workHours;
    }
    
    public void setWorkHours(int workHours) {
        if (workHours >= 0 && workHours <= 40) { // Max part-time hours
            this.workHours = workHours;
        } else {
            System.out.println("Invalid work hours for part-time employee");
        }
    }
    
    public double getHourlyRate() {
        return hourlyRate;
    }
    
    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate >= 0) {
            this.hourlyRate = hourlyRate;
        } else {
            System.out.println("Hourly rate cannot be negative");
        }
    }
    
    // Implementation of abstract method
    @Override
    public double calculateSalary() {
        return workHours * hourlyRate; // Part-time employees only get hourly pay
    }
    
    // Implementation of Department interface methods
    @Override
    public void assignDepartment(String department) {
        setDepartment(department);
        System.out.println("Part-time employee " + getName() + " assigned to " + department);
    }
    
    @Override
    public String getDepartmentDetails() {
        return "Part-time employee in " + getDepartment() + " department";
    }
}

// Main class to demonstrate the system
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        System.out.println("=== Employee Management System ===\n");
        
        // Creating employees
        FullTimeEmployee fullTimeEmp = new FullTimeEmployee(1001, "John Doe", 3000.0, 40, 25.0);
        PartTimeEmployee partTimeEmp = new PartTimeEmployee(1002, "Jane Smith", 0.0, 20, 15.0);
        
        // Assigning departments
        fullTimeEmp.assignDepartment("Engineering");
        partTimeEmp.assignDepartment("Marketing");
        
        // Demonstrating polymorphism - using Employee reference
        Employee[] employees = {fullTimeEmp, partTimeEmp};
        
        System.out.println("Processing all employees using polymorphism:");
        for (Employee emp : employees) {
            emp.displayDetails(); // Polymorphic method call
        }
        
        // Demonstrating interface usage
        System.out.println("Department Details:");
        Department[] departments = {fullTimeEmp, partTimeEmp};
        for (Department dept : departments) {
            System.out.println(dept.getDepartmentDetails());
        }
        
        // Demonstrating encapsulation
        System.out.println("\n=== Testing Encapsulation ===");
        fullTimeEmp.setName(""); // Should show validation message
        fullTimeEmp.setBaseSalary(-1000); // Should show validation message
        fullTimeEmp.setName("John Updated");
        fullTimeEmp.setBaseSalary(3500.0);
        
        System.out.println("Updated employee details:");
        fullTimeEmp.displayDetails();
    }
} 