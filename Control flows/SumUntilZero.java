import java.util.Scanner;

public class SumUntilZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        
        while (true) {
            System.out.print("Enter a number (0 or negative to stop): ");
            int number = scanner.nextInt();
            
            if (number <= 0) {
                break;
            }
            
            sum += number;
        }
        
        System.out.println("Sum of all entered numbers: " + sum);
        scanner.close();
    }
} 