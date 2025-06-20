import java.util.Scanner;
import java.util.Arrays;

public class NumberCheckerPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        int[] digits = getDigits(n);
        int[] reversed = reverseArray(digits);
        System.out.println("Count of digits: " + digits.length);
        System.out.print("Digits: ");
        for (int d : digits) System.out.print(d + " ");
        System.out.println();
        System.out.print("Reversed: ");
        for (int d : reversed) System.out.print(d + " ");
        System.out.println();
        System.out.println("Arrays equal: " + Arrays.equals(digits, reversed));
        System.out.println("Is Palindrome: " + isPalindrome(digits));
        System.out.println("Is Duck Number: " + isDuckNumber(digits));
        scanner.close();
    }
    public static int[] getDigits(int n) {
        String s = String.valueOf(Math.abs(n));
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) arr[i] = s.charAt(i) - '0';
        return arr;
    }
    public static int[] reverseArray(int[] arr) {
        int[] rev = new int[arr.length];
        for (int i = 0; i < arr.length; i++) rev[i] = arr[arr.length - 1 - i];
        return rev;
    }
    public static boolean isPalindrome(int[] arr) {
        int[] rev = reverseArray(arr);
        return Arrays.equals(arr, rev);
    }
    public static boolean isDuckNumber(int[] digits) {
        for (int i = 1; i < digits.length; i++) if (digits[i] == 0) return true;
        return false;
    }
} 