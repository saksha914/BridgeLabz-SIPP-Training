// Ride-Hailing Application
// Demonstrates: Abstract Classes, Interfaces, Encapsulation, Polymorphism

// Interface for GPS functionality
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Abstract class Vehicle with encapsulation
abstract class Vehicle {
    // Private fields - Encapsulation
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation;
    private boolean isAvailable;
    private String licensePlate;
    
    // Constructor
    public Vehicle(String vehicleId, String driverName, double ratePerKm, String licensePlate) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.licensePlate = licensePlate;
        this.isAvailable = true;
        this.currentLocation = "Unknown";
    }
    
    // Getter methods - Encapsulation
    public String getVehicleId() {
        return vehicleId;
    }
    
    public String getDriverName() {
        return driverName;
    }
    
    public double getRatePerKm() {
        return ratePerKm;
    }
    
    public String getCurrentLocation() {
        return currentLocation;
    }
    
    public boolean isAvailable() {
        return isAvailable;
    }
    
    public String getLicensePlate() {
        return licensePlate;
    }
    
    // Setter methods with validation - Encapsulation
    public void setVehicleId(String vehicleId) {
        if (vehicleId != null && !vehicleId.trim().isEmpty()) {
            this.vehicleId = vehicleId;
        } else {
            System.out.println("Vehicle ID cannot be empty");
        }
    }
    
    public void setDriverName(String driverName) {
        if (driverName != null && !driverName.trim().isEmpty()) {
            this.driverName = driverName;
        } else {
            System.out.println("Driver name cannot be empty");
        }
    }
    
    public void setRatePerKm(double ratePerKm) {
        if (ratePerKm >= 0) {
            this.ratePerKm = ratePerKm;
        } else {
            System.out.println("Rate per km cannot be negative");
        }
    }
    
    protected void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }
    
    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }
    
    public void setLicensePlate(String licensePlate) {
        if (licensePlate != null && !licensePlate.trim().isEmpty()) {
            this.licensePlate = licensePlate;
        } else {
            System.out.println("License plate cannot be empty");
        }
    }
    
    // Abstract method - must be implemented by subclasses
    public abstract double calculateFare(double distance);
    
    // Concrete method - shared implementation
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("License Plate: " + licensePlate);
        System.out.println("Rate per km: $" + ratePerKm);
        System.out.println("Current Location: " + currentLocation);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
    }
}

// Car class extending Vehicle
class Car extends Vehicle implements GPS {
    private int seats;
    private String carType;
    private static final double BASE_FARE = 5.0;
    
    public Car(String vehicleId, String driverName, double ratePerKm, String licensePlate, int seats, String carType) {
        super(vehicleId, driverName, ratePerKm, licensePlate);
        this.seats = seats;
        this.carType = carType;
    }
    
    // Getter and setter methods
    public int getSeats() {
        return seats;
    }
    
    public void setSeats(int seats) {
        if (seats >= 2 && seats <= 8) {
            this.seats = seats;
        } else {
            System.out.println("Invalid number of seats");
        }
    }
    
    public String getCarType() {
        return carType;
    }
    
    public void setCarType(String carType) {
        if (carType != null && !carType.trim().isEmpty()) {
            this.carType = carType;
        } else {
            System.out.println("Car type cannot be empty");
        }
    }
    
    // Implementation of abstract method
    @Override
    public double calculateFare(double distance) {
        if (distance <= 0) {
            return 0.0;
        }
        // Cars get 10% discount for distances > 10 km
        double baseFare = BASE_FARE + (getRatePerKm() * distance);
        if (distance > 10) {
            baseFare = baseFare * 0.90;
        }
        return baseFare;
    }
    
    // Implementation of GPS interface methods
    @Override
    public String getCurrentLocation() {
        return super.getCurrentLocation();
    }
    
    @Override
    public void updateLocation(String newLocation) {
        if (newLocation != null && !newLocation.trim().isEmpty()) {
            setCurrentLocation(newLocation);
            System.out.println("Car location updated to: " + newLocation);
        } else {
            System.out.println("Invalid location");
        }
    }
    
    @Override
    public void getVehicleDetails() {
        super.getVehicleDetails();
        System.out.println("Seats: " + seats);
        System.out.println("Car Type: " + carType);
        System.out.println("------------------------");
    }
}

// Bike class extending Vehicle
class Bike extends Vehicle implements GPS {
    private int engineCapacity;
    private String transmission;
    private static final double BASE_FARE = 2.0;
    
    public Bike(String vehicleId, String driverName, double ratePerKm, String licensePlate, int engineCapacity, String transmission) {
        super(vehicleId, driverName, ratePerKm, licensePlate);
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
    public double calculateFare(double distance) {
        if (distance <= 0) {
            return 0.0;
        }
        // Bikes get 15% discount for distances > 5 km
        double baseFare = BASE_FARE + (getRatePerKm() * distance);
        if (distance > 5) {
            baseFare = baseFare * 0.85;
        }
        return baseFare;
    }
    
    // Implementation of GPS interface methods
    @Override
    public String getCurrentLocation() {
        return super.getCurrentLocation();
    }
    
    @Override
    public void updateLocation(String newLocation) {
        if (newLocation != null && !newLocation.trim().isEmpty()) {
            setCurrentLocation(newLocation);
            System.out.println("Bike location updated to: " + newLocation);
        } else {
            System.out.println("Invalid location");
        }
    }
    
    @Override
    public void getVehicleDetails() {
        super.getVehicleDetails();
        System.out.println("Engine Capacity: " + engineCapacity + "cc");
        System.out.println("Transmission: " + transmission);
        System.out.println("------------------------");
    }
}

// Auto class extending Vehicle
class Auto extends Vehicle implements GPS {
    private int maxPassengers;
    private boolean hasMeter;
    private static final double BASE_FARE = 3.0;
    
    public Auto(String vehicleId, String driverName, double ratePerKm, String licensePlate, int maxPassengers, boolean hasMeter) {
        super(vehicleId, driverName, ratePerKm, licensePlate);
        this.maxPassengers = maxPassengers;
        this.hasMeter = hasMeter;
    }
    
    // Getter and setter methods
    public int getMaxPassengers() {
        return maxPassengers;
    }
    
    public void setMaxPassengers(int maxPassengers) {
        if (maxPassengers >= 1 && maxPassengers <= 4) {
            this.maxPassengers = maxPassengers;
        } else {
            System.out.println("Invalid number of passengers");
        }
    }
    
    public boolean isHasMeter() {
        return hasMeter;
    }
    
    public void setHasMeter(boolean hasMeter) {
        this.hasMeter = hasMeter;
    }
    
    // Implementation of abstract method
    @Override
    public double calculateFare(double distance) {
        if (distance <= 0) {
            return 0.0;
        }
        // Autos get 20% discount for distances > 8 km
        double baseFare = BASE_FARE + (getRatePerKm() * distance);
        if (distance > 8) {
            baseFare = baseFare * 0.80;
        }
        return baseFare;
    }
    
    // Implementation of GPS interface methods
    @Override
    public String getCurrentLocation() {
        return super.getCurrentLocation();
    }
    
    @Override
    public void updateLocation(String newLocation) {
        if (newLocation != null && !newLocation.trim().isEmpty()) {
            setCurrentLocation(newLocation);
            System.out.println("Auto location updated to: " + newLocation);
        } else {
            System.out.println("Invalid location");
        }
    }
    
    @Override
    public void getVehicleDetails() {
        super.getVehicleDetails();
        System.out.println("Max Passengers: " + maxPassengers);
        System.out.println("Has Meter: " + (hasMeter ? "Yes" : "No"));
        System.out.println("------------------------");
    }
}

// Main class to demonstrate the system
public class RideHailingApplication {
    public static void main(String[] args) {
        System.out.println("=== Ride-Hailing Application ===\n");
        
        // Creating vehicles
        Car car = new Car("CAR001", "John Driver", 2.5, "ABC123", 4, "Sedan");
        Bike bike = new Bike("BIKE001", "Mike Rider", 1.5, "XYZ789", 150, "Manual");
        Auto auto = new Auto("AUTO001", "Raj Driver", 2.0, "DEF456", 3, true);
        
        // Updating locations
        car.updateLocation("Central Park");
        bike.updateLocation("Times Square");
        auto.updateLocation("Brooklyn Bridge");
        
        // Demonstrating polymorphism - using Vehicle reference
        Vehicle[] vehicles = {car, bike, auto};
        
        System.out.println("Vehicle Details:");
        for (Vehicle vehicle : vehicles) {
            vehicle.getVehicleDetails(); // Polymorphic method call
        }
        
        // Demonstrating fare calculation with polymorphism
        System.out.println("Fare Calculation for 15 km ride:");
        for (Vehicle vehicle : vehicles) {
            double fare = vehicle.calculateFare(15.0);
            System.out.println(vehicle.getDriverName() + " (" + vehicle.getClass().getSimpleName() + 
                             "): $" + fare);
        }
        
        // Demonstrating interface usage
        System.out.println("\nGPS Tracking:");
        GPS[] gpsVehicles = {car, bike, auto};
        for (GPS gps : gpsVehicles) {
            System.out.println("Current location: " + gps.getCurrentLocation());
        }
        
        // Demonstrating fare calculation for different distances
        System.out.println("\nFare Comparison for Different Distances:");
        double[] distances = {5.0, 10.0, 15.0};
        for (double distance : distances) {
            System.out.println("\nDistance: " + distance + " km");
            for (Vehicle vehicle : vehicles) {
                double fare = vehicle.calculateFare(distance);
                System.out.println(vehicle.getDriverName() + ": $" + fare);
            }
        }
        
        // Demonstrating encapsulation
        System.out.println("\n=== Testing Encapsulation ===");
        car.setDriverName(""); // Should show validation message
        bike.setRatePerKm(-5); // Should show validation message
        auto.setMaxPassengers(10); // Should show validation message
        
        car.setDriverName("John Updated");
        bike.setRatePerKm(3.0);
        auto.setMaxPassengers(4);
        
        System.out.println("Updated vehicle details:");
        car.getVehicleDetails();
        bike.getVehicleDetails();
        auto.getVehicleDetails();
    }
} 