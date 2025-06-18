import java.util.Scanner;

public class SubstringComparison {
    
    // Method to create substring using charAt()
    public static String createSubstringUsingCharAt(String text, int start, int end) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i < end; i++) {
            result.append(text.charAt(i));
        }
        return result.toString();
    }
    
    // Method to compare two strings using charAt()
    public static boolean compareStrings(String str1, String str2) {
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
        
        System.out.print("Enter a string: ");
        String text = scanner.next();
        
        System.out.print("Enter start index: ");
        int start = scanner.nextInt();
        
        System.out.print("Enter end index: ");
        int end = scanner.nextInt();
        
        // Create substring using charAt()
        String substring1 = createSubstringUsingCharAt(text, start, end);
        
        // Create substring using built-in substring()
        String substring2 = text.substring(start, end);
        
        // Compare the results
        boolean areEqual = compareStrings(substring1, substring2);
        
        System.out.println("\nResults:");
        System.out.println("Substring using charAt(): " + substring1);
        System.out.println("Substring using substring(): " + substring2);
        System.out.println("Are the substrings equal? " + areEqual);
        
        scanner.close();
    }
} 