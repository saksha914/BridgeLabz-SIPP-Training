public class Circle {
    private double radius;

    // Default constructor
    public Circle() {
        this(1.0); // Default radius
    }

    // Parameterized constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() { return radius; }
    public void setRadius(double radius) { this.radius = radius; }

    public double area() {
        return Math.PI * radius * radius;
    }

    public void displayDetails() {
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + area());
    }

    public static void main(String[] args) {
        Circle defaultCircle = new Circle();
        Circle customCircle = new Circle(5.0);
        System.out.println("Default Circle:");
        defaultCircle.displayDetails();
        System.out.println("\nCustom Circle:");
        customCircle.displayDetails();
    }
} 