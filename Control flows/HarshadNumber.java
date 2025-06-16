import java.util.Scanner;

public class HarshadNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();
        
        if (number <= 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            int originalNumber = number;
            int sum = 0;
            
            // Calculate sum of digits
            while (number != 0) {
                sum += number % 10;
                number /= 10;
            }
            
            if (originalNumber % sum == 0) {
                System.out.println(originalNumber + " is a Harshad Number");
            } else {
                System.out.println(originalNumber + " is not a Harshad Number");
            }
        }
        
        scanner.close();
    }
} 