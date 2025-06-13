import java.util.Scanner;

public class DynamicCourseFeeDiscount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the course fee: ");
        double fee = input.nextDouble();
        
        System.out.print("Enter the discount percentage: ");
        double discountPercent = input.nextDouble();
        
        double discount = (fee * discountPercent) / 100;
        double finalFee = fee - discount;
        
        System.out.printf("The discount amount is INR %.2f and final discounted fee is INR %.2f%n", 
                         discount, finalFee);
        
        input.close();
    }
} 