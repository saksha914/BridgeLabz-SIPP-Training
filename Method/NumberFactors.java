import java.util.Scanner;

public class NumberFactors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        int[] factors = findFactors(n);
        System.out.print("Factors: ");
        for (int f : factors) System.out.print(f + " ");
        System.out.println();
        System.out.println("Sum of factors: " + sumOfFactors(factors));
        System.out.println("Product of factors: " + productOfFactors(factors));
        System.out.println("Sum of squares of factors: " + sumOfSquaresOfFactors(factors));
        scanner.close();
    }
    public static int[] findFactors(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) if (n % i == 0) count++;
        int[] arr = new int[count];
        int idx = 0;
        for (int i = 1; i <= n; i++) if (n % i == 0) arr[idx++] = i;
        return arr;
    }
    public static int sumOfFactors(int[] arr) {
        int sum = 0;
        for (int x : arr) sum += x;
        return sum;
    }
    public static int productOfFactors(int[] arr) {
        int prod = 1;
        for (int x : arr) prod *= x;
        return prod;
    }
    public static int sumOfSquaresOfFactors(int[] arr) {
        int sum = 0;
        for (int x : arr) sum += (int)Math.pow(x, 2);
        return sum;
    }
} 