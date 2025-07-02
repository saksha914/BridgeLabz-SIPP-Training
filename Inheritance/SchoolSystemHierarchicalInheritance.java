class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Teacher extends Person {
    private String subject;
    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }
    public void displayRole() {
        System.out.println("Role: Teacher");
        System.out.println("Subject: " + subject);
    }
}

class Student extends Person {
    private String grade;
    public Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }
    public void displayRole() {
        System.out.println("Role: Student");
        System.out.println("Grade: " + grade);
    }
}

class Staff extends Person {
    private String department;
    public Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }
    public void displayRole() {
        System.out.println("Role: Staff");
        System.out.println("Department: " + department);
    }
}

public class SchoolSystemHierarchicalInheritance {
    public static void main(String[] args) {
        Person[] people = {
            new Teacher("Alice", 35, "Math"),
            new Student("Bob", 16, "10th Grade"),
            new Staff("Charlie", 40, "Administration")
        };
        for (Person p : people) {
            if (p instanceof Teacher) ((Teacher)p).displayRole();
            else if (p instanceof Student) ((Student)p).displayRole();
            else if (p instanceof Staff) ((Staff)p).displayRole();
            System.out.println();
        }
    }
} 