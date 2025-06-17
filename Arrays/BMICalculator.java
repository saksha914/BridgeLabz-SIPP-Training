import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of persons: ");
        int numPersons = scanner.nextInt();
        
        double[][] personData = new double[numPersons][3]; // [weight, height, BMI]
        String[] weightStatus = new String[numPersons];
        
        // Input data and calculate BMI
        for (int i = 0; i < numPersons; i++) {
            System.out.println("\nPerson " + (i + 1) + ":");
            
            // Input weight
            do {
                System.out.print("Enter weight (kg): ");
                personData[i][0] = scanner.nextDouble();
            } while (personData[i][0] <= 0);
            
            // Input height
            do {
                System.out.print("Enter height (meters): ");
                personData[i][1] = scanner.nextDouble();
            } while (personData[i][1] <= 0);
            
            // Calculate BMI
            personData[i][2] = personData[i][0] / (personData[i][1] * personData[i][1]);
            
            // Determine weight status
            if (personData[i][2] < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] < 25) {
                weightStatus[i] = "Normal weight";
            } else if (personData[i][2] < 30) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }
        
        // Display results
        System.out.println("\nBMI Results:");
        for (int i = 0; i < numPersons; i++) {
            System.out.println("\nPerson " + (i + 1) + ":");
            System.out.printf("Height: %.2f meters\n", personData[i][1]);
            System.out.printf("Weight: %.2f kg\n", personData[i][0]);
            System.out.printf("BMI: %.2f\n", personData[i][2]);
            System.out.println("Status: " + weightStatus[i]);
        }
        
        scanner.close();
    }
} 