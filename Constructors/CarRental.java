public class CarRental {
    private String customerName;
    private String carModel;
    private int rentalDays;
    private double totalCost;

    // Default constructor
    public CarRental() {
        this("Unknown", "Standard", 1);
    }

    // Parameterized constructor
    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.totalCost = calculateTotalCost();
    }

    private double calculateTotalCost() {
        double rate = 1000.0; // base rate per day
        if (carModel.equalsIgnoreCase("Luxury")) rate = 2000.0;
        return rate * rentalDays;
    }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public String getCarModel() { return carModel; }
    public void setCarModel(String carModel) { this.carModel = carModel; }
    public int getRentalDays() { return rentalDays; }
    public void setRentalDays(int rentalDays) { this.rentalDays = rentalDays; }
    public double getTotalCost() { return totalCost; }

    public void displayDetails() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Total Cost: " + totalCost);
    }

    public static void main(String[] args) {
        CarRental defaultRental = new CarRental();
        CarRental customRental = new CarRental("Alice", "Luxury", 5);
        System.out.println("Default Rental:");
        defaultRental.displayDetails();
        System.out.println("\nCustom Rental:");
        customRental.displayDetails();
    }
} 