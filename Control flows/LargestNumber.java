import java.util.Scanner;

public class LargestNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();
        
        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();
        
        System.out.print("Enter third number: ");
        int num3 = scanner.nextInt();
        
        boolean isFirstLargest = (num1 >= num2 && num1 >= num3);
        boolean isSecondLargest = (num2 >= num1 && num2 >= num3);
        boolean isThirdLargest = (num3 >= num1 && num3 >= num2);
        
        System.out.println("Is the first number the largest? " + isFirstLargest);
        System.out.println("Is the second number the largest? " + isSecondLargest);
        System.out.println("Is the third number the largest? " + isThirdLargest);
        
        scanner.close();
    }
} 