public class Vehicle {
    private static double registrationFee = 5000.0;
    private final String registrationNumber;
    private String ownerName;
    private String vehicleType;

    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println("Registration fee updated to: " + registrationFee);
    }

    public String getRegistrationNumber() { return registrationNumber; }
    public String getOwnerName() { return ownerName; }
    public String getVehicleType() { return vehicleType; }

    public void displayDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Fee: " + registrationFee);
        }
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Alice", "Car", "MH12AB1234");
        Vehicle v2 = new Vehicle("Bob", "Bike", "MH12XY5678");
        v1.displayDetails();
        System.out.println();
        v2.displayDetails();
        Vehicle.updateRegistrationFee(6000.0);
        v1.displayDetails();
    }
} 