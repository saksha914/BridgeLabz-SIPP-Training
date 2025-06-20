import java.util.Scanner;

public class StudentVoteChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ages = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter age of student " + (i+1) + ": ");
            ages[i] = scanner.nextInt();
        }
        for (int i = 0; i < 10; i++) {
            boolean canVote = canStudentVote(ages[i]);
            System.out.println("Student " + (i+1) + " (age " + ages[i] + ") can vote: " + canVote);
        }
        scanner.close();
    }
    public static boolean canStudentVote(int age) {
        if (age < 0) return false;
        return age >= 18;
    }
} 