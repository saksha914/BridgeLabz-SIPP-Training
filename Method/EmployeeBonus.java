import java.util.Random;

public class EmployeeBonus {
    public static void main(String[] args) {
        double[][] employees = generateEmployeeData(10);
        double[][] newSalaries = calculateNewSalariesAndBonus(employees);
        displaySalaries(employees, newSalaries);
    }
    public static double[][] generateEmployeeData(int n) {
        Random rand = new Random();
        double[][] data = new double[n][2];
        for (int i = 0; i < n; i++) {
            data[i][0] = 10000 + rand.nextInt(90000); // salary
            data[i][1] = 1 + rand.nextInt(10); // years of service
        }
        return data;
    }
    public static double[][] calculateNewSalariesAndBonus(double[][] employees) {
        double[][] result = new double[employees.length][2];
        for (int i = 0; i < employees.length; i++) {
            double bonusRate = employees[i][1] > 5 ? 0.05 : 0.02;
            double bonus = employees[i][0] * bonusRate;
            result[i][0] = employees[i][0] + bonus; // new salary
            result[i][1] = bonus;
        }
        return result;
    }
    public static void displaySalaries(double[][] oldData, double[][] newData) {
        double sumOld = 0, sumNew = 0, totalBonus = 0;
        System.out.println("Salary\tYears\tNew Salary\tBonus");
        for (int i = 0; i < oldData.length; i++) {
            System.out.printf("%.0f\t%.0f\t%.0f\t\t%.0f\n", oldData[i][0], oldData[i][1], newData[i][0], newData[i][1]);
            sumOld += oldData[i][0];
            sumNew += newData[i][0];
            totalBonus += newData[i][1];
        }
        System.out.printf("Total Old Salary: %.0f\nTotal New Salary: %.0f\nTotal Bonus: %.0f\n", sumOld, sumNew, totalBonus);
    }
} 