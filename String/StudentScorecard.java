import java.util.Scanner;

public class StudentScorecard {
    
    // Method to generate random scores
    public static int[][] generateScores(int numStudents) {
        int[][] scores = new int[numStudents][3];
        for (int i = 0; i < numStudents; i++) {
            scores[i][0] = (int)(Math.random() * 90) + 10; // Physics (10-99)
            scores[i][1] = (int)(Math.random() * 90) + 10; // Chemistry (10-99)
            scores[i][2] = (int)(Math.random() * 90) + 10; // Maths (10-99)
        }
        return scores;
    }
    
    // Method to calculate total, average, and percentage
    public static double[][] calculateStats(int[][] scores) {
        double[][] stats = new double[scores.length][3];
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;
            
            stats[i][0] = Math.round(total * 100.0) / 100.0;
            stats[i][1] = Math.round(average * 100.0) / 100.0;
            stats[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return stats;
    }
    
    // Method to calculate grade based on percentage
    public static String[][] calculateGrades(double[][] stats) {
        String[][] grades = new String[stats.length][1];
        for (int i = 0; i < stats.length; i++) {
            double percentage = stats[i][2];
            if (percentage >= 90) {
                grades[i][0] = "A+";
            } else if (percentage >= 80) {
                grades[i][0] = "A";
            } else if (percentage >= 70) {
                grades[i][0] = "B";
            } else if (percentage >= 60) {
                grades[i][0] = "C";
            } else if (percentage >= 50) {
                grades[i][0] = "D";
            } else {
                grades[i][0] = "F";
            }
        }
        return grades;
    }
    
    // Method to display scorecard
    public static void displayScorecard(int[][] scores, double[][] stats, String[][] grades) {
        System.out.println("\nStudent Scorecard");
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s%n",
                         "Student", "Physics", "Chemistry", "Maths", "Total", "Average", "Grade");
        System.out.println("------------------------------------------------------------");
        
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%-10d %-10d %-10d %-10d %-10.2f %-10.2f %-10s%n",
                            i + 1, scores[i][0], scores[i][1], scores[i][2],
                            stats[i][0], stats[i][1], grades[i][0]);
        }
        System.out.println("------------------------------------------------------------");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of students: ");
        int numStudents = scanner.nextInt();
        
        // Generate scores
        int[][] scores = generateScores(numStudents);
        
        // Calculate statistics
        double[][] stats = calculateStats(scores);
        
        // Calculate grades
        String[][] grades = calculateGrades(stats);
        
        // Display scorecard
        displayScorecard(scores, stats, grades);
        
        scanner.close();
    }
} 