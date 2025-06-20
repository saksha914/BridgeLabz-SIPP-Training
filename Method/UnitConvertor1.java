import java.util.Scanner;

public class UnitConvertor1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter yards: ");
        double yards = scanner.nextDouble();
        System.out.println("Yards to feet: " + convertYardsToFeet(yards));
        System.out.print("Enter feet: ");
        double feet = scanner.nextDouble();
        System.out.println("Feet to yards: " + convertFeetToYards(feet));
        System.out.print("Enter meters: ");
        double meters = scanner.nextDouble();
        System.out.println("Meters to inches: " + convertMetersToInches(meters));
        System.out.print("Enter inches: ");
        double inches = scanner.nextDouble();
        System.out.println("Inches to meters: " + convertInchesToMeters(inches));
        System.out.println("Inches to centimeters: " + convertInchesToCentimeters(inches));
        scanner.close();
    }
    public static double convertYardsToFeet(double yards) {
        return yards * 3;
    }
    public static double convertFeetToYards(double feet) {
        return feet * 0.333333;
    }
    public static double convertMetersToInches(double meters) {
        return meters * 39.3701;
    }
    public static double convertInchesToMeters(double inches) {
        return inches * 0.0254;
    }
    public static double convertInchesToCentimeters(double inches) {
        return inches * 2.54;
    }
} 