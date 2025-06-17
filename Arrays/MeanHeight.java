import java.util.Scanner;

public class MeanHeight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] heights = new double[11];
        double sum = 0.0;

        // Get input for heights
        System.out.println("Enter heights of 11 football players (in meters):");
        for (int i = 0; i < 11; i++) {
            System.out.print("Player " + (i + 1) + " height: ");
            heights[i] = scanner.nextDouble();
            sum += heights[i];
        }

        // Calculate mean height
        double meanHeight = sum / 11;

        // Display results
        System.out.println("\nHeights of players:");
        for (int i = 0; i < 11; i++) {
            System.out.printf("Player %d: %.2f meters\n", (i + 1), heights[i]);
        }
        System.out.printf("\nMean height of the team: %.2f meters\n", meanHeight);

        scanner.close();
    }
} 