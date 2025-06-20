import java.util.Scanner;

public class NaturalNumberSumRecursive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.println("Please enter a natural number (greater than 0)");
        } else {
            int sumRec = sumRecursive(n);
            int sumFormula = sumFormula(n);
            System.out.println("Sum using recursion: " + sumRec);
            System.out.println("Sum using formula: " + sumFormula);
            System.out.println("Both results are " + (sumRec == sumFormula ? "equal." : "not equal!"));
        }
        scanner.close();
    }
    public static int sumRecursive(int n) {
        if (n == 1) return 1;
        return n + sumRecursive(n - 1);
    }
    public static int sumFormula(int n) {
        return n * (n + 1) / 2;
    }
} 