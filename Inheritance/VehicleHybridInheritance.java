interface Refuelable {
    void refuel();
}

class Vehicle {
    protected int maxSpeed;
    protected String model;
    public Vehicle(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }
}

class ElectricVehicle extends Vehicle {
    public ElectricVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }
    public void charge() {
        System.out.println(model + " (Electric) is charging.");
    }
}

class PetrolVehicle extends Vehicle implements Refuelable {
    public PetrolVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }
    @Override
    public void refuel() {
        System.out.println(model + " (Petrol) is refueling.");
    }
}

public class VehicleHybridInheritance {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new ElectricVehicle(160, "Tesla Model 3"),
            new PetrolVehicle(180, "Honda City")
        };
        for (Vehicle v : vehicles) {
            if (v instanceof ElectricVehicle) ((ElectricVehicle)v).charge();
            if (v instanceof Refuelable) ((Refuelable)v).refuel();
        }
    }
} 