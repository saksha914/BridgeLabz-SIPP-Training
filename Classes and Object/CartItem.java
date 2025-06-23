public class CartItem {
    private String itemName;
    private double price;
    private int quantity;

    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public void addItem(int qty) {
        this.quantity += qty;
        System.out.println(qty + " item(s) added to cart.");
    }

    public void removeItem(int qty) {
        if (qty <= quantity) {
            this.quantity -= qty;
            System.out.println(qty + " item(s) removed from cart.");
        } else {
            System.out.println("Cannot remove more than present in cart.");
        }
    }

    public double totalCost() {
        return price * quantity;
    }

    public void displayTotalCost() {
        System.out.println("Item: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Cost: " + totalCost());
    }

    public static void main(String[] args) {
        CartItem cart = new CartItem("Book", 200, 2);
        cart.displayTotalCost();
        cart.addItem(3);
        cart.displayTotalCost();
        cart.removeItem(4);
        cart.displayTotalCost();
    }
} 