import java.util.Scanner;

public class LeapYearSingleCondition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a year (>= 1582): ");
        int year = scanner.nextInt();
        
        if (year < 1582) {
            System.out.println("Please enter a year >= 1582 (Gregorian calendar)");
        } else {
            boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
            
            if (isLeapYear) {
                System.out.println(year + " is a Leap Year");
            } else {
                System.out.println(year + " is not a Leap Year");
            }
        }
        
        scanner.close();
    }
} 