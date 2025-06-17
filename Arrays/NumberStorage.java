import java.util.Scanner;

public class NumberStorage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;

        System.out.println("Enter numbers (enter 0 or negative to stop, max 10 numbers):");
        
        while (true) {
            if (index >= 10) {
                System.out.println("Maximum limit of 10 numbers reached.");
                break;
            }

            System.out.print("Enter number " + (index + 1) + ": ");
            double number = scanner.nextDouble();

            if (number <= 0) {
                break;
            }

            numbers[index] = number;
            index++;
        }

        // Calculate sum and display numbers
        System.out.println("\nNumbers entered:");
        for (int i = 0; i < index; i++) {
            System.out.printf("Number %d: %.2f\n", (i + 1), numbers[i]);
            total += numbers[i];
        }

        System.out.printf("\nTotal sum: %.2f\n", total);
        scanner.close();
    }
} 