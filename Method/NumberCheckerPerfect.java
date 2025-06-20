import java.util.Scanner;

public class NumberCheckerPerfect {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        System.out.println("Is Perfect: " + isPerfect(n));
        System.out.println("Is Abundant: " + isAbundant(n));
        System.out.println("Is Deficient: " + isDeficient(n));
        System.out.println("Is Strong: " + isStrong(n));
        scanner.close();
    }
    public static boolean isPerfect(int n) {
        return sumOfProperDivisors(n) == n;
    }
    public static boolean isAbundant(int n) {
        return sumOfProperDivisors(n) > n;
    }
    public static boolean isDeficient(int n) {
        return sumOfProperDivisors(n) < n;
    }
    public static boolean isStrong(int n) {
        int sum = 0, t = n;
        while (t > 0) {
            sum += factorial(t % 10);
            t /= 10;
        }
        return sum == n;
    }
    public static int sumOfProperDivisors(int n) {
        int sum = 0;
        for (int i = 1; i <= n / 2; i++) if (n % i == 0) sum += i;
        return sum;
    }
    public static int factorial(int n) {
        int f = 1;
        for (int i = 2; i <= n; i++) f *= i;
        return f;
    }
} 