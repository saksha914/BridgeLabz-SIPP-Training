import java.util.Scanner;

public class TextTrimmer {
    
    // Method to find string length without using length()
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }
    
    // Method to find start and end indices for trimming
    public static int[] findTrimIndices(String text) {
        int start = 0;
        int end = text.length() - 1;
        
        // Find start index (skip leading spaces)
        while (start <= end && text.charAt(start) == ' ') {
            start++;
        }
        
        // Find end index (skip trailing spaces)
        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }
        
        return new int[]{start, end};
    }
    
    // Method to create substring using charAt()
    public static String createSubstring(String text, int start, int end) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i <= end; i++) {
            result.append(text.charAt(i));
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
        
        System.out.print("Enter text with spaces: ");
        String text = scanner.nextLine();
        
        // Find trim indices
        int[] indices = findTrimIndices(text);
        
        // Create trimmed string using charAt()
        String trimmed1 = createSubstring(text, indices[0], indices[1]);
        
        // Create trimmed string using trim()
        String trimmed2 = text.trim();
        
        // Compare the results
        boolean areEqual = compareStrings(trimmed1, trimmed2);
        
        System.out.println("\nResults:");
        System.out.println("Original text: \"" + text + "\"");
        System.out.println("Trimmed using charAt(): \"" + trimmed1 + "\"");
        System.out.println("Trimmed using trim(): \"" + trimmed2 + "\"");
        System.out.println("Are the results equal? " + areEqual);
        
        scanner.close();
    }
} 