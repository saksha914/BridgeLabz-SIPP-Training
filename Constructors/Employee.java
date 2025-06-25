class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public void displayDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
    }
}

class Manager extends Employee {
    private String team;

    public Manager(int employeeID, String department, double salary, String team) {
        super(employeeID, department, salary);
        this.team = team;
    }

    public void displayManagerDetails() {
        System.out.println("[Manager]");
        System.out.println("Employee ID: " + employeeID); // public
        System.out.println("Department: " + department); // protected
        System.out.println("Salary: " + getSalary()); // private via getter
        System.out.println("Team: " + team);
    }

    public static void main(String[] args) {
        Manager mgr = new Manager(1001, "IT", 80000, "Dev Team");
        mgr.displayManagerDetails();
        mgr.setSalary(90000);
        System.out.println("\nAfter salary update:");
        mgr.displayManagerDetails();
    }
} 