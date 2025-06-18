import java.util.Scanner;

public class IllegalArgumentExceptionDemo {
    
    // Method to generate IllegalArgumentException
    public static void generateException(String text, int start, int end) {
        // This will generate IllegalArgumentException if start > end
        System.out.println("Substring: " + text.substring(start, end));
    }
    
    // Method to handle IllegalArgumentException
    public static void handleException(String text, int start, int end) {
        try {
            // This will generate IllegalArgumentException if start > end
            System.out.println("Substring: " + text.substring(start, end));
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();
        
        System.out.print("Enter start index: ");
        int start = scanner.nextInt();
        
        System.out.print("Enter end index: ");
        int end = scanner.nextInt();
        
        System.out.println("\nGenerating IllegalArgumentException:");
        try {
            generateException(text, start, end);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught in main: " + e.getMessage());
        }
        
        System.out.println("\nHandling IllegalArgumentException:");
        handleException(text, start, end);
        
        scanner.close();
    }
} 