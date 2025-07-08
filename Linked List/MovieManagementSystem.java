// Movie Management System using Doubly Linked List
// Demonstrates: Doubly Linked List operations - Insert, Delete, Search, Update, Display (Forward/Reverse)

// Node class for Movie
class MovieNode {
    String title;
    String director;
    int year;
    double rating;
    MovieNode next;
    MovieNode prev;
    
    public MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

// Doubly Linked List class for Movie Management
class MovieLinkedList {
    private MovieNode head;
    private MovieNode tail;
    private int size;
    
    public MovieLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    // Add movie at the beginning
    public void addAtBeginning(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
        System.out.println("Movie added at the beginning successfully!");
    }
    
    // Add movie at the end
    public void addAtEnd(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        System.out.println("Movie added at the end successfully!");
    }
    
    // Add movie at specific position
    public void addAtPosition(int position, String title, String director, int year, double rating) {
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position!");
            return;
        }
        
        if (position == 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }
        
        if (position == size + 1) {
            addAtEnd(title, director, year, rating);
            return;
        }
        
        MovieNode newNode = new MovieNode(title, director, year, rating);
        MovieNode current = head;
        
        for (int i = 1; i < position; i++) {
            current = current.next;
        }
        
        newNode.prev = current.prev;
        newNode.next = current;
        current.prev.next = newNode;
        current.prev = newNode;
        size++;
        System.out.println("Movie added at position " + position + " successfully!");
    }
    
    // Remove movie by title
    public boolean removeByTitle(String title) {
        if (head == null) {
            System.out.println("List is empty!");
            return false;
        }
        
        MovieNode current = head;
        
        while (current != null && !current.title.equalsIgnoreCase(title)) {
            current = current.next;
        }
        
        if (current == null) {
            System.out.println("Movie with title '" + title + "' not found!");
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
        System.out.println("Movie '" + title + "' removed successfully!");
        return true;
    }
    
    // Search movie by director
    public void searchByDirector(String director) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        
        System.out.println("\nMovies by Director '" + director + "':");
        System.out.printf("%-30s %-20s %-8s %-8s%n", "Title", "Director", "Year", "Rating");
        System.out.println("------------------------------------------------------------");
        
        MovieNode current = head;
        boolean found = false;
        
        while (current != null) {
            if (current.director.equalsIgnoreCase(director)) {
                System.out.printf("%-30s %-20s %-8d %-8.1f%n", 
                                current.title, current.director, current.year, current.rating);
                found = true;
            }
            current = current.next;
        }
        
        if (!found) {
            System.out.println("No movies found by director '" + director + "'");
        }
    }
    
    // Search movie by rating
    public void searchByRating(double rating) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        
        System.out.println("\nMovies with Rating >= " + rating + ":");
        System.out.printf("%-30s %-20s %-8s %-8s%n", "Title", "Director", "Year", "Rating");
        System.out.println("------------------------------------------------------------");
        
        MovieNode current = head;
        boolean found = false;
        
        while (current != null) {
            if (current.rating >= rating) {
                System.out.printf("%-30s %-20s %-8d %-8.1f%n", 
                                current.title, current.director, current.year, current.rating);
                found = true;
            }
            current = current.next;
        }
        
        if (!found) {
            System.out.println("No movies found with rating >= " + rating);
        }
    }
    
    // Update movie rating by title
    public boolean updateRating(String title, double newRating) {
        MovieNode current = head;
        
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                current.rating = newRating;
                System.out.println("Rating updated successfully for '" + title + "'!");
                return true;
            }
            current = current.next;
        }
        
        System.out.println("Movie with title '" + title + "' not found!");
        return false;
    }
    
    // Display all movies in forward order
    public void displayForward() {
        if (head == null) {
            System.out.println("No movies in the list!");
            return;
        }
        
        System.out.println("\n=== Movies (Forward Order) ===");
        System.out.printf("%-30s %-20s %-8s %-8s%n", "Title", "Director", "Year", "Rating");
        System.out.println("------------------------------------------------------------");
        
        MovieNode current = head;
        while (current != null) {
            System.out.printf("%-30s %-20s %-8d %-8.1f%n", 
                            current.title, current.director, current.year, current.rating);
            current = current.next;
        }
        System.out.println("Total Movies: " + size);
    }
    
    // Display all movies in reverse order
    public void displayReverse() {
        if (tail == null) {
            System.out.println("No movies in the list!");
            return;
        }
        
        System.out.println("\n=== Movies (Reverse Order) ===");
        System.out.printf("%-30s %-20s %-8s %-8s%n", "Title", "Director", "Year", "Rating");
        System.out.println("------------------------------------------------------------");
        
        MovieNode current = tail;
        while (current != null) {
            System.out.printf("%-30s %-20s %-8d %-8.1f%n", 
                            current.title, current.director, current.year, current.rating);
            current = current.prev;
        }
        System.out.println("Total Movies: " + size);
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

// Main class to demonstrate the Movie Management System
public class MovieManagementSystem {
    public static void main(String[] args) {
        System.out.println("=== Movie Management System ===\n");
        
        MovieLinkedList movieList = new MovieLinkedList();
        
        // Adding movies at different positions
        System.out.println("Adding movies...");
        movieList.addAtEnd("The Shawshank Redemption", "Frank Darabont", 1994, 9.3);
        movieList.addAtEnd("The Godfather", "Francis Ford Coppola", 1972, 9.2);
        movieList.addAtBeginning("Pulp Fiction", "Quentin Tarantino", 1994, 8.9);
        movieList.addAtPosition(2, "The Dark Knight", "Christopher Nolan", 2008, 9.0);
        movieList.addAtEnd("Fight Club", "David Fincher", 1999, 8.8);
        movieList.addAtEnd("Inception", "Christopher Nolan", 2010, 8.8);
        
        // Display movies in forward order
        movieList.displayForward();
        
        // Display movies in reverse order
        movieList.displayReverse();
        
        // Search by director
        System.out.println("\n=== Searching by Director ===");
        movieList.searchByDirector("Christopher Nolan");
        
        // Search by rating
        System.out.println("\n=== Searching by Rating ===");
        movieList.searchByRating(9.0);
        
        // Update movie rating
        System.out.println("\n=== Updating Movie Rating ===");
        movieList.updateRating("Pulp Fiction", 9.1);
        
        // Display updated list
        movieList.displayForward();
        
        // Remove a movie
        System.out.println("\n=== Removing Movie ===");
        movieList.removeByTitle("Fight Club");
        
        // Display final list
        movieList.displayForward();
        
        // Test edge cases
        System.out.println("\n=== Testing Edge Cases ===");
        movieList.removeByTitle("Non-existent Movie"); // Non-existent movie
        movieList.updateRating("Non-existent Movie", 5.0); // Non-existent movie
        movieList.addAtPosition(10, "Test Movie", "Test Director", 2023, 7.0); // Invalid position
        movieList.addAtPosition(3, "Valid Movie", "Valid Director", 2023, 7.5); // Valid position
        
        movieList.displayForward();
    }
} 