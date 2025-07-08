// Social Media Friend Connections using Singly Linked List
// Demonstrates: Singly Linked List with nested friend lists, mutual friends, friend counting

import java.util.ArrayList;
import java.util.List;

// Node class for Friend ID
class FriendIdNode {
    int friendId;
    FriendIdNode next;
    
    public FriendIdNode(int friendId) {
        this.friendId = friendId;
        this.next = null;
    }
}

// Node class for User
class UserNode {
    int userId;
    String name;
    int age;
    FriendIdNode friends; // Linked list of friend IDs
    UserNode next;
    
    public UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friends = null;
        this.next = null;
    }
}

// Singly Linked List class for Social Media Friend Connections
class SocialMediaLinkedList {
    private UserNode head;
    private int size;
    
    public SocialMediaLinkedList() {
        this.head = null;
        this.size = 0;
    }
    
    // Add user at the beginning
    public void addUserAtBeginning(int userId, String name, int age) {
        UserNode newNode = new UserNode(userId, name, age);
        newNode.next = head;
        head = newNode;
        size++;
        System.out.println("User added at the beginning successfully!");
    }
    
    // Add user at the end
    public void addUserAtEnd(int userId, String name, int age) {
        UserNode newNode = new UserNode(userId, name, age);
        
        if (head == null) {
            head = newNode;
        } else {
            UserNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        System.out.println("User added at the end successfully!");
    }
    
    // Add user at specific position
    public void addUserAtPosition(int position, int userId, String name, int age) {
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position!");
            return;
        }
        
        if (position == 1) {
            addUserAtBeginning(userId, name, age);
            return;
        }
        
        UserNode newNode = new UserNode(userId, name, age);
        UserNode current = head;
        
        for (int i = 1; i < position - 1; i++) {
            current = current.next;
        }
        
        newNode.next = current.next;
        current.next = newNode;
        size++;
        System.out.println("User added at position " + position + " successfully!");
    }
    
    // Find user by User ID
    public UserNode findUserById(int userId) {
        UserNode current = head;
        
        while (current != null) {
            if (current.userId == userId) {
                return current;
            }
            current = current.next;
        }
        
        return null;
    }
    
    // Find user by Name
    public UserNode findUserByName(String name) {
        UserNode current = head;
        
        while (current != null) {
            if (current.name.equalsIgnoreCase(name)) {
                return current;
            }
            current = current.next;
        }
        
        return null;
    }
    
    // Add friend connection between two users
    public boolean addFriendConnection(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);
        
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found!");
            return false;
        }
        
        if (userId1 == userId2) {
            System.out.println("User cannot be friends with themselves!");
            return false;
        }
        
        // Check if already friends
        if (isFriend(user1, userId2)) {
            System.out.println("Users are already friends!");
            return false;
        }
        
        // Add user2 to user1's friend list
        addFriendToList(user1, userId2);
        
        // Add user1 to user2's friend list
        addFriendToList(user2, userId1);
        
        System.out.println("Friend connection added between User " + userId1 + " and User " + userId2 + "!");
        return true;
    }
    
    // Helper method to add friend to user's friend list
    private void addFriendToList(UserNode user, int friendId) {
        FriendIdNode newFriend = new FriendIdNode(friendId);
        
        if (user.friends == null) {
            user.friends = newFriend;
        } else {
            FriendIdNode current = user.friends;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newFriend;
        }
    }
    
    // Remove friend connection
    public boolean removeFriendConnection(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);
        
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found!");
            return false;
        }
        
        // Remove user2 from user1's friend list
        boolean removed1 = removeFriendFromList(user1, userId2);
        
        // Remove user1 from user2's friend list
        boolean removed2 = removeFriendFromList(user2, userId1);
        
        if (removed1 && removed2) {
            System.out.println("Friend connection removed between User " + userId1 + " and User " + userId2 + "!");
            return true;
        } else {
            System.out.println("Friend connection not found!");
            return false;
        }
    }
    
    // Helper method to remove friend from user's friend list
    private boolean removeFriendFromList(UserNode user, int friendId) {
        if (user.friends == null) {
            return false;
        }
        
        if (user.friends.friendId == friendId) {
            user.friends = user.friends.next;
            return true;
        }
        
        FriendIdNode current = user.friends;
        while (current.next != null && current.next.friendId != friendId) {
            current = current.next;
        }
        
        if (current.next != null) {
            current.next = current.next.next;
            return true;
        }
        
        return false;
    }
    
    // Check if two users are friends
    private boolean isFriend(UserNode user, int friendId) {
        FriendIdNode current = user.friends;
        
        while (current != null) {
            if (current.friendId == friendId) {
                return true;
            }
            current = current.next;
        }
        
        return false;
    }
    
    // Find mutual friends between two users
    public List<Integer> findMutualFriends(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);
        
        List<Integer> mutualFriends = new ArrayList<>();
        
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found!");
            return mutualFriends;
        }
        
        // Get user1's friends
        List<Integer> user1Friends = getFriendIds(user1);
        List<Integer> user2Friends = getFriendIds(user2);
        
        // Find common friends
        for (int friendId : user1Friends) {
            if (user2Friends.contains(friendId)) {
                mutualFriends.add(friendId);
            }
        }
        
        return mutualFriends;
    }
    
    // Helper method to get list of friend IDs
    private List<Integer> getFriendIds(UserNode user) {
        List<Integer> friendIds = new ArrayList<>();
        FriendIdNode current = user.friends;
        
        while (current != null) {
            friendIds.add(current.friendId);
            current = current.next;
        }
        
        return friendIds;
    }
    
    // Display all friends of a specific user
    public void displayUserFriends(int userId) {
        UserNode user = findUserById(userId);
        
        if (user == null) {
            System.out.println("User not found!");
            return;
        }
        
        System.out.println("\n=== Friends of User " + userId + " (" + user.name + ") ===");
        
        if (user.friends == null) {
            System.out.println("No friends found.");
            return;
        }
        
        System.out.printf("%-8s %-20s %-8s%n", "User ID", "Name", "Age");
        System.out.println("--------------------------------");
        
        FriendIdNode current = user.friends;
        while (current != null) {
            UserNode friend = findUserById(current.friendId);
            if (friend != null) {
                System.out.printf("%-8d %-20s %-8d%n", 
                                friend.userId, friend.name, friend.age);
            }
            current = current.next;
        }
    }
    
    // Count number of friends for each user
    public void displayFriendCounts() {
        if (head == null) {
            System.out.println("No users in the system!");
            return;
        }
        
        System.out.println("\n=== Friend Counts ===");
        System.out.printf("%-8s %-20s %-12s%n", "User ID", "Name", "Friend Count");
        System.out.println("----------------------------------------");
        
        UserNode current = head;
        while (current != null) {
            int friendCount = countFriends(current);
            System.out.printf("%-8d %-20s %-12d%n", 
                            current.userId, current.name, friendCount);
            current = current.next;
        }
    }
    
    // Helper method to count friends
    private int countFriends(UserNode user) {
        int count = 0;
        FriendIdNode current = user.friends;
        
        while (current != null) {
            count++;
            current = current.next;
        }
        
        return count;
    }
    
    // Search for user by Name or User ID
    public void searchUser(String searchTerm) {
        if (head == null) {
            System.out.println("No users in the system!");
            return;
        }
        
        System.out.println("\nSearching for: '" + searchTerm + "'");
        System.out.printf("%-8s %-20s %-8s%n", "User ID", "Name", "Age");
        System.out.println("--------------------------------");
        
        UserNode current = head;
        boolean found = false;
        
        while (current != null) {
            if (current.name.toLowerCase().contains(searchTerm.toLowerCase()) ||
                String.valueOf(current.userId).contains(searchTerm)) {
                System.out.printf("%-8d %-20s %-8d%n", 
                                current.userId, current.name, current.age);
                found = true;
            }
            current = current.next;
        }
        
        if (!found) {
            System.out.println("No users found matching '" + searchTerm + "'");
        }
    }
    
    // Display all users
    public void displayAllUsers() {
        if (head == null) {
            System.out.println("No users in the system!");
            return;
        }
        
        System.out.println("\n=== All Users ===");
        System.out.printf("%-8s %-20s %-8s%n", "User ID", "Name", "Age");
        System.out.println("--------------------------------");
        
        UserNode current = head;
        while (current != null) {
            System.out.printf("%-8d %-20s %-8d%n", 
                            current.userId, current.name, current.age);
            current = current.next;
        }
        System.out.println("Total Users: " + size);
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

// Main class to demonstrate the Social Media Friend Connections
public class SocialMediaFriendConnections {
    public static void main(String[] args) {
        System.out.println("=== Social Media Friend Connections ===\n");
        
        SocialMediaLinkedList socialMedia = new SocialMediaLinkedList();
        
        // Adding users
        System.out.println("Adding users...");
        socialMedia.addUserAtEnd(1, "John Doe", 25);
        socialMedia.addUserAtEnd(2, "Jane Smith", 30);
        socialMedia.addUserAtEnd(3, "Bob Wilson", 28);
        socialMedia.addUserAtEnd(4, "Alice Johnson", 22);
        socialMedia.addUserAtEnd(5, "Charlie Brown", 35);
        socialMedia.addUserAtEnd(6, "Diana Prince", 27);
        
        // Display all users
        socialMedia.displayAllUsers();
        
        // Add friend connections
        System.out.println("\n=== Adding Friend Connections ===");
        socialMedia.addFriendConnection(1, 2);
        socialMedia.addFriendConnection(1, 3);
        socialMedia.addFriendConnection(2, 3);
        socialMedia.addFriendConnection(2, 4);
        socialMedia.addFriendConnection(3, 4);
        socialMedia.addFriendConnection(3, 5);
        socialMedia.addFriendConnection(4, 5);
        socialMedia.addFriendConnection(4, 6);
        socialMedia.addFriendConnection(5, 6);
        
        // Display friend counts
        socialMedia.displayFriendCounts();
        
        // Display friends of specific users
        socialMedia.displayUserFriends(1);
        socialMedia.displayUserFriends(3);
        
        // Find mutual friends
        System.out.println("\n=== Finding Mutual Friends ===");
        List<Integer> mutualFriends = socialMedia.findMutualFriends(1, 4);
        System.out.println("Mutual friends between User 1 and User 4:");
        if (mutualFriends.isEmpty()) {
            System.out.println("No mutual friends found.");
        } else {
            for (int friendId : mutualFriends) {
                System.out.println("User " + friendId);
            }
        }
        
        // Search for users
        System.out.println("\n=== Searching Users ===");
        socialMedia.searchUser("john");
        socialMedia.searchUser("3");
        
        // Remove friend connection
        System.out.println("\n=== Removing Friend Connection ===");
        socialMedia.removeFriendConnection(1, 3);
        
        // Display updated friend counts
        socialMedia.displayFriendCounts();
        
        // Test edge cases
        System.out.println("\n=== Testing Edge Cases ===");
        socialMedia.addFriendConnection(1, 1); // Self-friendship
        socialMedia.addFriendConnection(1, 2); // Already friends
        socialMedia.addFriendConnection(1, 999); // Non-existent user
        socialMedia.removeFriendConnection(1, 999); // Non-existent user
        
        // Display final state
        socialMedia.displayAllUsers();
        socialMedia.displayFriendCounts();
    }
} 