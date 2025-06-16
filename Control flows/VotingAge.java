import java.util.Scanner;

public class VotingAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter person's age: ");
        int age = scanner.nextInt();
        
        if (age >= 18) {
            System.out.println("The person's age is " + age + " and can vote.");
        } else {
            System.out.println("The person's age is " + age + " and cannot vote.");
        }
        
        scanner.close();
    }
} 