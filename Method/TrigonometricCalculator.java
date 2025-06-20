import java.util.Scanner;

public class TrigonometricCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter angle in degrees: ");
        double angle = scanner.nextDouble();
        double[] results = calculateTrigonometricFunctions(angle);
        System.out.printf("Sine: %.4f\nCosine: %.4f\nTangent: %.4f\n", results[0], results[1], results[2]);
        scanner.close();
    }

    public static double[] calculateTrigonometricFunctions(double angle) {
        double radians = Math.toRadians(angle);
        double[] res = new double[3];
        res[0] = Math.sin(radians);
        res[1] = Math.cos(radians);
        res[2] = Math.tan(radians);
        return res;
    }
} 