import java.util.Scanner;

public class AddTwoNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        double number1 = input.nextDouble();
        
        System.out.print("Enter second number: ");
        double number2 = input.nextDouble();
        
        double sum = number1 + number2;
        
        System.out.printf("The sum of %.2f and %.2f is %.2f%n", number1, number2, sum);
        
        input.close();
    }
} 