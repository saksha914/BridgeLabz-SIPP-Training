import java.util.Scanner;

public class StringIndexOutOfBoundsDemo {
    
    // Method to generate StringIndexOutOfBoundsException
    public static void generateException(String text) {
        // Accessing index beyond string length
        System.out.println("Accessing character at index beyond string length: " + text.charAt(text.length()));
    }
    
    // Method to handle StringIndexOutOfBoundsException
    public static void handleException(String text) {
        try {
            // Accessing index beyond string length
            System.out.println("Accessing character at index beyond string length: " + text.charAt(text.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException caught: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();
        
        System.out.println("\nGenerating StringIndexOutOfBoundsException:");
        try {
            generateException(text);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception caught in main: " + e.getMessage());
        }
        
        System.out.println("\nHandling StringIndexOutOfBoundsException:");
        handleException(text);
        
        scanner.close();
    }
} 