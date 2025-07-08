// E-Commerce Platform
// Demonstrates: Abstract Classes, Interfaces, Encapsulation, Polymorphism

// Interface for Taxable products
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Abstract class Product with encapsulation
abstract class Product {
    // Private fields - Encapsulation
    private String productId;
    private String name;
    private double price;
    private int quantity;
    
    // Constructor
    public Product(String productId, String name, double price, int quantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    // Getter methods - Encapsulation
    public String getProductId() {
        return productId;
    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    // Setter methods with validation - Encapsulation
    public void setProductId(String productId) {
        if (productId != null && !productId.trim().isEmpty()) {
            this.productId = productId;
        } else {
            System.out.println("Product ID cannot be empty");
        }
    }
    
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Product name cannot be empty");
        }
    }
    
    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Price cannot be negative");
        }
    }
    
    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        } else {
            System.out.println("Quantity cannot be negative");
        }
    }
    
    // Abstract method - must be implemented by subclasses
    public abstract double calculateDiscount();
    
    // Concrete method - shared implementation
    public void getItemDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Discount: $" + calculateDiscount());
    }
    
    // Method to calculate final price
    public double calculateFinalPrice() {
        double discount = calculateDiscount();
        double tax = 0.0;
        
        // Check if product implements Taxable interface
        if (this instanceof Taxable) {
            tax = ((Taxable) this).calculateTax();
        }
        
        return (price - discount + tax) * quantity;
    }
}

// Electronics class extending Product
class Electronics extends Product implements Taxable {
    private String brand;
    private int warrantyMonths;
    private static final double TAX_RATE = 0.15; // 15% tax
    
    public Electronics(String productId, String name, double price, int quantity, String brand, int warrantyMonths) {
        super(productId, name, price, quantity);
        this.brand = brand;
        this.warrantyMonths = warrantyMonths;
    }
    
    // Getter and setter methods
    public String getBrand() {
        return brand;
    }
    
    public void setBrand(String brand) {
        if (brand != null && !brand.trim().isEmpty()) {
            this.brand = brand;
        } else {
            System.out.println("Brand cannot be empty");
        }
    }
    
    public int getWarrantyMonths() {
        return warrantyMonths;
    }
    
    public void setWarrantyMonths(int warrantyMonths) {
        if (warrantyMonths >= 0) {
            this.warrantyMonths = warrantyMonths;
        } else {
            System.out.println("Warranty months cannot be negative");
        }
    }
    
    // Implementation of abstract method
    @Override
    public double calculateDiscount() {
        // Electronics get 10% discount if price > $500
        if (getPrice() > 500) {
            return getPrice() * 0.10;
        }
        return 0.0;
    }
    
    // Implementation of Taxable interface methods
    @Override
    public double calculateTax() {
        return getPrice() * TAX_RATE;
    }
    
    @Override
    public String getTaxDetails() {
        return "Electronics tax rate: " + (TAX_RATE * 100) + "%";
    }
    
    @Override
    public void getItemDetails() {
        super.getItemDetails();
        System.out.println("Brand: " + brand);
        System.out.println("Warranty: " + warrantyMonths + " months");
        System.out.println("Tax: $" + calculateTax());
        System.out.println("------------------------");
    }
}

// Clothing class extending Product
class Clothing extends Product implements Taxable {
    private String size;
    private String material;
    private static final double TAX_RATE = 0.08; // 8% tax
    
    public Clothing(String productId, String name, double price, int quantity, String size, String material) {
        super(productId, name, price, quantity);
        this.size = size;
        this.material = material;
    }
    
    // Getter and setter methods
    public String getSize() {
        return size;
    }
    
    public void setSize(String size) {
        if (size != null && !size.trim().isEmpty()) {
            this.size = size;
        } else {
            System.out.println("Size cannot be empty");
        }
    }
    
    public String getMaterial() {
        return material;
    }
    
    public void setMaterial(String material) {
        if (material != null && !material.trim().isEmpty()) {
            this.material = material;
        } else {
            System.out.println("Material cannot be empty");
        }
    }
    
    // Implementation of abstract method
    @Override
    public double calculateDiscount() {
        // Clothing gets 20% discount on sale items
        return getPrice() * 0.20;
    }
    
    // Implementation of Taxable interface methods
    @Override
    public double calculateTax() {
        return getPrice() * TAX_RATE;
    }
    
    @Override
    public String getTaxDetails() {
        return "Clothing tax rate: " + (TAX_RATE * 100) + "%";
    }
    
    @Override
    public void getItemDetails() {
        super.getItemDetails();
        System.out.println("Size: " + size);
        System.out.println("Material: " + material);
        System.out.println("Tax: $" + calculateTax());
        System.out.println("------------------------");
    }
}

// Groceries class extending Product
class Groceries extends Product {
    private String expiryDate;
    private boolean isOrganic;
    
    public Groceries(String productId, String name, double price, int quantity, String expiryDate, boolean isOrganic) {
        super(productId, name, price, quantity);
        this.expiryDate = expiryDate;
        this.isOrganic = isOrganic;
    }
    
    // Getter and setter methods
    public String getExpiryDate() {
        return expiryDate;
    }
    
    public void setExpiryDate(String expiryDate) {
        if (expiryDate != null && !expiryDate.trim().isEmpty()) {
            this.expiryDate = expiryDate;
        } else {
            System.out.println("Expiry date cannot be empty");
        }
    }
    
    public boolean isOrganic() {
        return isOrganic;
    }
    
    public void setOrganic(boolean organic) {
        this.isOrganic = organic;
    }
    
    // Implementation of abstract method
    @Override
    public double calculateDiscount() {
        // Groceries get 5% discount if organic
        if (isOrganic) {
            return getPrice() * 0.05;
        }
        return 0.0;
    }
    
    @Override
    public void getItemDetails() {
        super.getItemDetails();
        System.out.println("Expiry Date: " + expiryDate);
        System.out.println("Organic: " + (isOrganic ? "Yes" : "No"));
        System.out.println("Tax: $0.00 (Groceries are tax-free)");
        System.out.println("------------------------");
    }
}

// Main class to demonstrate the system
public class ECommercePlatform {
    public static void main(String[] args) {
        System.out.println("=== E-Commerce Platform ===\n");
        
        // Creating products
        Electronics laptop = new Electronics("E001", "Gaming Laptop", 1200.0, 1, "Dell", 24);
        Clothing shirt = new Clothing("C001", "Cotton T-Shirt", 25.0, 2, "M", "Cotton");
        Groceries apple = new Groceries("G001", "Organic Apples", 5.0, 3, "2024-01-15", true);
        
        // Demonstrating polymorphism - using Product reference
        Product[] products = {laptop, shirt, apple};
        
        System.out.println("Product Details:");
        for (Product product : products) {
            product.getItemDetails(); // Polymorphic method call
        }
        
        // Demonstrating final price calculation with polymorphism
        System.out.println("Final Price Calculation:");
        for (Product product : products) {
            System.out.println(product.getName() + " - Final Price: $" + product.calculateFinalPrice());
        }
        
        // Demonstrating interface usage
        System.out.println("\nTax Details for Taxable Products:");
        for (Product product : products) {
            if (product instanceof Taxable) {
                Taxable taxableProduct = (Taxable) product;
                System.out.println(product.getName() + ": " + taxableProduct.getTaxDetails());
            }
        }
        
        // Demonstrating encapsulation
        System.out.println("\n=== Testing Encapsulation ===");
        laptop.setPrice(-100); // Should show validation message
        shirt.setName(""); // Should show validation message
        laptop.setPrice(1100.0);
        shirt.setName("Updated T-Shirt");
        
        System.out.println("Updated product details:");
        laptop.getItemDetails();
        shirt.getItemDetails();
    }
} 