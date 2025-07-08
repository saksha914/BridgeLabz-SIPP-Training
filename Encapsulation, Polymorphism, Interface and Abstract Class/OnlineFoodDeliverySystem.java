// Online Food Delivery System
// Demonstrates: Abstract Classes, Interfaces, Encapsulation, Polymorphism

// Interface for Discountable items
interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

// Abstract class FoodItem with encapsulation
abstract class FoodItem {
    // Private fields - Encapsulation
    private String itemName;
    private double price;
    private int quantity;
    private String category;
    private boolean isAvailable;
    
    // Constructor
    public FoodItem(String itemName, double price, int quantity, String category) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.isAvailable = true;
    }
    
    // Getter methods - Encapsulation
    public String getItemName() {
        return itemName;
    }
    
    public double getPrice() {
        return price;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public String getCategory() {
        return category;
    }
    
    public boolean isAvailable() {
        return isAvailable;
    }
    
    // Setter methods with validation - Encapsulation
    public void setItemName(String itemName) {
        if (itemName != null && !itemName.trim().isEmpty()) {
            this.itemName = itemName;
        } else {
            System.out.println("Item name cannot be empty");
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
    
    public void setCategory(String category) {
        if (category != null && !category.trim().isEmpty()) {
            this.category = category;
        } else {
            System.out.println("Category cannot be empty");
        }
    }
    
    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }
    
    // Abstract method - must be implemented by subclasses
    public abstract double calculateTotalPrice();
    
    // Concrete method - shared implementation
    public void getItemDetails() {
        System.out.println("Item Name: " + itemName);
        System.out.println("Category: " + category);
        System.out.println("Price: $" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
        System.out.println("Total Price: $" + calculateTotalPrice());
    }
}

// VegItem class extending FoodItem
class VegItem extends FoodItem implements Discountable {
    private boolean isOrganic;
    private String spiceLevel;
    private static final double ORGANIC_CHARGE = 2.0;
    private static final double DISCOUNT_RATE = 0.10; // 10% discount
    
    public VegItem(String itemName, double price, int quantity, boolean isOrganic, String spiceLevel) {
        super(itemName, price, quantity, "Vegetarian");
        this.isOrganic = isOrganic;
        this.spiceLevel = spiceLevel;
    }
    
    // Getter and setter methods
    public boolean isOrganic() {
        return isOrganic;
    }
    
    public void setOrganic(boolean organic) {
        this.isOrganic = organic;
    }
    
    public String getSpiceLevel() {
        return spiceLevel;
    }
    
    public void setSpiceLevel(String spiceLevel) {
        if (spiceLevel != null && !spiceLevel.trim().isEmpty()) {
            this.spiceLevel = spiceLevel;
        } else {
            System.out.println("Spice level cannot be empty");
        }
    }
    
    // Implementation of abstract method
    @Override
    public double calculateTotalPrice() {
        double basePrice = getPrice() * getQuantity();
        if (isOrganic) {
            basePrice += ORGANIC_CHARGE * getQuantity();
        }
        return basePrice;
    }
    
    // Implementation of Discountable interface methods
    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * DISCOUNT_RATE;
    }
    
    @Override
    public String getDiscountDetails() {
        return "Vegetarian items get " + (DISCOUNT_RATE * 100) + "% discount";
    }
    
    @Override
    public void getItemDetails() {
        super.getItemDetails();
        System.out.println("Organic: " + (isOrganic ? "Yes" : "No"));
        System.out.println("Spice Level: " + spiceLevel);
        System.out.println("Discount: $" + applyDiscount());
        System.out.println("Final Price: $" + (calculateTotalPrice() - applyDiscount()));
        System.out.println("------------------------");
    }
}

// NonVegItem class extending FoodItem
class NonVegItem extends FoodItem implements Discountable {
    private String meatType;
    private boolean isHalal;
    private static final double MEAT_CHARGE = 3.0;
    private static final double DISCOUNT_RATE = 0.05; // 5% discount
    
    public NonVegItem(String itemName, double price, int quantity, String meatType, boolean isHalal) {
        super(itemName, price, quantity, "Non-Vegetarian");
        this.meatType = meatType;
        this.isHalal = isHalal;
    }
    
    // Getter and setter methods
    public String getMeatType() {
        return meatType;
    }
    
    public void setMeatType(String meatType) {
        if (meatType != null && !meatType.trim().isEmpty()) {
            this.meatType = meatType;
        } else {
            System.out.println("Meat type cannot be empty");
        }
    }
    
    public boolean isHalal() {
        return isHalal;
    }
    
    public void setHalal(boolean halal) {
        this.isHalal = halal;
    }
    
    // Implementation of abstract method
    @Override
    public double calculateTotalPrice() {
        double basePrice = getPrice() * getQuantity();
        basePrice += MEAT_CHARGE * getQuantity(); // Additional charge for non-veg
        return basePrice;
    }
    
    // Implementation of Discountable interface methods
    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * DISCOUNT_RATE;
    }
    
    @Override
    public String getDiscountDetails() {
        return "Non-vegetarian items get " + (DISCOUNT_RATE * 100) + "% discount";
    }
    
    @Override
    public void getItemDetails() {
        super.getItemDetails();
        System.out.println("Meat Type: " + meatType);
        System.out.println("Halal: " + (isHalal ? "Yes" : "No"));
        System.out.println("Discount: $" + applyDiscount());
        System.out.println("Final Price: $" + (calculateTotalPrice() - applyDiscount()));
        System.out.println("------------------------");
    }
}

// Main class to demonstrate the system
public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        System.out.println("=== Online Food Delivery System ===\n");
        
        // Creating food items
        VegItem vegItem = new VegItem("Paneer Tikka", 15.0, 2, true, "Medium");
        NonVegItem nonVegItem = new NonVegItem("Chicken Biryani", 20.0, 1, "Chicken", true);
        
        // Demonstrating polymorphism - using FoodItem reference
        FoodItem[] foodItems = {vegItem, nonVegItem};
        
        System.out.println("Food Items Details:");
        for (FoodItem item : foodItems) {
            item.getItemDetails(); // Polymorphic method call
        }
        
        // Demonstrating interface usage
        System.out.println("Discount Information:");
        Discountable[] discountableItems = {vegItem, nonVegItem};
        for (Discountable item : discountableItems) {
            System.out.println(((FoodItem) item).getItemName() + ": " + item.getDiscountDetails());
        }
        
        // Demonstrating order processing with polymorphism
        System.out.println("\nOrder Processing:");
        processOrder(foodItems);
        
        // Demonstrating encapsulation
        System.out.println("\n=== Testing Encapsulation ===");
        vegItem.setItemName(""); // Should show validation message
        nonVegItem.setPrice(-10); // Should show validation message
        vegItem.setQuantity(-1); // Should show validation message
        
        vegItem.setItemName("Updated Paneer Tikka");
        nonVegItem.setPrice(25.0);
        vegItem.setQuantity(3);
        
        System.out.println("Updated food items:");
        vegItem.getItemDetails();
        nonVegItem.getItemDetails();
    }
    
    // Method demonstrating polymorphism
    public static void processOrder(FoodItem[] items) {
        double totalOrderValue = 0.0;
        double totalDiscount = 0.0;
        
        System.out.println("Processing order for " + items.length + " items:");
        
        for (FoodItem item : items) {
            if (item.isAvailable()) {
                double itemTotal = item.calculateTotalPrice();
                double itemDiscount = 0.0;
                
                if (item instanceof Discountable) {
                    itemDiscount = ((Discountable) item).applyDiscount();
                }
                
                double finalPrice = itemTotal - itemDiscount;
                
                System.out.println(item.getItemName() + ": $" + itemTotal + 
                                 " - $" + itemDiscount + " = $" + finalPrice);
                
                totalOrderValue += itemTotal;
                totalDiscount += itemDiscount;
            } else {
                System.out.println(item.getItemName() + ": Not available");
            }
        }
        
        System.out.println("Total Order Value: $" + totalOrderValue);
        System.out.println("Total Discount: $" + totalDiscount);
        System.out.println("Final Amount: $" + (totalOrderValue - totalDiscount));
    }
} 