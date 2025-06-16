import java.util.Scanner;

public class MultiplesBelow100While {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a positive integer less than 100: ");
        int number = scanner.nextInt();
        
        if (number <= 0 || number >= 100) {
            System.out.println("Please enter a positive integer less than 100.");
        } else {
            System.out.println("Multiples of " + number + " below 100:");
            int counter = number - 1;
            while (counter > 1) {
                if (number % counter == 0) {
                    System.out.println(counter);
                }
                counter--;
            }
        }
        
        scanner.close();
    }
} 