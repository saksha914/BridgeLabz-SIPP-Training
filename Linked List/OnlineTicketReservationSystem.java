// Online Ticket Reservation System using Circular Linked List
// Demonstrates: Circular Linked List operations for ticket booking management

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Node class for Ticket
class TicketNode {
    int ticketId;
    String customerName;
    String movieName;
    int seatNumber;
    LocalDateTime bookingTime;
    TicketNode next;
    
    public TicketNode(int ticketId, String customerName, String movieName, int seatNumber) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = LocalDateTime.now();
        this.next = null;
    }
}

// Circular Linked List class for Online Ticket Reservation
class TicketReservationLinkedList {
    private TicketNode head;
    private int nextTicketId;
    private int size;
    
    public TicketReservationLinkedList() {
        this.head = null;
        this.nextTicketId = 1001; // Starting ticket ID
        this.size = 0;
    }
    
    // Add new ticket reservation at the end
    public void addTicket(String customerName, String movieName, int seatNumber) {
        TicketNode newNode = new TicketNode(nextTicketId, customerName, movieName, seatNumber);
        
        if (head == null) {
            head = newNode;
            newNode.next = head; // Point to itself
        } else {
            // Find the last node
            TicketNode last = head;
            while (last.next != head) {
                last = last.next;
            }
            
            last.next = newNode;
            newNode.next = head;
        }
        
        size++;
        System.out.println("Ticket " + nextTicketId + " booked successfully for " + customerName + "!");
        nextTicketId++;
    }
    
    // Remove ticket by Ticket ID
    public boolean removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets in the system!");
            return false;
        }
        
        // If head is the only node
        if (head.next == head && head.ticketId == ticketId) {
            head = null;
            size--;
            System.out.println("Ticket " + ticketId + " cancelled successfully!");
            return true;
        }
        
        // If head is to be removed
        if (head.ticketId == ticketId) {
            TicketNode last = head;
            while (last.next != head) {
                last = last.next;
            }
            last.next = head.next;
            head = head.next;
            size--;
            System.out.println("Ticket " + ticketId + " cancelled successfully!");
            return true;
        }
        
        // Find the ticket to remove
        TicketNode current = head;
        while (current.next != head && current.next.ticketId != ticketId) {
            current = current.next;
        }
        
        if (current.next != head) {
            current.next = current.next.next;
            size--;
            System.out.println("Ticket " + ticketId + " cancelled successfully!");
            return true;
        } else {
            System.out.println("Ticket " + ticketId + " not found!");
            return false;
        }
    }
    
    // Search ticket by Customer Name
    public void searchByCustomerName(String customerName) {
        if (head == null) {
            System.out.println("No tickets in the system!");
            return;
        }
        
        System.out.println("\nTickets for customer '" + customerName + "':");
        System.out.printf("%-10s %-20s %-20s %-10s %-20s%n", 
                        "Ticket ID", "Customer Name", "Movie Name", "Seat", "Booking Time");
        System.out.println("------------------------------------------------------------------------------");
        
        TicketNode current = head;
        boolean found = false;
        
        do {
            if (current.customerName.equalsIgnoreCase(customerName)) {
                System.out.printf("%-10d %-20s %-20s %-10d %-20s%n", 
                                current.ticketId, current.customerName, current.movieName, 
                                current.seatNumber, 
                                current.bookingTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
                found = true;
            }
            current = current.next;
        } while (current != head);
        
        if (!found) {
            System.out.println("No tickets found for customer '" + customerName + "'");
        }
    }
    
    // Search ticket by Movie Name
    public void searchByMovieName(String movieName) {
        if (head == null) {
            System.out.println("No tickets in the system!");
            return;
        }
        
        System.out.println("\nTickets for movie '" + movieName + "':");
        System.out.printf("%-10s %-20s %-20s %-10s %-20s%n", 
                        "Ticket ID", "Customer Name", "Movie Name", "Seat", "Booking Time");
        System.out.println("------------------------------------------------------------------------------");
        
        TicketNode current = head;
        boolean found = false;
        
        do {
            if (current.movieName.equalsIgnoreCase(movieName)) {
                System.out.printf("%-10d %-20s %-20s %-10d %-20s%n", 
                                current.ticketId, current.customerName, current.movieName, 
                                current.seatNumber, 
                                current.bookingTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
                found = true;
            }
            current = current.next;
        } while (current != head);
        
        if (!found) {
            System.out.println("No tickets found for movie '" + movieName + "'");
        }
    }
    
    // Display all tickets
    public void displayAllTickets() {
        if (head == null) {
            System.out.println("No tickets in the system!");
            return;
        }
        
        System.out.println("\n=== All Booked Tickets ===");
        System.out.printf("%-10s %-20s %-20s %-10s %-20s%n", 
                        "Ticket ID", "Customer Name", "Movie Name", "Seat", "Booking Time");
        System.out.println("------------------------------------------------------------------------------");
        
        TicketNode current = head;
        do {
            System.out.printf("%-10d %-20s %-20s %-10d %-20s%n", 
                            current.ticketId, current.customerName, current.movieName, 
                            current.seatNumber, 
                            current.bookingTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
            current = current.next;
        } while (current != head);
        
        System.out.println("Total Booked Tickets: " + size);
    }
    
    // Calculate total number of booked tickets
    public int getTotalBookedTickets() {
        return size;
    }
    
    // Get tickets count by movie
    public int getTicketsByMovie(String movieName) {
        if (head == null) {
            return 0;
        }
        
        int count = 0;
        TicketNode current = head;
        
        do {
            if (current.movieName.equalsIgnoreCase(movieName)) {
                count++;
            }
            current = current.next;
        } while (current != head);
        
        return count;
    }
    
    // Get tickets count by customer
    public int getTicketsByCustomer(String customerName) {
        if (head == null) {
            return 0;
        }
        
        int count = 0;
        TicketNode current = head;
        
        do {
            if (current.customerName.equalsIgnoreCase(customerName)) {
                count++;
            }
            current = current.next;
        } while (current != head);
        
        return count;
    }
    
    // Check if seat is available for a movie
    public boolean isSeatAvailable(String movieName, int seatNumber) {
        if (head == null) {
            return true;
        }
        
        TicketNode current = head;
        
        do {
            if (current.movieName.equalsIgnoreCase(movieName) && current.seatNumber == seatNumber) {
                return false;
            }
            current = current.next;
        } while (current != head);
        
        return true;
    }
    
    // Get available seats for a movie
    public void displayAvailableSeats(String movieName, int totalSeats) {
        System.out.println("\nAvailable seats for movie '" + movieName + "':");
        
        boolean[] occupiedSeats = new boolean[totalSeats + 1];
        
        if (head != null) {
            TicketNode current = head;
            do {
                if (current.movieName.equalsIgnoreCase(movieName)) {
                    occupiedSeats[current.seatNumber] = true;
                }
                current = current.next;
            } while (current != head);
        }
        
        System.out.print("Available: ");
        boolean first = true;
        for (int i = 1; i <= totalSeats; i++) {
            if (!occupiedSeats[i]) {
                if (!first) {
                    System.out.print(", ");
                }
                System.out.print(i);
                first = false;
            }
        }
        
        if (first) {
            System.out.print("None (all seats booked)");
        }
        System.out.println();
    }
    
    // Get size of the list
    public int getSize() {
        return size;
    }
    
    // Check if list is empty
    public boolean isEmpty() {
        return head == null;
    }
    
    // Get next ticket ID
    public int getNextTicketId() {
        return nextTicketId;
    }
}

// Main class to demonstrate the Online Ticket Reservation System
public class OnlineTicketReservationSystem {
    public static void main(String[] args) {
        System.out.println("=== Online Ticket Reservation System ===\n");
        
        TicketReservationLinkedList reservationSystem = new TicketReservationLinkedList();
        
        // Adding ticket reservations
        System.out.println("=== Booking Tickets ===");
        reservationSystem.addTicket("John Doe", "Avengers: Endgame", 5);
        reservationSystem.addTicket("Jane Smith", "Avengers: Endgame", 7);
        reservationSystem.addTicket("Bob Wilson", "Spider-Man: No Way Home", 3);
        reservationSystem.addTicket("Alice Johnson", "Avengers: Endgame", 12);
        reservationSystem.addTicket("Charlie Brown", "The Batman", 8);
        reservationSystem.addTicket("Diana Prince", "Spider-Man: No Way Home", 15);
        reservationSystem.addTicket("Bruce Wayne", "The Batman", 2);
        reservationSystem.addTicket("Peter Parker", "Avengers: Endgame", 9);
        
        // Display all tickets
        reservationSystem.displayAllTickets();
        
        // Search by customer name
        System.out.println("\n=== Searching by Customer Name ===");
        reservationSystem.searchByCustomerName("John Doe");
        reservationSystem.searchByCustomerName("Alice Johnson");
        
        // Search by movie name
        System.out.println("\n=== Searching by Movie Name ===");
        reservationSystem.searchByMovieName("Avengers: Endgame");
        reservationSystem.searchByMovieName("The Batman");
        
        // Display statistics
        System.out.println("\n=== Reservation Statistics ===");
        System.out.println("Total Booked Tickets: " + reservationSystem.getTotalBookedTickets());
        System.out.println("Tickets for 'Avengers: Endgame': " + reservationSystem.getTicketsByMovie("Avengers: Endgame"));
        System.out.println("Tickets for 'The Batman': " + reservationSystem.getTicketsByMovie("The Batman"));
        System.out.println("Tickets for 'Spider-Man: No Way Home': " + reservationSystem.getTicketsByMovie("Spider-Man: No Way Home"));
        
        // Check seat availability
        System.out.println("\n=== Checking Seat Availability ===");
        System.out.println("Is seat 5 available for 'Avengers: Endgame': " + reservationSystem.isSeatAvailable("Avengers: Endgame", 5));
        System.out.println("Is seat 10 available for 'Avengers: Endgame': " + reservationSystem.isSeatAvailable("Avengers: Endgame", 10));
        
        // Display available seats
        reservationSystem.displayAvailableSeats("Avengers: Endgame", 20);
        reservationSystem.displayAvailableSeats("The Batman", 15);
        
        // Cancel a ticket
        System.out.println("\n=== Cancelling Ticket ===");
        reservationSystem.removeTicket(1001); // Cancel John Doe's ticket
        
        // Display updated tickets
        reservationSystem.displayAllTickets();
        
        // Check seat availability after cancellation
        System.out.println("\n=== Checking Seat Availability After Cancellation ===");
        System.out.println("Is seat 5 available for 'Avengers: Endgame': " + reservationSystem.isSeatAvailable("Avengers: Endgame", 5));
        reservationSystem.displayAvailableSeats("Avengers: Endgame", 20);
        
        // Book more tickets
        System.out.println("\n=== Booking More Tickets ===");
        reservationSystem.addTicket("Emma Watson", "Avengers: Endgame", 5); // Book the cancelled seat
        reservationSystem.addTicket("Tom Hanks", "The Batman", 10);
        reservationSystem.addTicket("Julia Roberts", "Spider-Man: No Way Home", 1);
        
        // Display final state
        reservationSystem.displayAllTickets();
        
        // Test edge cases
        System.out.println("\n=== Testing Edge Cases ===");
        reservationSystem.removeTicket(9999); // Non-existent ticket
        reservationSystem.searchByCustomerName("Non-existent Customer");
        reservationSystem.searchByMovieName("Non-existent Movie");
        
        // Test with empty system
        System.out.println("\n=== Testing Empty System ===");
        TicketReservationLinkedList emptySystem = new TicketReservationLinkedList();
        emptySystem.displayAllTickets();
        emptySystem.removeTicket(1001);
        emptySystem.searchByCustomerName("John");
        emptySystem.searchByMovieName("Avengers");
        
        // Test circular nature
        System.out.println("\n=== Testing Circular Nature ===");
        System.out.println("Adding tickets to demonstrate circular traversal...");
        for (int i = 0; i < 5; i++) {
            emptySystem.addTicket("Customer " + (i + 1), "Movie " + (i + 1), i + 1);
        }
        emptySystem.displayAllTickets();
    }
} 