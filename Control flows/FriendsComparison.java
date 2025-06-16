import java.util.Scanner;

public class FriendsComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input for Amar
        System.out.println("Enter Amar's details:");
        System.out.print("Age: ");
        int amarAge = scanner.nextInt();
        System.out.print("Height (in cm): ");
        double amarHeight = scanner.nextDouble();
        
        // Input for Akbar
        System.out.println("\nEnter Akbar's details:");
        System.out.print("Age: ");
        int akbarAge = scanner.nextInt();
        System.out.print("Height (in cm): ");
        double akbarHeight = scanner.nextDouble();
        
        // Input for Anthony
        System.out.println("\nEnter Anthony's details:");
        System.out.print("Age: ");
        int anthonyAge = scanner.nextInt();
        System.out.print("Height (in cm): ");
        double anthonyHeight = scanner.nextDouble();
        
        // Find youngest
        int youngestAge = Math.min(Math.min(amarAge, akbarAge), anthonyAge);
        String youngest = "";
        if (youngestAge == amarAge) youngest = "Amar";
        else if (youngestAge == akbarAge) youngest = "Akbar";
        else youngest = "Anthony";
        
        // Find tallest
        double tallestHeight = Math.max(Math.max(amarHeight, akbarHeight), anthonyHeight);
        String tallest = "";
        if (tallestHeight == amarHeight) tallest = "Amar";
        else if (tallestHeight == akbarHeight) tallest = "Akbar";
        else tallest = "Anthony";
        
        System.out.println("\nYoungest friend is: " + youngest + " (Age: " + youngestAge + ")");
        System.out.println("Tallest friend is: " + tallest + " (Height: " + tallestHeight + " cm)");
        
        scanner.close();
    }
} 