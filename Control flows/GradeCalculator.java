import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter marks for three subjects:");
        System.out.print("Physics: ");
        int physics = scanner.nextInt();
        
        System.out.print("Chemistry: ");
        int chemistry = scanner.nextInt();
        
        System.out.print("Mathematics: ");
        int maths = scanner.nextInt();
        
        double average = (physics + chemistry + maths) / 3.0;
        String grade;
        String remarks;
        
        if (average >= 90) {
            grade = "A+";
            remarks = "Excellent";
        } else if (average >= 80) {
            grade = "A";
            remarks = "Very Good";
        } else if (average >= 70) {
            grade = "B";
            remarks = "Good";
        } else if (average >= 60) {
            grade = "C";
            remarks = "Satisfactory";
        } else if (average >= 50) {
            grade = "D";
            remarks = "Pass";
        } else {
            grade = "F";
            remarks = "Fail";
        }
        
        System.out.println("\nResults:");
        System.out.println("Average Mark: " + String.format("%.2f", average));
        System.out.println("Grade: " + grade);
        System.out.println("Remarks: " + remarks);
        
        scanner.close();
    }
} 