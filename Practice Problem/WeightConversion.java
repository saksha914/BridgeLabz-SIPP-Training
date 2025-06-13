import java.util.Scanner;

public class WeightConversion {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter weight in kilograms: ");
        double kilograms = input.nextDouble();
        
        double pounds = kilograms * 2.20462;
        
        System.out.printf("%.2f kilograms is equal to %.2f pounds%n", kilograms, pounds);
        
        input.close();
    }
} 