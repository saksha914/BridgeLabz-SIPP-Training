// Student Record Management System using Singly Linked List
// Demonstrates: Singly Linked List operations - Insert, Delete, Search, Update, Display

// Node class for Student
class StudentNode {
    int rollNumber;
    String name;
    int age;
    char grade;
    StudentNode next;
    
    public StudentNode(int rollNumber, String name, int age, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

// Singly Linked List class for Student Management
class StudentLinkedList {
    private StudentNode head;
    private int size;
    
    public StudentLinkedList() {
        this.head = null;
        this.size = 0;
    }
    
    // Add student at the beginning
    public void addAtBeginning(int rollNumber, String name, int age, char grade) {
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        newNode.next = head;
        head = newNode;
        size++;
        System.out.println("Student added at the beginning successfully!");
    }
    
    // Add student at the end
    public void addAtEnd(int rollNumber, String name, int age, char grade) {
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        
        if (head == null) {
            head = newNode;
        } else {
            StudentNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        System.out.println("Student added at the end successfully!");
    }
    
    // Add student at specific position
    public void addAtPosition(int position, int rollNumber, String name, int age, char grade) {
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position!");
            return;
        }
        
        if (position == 1) {
            addAtBeginning(rollNumber, name, age, grade);
            return;
        }
        
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        StudentNode current = head;
        
        for (int i = 1; i < position - 1; i++) {
            current = current.next;
        }
        
        newNode.next = current.next;
        current.next = newNode;
        size++;
        System.out.println("Student added at position " + position + " successfully!");
    }
    
    // Delete student by Roll Number
    public boolean deleteByRollNumber(int rollNumber) {
        if (head == null) {
            System.out.println("List is empty!");
            return false;
        }
        
        if (head.rollNumber == rollNumber) {
            head = head.next;
            size--;
            System.out.println("Student with Roll Number " + rollNumber + " deleted successfully!");
            return true;
        }
        
        StudentNode current = head;
        while (current.next != null && current.next.rollNumber != rollNumber) {
            current = current.next;
        }
        
        if (current.next != null) {
            current.next = current.next.next;
            size--;
            System.out.println("Student with Roll Number " + rollNumber + " deleted successfully!");
            return true;
        } else {
            System.out.println("Student with Roll Number " + rollNumber + " not found!");
            return false;
        }
    }
    
    // Search student by Roll Number
    public StudentNode searchByRollNumber(int rollNumber) {
        StudentNode current = head;
        
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                return current;
            }
            current = current.next;
        }
        
        return null;
    }
    
    // Update student grade by Roll Number
    public boolean updateGrade(int rollNumber, char newGrade) {
        StudentNode student = searchByRollNumber(rollNumber);
        
        if (student != null) {
            student.grade = newGrade;
            System.out.println("Grade updated successfully for Roll Number " + rollNumber + "!");
            return true;
        } else {
            System.out.println("Student with Roll Number " + rollNumber + " not found!");
            return false;
        }
    }
    
    // Display all student records
    public void displayAllStudents() {
        if (head == null) {
            System.out.println("No students in the list!");
            return;
        }
        
        System.out.println("\n=== Student Records ===");
        System.out.printf("%-12s %-20s %-8s %-8s%n", "Roll Number", "Name", "Age", "Grade");
        System.out.println("------------------------------------------------");
        
        StudentNode current = head;
        while (current != null) {
            System.out.printf("%-12d %-20s %-8d %-8c%n", 
                            current.rollNumber, current.name, current.age, current.grade);
            current = current.next;
        }
        System.out.println("Total Students: " + size);
    }
    
    // Get size of the list
    public int getSize() {
        return size;
    }
    
    // Check if list is empty
    public boolean isEmpty() {
        return head == null;
    }
}

// Main class to demonstrate the Student Record Management System
public class StudentRecordManagement {
    public static void main(String[] args) {
        System.out.println("=== Student Record Management System ===\n");
        
        StudentLinkedList studentList = new StudentLinkedList();
        
        // Adding students at different positions
        System.out.println("Adding students...");
        studentList.addAtEnd(101, "John Doe", 20, 'A');
        studentList.addAtEnd(102, "Jane Smith", 19, 'B');
        studentList.addAtBeginning(100, "Alice Johnson", 21, 'A');
        studentList.addAtPosition(2, 103, "Bob Wilson", 22, 'C');
        studentList.addAtEnd(104, "Charlie Brown", 20, 'B');
        
        // Display all students
        studentList.displayAllStudents();
        
        // Search for a student
        System.out.println("\n=== Searching for Student ===");
        int searchRoll = 102;
        StudentNode foundStudent = studentList.searchByRollNumber(searchRoll);
        if (foundStudent != null) {
            System.out.println("Found Student:");
            System.out.println("Roll Number: " + foundStudent.rollNumber);
            System.out.println("Name: " + foundStudent.name);
            System.out.println("Age: " + foundStudent.age);
            System.out.println("Grade: " + foundStudent.grade);
        }
        
        // Update student grade
        System.out.println("\n=== Updating Student Grade ===");
        studentList.updateGrade(103, 'A');
        
        // Display updated list
        studentList.displayAllStudents();
        
        // Delete a student
        System.out.println("\n=== Deleting Student ===");
        studentList.deleteByRollNumber(102);
        
        // Display final list
        studentList.displayAllStudents();
        
        // Test edge cases
        System.out.println("\n=== Testing Edge Cases ===");
        studentList.deleteByRollNumber(999); // Non-existent student
        studentList.updateGrade(999, 'F'); // Non-existent student
        studentList.addAtPosition(10, 105, "Test Student", 18, 'D'); // Invalid position
        studentList.addAtPosition(3, 105, "Valid Student", 18, 'D'); // Valid position
        
        studentList.displayAllStudents();
    }
} 