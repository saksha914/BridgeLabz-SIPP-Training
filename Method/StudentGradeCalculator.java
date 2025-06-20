import java.util.Random;
import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        int[][] scores = generateRandomScores(n);
        double[][] results = calculateResults(scores);
        displayScorecard(scores, results);
        scanner.close();
    }
    public static int[][] generateRandomScores(int n) {
        Random rand = new Random();
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = 40 + rand.nextInt(61); // 2-digit random score
            }
        }
        return arr;
    }
    public static double[][] calculateResults(int[][] scores) {
        double[][] res = new double[scores.length][3];
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = total / 3.0;
            double percent = (total / 300.0) * 100;
            res[i][0] = total;
            res[i][1] = Math.round(avg * 100.0) / 100.0;
            res[i][2] = Math.round(percent * 100.0) / 100.0;
        }
        return res;
    }
    public static void displayScorecard(int[][] scores, double[][] results) {
        System.out.println("Phy\tChem\tMath\tTotal\tAvg\t% ");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%d\t%d\t%d\t%.0f\t%.2f\t%.2f\n", scores[i][0], scores[i][1], scores[i][2], results[i][0], results[i][1], results[i][2]);
        }
    }
} 