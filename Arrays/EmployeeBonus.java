import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double[][] employeeData = new double[10][2]; // [salary, yearsOfService]
        double[] newSalary = new double[10];
        double[] bonus = new double[10];
        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        
        // Input data
        for (int i = 0; i < 10; i++) {
            System.out.println("\nEmployee " + (i + 1) + ":");
            
            // Input salary
            do {
                System.out.print("Enter salary: ");
                employeeData[i][0] = scanner.nextDouble();
            } while (employeeData[i][0] <= 0);
            
            // Input years of service
            do {
                System.out.print("Enter years of service: ");
                employeeData[i][1] = scanner.nextDouble();
            } while (employeeData[i][1] < 0);
            
            // Calculate bonus and new salary
            if (employeeData[i][1] > 5) {
                bonus[i] = employeeData[i][0] * 0.05;
            } else {
                bonus[i] = employeeData[i][0] * 0.02;
            }
            
            newSalary[i] = employeeData[i][0] + bonus[i];
            
            // Update totals
            totalBonus += bonus[i];
            totalOldSalary += employeeData[i][0];
            totalNewSalary += newSalary[i];
        }
        
        // Display results
        System.out.println("\nEmployee Bonus Report:");
        for (int i = 0; i < 10; i++) {
            System.out.println("\nEmployee " + (i + 1) + ":");
            System.out.printf("Old Salary: %.2f\n", employeeData[i][0]);
            System.out.printf("Years of Service: %.1f\n", employeeData[i][1]);
            System.out.printf("Bonus: %.2f\n", bonus[i]);
            System.out.printf("New Salary: %.2f\n", newSalary[i]);
        }
        
        System.out.println("\nSummary:");
        System.out.printf("Total Bonus Payout: %.2f\n", totalBonus);
        System.out.printf("Total Old Salary: %.2f\n", totalOldSalary);
        System.out.printf("Total New Salary: %.2f\n", totalNewSalary);
        
        scanner.close();
    }
} 