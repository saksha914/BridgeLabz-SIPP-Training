import java.util.Scanner;

public class LeapYearMultipleIf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a year (>= 1582): ");
        int year = scanner.nextInt();
        
        if (year < 1582) {
            System.out.println("Please enter a year >= 1582 (Gregorian calendar)");
        } else {
            boolean isLeapYear = false;
            
            if (year % 4 == 0) {
                if (year % 100 == 0) {
                    if (year % 400 == 0) {
                        isLeapYear = true;
                    }
                } else {
                    isLeapYear = true;
                }
            }
            
            if (isLeapYear) {
                System.out.println(year + " is a Leap Year");
            } else {
                System.out.println(year + " is not a Leap Year");
            }
        }
        
        scanner.close();
    }
} 