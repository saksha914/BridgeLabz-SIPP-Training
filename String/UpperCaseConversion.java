import java.util.Scanner;

public class UpperCaseConversion {
    
    // Method to convert text to uppercase using charAt()
    public static String convertToUpperCase(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= 'a' && c <= 'z') {
                // Convert to uppercase by subtracting 32 from ASCII value
                result.append((char)(c - 32));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
    
    // Method to compare strings using charAt()
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
        
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        
        // Convert using charAt()
        String upperCase1 = convertToUpperCase(text);
        
        // Convert using toUpperCase()
        String upperCase2 = text.toUpperCase();
        
        // Compare the results
        boolean areEqual = compareStrings(upperCase1, upperCase2);
        
        System.out.println("\nResults:");
        System.out.println("Original text: " + text);
        System.out.println("Uppercase using charAt(): " + upperCase1);
        System.out.println("Uppercase using toUpperCase(): " + upperCase2);
        System.out.println("Are the results equal? " + areEqual);
        
        scanner.close();
    }
} 