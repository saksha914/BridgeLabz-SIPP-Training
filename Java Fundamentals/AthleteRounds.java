import java.util.Scanner;

public class AthleteRounds {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter first side of triangle in meters: ");
        double side1 = input.nextDouble();
        
        System.out.print("Enter second side of triangle in meters: ");
        double side2 = input.nextDouble();
        
        System.out.print("Enter third side of triangle in meters: ");
        double side3 = input.nextDouble();
        
        double perimeter = side1 + side2 + side3;
        double targetDistance = 5000; // 5 km in meters
        double rounds = targetDistance / perimeter;
        
        System.out.printf("The total number of rounds the athlete will run is %.2f to complete 5 km%n",
                         rounds);
        
        input.close();
    }
} 