import java.util.Scanner;

public class DigitCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();
        
        int count = 0;
        int tempNumber = Math.abs(number); // Handle negative numbers
        
        while (tempNumber != 0) {
            tempNumber /= 10;
            count++;
        }
        
        // Handle the case when number is 0
        if (number == 0) {
            count = 1;
        }
        
        System.out.println("Number of digits: " + count);
        
        scanner.close();
    }
} 