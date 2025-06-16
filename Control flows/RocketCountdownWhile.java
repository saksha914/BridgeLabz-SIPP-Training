import java.util.Scanner;

public class RocketCountdownWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter countdown start number: ");
        int countdown = scanner.nextInt();
        
        System.out.println("Starting countdown...");
        while (countdown >= 1) {
            System.out.println(countdown);
            countdown--;
        }
        System.out.println("Liftoff!");
        
        scanner.close();
    }
} 