import java.util.Scanner;

public class NaturalNumberSumFor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        if (number > 0) {
            // Using formula
            int sumFormula = number * (number + 1) / 2;
            
            // Using for loop
            int sumLoop = 0;
            for (int i = 1; i <= number; i++) {
                sumLoop += i;
            }
            
            System.out.println("Sum using formula: " + sumFormula);
            System.out.println("Sum using for loop: " + sumLoop);
            System.out.println("Both results are " + (sumFormula == sumLoop ? "correct" : "incorrect"));
        } else {
            System.out.println("Please enter a positive integer.");
        }
        
        scanner.close();
    }
} 