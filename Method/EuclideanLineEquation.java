import java.util.Scanner;

public class EuclideanLineEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter x1: ");
        double x1 = scanner.nextDouble();
        System.out.print("Enter y1: ");
        double y1 = scanner.nextDouble();
        System.out.print("Enter x2: ");
        double x2 = scanner.nextDouble();
        System.out.print("Enter y2: ");
        double y2 = scanner.nextDouble();
        double dist = euclideanDistance(x1, y1, x2, y2);
        double[] eq = lineEquation(x1, y1, x2, y2);
        System.out.printf("Distance: %.2f\n", dist);
        System.out.printf("Line equation: y = %.2fx + %.2f\n", eq[0], eq[1]);
        scanner.close();
    }
    public static double euclideanDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
    public static double[] lineEquation(double x1, double y1, double x2, double y2) {
        double m = (y2 - y1) / (x2 - x1);
        double b = y1 - m * x1;
        return new double[]{m, b};
    }
} 