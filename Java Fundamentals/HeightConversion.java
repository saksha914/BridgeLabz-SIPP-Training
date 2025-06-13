import java.util.Scanner;

public class HeightConversion {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter height in centimeters: ");
        double heightCm = input.nextDouble();
        
        // Convert to inches first
        double heightInches = heightCm / 2.54;
        
        // Convert to feet and remaining inches
        int feet = (int)(heightInches / 12);
        double remainingInches = heightInches % 12;
        
        System.out.printf("Your Height in cm is %.2f while in feet is %d and inches is %.2f%n", 
                         heightCm, feet, remainingInches);
        
        input.close();
    }
} 