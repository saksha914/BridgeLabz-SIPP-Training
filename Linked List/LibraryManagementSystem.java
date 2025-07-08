// Library Management System using Doubly Linked List
// Demonstrates: Doubly Linked List operations - Insert, Delete, Search, Update, Display (Forward/Reverse)

// Node class for Book
class BookNode {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    BookNode next;
    BookNode prev;
    
    public BookNode(String title, String author, String genre, int bookId) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = true;
        this.next = null;
        this.prev = null;
    }
}

// Doubly Linked List class for Library Management
class LibraryLinkedList {
    private BookNode head;
    private BookNode tail;
    private int size;
    
    public LibraryLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    // Add book at the beginning
    public void addAtBeginning(String title, String author, String genre, int bookId) {
        BookNode newNode = new BookNode(title, author, genre, bookId);
        
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
        System.out.println("Book added at the beginning successfully!");
    }
    
    // Add book at the end
    public void addAtEnd(String title, String author, String genre, int bookId) {
        BookNode newNode = new BookNode(title, author, genre, bookId);
        
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        System.out.println("Book added at the end successfully!");
    }
    
    // Add book at specific position
    public void addAtPosition(int position, String title, String author, String genre, int bookId) {
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position!");
            return;
        }
        
        if (position == 1) {
            addAtBeginning(title, author, genre, bookId);
            return;
        }
        
        if (position == size + 1) {
            addAtEnd(title, author, genre, bookId);
            return;
        }
        
        BookNode newNode = new BookNode(title, author, genre, bookId);
        BookNode current = head;
        
        for (int i = 1; i < position; i++) {
            current = current.next;
        }
        
        newNode.prev = current.prev;
        newNode.next = current;
        current.prev.next = newNode;
        current.prev = newNode;
        size++;
        System.out.println("Book added at position " + position + " successfully!");
    }
    
    // Remove book by Book ID
    public boolean removeByBookId(int bookId) {
        if (head == null) {
            System.out.println("Library is empty!");
            return false;
        }
        
        BookNode current = head;
        
        while (current != null && current.bookId != bookId) {
            current = current.next;
        }
        
        if (current == null) {
            System.out.println("Book with ID " + bookId + " not found!");
            return false;
        }
        
        if (current == head) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
        } else if (current == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        
        size--;
        System.out.println("Book with ID " + bookId + " removed successfully!");
        return true;
    }
    
    // Search book by title
    public void searchByTitle(String title) {
        if (head == null) {
            System.out.println("Library is empty!");
            return;
        }
        
        System.out.println("\nBooks with title containing '" + title + "':");
        System.out.printf("%-8s %-25s %-20s %-15s %-12s%n", "Book ID", "Title", "Author", "Genre", "Available");
        System.out.println("----------------------------------------------------------------------------");
        
        BookNode current = head;
        boolean found = false;
        
        while (current != null) {
            if (current.title.toLowerCase().contains(title.toLowerCase())) {
                System.out.printf("%-8d %-25s %-20s %-15s %-12s%n", 
                                current.bookId, current.title, current.author, 
                                current.genre, current.isAvailable ? "Yes" : "No");
                found = true;
            }
            current = current.next;
        }
        
        if (!found) {
            System.out.println("No books found with title containing '" + title + "'");
        }
    }
    
    // Search book by author
    public void searchByAuthor(String author) {
        if (head == null) {
            System.out.println("Library is empty!");
            return;
        }
        
        System.out.println("\nBooks by author '" + author + "':");
        System.out.printf("%-8s %-25s %-20s %-15s %-12s%n", "Book ID", "Title", "Author", "Genre", "Available");
        System.out.println("----------------------------------------------------------------------------");
        
        BookNode current = head;
        boolean found = false;
        
        while (current != null) {
            if (current.author.equalsIgnoreCase(author)) {
                System.out.printf("%-8d %-25s %-20s %-15s %-12s%n", 
                                current.bookId, current.title, current.author, 
                                current.genre, current.isAvailable ? "Yes" : "No");
                found = true;
            }
            current = current.next;
        }
        
        if (!found) {
            System.out.println("No books found by author '" + author + "'");
        }
    }
    
    // Update book availability status
    public boolean updateAvailability(int bookId, boolean isAvailable) {
        BookNode current = head;
        
        while (current != null) {
            if (current.bookId == bookId) {
                current.isAvailable = isAvailable;
                System.out.println("Availability updated successfully for Book ID " + bookId + "!");
                return true;
            }
            current = current.next;
        }
        
        System.out.println("Book with ID " + bookId + " not found!");
        return false;
    }
    
    // Display all books in forward order
    public void displayForward() {
        if (head == null) {
            System.out.println("No books in the library!");
            return;
        }
        
        System.out.println("\n=== Books (Forward Order) ===");
        System.out.printf("%-8s %-25s %-20s %-15s %-12s%n", "Book ID", "Title", "Author", "Genre", "Available");
        System.out.println("----------------------------------------------------------------------------");
        
        BookNode current = head;
        while (current != null) {
            System.out.printf("%-8d %-25s %-20s %-15s %-12s%n", 
                            current.bookId, current.title, current.author, 
                            current.genre, current.isAvailable ? "Yes" : "No");
            current = current.next;
        }
        System.out.println("Total Books: " + size);
    }
    
    // Display all books in reverse order
    public void displayReverse() {
        if (tail == null) {
            System.out.println("No books in the library!");
            return;
        }
        
        System.out.println("\n=== Books (Reverse Order) ===");
        System.out.printf("%-8s %-25s %-20s %-15s %-12s%n", "Book ID", "Title", "Author", "Genre", "Available");
        System.out.println("----------------------------------------------------------------------------");
        
        BookNode current = tail;
        while (current != null) {
            System.out.printf("%-8d %-25s %-20s %-15s %-12s%n", 
                            current.bookId, current.title, current.author, 
                            current.genre, current.isAvailable ? "Yes" : "No");
            current = current.prev;
        }
        System.out.println("Total Books: " + size);
    }
    
    // Count total number of books
    public int getTotalBooks() {
        return size;
    }
    
    // Count available books
    public int getAvailableBooks() {
        int count = 0;
        BookNode current = head;
        
        while (current != null) {
            if (current.isAvailable) {
                count++;
            }
            current = current.next;
        }
        
        return count;
    }
    
    // Count borrowed books
    public int getBorrowedBooks() {
        return size - getAvailableBooks();
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

// Main class to demonstrate the Library Management System
public class LibraryManagementSystem {
    public static void main(String[] args) {
        System.out.println("=== Library Management System ===\n");
        
        LibraryLinkedList library = new LibraryLinkedList();
        
        // Adding books at different positions
        System.out.println("Adding books...");
        library.addAtEnd("To Kill a Mockingbird", "Harper Lee", "Fiction", 101);
        library.addAtEnd("1984", "George Orwell", "Dystopian", 102);
        library.addAtBeginning("The Great Gatsby", "F. Scott Fitzgerald", "Classic", 100);
        library.addAtPosition(2, "Pride and Prejudice", "Jane Austen", "Romance", 103);
        library.addAtEnd("The Hobbit", "J.R.R. Tolkien", "Fantasy", 104);
        library.addAtEnd("Animal Farm", "George Orwell", "Allegory", 105);
        
        // Display books in forward order
        library.displayForward();
        
        // Display books in reverse order
        library.displayReverse();
        
        // Search by title
        System.out.println("\n=== Searching by Title ===");
        library.searchByTitle("great");
        
        // Search by author
        System.out.println("\n=== Searching by Author ===");
        library.searchByAuthor("George Orwell");
        
        // Update availability
        System.out.println("\n=== Updating Availability ===");
        library.updateAvailability(101, false); // Book borrowed
        library.updateAvailability(103, false); // Book borrowed
        
        // Display updated list
        library.displayForward();
        
        // Show statistics
        System.out.println("\n=== Library Statistics ===");
        System.out.println("Total Books: " + library.getTotalBooks());
        System.out.println("Available Books: " + library.getAvailableBooks());
        System.out.println("Borrowed Books: " + library.getBorrowedBooks());
        
        // Remove a book
        System.out.println("\n=== Removing Book ===");
        library.removeByBookId(104);
        
        // Display final list
        library.displayForward();
        
        // Test edge cases
        System.out.println("\n=== Testing Edge Cases ===");
        library.removeByBookId(999); // Non-existent book
        library.updateAvailability(999, true); // Non-existent book
        library.addAtPosition(10, "Test Book", "Test Author", "Test Genre", 106); // Invalid position
        library.addAtPosition(3, "Valid Book", "Valid Author", "Valid Genre", 106); // Valid position
        
        library.displayForward();
    }
} 