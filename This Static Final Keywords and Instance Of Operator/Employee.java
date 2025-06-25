public class Employee {
    private static String companyName = "Tech Solutions";
    private static int totalEmployees = 0;
    private final int id;
    private String name;
    private String designation;

    public Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }

    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    public String getName() { return name; }
    public int getId() { return id; }
    public String getDesignation() { return designation; }

    public void displayDetails() {
        if (this instanceof Employee) {
            System.out.println("Company: " + companyName);
            System.out.println("Name: " + name);
            System.out.println("ID: " + id);
            System.out.println("Designation: " + designation);
        }
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Alice", 101, "Developer");
        Employee e2 = new Employee("Bob", 102, "Manager");
        e1.displayDetails();
        System.out.println();
        e2.displayDetails();
        Employee.displayTotalEmployees();
    }
} 