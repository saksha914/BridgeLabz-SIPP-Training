import java.util.Scanner;

public class BasicArithmetic {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        double num1 = input.nextDouble();
        
        System.out.print("Enter second number: ");
        double num2 = input.nextDouble();
        
        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        double quotient = num2 != 0 ? num1 / num2 : Double.POSITIVE_INFINITY;
        
        System.out.printf("Sum: %.2f%n", sum);
        System.out.printf("Difference: %.2f%n", difference);
        System.out.printf("Product: %.2f%n", product);
        if (num2 != 0) {
            System.out.printf("Quotient: %.2f%n", quotient);
        } else {
            System.out.println("Quotient: Cannot divide by zero");
        }
        
        input.close();
    }
} 