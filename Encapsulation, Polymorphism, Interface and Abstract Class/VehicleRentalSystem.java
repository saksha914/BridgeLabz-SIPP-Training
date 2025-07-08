// Vehicle Rental System
// Demonstrates: Abstract Classes, Interfaces, Encapsulation, Polymorphism

// Interface for Insurable vehicles
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Abstract class Vehicle with encapsulation
abstract class Vehicle {
    // Private fields - Encapsulation
    private String vehicleNumber;
    private String type;
    private double rentalRate;
    private String insurancePolicyNumber;
    private boolean isAvailable;
    
    // Constructor
    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
        this.isAvailable = true;
    }
    
    // Getter methods - Encapsulation
    public String getVehicleNumber() {
        return vehicleNumber;
    }
    
    public String getType() {
        return type;
    }
    
    public double getRentalRate() {
        return rentalRate;
    }
    
    public String getInsurancePolicyNumber() {
        return insurancePolicyNumber;
    }
    
    public boolean isAvailable() {
        return isAvailable;
    }
    
    // Setter methods with validation - Encapsulation
    public void setVehicleNumber(String vehicleNumber) {
        if (vehicleNumber != null && !vehicleNumber.trim().isEmpty()) {
            this.vehicleNumber = vehicleNumber;
        } else {
            System.out.println("Vehicle number cannot be empty");
        }
    }
    
    public void setType(String type) {
        if (type != null && !type.trim().isEmpty()) {
            this.type = type;
        } else {
            System.out.println("Vehicle type cannot be empty");
        }
    }
    
    public void setRentalRate(double rentalRate) {
        if (rentalRate >= 0) {
            this.rentalRate = rentalRate;
        } else {
            System.out.println("Rental rate cannot be negative");
        }
    }
    
    public void setInsurancePolicyNumber(String insurancePolicyNumber) {
        if (insurancePolicyNumber != null && !insurancePolicyNumber.trim().isEmpty()) {
            this.insurancePolicyNumber = insurancePolicyNumber;
        } else {
            System.out.println("Insurance policy number cannot be empty");
        }
    }
    
    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }
    
    // Abstract method - must be implemented by subclasses
    public abstract double calculateRentalCost(int days);
    
    // Concrete method - shared implementation
    public void getVehicleDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Rate: $" + rentalRate + " per day");
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
    }
}

// Car class extending Vehicle
class Car extends Vehicle implements Insurable {
    private int seats;
    private String fuelType;
    private static final double INSURANCE_RATE = 0.05; // 5% of rental cost
    
    public Car(String vehicleNumber, String type, double rentalRate, int seats, String fuelType) {
        super(vehicleNumber, type, rentalRate);
        this.seats = seats;
        this.fuelType = fuelType;
    }
    
    // Getter and setter methods
    public int getSeats() {
        return seats;
    }
    
    public void setSeats(int seats) {
        if (seats > 0 && seats <= 10) {
            this.seats = seats;
        } else {
            System.out.println("Invalid number of seats");
        }
    }
    
    public String getFuelType() {
        return fuelType;
    }
    
    public void setFuelType(String fuelType) {
        if (fuelType != null && !fuelType.trim().isEmpty()) {
            this.fuelType = fuelType;
        } else {
            System.out.println("Fuel type cannot be empty");
        }
    }
    
    // Implementation of abstract method
    @Override
    public double calculateRentalCost(int days) {
        if (days <= 0) {
            return 0.0;
        }
        // Cars get 10% discount for rentals longer than 7 days
        double baseCost = getRentalRate() * days;
        if (days > 7) {
            baseCost = baseCost * 0.90;
        }
        return baseCost;
    }
    
    // Implementation of Insurable interface methods
    @Override
    public double calculateInsurance() {
        return getRentalRate() * INSURANCE_RATE;
    }
    
    @Override
    public String getInsuranceDetails() {
        return "Car insurance rate: " + (INSURANCE_RATE * 100) + "% of daily rental";
    }
    
    @Override
    public void getVehicleDetails() {
        super.getVehicleDetails();
        System.out.println("Seats: " + seats);
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Daily Insurance: $" + calculateInsurance());
        System.out.println("------------------------");
    }
}

// Bike class extending Vehicle
class Bike extends Vehicle implements Insurable {
    private int engineCapacity;
    private String transmission;
    private static final double INSURANCE_RATE = 0.03; // 3% of rental cost
    
    public Bike(String vehicleNumber, String type, double rentalRate, int engineCapacity, String transmission) {
        super(vehicleNumber, type, rentalRate);
        this.engineCapacity = engineCapacity;
        this.transmission = transmission;
    }
    
    // Getter and setter methods
    public int getEngineCapacity() {
        return engineCapacity;
    }
    
    public void setEngineCapacity(int engineCapacity) {
        if (engineCapacity > 0 && engineCapacity <= 2000) {
            this.engineCapacity = engineCapacity;
        } else {
            System.out.println("Invalid engine capacity");
        }
    }
    
    public String getTransmission() {
        return transmission;
    }
    
    public void setTransmission(String transmission) {
        if (transmission != null && !transmission.trim().isEmpty()) {
            this.transmission = transmission;
        } else {
            System.out.println("Transmission cannot be empty");
        }
    }
    
    // Implementation of abstract method
    @Override
    public double calculateRentalCost(int days) {
        if (days <= 0) {
            return 0.0;
        }
        // Bikes get 15% discount for rentals longer than 5 days
        double baseCost = getRentalRate() * days;
        if (days > 5) {
            baseCost = baseCost * 0.85;
        }
        return baseCost;
    }
    
    // Implementation of Insurable interface methods
    @Override
    public double calculateInsurance() {
        return getRentalRate() * INSURANCE_RATE;
    }
    
    @Override
    public String getInsuranceDetails() {
        return "Bike insurance rate: " + (INSURANCE_RATE * 100) + "% of daily rental";
    }
    
    @Override
    public void getVehicleDetails() {
        super.getVehicleDetails();
        System.out.println("Engine Capacity: " + engineCapacity + "cc");
        System.out.println("Transmission: " + transmission);
        System.out.println("Daily Insurance: $" + calculateInsurance());
        System.out.println("------------------------");
    }
}

// Truck class extending Vehicle
class Truck extends Vehicle implements Insurable {
    private double loadCapacity;
    private String licenseType;
    private static final double INSURANCE_RATE = 0.08; // 8% of rental cost
    
    public Truck(String vehicleNumber, String type, double rentalRate, double loadCapacity, String licenseType) {
        super(vehicleNumber, type, rentalRate);
        this.loadCapacity = loadCapacity;
        this.licenseType = licenseType;
    }
    
    // Getter and setter methods
    public double getLoadCapacity() {
        return loadCapacity;
    }
    
    public void setLoadCapacity(double loadCapacity) {
        if (loadCapacity > 0 && loadCapacity <= 50) { // Max 50 tons
            this.loadCapacity = loadCapacity;
        } else {
            System.out.println("Invalid load capacity");
        }
    }
    
    public String getLicenseType() {
        return licenseType;
    }
    
    public void setLicenseType(String licenseType) {
        if (licenseType != null && !licenseType.trim().isEmpty()) {
            this.licenseType = licenseType;
        } else {
            System.out.println("License type cannot be empty");
        }
    }
    
    // Implementation of abstract method
    @Override
    public double calculateRentalCost(int days) {
        if (days <= 0) {
            return 0.0;
        }
        // Trucks get 20% discount for rentals longer than 10 days
        double baseCost = getRentalRate() * days;
        if (days > 10) {
            baseCost = baseCost * 0.80;
        }
        return baseCost;
    }
    
    // Implementation of Insurable interface methods
    @Override
    public double calculateInsurance() {
        return getRentalRate() * INSURANCE_RATE;
    }
    
    @Override
    public String getInsuranceDetails() {
        return "Truck insurance rate: " + (INSURANCE_RATE * 100) + "% of daily rental";
    }
    
    @Override
    public void getVehicleDetails() {
        super.getVehicleDetails();
        System.out.println("Load Capacity: " + loadCapacity + " tons");
        System.out.println("License Type: " + licenseType);
        System.out.println("Daily Insurance: $" + calculateInsurance());
        System.out.println("------------------------");
    }
}

// Main class to demonstrate the system
public class VehicleRentalSystem {
    public static void main(String[] args) {
        System.out.println("=== Vehicle Rental System ===\n");
        
        // Creating vehicles
        Car car = new Car("CAR001", "Sedan", 50.0, 5, "Petrol");
        Bike bike = new Bike("BIKE001", "Sports", 25.0, 150, "Manual");
        Truck truck = new Truck("TRUCK001", "Heavy", 200.0, 10.0, "Commercial");
        
        // Setting insurance policy numbers
        car.setInsurancePolicyNumber("INS001");
        bike.setInsurancePolicyNumber("INS002");
        truck.setInsurancePolicyNumber("INS003");
        
        // Demonstrating polymorphism - using Vehicle reference
        Vehicle[] vehicles = {car, bike, truck};
        
        System.out.println("Vehicle Details:");
        for (Vehicle vehicle : vehicles) {
            vehicle.getVehicleDetails(); // Polymorphic method call
        }
        
        // Demonstrating rental cost calculation with polymorphism
        System.out.println("Rental Cost Calculation (5 days):");
        for (Vehicle vehicle : vehicles) {
            double rentalCost = vehicle.calculateRentalCost(5);
            double insuranceCost = 0.0;
            
            if (vehicle instanceof Insurable) {
                insuranceCost = ((Insurable) vehicle).calculateInsurance() * 5;
            }
            
            System.out.println(vehicle.getType() + " - Rental: $" + rentalCost + 
                             ", Insurance: $" + insuranceCost + 
                             ", Total: $" + (rentalCost + insuranceCost));
        }
        
        // Demonstrating interface usage
        System.out.println("\nInsurance Details:");
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Insurable) {
                Insurable insurableVehicle = (Insurable) vehicle;
                System.out.println(vehicle.getType() + ": " + insurableVehicle.getInsuranceDetails());
            }
        }
        
        // Demonstrating encapsulation
        System.out.println("\n=== Testing Encapsulation ===");
        car.setRentalRate(-50); // Should show validation message
        bike.setEngineCapacity(3000); // Should show validation message
        car.setRentalRate(60.0);
        bike.setEngineCapacity(200);
        
        System.out.println("Updated vehicle details:");
        car.getVehicleDetails();
        bike.getVehicleDetails();
    }
} 