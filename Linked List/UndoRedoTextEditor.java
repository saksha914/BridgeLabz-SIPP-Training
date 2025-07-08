// Undo/Redo Functionality for Text Editor using Doubly Linked List
// Demonstrates: Doubly Linked List operations for undo/redo history management

// Node class for Text State
class TextStateNode {
    String textContent;
    String action; // Type of action (typing, deletion, etc.)
    TextStateNode next;
    TextStateNode prev;
    
    public TextStateNode(String textContent, String action) {
        this.textContent = textContent;
        this.action = action;
        this.next = null;
        this.prev = null;
    }
}

// Doubly Linked List class for Undo/Redo Text Editor
class UndoRedoLinkedList {
    private TextStateNode head;
    private TextStateNode tail;
    private TextStateNode currentState;
    private int maxHistorySize;
    private int size;
    
    public UndoRedoLinkedList(int maxHistorySize) {
        this.head = null;
        this.tail = null;
        this.currentState = null;
        this.maxHistorySize = maxHistorySize;
        this.size = 0;
    }
    
    // Add new text state
    public void addTextState(String textContent, String action) {
        TextStateNode newNode = new TextStateNode(textContent, action);
        
        // If this is the first state
        if (head == null) {
            head = tail = newNode;
            currentState = newNode;
        } else {
            // Remove any states after current state (for redo)
            if (currentState != tail) {
                removeStatesAfter(currentState);
            }
            
            // Add new state after current state
            newNode.prev = currentState;
            newNode.next = currentState.next;
            if (currentState.next != null) {
                currentState.next.prev = newNode;
            } else {
                tail = newNode;
            }
            currentState.next = newNode;
            currentState = newNode;
        }
        
        size++;
        
        // Maintain history size limit
        if (size > maxHistorySize) {
            removeOldestState();
        }
        
        System.out.println("Text state added: " + action);
    }
    
    // Remove states after a given state (for redo functionality)
    private void removeStatesAfter(TextStateNode state) {
        if (state.next == null) {
            return; // No states to remove
        }
        
        TextStateNode current = state.next;
        int removedCount = 0;
        
        while (current != null) {
            TextStateNode next = current.next;
            current.next = null;
            current.prev = null;
            current = next;
            removedCount++;
        }
        
        state.next = null;
        tail = state;
        size -= removedCount;
    }
    
    // Remove oldest state when history limit is exceeded
    private void removeOldestState() {
        if (head == null) {
            return;
        }
        
        TextStateNode oldHead = head;
        head = head.next;
        
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
            currentState = null;
        }
        
        oldHead.next = null;
        oldHead.prev = null;
        size--;
    }
    
    // Undo functionality
    public boolean undo() {
        if (currentState == null || currentState.prev == null) {
            System.out.println("Nothing to undo!");
            return false;
        }
        
        currentState = currentState.prev;
        System.out.println("Undo: " + currentState.action);
        System.out.println("Current text: " + currentState.textContent);
        return true;
    }
    
    // Redo functionality
    public boolean redo() {
        if (currentState == null || currentState.next == null) {
            System.out.println("Nothing to redo!");
            return false;
        }
        
        currentState = currentState.next;
        System.out.println("Redo: " + currentState.action);
        System.out.println("Current text: " + currentState.textContent);
        return true;
    }
    
    // Display current state
    public void displayCurrentState() {
        if (currentState == null) {
            System.out.println("No text state available!");
            return;
        }
        
        System.out.println("\n=== Current Text State ===");
        System.out.println("Action: " + currentState.action);
        System.out.println("Text: " + currentState.textContent);
        System.out.println("History Size: " + size + "/" + maxHistorySize);
    }
    
    // Display all states in forward order
    public void displayForwardHistory() {
        if (head == null) {
            System.out.println("No text history available!");
            return;
        }
        
        System.out.println("\n=== Forward History ===");
        System.out.printf("%-15s %-30s%n", "Action", "Text Content");
        System.out.println("----------------------------------------");
        
        TextStateNode current = head;
        int stateNumber = 1;
        
        while (current != null) {
            String marker = (current == currentState) ? " [CURRENT]" : "";
            String displayText = current.textContent.length() > 25 ? 
                               current.textContent.substring(0, 22) + "..." : 
                               current.textContent;
            
            System.out.printf("%-15s %-30s%s%n", 
                            current.action, displayText, marker);
            current = current.next;
            stateNumber++;
        }
    }
    
    // Display all states in reverse order
    public void displayReverseHistory() {
        if (tail == null) {
            System.out.println("No text history available!");
            return;
        }
        
        System.out.println("\n=== Reverse History ===");
        System.out.printf("%-15s %-30s%n", "Action", "Text Content");
        System.out.println("----------------------------------------");
        
        TextStateNode current = tail;
        int stateNumber = 1;
        
        while (current != null) {
            String marker = (current == currentState) ? " [CURRENT]" : "";
            String displayText = current.textContent.length() > 25 ? 
                               current.textContent.substring(0, 22) + "..." : 
                               current.textContent;
            
            System.out.printf("%-15s %-30s%s%n", 
                            current.action, displayText, marker);
            current = current.prev;
            stateNumber++;
        }
    }
    
    // Get current text content
    public String getCurrentText() {
        return currentState != null ? currentState.textContent : "";
    }
    
    // Get current action
    public String getCurrentAction() {
        return currentState != null ? currentState.action : "";
    }
    
    // Check if undo is possible
    public boolean canUndo() {
        return currentState != null && currentState.prev != null;
    }
    
    // Check if redo is possible
    public boolean canRedo() {
        return currentState != null && currentState.next != null;
    }
    
    // Get history size
    public int getHistorySize() {
        return size;
    }
    
    // Get max history size
    public int getMaxHistorySize() {
        return maxHistorySize;
    }
    
    // Check if history is empty
    public boolean isEmpty() {
        return head == null;
    }
    
    // Clear all history
    public void clearHistory() {
        head = null;
        tail = null;
        currentState = null;
        size = 0;
        System.out.println("History cleared!");
    }
}

// Main class to demonstrate the Undo/Redo Text Editor
public class UndoRedoTextEditor {
    public static void main(String[] args) {
        System.out.println("=== Undo/Redo Text Editor ===\n");
        
        // Create text editor with max 10 states
        UndoRedoLinkedList textEditor = new UndoRedoLinkedList(10);
        
        // Simulate text editing actions
        System.out.println("=== Simulating Text Editing ===");
        textEditor.addTextState("", "Initial State");
        textEditor.addTextState("H", "Typed 'H'");
        textEditor.addTextState("He", "Typed 'e'");
        textEditor.addTextState("Hel", "Typed 'l'");
        textEditor.addTextState("Hell", "Typed 'l'");
        textEditor.addTextState("Hello", "Typed 'o'");
        textEditor.addTextState("Hello ", "Typed space");
        textEditor.addTextState("Hello W", "Typed 'W'");
        textEditor.addTextState("Hello Wo", "Typed 'o'");
        textEditor.addTextState("Hello Wor", "Typed 'r'");
        textEditor.addTextState("Hello Worl", "Typed 'l'");
        textEditor.addTextState("Hello World", "Typed 'd'");
        
        // Display current state
        textEditor.displayCurrentState();
        
        // Display forward history
        textEditor.displayForwardHistory();
        
        // Perform undo operations
        System.out.println("\n=== Performing Undo Operations ===");
        for (int i = 0; i < 3; i++) {
            textEditor.undo();
        }
        
        // Display current state after undo
        textEditor.displayCurrentState();
        
        // Perform redo operations
        System.out.println("\n=== Performing Redo Operations ===");
        for (int i = 0; i < 2; i++) {
            textEditor.redo();
        }
        
        // Display current state after redo
        textEditor.displayCurrentState();
        
        // Add more text after redo
        System.out.println("\n=== Adding More Text After Redo ===");
        textEditor.addTextState("Hello Worl!", "Typed '!'");
        textEditor.addTextState("Hello Worl! ", "Typed space");
        textEditor.addTextState("Hello Worl! H", "Typed 'H'");
        textEditor.addTextState("Hello Worl! Ho", "Typed 'o'");
        textEditor.addTextState("Hello Worl! How", "Typed 'w'");
        
        // Display forward history
        textEditor.displayForwardHistory();
        
        // Test undo/redo limits
        System.out.println("\n=== Testing Undo/Redo Limits ===");
        
        // Try to undo more than available
        System.out.println("Trying to undo multiple times:");
        for (int i = 0; i < 15; i++) {
            if (!textEditor.undo()) {
                break;
            }
        }
        
        // Try to redo more than available
        System.out.println("\nTrying to redo multiple times:");
        for (int i = 0; i < 15; i++) {
            if (!textEditor.redo()) {
                break;
            }
        }
        
        // Display reverse history
        textEditor.displayReverseHistory();
        
        // Test history size limit
        System.out.println("\n=== Testing History Size Limit ===");
        System.out.println("Current history size: " + textEditor.getHistorySize() + "/" + textEditor.getMaxHistorySize());
        
        // Add more states to test size limit
        for (int i = 0; i < 5; i++) {
            textEditor.addTextState("Hello Worl! How " + (i + 1), "Added text " + (i + 1));
        }
        
        System.out.println("After adding more states: " + textEditor.getHistorySize() + "/" + textEditor.getMaxHistorySize());
        textEditor.displayForwardHistory();
        
        // Test edge cases
        System.out.println("\n=== Testing Edge Cases ===");
        
        // Create empty editor
        UndoRedoLinkedList emptyEditor = new UndoRedoLinkedList(5);
        emptyEditor.undo(); // Should fail
        emptyEditor.redo(); // Should fail
        emptyEditor.displayCurrentState();
        
        // Test with single state
        emptyEditor.addTextState("Single state", "Initial");
        emptyEditor.undo(); // Should fail
        emptyEditor.redo(); // Should fail
        emptyEditor.displayCurrentState();
    }
} 