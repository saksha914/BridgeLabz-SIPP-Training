import java.util.Scanner;

public class RocketCountdownFor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter countdown start number: ");
        int countdown = scanner.nextInt();
        
        System.out.println("Starting countdown...");
        for (int i = countdown; i >= 1; i--) {
            System.out.println(i);
        }
        System.out.println("Liftoff!");
        
        scanner.close();
    }
} 