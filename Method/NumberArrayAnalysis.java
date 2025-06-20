import java.util.Scanner;

public class NumberArrayAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i+1) + ": ");
            numbers[i] = scanner.nextInt();
        }
        for (int num : numbers) {
            if (isPositive(num)) {
                if (isEven(num)) {
                    System.out.println(num + " is positive and even.");
                } else {
                    System.out.println(num + " is positive and odd.");
                }
            } else {
                System.out.println(num + " is negative.");
            }
        }
        int cmp = compare(numbers[0], numbers[4]);
        if (cmp == 0) System.out.println("First and last elements are equal.");
        else if (cmp == 1) System.out.println("First element is greater than last.");
        else System.out.println("First element is less than last.");
        scanner.close();
    }
    public static boolean isPositive(int n) {
        return n > 0;
    }
    public static boolean isEven(int n) {
        return n % 2 == 0;
    }
    public static int compare(int a, int b) {
        if (a > b) return 1;
        else if (a == b) return 0;
        else return -1;
    }
} 