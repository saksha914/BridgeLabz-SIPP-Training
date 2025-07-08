// Library Management System
// Demonstrates: Abstract Classes, Interfaces, Encapsulation, Polymorphism

// Interface for Reservable items
interface Reservable {
    boolean reserveItem(String borrowerId);
    boolean checkAvailability();
}

// Abstract class LibraryItem with encapsulation
abstract class LibraryItem {
    // Private fields - Encapsulation
    private String itemId;
    private String title;
    private String author;
    private boolean isAvailable;
    private String borrowerId;
    private String borrowerName;
    
    // Constructor
    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }
    
    // Getter methods - Encapsulation
    public String getItemId() {
        return itemId;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public boolean isAvailable() {
        return isAvailable;
    }
    
    public String getBorrowerId() {
        return borrowerId;
    }
    
    public String getBorrowerName() {
        return borrowerName;
    }
    
    // Setter methods with validation - Encapsulation
    public void setItemId(String itemId) {
        if (itemId != null && !itemId.trim().isEmpty()) {
            this.itemId = itemId;
        } else {
            System.out.println("Item ID cannot be empty");
        }
    }
    
    public void setTitle(String title) {
        if (title != null && !title.trim().isEmpty()) {
            this.title = title;
        } else {
            System.out.println("Title cannot be empty");
        }
    }
    
    public void setAuthor(String author) {
        if (author != null && !author.trim().isEmpty()) {
            this.author = author;
        } else {
            System.out.println("Author cannot be empty");
        }
    }
    
    protected void setAvailable(boolean available) {
        this.isAvailable = available;
    }
    
    protected void setBorrowerId(String borrowerId) {
        this.borrowerId = borrowerId;
    }
    
    protected void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }
    
    // Abstract method - must be implemented by subclasses
    public abstract int getLoanDuration();
    
    // Concrete method - shared implementation
    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
        System.out.println("Loan Duration: " + getLoanDuration() + " days");
        if (!isAvailable) {
            System.out.println("Borrowed by: " + borrowerName + " (ID: " + borrowerId + ")");
        }
    }
}

// Book class extending LibraryItem
class Book extends LibraryItem implements Reservable {
    private String isbn;
    private int pages;
    private String genre;
    
    public Book(String itemId, String title, String author, String isbn, int pages, String genre) {
        super(itemId, title, author);
        this.isbn = isbn;
        this.pages = pages;
        this.genre = genre;
    }
    
    // Getter and setter methods
    public String getIsbn() {
        return isbn;
    }
    
    public void setIsbn(String isbn) {
        if (isbn != null && !isbn.trim().isEmpty()) {
            this.isbn = isbn;
        } else {
            System.out.println("ISBN cannot be empty");
        }
    }
    
    public int getPages() {
        return pages;
    }
    
    public void setPages(int pages) {
        if (pages > 0) {
            this.pages = pages;
        } else {
            System.out.println("Pages must be positive");
        }
    }
    
    public String getGenre() {
        return genre;
    }
    
    public void setGenre(String genre) {
        if (genre != null && !genre.trim().isEmpty()) {
            this.genre = genre;
        } else {
            System.out.println("Genre cannot be empty");
        }
    }
    
    // Implementation of abstract method
    @Override
    public int getLoanDuration() {
        return 21; // Books can be borrowed for 21 days
    }
    
    // Implementation of Reservable interface methods
    @Override
    public boolean reserveItem(String borrowerId) {
        if (isAvailable()) {
            setAvailable(false);
            setBorrowerId(borrowerId);
            setBorrowerName("Reserved by " + borrowerId);
            System.out.println("Book '" + getTitle() + "' reserved successfully");
            return true;
        } else {
            System.out.println("Book '" + getTitle() + "' is not available for reservation");
            return false;
        }
    }
    
    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
    
    @Override
    public void getItemDetails() {
        super.getItemDetails();
        System.out.println("ISBN: " + isbn);
        System.out.println("Pages: " + pages);
        System.out.println("Genre: " + genre);
        System.out.println("------------------------");
    }
}

// Magazine class extending LibraryItem
class Magazine extends LibraryItem implements Reservable {
    private String issueNumber;
    private String publisher;
    private int year;
    
    public Magazine(String itemId, String title, String author, String issueNumber, String publisher, int year) {
        super(itemId, title, author);
        this.issueNumber = issueNumber;
        this.publisher = publisher;
        this.year = year;
    }
    
    // Getter and setter methods
    public String getIssueNumber() {
        return issueNumber;
    }
    
    public void setIssueNumber(String issueNumber) {
        if (issueNumber != null && !issueNumber.trim().isEmpty()) {
            this.issueNumber = issueNumber;
        } else {
            System.out.println("Issue number cannot be empty");
        }
    }
    
    public String getPublisher() {
        return publisher;
    }
    
    public void setPublisher(String publisher) {
        if (publisher != null && !publisher.trim().isEmpty()) {
            this.publisher = publisher;
        } else {
            System.out.println("Publisher cannot be empty");
        }
    }
    
    public int getYear() {
        return year;
    }
    
    public void setYear(int year) {
        if (year >= 1900 && year <= 2024) {
            this.year = year;
        } else {
            System.out.println("Invalid year");
        }
    }
    
    // Implementation of abstract method
    @Override
    public int getLoanDuration() {
        return 7; // Magazines can be borrowed for 7 days
    }
    
    // Implementation of Reservable interface methods
    @Override
    public boolean reserveItem(String borrowerId) {
        if (isAvailable()) {
            setAvailable(false);
            setBorrowerId(borrowerId);
            setBorrowerName("Reserved by " + borrowerId);
            System.out.println("Magazine '" + getTitle() + "' reserved successfully");
            return true;
        } else {
            System.out.println("Magazine '" + getTitle() + "' is not available for reservation");
            return false;
        }
    }
    
    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
    
    @Override
    public void getItemDetails() {
        super.getItemDetails();
        System.out.println("Issue Number: " + issueNumber);
        System.out.println("Publisher: " + publisher);
        System.out.println("Year: " + year);
        System.out.println("------------------------");
    }
}

// DVD class extending LibraryItem
class DVD extends LibraryItem implements Reservable {
    private int duration;
    private String director;
    private String rating;
    
    public DVD(String itemId, String title, String author, int duration, String director, String rating) {
        super(itemId, title, author);
        this.duration = duration;
        this.director = director;
        this.rating = rating;
    }
    
    // Getter and setter methods
    public int getDuration() {
        return duration;
    }
    
    public void setDuration(int duration) {
        if (duration > 0) {
            this.duration = duration;
        } else {
            System.out.println("Duration must be positive");
        }
    }
    
    public String getDirector() {
        return director;
    }
    
    public void setDirector(String director) {
        if (director != null && !director.trim().isEmpty()) {
            this.director = director;
        } else {
            System.out.println("Director cannot be empty");
        }
    }
    
    public String getRating() {
        return rating;
    }
    
    public void setRating(String rating) {
        if (rating != null && !rating.trim().isEmpty()) {
            this.rating = rating;
        } else {
            System.out.println("Rating cannot be empty");
        }
    }
    
    // Implementation of abstract method
    @Override
    public int getLoanDuration() {
        return 14; // DVDs can be borrowed for 14 days
    }
    
    // Implementation of Reservable interface methods
    @Override
    public boolean reserveItem(String borrowerId) {
        if (isAvailable()) {
            setAvailable(false);
            setBorrowerId(borrowerId);
            setBorrowerName("Reserved by " + borrowerId);
            System.out.println("DVD '" + getTitle() + "' reserved successfully");
            return true;
        } else {
            System.out.println("DVD '" + getTitle() + "' is not available for reservation");
            return false;
        }
    }
    
    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
    
    @Override
    public void getItemDetails() {
        super.getItemDetails();
        System.out.println("Duration: " + duration + " minutes");
        System.out.println("Director: " + director);
        System.out.println("Rating: " + rating);
        System.out.println("------------------------");
    }
}

// Main class to demonstrate the system
public class LibraryManagementSystem {
    public static void main(String[] args) {
        System.out.println("=== Library Management System ===\n");
        
        // Creating library items
        Book book = new Book("B001", "Java Programming", "John Smith", "978-1234567890", 450, "Programming");
        Magazine magazine = new Magazine("M001", "Tech Weekly", "Tech Publications", "Vol. 15, No. 3", "Tech Corp", 2024);
        DVD dvd = new DVD("D001", "Java Tutorial", "Programming Academy", 120, "Jane Doe", "G");
        
        // Demonstrating polymorphism - using LibraryItem reference
        LibraryItem[] items = {book, magazine, dvd};
        
        System.out.println("Library Items Details:");
        for (LibraryItem item : items) {
            item.getItemDetails(); // Polymorphic method call
        }
        
        // Demonstrating interface usage
        System.out.println("Reservation System:");
        Reservable[] reservableItems = {book, magazine, dvd};
        for (Reservable item : reservableItems) {
            System.out.println("Checking availability for " + ((LibraryItem) item).getTitle() + ": " + 
                             (item.checkAvailability() ? "Available" : "Not Available"));
        }
        
        // Demonstrating reservations
        System.out.println("\nMaking Reservations:");
        book.reserveItem("STU001");
        magazine.reserveItem("STU002");
        dvd.reserveItem("STU003");
        
        // Try to reserve already reserved items
        book.reserveItem("STU004"); // Should fail
        
        // Demonstrating updated details after reservations
        System.out.println("\nUpdated Item Details:");
        for (LibraryItem item : items) {
            item.getItemDetails();
        }
        
        // Demonstrating encapsulation
        System.out.println("\n=== Testing Encapsulation ===");
        book.setTitle(""); // Should show validation message
        magazine.setYear(1800); // Should show validation message
        dvd.setDuration(-60); // Should show validation message
        
        book.setTitle("Updated Java Programming");
        magazine.setYear(2023);
        dvd.setDuration(90);
        
        System.out.println("Updated item details:");
        book.getItemDetails();
        magazine.getItemDetails();
        dvd.getItemDetails();
    }
} 