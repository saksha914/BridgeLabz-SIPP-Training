import java.util.Scanner;

public class VotingEligibility {
    
    // Method to generate random ages
    public static int[] generateAges(int numStudents) {
        int[] ages = new int[numStudents];
        for (int i = 0; i < numStudents; i++) {
            ages[i] = (int)(Math.random() * 30) + 10; // Ages between 10-39
        }
        return ages;
    }
    
    // Method to check voting eligibility
    public static String[][] checkEligibility(int[] ages) {
        String[][] eligibility = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            eligibility[i][0] = String.valueOf(ages[i]);
            if (ages[i] < 0) {
                eligibility[i][1] = "Invalid Age";
            } else if (ages[i] >= 18) {
                eligibility[i][1] = "Can Vote";
            } else {
                eligibility[i][1] = "Cannot Vote";
            }
        }
        return eligibility;
    }
    
    // Method to display results in tabular format
    public static void displayResults(String[][] eligibility) {
        System.out.println("\nVoting Eligibility Results");
        System.out.println("------------------------");
        System.out.printf("%-10s %-15s%n", "Age", "Eligibility");
        System.out.println("------------------------");
        
        for (String[] row : eligibility) {
            System.out.printf("%-10s %-15s%n", row[0], row[1]);
        }
        System.out.println("------------------------");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of students: ");
        int numStudents = scanner.nextInt();
        
        // Generate random ages
        int[] ages = generateAges(numStudents);
        
        // Check voting eligibility
        String[][] eligibility = checkEligibility(ages);
        
        // Display results
        displayResults(eligibility);
        
        scanner.close();
    }
} 