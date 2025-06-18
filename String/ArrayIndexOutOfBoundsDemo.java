import java.util.Scanner;

public class ArrayIndexOutOfBoundsDemo {
    
    // Method to generate ArrayIndexOutOfBoundsException
    public static void generateException(String[] names) {
        // Accessing index beyond array length
        System.out.println("Accessing index beyond array length: " + names[names.length]);
    }
    
    // Method to handle ArrayIndexOutOfBoundsException
    public static void handleException(String[] names) {
        try {
            // Accessing index beyond array length
            System.out.println("Accessing index beyond array length: " + names[names.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of names: ");
        int size = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        String[] names = new String[size];
        
        // Input names
        for (int i = 0; i < size; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = scanner.nextLine();
        }
        
        System.out.println("\nGenerating ArrayIndexOutOfBoundsException:");
        try {
            generateException(names);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception caught in main: " + e.getMessage());
        }
        
        System.out.println("\nHandling ArrayIndexOutOfBoundsException:");
        handleException(names);
        
        scanner.close();
    }
} 