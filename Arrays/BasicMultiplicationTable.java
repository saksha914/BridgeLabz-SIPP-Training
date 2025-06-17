import java.util.Scanner;

public class BasicMultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        int[] multiplicationTable = new int[10];
        
        // Calculate multiplication table
        for (int i = 0; i < 10; i++) {
            multiplicationTable[i] = number * (i + 1);
        }
        
        // Display results
        System.out.println("\nMultiplication Table for " + number + ":");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d * %d = %d\n", number, (i + 1), multiplicationTable[i]);
        }
        
        scanner.close();
    }
} 