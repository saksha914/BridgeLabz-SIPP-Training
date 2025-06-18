import java.util.Scanner;

public class LowerCaseConversion {
    
    // Method to convert text to lowercase using charAt()
    public static String convertToLowerCase(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                // Convert to lowercase by adding 32 to ASCII value
                result.append((char)(c + 32));
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
        String lowerCase1 = convertToLowerCase(text);
        
        // Convert using toLowerCase()
        String lowerCase2 = text.toLowerCase();
        
        // Compare the results
        boolean areEqual = compareStrings(lowerCase1, lowerCase2);
        
        System.out.println("\nResults:");
        System.out.println("Original text: " + text);
        System.out.println("Lowercase using charAt(): " + lowerCase1);
        System.out.println("Lowercase using toLowerCase(): " + lowerCase2);
        System.out.println("Are the results equal? " + areEqual);
        
        scanner.close();
    }
} 