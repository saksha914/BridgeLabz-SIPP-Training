import java.util.Scanner;

public class WeightConversion {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter weight in pounds: ");
        double weightPounds = input.nextDouble();
        
        double weightKg = weightPounds / 2.2;
        
        System.out.printf("The weight of the person in pounds is %.2f and in kg is %.2f%n",
                         weightPounds, weightKg);
        
        input.close();
    }
} 