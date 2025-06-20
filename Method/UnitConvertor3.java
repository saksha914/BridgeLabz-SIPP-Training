import java.util.Scanner;

public class UnitConvertor3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Fahrenheit: ");
        double f = scanner.nextDouble();
        System.out.println("Fahrenheit to Celsius: " + convertFahrenheitToCelsius(f));
        System.out.print("Enter Celsius: ");
        double c = scanner.nextDouble();
        System.out.println("Celsius to Fahrenheit: " + convertCelsiusToFahrenheit(c));
        System.out.print("Enter pounds: ");
        double pounds = scanner.nextDouble();
        System.out.println("Pounds to kilograms: " + convertPoundsToKilograms(pounds));
        System.out.print("Enter kilograms: ");
        double kg = scanner.nextDouble();
        System.out.println("Kilograms to pounds: " + convertKilogramsToPounds(kg));
        System.out.print("Enter gallons: ");
        double gallons = scanner.nextDouble();
        System.out.println("Gallons to liters: " + convertGallonsToLiters(gallons));
        System.out.print("Enter liters: ");
        double liters = scanner.nextDouble();
        System.out.println("Liters to gallons: " + convertLitersToGallons(liters));
        scanner.close();
    }
    public static double convertFahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }
    public static double convertCelsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }
    public static double convertPoundsToKilograms(double pounds) {
        return pounds * 0.453592;
    }
    public static double convertKilogramsToPounds(double kg) {
        return kg * 2.20462;
    }
    public static double convertGallonsToLiters(double gallons) {
        return gallons * 3.78541;
    }
    public static double convertLitersToGallons(double liters) {
        return liters * 0.264172;
    }
} 