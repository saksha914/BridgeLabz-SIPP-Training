// Inventory Management System using Singly Linked List
// Demonstrates: Singly Linked List operations with sorting and total value calculation

// Node class for Inventory Item
class ItemNode {
    String itemName;
    int itemId;
    int quantity;
    double price;
    ItemNode next;
    
    public ItemNode(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

// Singly Linked List class for Inventory Management
class InventoryLinkedList {
    private ItemNode head;
    private int size;
    
    public InventoryLinkedList() {
        this.head = null;
        this.size = 0;
    }
    
    // Add item at the beginning
    public void addAtBeginning(String itemName, int itemId, int quantity, double price) {
        ItemNode newNode = new ItemNode(itemName, itemId, quantity, price);
        newNode.next = head;
        head = newNode;
        size++;
        System.out.println("Item added at the beginning successfully!");
    }
    
    // Add item at the end
    public void addAtEnd(String itemName, int itemId, int quantity, double price) {
        ItemNode newNode = new ItemNode(itemName, itemId, quantity, price);
        
        if (head == null) {
            head = newNode;
        } else {
            ItemNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        System.out.println("Item added at the end successfully!");
    }
    
    // Add item at specific position
    public void addAtPosition(int position, String itemName, int itemId, int quantity, double price) {
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position!");
            return;
        }
        
        if (position == 1) {
            addAtBeginning(itemName, itemId, quantity, price);
            return;
        }
        
        ItemNode newNode = new ItemNode(itemName, itemId, quantity, price);
        ItemNode current = head;
        
        for (int i = 1; i < position - 1; i++) {
            current = current.next;
        }
        
        newNode.next = current.next;
        current.next = newNode;
        size++;
        System.out.println("Item added at position " + position + " successfully!");
    }
    
    // Remove item by Item ID
    public boolean removeByItemId(int itemId) {
        if (head == null) {
            System.out.println("Inventory is empty!");
            return false;
        }
        
        if (head.itemId == itemId) {
            head = head.next;
            size--;
            System.out.println("Item with ID " + itemId + " removed successfully!");
            return true;
        }
        
        ItemNode current = head;
        while (current.next != null && current.next.itemId != itemId) {
            current = current.next;
        }
        
        if (current.next != null) {
            current.next = current.next.next;
            size--;
            System.out.println("Item with ID " + itemId + " removed successfully!");
            return true;
        } else {
            System.out.println("Item with ID " + itemId + " not found!");
            return false;
        }
    }
    
    // Update quantity by Item ID
    public boolean updateQuantity(int itemId, int newQuantity) {
        if (newQuantity < 0) {
            System.out.println("Quantity cannot be negative!");
            return false;
        }
        
        ItemNode current = head;
        while (current != null) {
            if (current.itemId == itemId) {
                current.quantity = newQuantity;
                System.out.println("Quantity updated successfully for Item ID " + itemId + "!");
                return true;
            }
            current = current.next;
        }
        
        System.out.println("Item with ID " + itemId + " not found!");
        return false;
    }
    
    // Search item by Item ID
    public ItemNode searchByItemId(int itemId) {
        ItemNode current = head;
        
        while (current != null) {
            if (current.itemId == itemId) {
                return current;
            }
            current = current.next;
        }
        
        return null;
    }
    
    // Search item by Item Name
    public void searchByItemName(String itemName) {
        if (head == null) {
            System.out.println("Inventory is empty!");
            return;
        }
        
        System.out.println("\nItems with name containing '" + itemName + "':");
        System.out.printf("%-8s %-20s %-10s %-10s%n", "Item ID", "Item Name", "Quantity", "Price");
        System.out.println("------------------------------------------------------------");
        
        ItemNode current = head;
        boolean found = false;
        
        while (current != null) {
            if (current.itemName.toLowerCase().contains(itemName.toLowerCase())) {
                System.out.printf("%-8d %-20s %-10d %-10.2f%n", 
                                current.itemId, current.itemName, current.quantity, current.price);
                found = true;
            }
            current = current.next;
        }
        
        if (!found) {
            System.out.println("No items found with name containing '" + itemName + "'");
        }
    }
    
    // Calculate total inventory value
    public double calculateTotalValue() {
        double totalValue = 0.0;
        ItemNode current = head;
        
        while (current != null) {
            totalValue += current.quantity * current.price;
            current = current.next;
        }
        
        return totalValue;
    }
    
    // Sort inventory by Item Name (ascending)
    public void sortByNameAscending() {
        if (head == null || head.next == null) {
            return; // Already sorted
        }
        
        boolean swapped;
        do {
            swapped = false;
            ItemNode current = head;
            ItemNode previous = null;
            
            while (current.next != null) {
                if (current.itemName.compareToIgnoreCase(current.next.itemName) > 0) {
                    // Swap nodes
                    if (previous == null) {
                        head = current.next;
                    } else {
                        previous.next = current.next;
                    }
                    
                    ItemNode temp = current.next;
                    current.next = temp.next;
                    temp.next = current;
                    
                    swapped = true;
                } else {
                    previous = current;
                    current = current.next;
                }
            }
        } while (swapped);
        
        System.out.println("Inventory sorted by name (ascending) successfully!");
    }
    
    // Sort inventory by Item Name (descending)
    public void sortByNameDescending() {
        if (head == null || head.next == null) {
            return; // Already sorted
        }
        
        boolean swapped;
        do {
            swapped = false;
            ItemNode current = head;
            ItemNode previous = null;
            
            while (current.next != null) {
                if (current.itemName.compareToIgnoreCase(current.next.itemName) < 0) {
                    // Swap nodes
                    if (previous == null) {
                        head = current.next;
                    } else {
                        previous.next = current.next;
                    }
                    
                    ItemNode temp = current.next;
                    current.next = temp.next;
                    temp.next = current;
                    
                    swapped = true;
                } else {
                    previous = current;
                    current = current.next;
                }
            }
        } while (swapped);
        
        System.out.println("Inventory sorted by name (descending) successfully!");
    }
    
    // Sort inventory by Price (ascending)
    public void sortByPriceAscending() {
        if (head == null || head.next == null) {
            return; // Already sorted
        }
        
        boolean swapped;
        do {
            swapped = false;
            ItemNode current = head;
            ItemNode previous = null;
            
            while (current.next != null) {
                if (current.price > current.next.price) {
                    // Swap nodes
                    if (previous == null) {
                        head = current.next;
                    } else {
                        previous.next = current.next;
                    }
                    
                    ItemNode temp = current.next;
                    current.next = temp.next;
                    temp.next = current;
                    
                    swapped = true;
                } else {
                    previous = current;
                    current = current.next;
                }
            }
        } while (swapped);
        
        System.out.println("Inventory sorted by price (ascending) successfully!");
    }
    
    // Sort inventory by Price (descending)
    public void sortByPriceDescending() {
        if (head == null || head.next == null) {
            return; // Already sorted
        }
        
        boolean swapped;
        do {
            swapped = false;
            ItemNode current = head;
            ItemNode previous = null;
            
            while (current.next != null) {
                if (current.price < current.next.price) {
                    // Swap nodes
                    if (previous == null) {
                        head = current.next;
                    } else {
                        previous.next = current.next;
                    }
                    
                    ItemNode temp = current.next;
                    current.next = temp.next;
                    temp.next = current;
                    
                    swapped = true;
                } else {
                    previous = current;
                    current = current.next;
                }
            }
        } while (swapped);
        
        System.out.println("Inventory sorted by price (descending) successfully!");
    }
    
    // Display all inventory items
    public void displayAllItems() {
        if (head == null) {
            System.out.println("No items in inventory!");
            return;
        }
        
        System.out.println("\n=== Inventory Items ===");
        System.out.printf("%-8s %-20s %-10s %-10s %-12s%n", "Item ID", "Item Name", "Quantity", "Price", "Total Value");
        System.out.println("----------------------------------------------------------------");
        
        ItemNode current = head;
        while (current != null) {
            double itemValue = current.quantity * current.price;
            System.out.printf("%-8d %-20s %-10d %-10.2f %-12.2f%n", 
                            current.itemId, current.itemName, current.quantity, 
                            current.price, itemValue);
            current = current.next;
        }
        System.out.println("Total Inventory Value: $" + calculateTotalValue());
        System.out.println("Total Items: " + size);
    }
    
    // Get size of the list
    public int getSize() {
        return size;
    }
    
    // Check if list is empty
    public boolean isEmpty() {
        return head == null;
    }
}

// Main class to demonstrate the Inventory Management System
public class InventoryManagementSystem {
    public static void main(String[] args) {
        System.out.println("=== Inventory Management System ===\n");
        
        InventoryLinkedList inventory = new InventoryLinkedList();
        
        // Adding items at different positions
        System.out.println("Adding items...");
        inventory.addAtEnd("Laptop", 101, 5, 999.99);
        inventory.addAtEnd("Mouse", 102, 20, 25.50);
        inventory.addAtBeginning("Keyboard", 100, 10, 75.00);
        inventory.addAtPosition(2, "Monitor", 103, 8, 299.99);
        inventory.addAtEnd("Headphones", 104, 15, 89.99);
        inventory.addAtEnd("USB Drive", 105, 50, 15.99);
        
        // Display all items
        inventory.displayAllItems();
        
        // Search by Item ID
        System.out.println("\n=== Searching by Item ID ===");
        int searchId = 102;
        ItemNode foundItem = inventory.searchByItemId(searchId);
        if (foundItem != null) {
            System.out.println("Found Item:");
            System.out.println("ID: " + foundItem.itemId);
            System.out.println("Name: " + foundItem.itemName);
            System.out.println("Quantity: " + foundItem.quantity);
            System.out.println("Price: $" + foundItem.price);
        }
        
        // Search by Item Name
        System.out.println("\n=== Searching by Item Name ===");
        inventory.searchByItemName("lap");
        
        // Update quantity
        System.out.println("\n=== Updating Quantity ===");
        inventory.updateQuantity(102, 25);
        
        // Display updated inventory
        inventory.displayAllItems();
        
        // Sort by name (ascending)
        System.out.println("\n=== Sorting by Name (Ascending) ===");
        inventory.sortByNameAscending();
        inventory.displayAllItems();
        
        // Sort by price (descending)
        System.out.println("\n=== Sorting by Price (Descending) ===");
        inventory.sortByPriceDescending();
        inventory.displayAllItems();
        
        // Remove an item
        System.out.println("\n=== Removing Item ===");
        inventory.removeByItemId(104);
        
        // Display final inventory
        inventory.displayAllItems();
        
        // Test edge cases
        System.out.println("\n=== Testing Edge Cases ===");
        inventory.removeByItemId(999); // Non-existent item
        inventory.updateQuantity(999, 10); // Non-existent item
        inventory.updateQuantity(101, -5); // Negative quantity
        inventory.addAtPosition(10, "Test Item", 106, 5, 10.00); // Invalid position
        inventory.addAtPosition(3, "Valid Item", 106, 5, 10.00); // Valid position
        
        inventory.displayAllItems();
    }
} 