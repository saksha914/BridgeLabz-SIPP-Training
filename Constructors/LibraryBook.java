public class LibraryBook {
    private String title;
    private String author;
    private double price;
    private boolean available;

    public LibraryBook(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = true;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public boolean isAvailable() { return available; }

    public boolean borrowBook() {
        if (available) {
            available = false;
            System.out.println("Book borrowed successfully.");
            return true;
        } else {
            System.out.println("Book is not available.");
            return false;
        }
    }

    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
        System.out.println("Available: " + available);
    }

    public static void main(String[] args) {
        LibraryBook book = new LibraryBook("Effective Java", "Joshua Bloch", 499.99);
        book.displayDetails();
        book.borrowBook();
        book.displayDetails();
        book.borrowBook();
    }
} 