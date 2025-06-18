import java.util.Scanner;

public class StringComparison {
    
    // Method to compare strings using charAt()
    public static boolean compareUsingCharAt(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter first string: ");
        String str1 = scanner.next();
        
        System.out.print("Enter second string: ");
        String str2 = scanner.next();
        
        // Compare using charAt()
        boolean charAtResult = compareUsingCharAt(str1, str2);
        
        // Compare using equals()
        boolean equalsResult = str1.equals(str2);
        
        System.out.println("\nResults:");
        System.out.println("Comparison using charAt(): " + charAtResult);
        System.out.println("Comparison using equals(): " + equalsResult);
        System.out.println("Are the results same? " + (charAtResult == equalsResult));
        
        scanner.close();
    }
} 