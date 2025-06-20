import java.util.Scanner;

public class AthleteRounds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter side 1 of triangle (in meters): ");
        double a = scanner.nextDouble();
        System.out.print("Enter side 2 of triangle (in meters): ");
        double b = scanner.nextDouble();
        System.out.print("Enter side 3 of triangle (in meters): ");
        double c = scanner.nextDouble();
        double rounds = calculateRounds(a, b, c, 5000);
        System.out.printf("The athlete must complete %.2f rounds to cover 5 km.\n", rounds);
        scanner.close();
    }

    public static double calculateRounds(double a, double b, double c, double distance) {
        double perimeter = a + b + c;
        return distance / perimeter;
    }
} 