import java.util.Scanner;

public class SimpleInterest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter Principal amount: ");
        double principal = input.nextDouble();
        
        System.out.print("Enter Rate of Interest: ");
        double rate = input.nextDouble();
        
        System.out.print("Enter Time in years: ");
        double time = input.nextDouble();
        
        double simpleInterest = (principal * rate * time) / 100;
        
        System.out.printf("Simple Interest for Principal %.2f, Rate %.2f%% and Time %.2f years is %.2f%n",
                         principal, rate, time, simpleInterest);
        
        input.close();
    }
} 