// Task Scheduler using Circular Linked List
// Demonstrates: Circular Linked List operations - Insert, Delete, Search, Traverse, Display

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Node class for Task
class TaskNode {
    int taskId;
    String taskName;
    int priority; // 1 = High, 2 = Medium, 3 = Low
    LocalDate dueDate;
    TaskNode next;
    
    public TaskNode(int taskId, String taskName, int priority, LocalDate dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

// Circular Linked List class for Task Scheduler
class TaskLinkedList {
    private TaskNode head;
    private TaskNode currentTask;
    private int size;
    
    public TaskLinkedList() {
        this.head = null;
        this.currentTask = null;
        this.size = 0;
    }
    
    // Add task at the beginning
    public void addAtBeginning(int taskId, String taskName, int priority, LocalDate dueDate) {
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        
        if (head == null) {
            head = newNode;
            newNode.next = head; // Point to itself
            currentTask = head;
        } else {
            // Find the last node
            TaskNode last = head;
            while (last.next != head) {
                last = last.next;
            }
            
            newNode.next = head;
            last.next = newNode;
            head = newNode;
        }
        size++;
        System.out.println("Task added at the beginning successfully!");
    }
    
    // Add task at the end
    public void addAtEnd(int taskId, String taskName, int priority, LocalDate dueDate) {
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        
        if (head == null) {
            head = newNode;
            newNode.next = head; // Point to itself
            currentTask = head;
        } else {
            // Find the last node
            TaskNode last = head;
            while (last.next != head) {
                last = last.next;
            }
            
            last.next = newNode;
            newNode.next = head;
        }
        size++;
        System.out.println("Task added at the end successfully!");
    }
    
    // Add task at specific position
    public void addAtPosition(int position, int taskId, String taskName, int priority, LocalDate dueDate) {
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position!");
            return;
        }
        
        if (position == 1) {
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }
        
        if (position == size + 1) {
            addAtEnd(taskId, taskName, priority, dueDate);
            return;
        }
        
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        TaskNode current = head;
        
        for (int i = 1; i < position - 1; i++) {
            current = current.next;
        }
        
        newNode.next = current.next;
        current.next = newNode;
        size++;
        System.out.println("Task added at position " + position + " successfully!");
    }
    
    // Remove task by Task ID
    public boolean removeByTaskId(int taskId) {
        if (head == null) {
            System.out.println("List is empty!");
            return false;
        }
        
        // If head is the only node
        if (head.next == head && head.taskId == taskId) {
            head = null;
            currentTask = null;
            size--;
            System.out.println("Task with ID " + taskId + " removed successfully!");
            return true;
        }
        
        // If head is to be removed
        if (head.taskId == taskId) {
            TaskNode last = head;
            while (last.next != head) {
                last = last.next;
            }
            last.next = head.next;
            head = head.next;
            if (currentTask.taskId == taskId) {
                currentTask = head;
            }
            size--;
            System.out.println("Task with ID " + taskId + " removed successfully!");
            return true;
        }
        
        // Find the task to remove
        TaskNode current = head;
        while (current.next != head && current.next.taskId != taskId) {
            current = current.next;
        }
        
        if (current.next != head) {
            if (currentTask.taskId == taskId) {
                currentTask = current.next.next;
            }
            current.next = current.next.next;
            size--;
            System.out.println("Task with ID " + taskId + " removed successfully!");
            return true;
        } else {
            System.out.println("Task with ID " + taskId + " not found!");
            return false;
        }
    }
    
    // View current task
    public void viewCurrentTask() {
        if (currentTask == null) {
            System.out.println("No tasks in the scheduler!");
            return;
        }
        
        System.out.println("\n=== Current Task ===");
        displayTask(currentTask);
    }
    
    // Move to next task
    public void moveToNextTask() {
        if (currentTask == null) {
            System.out.println("No tasks in the scheduler!");
            return;
        }
        
        currentTask = currentTask.next;
        System.out.println("Moved to next task!");
        viewCurrentTask();
    }
    
    // Search tasks by priority
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        
        String priorityName = getPriorityName(priority);
        System.out.println("\nTasks with Priority '" + priorityName + "':");
        System.out.printf("%-8s %-25s %-12s %-12s%n", "Task ID", "Task Name", "Priority", "Due Date");
        System.out.println("------------------------------------------------------------");
        
        TaskNode current = head;
        boolean found = false;
        
        do {
            if (current.priority == priority) {
                System.out.printf("%-8d %-25s %-12s %-12s%n", 
                                current.taskId, current.taskName, 
                                getPriorityName(current.priority), 
                                current.dueDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                found = true;
            }
            current = current.next;
        } while (current != head);
        
        if (!found) {
            System.out.println("No tasks found with priority '" + priorityName + "'");
        }
    }
    
    // Display all tasks
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks in the scheduler!");
            return;
        }
        
        System.out.println("\n=== All Tasks ===");
        System.out.printf("%-8s %-25s %-12s %-12s%n", "Task ID", "Task Name", "Priority", "Due Date");
        System.out.println("------------------------------------------------------------");
        
        TaskNode current = head;
        do {
            System.out.printf("%-8d %-25s %-12s %-12s%n", 
                            current.taskId, current.taskName, 
                            getPriorityName(current.priority), 
                            current.dueDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            current = current.next;
        } while (current != head);
        
        System.out.println("Total Tasks: " + size);
    }
    
    // Helper method to display a single task
    private void displayTask(TaskNode task) {
        System.out.printf("%-8s %-25s %-12s %-12s%n", "Task ID", "Task Name", "Priority", "Due Date");
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-8d %-25s %-12s %-12s%n", 
                        task.taskId, task.taskName, 
                        getPriorityName(task.priority), 
                        task.dueDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }
    
    // Helper method to get priority name
    private String getPriorityName(int priority) {
        switch (priority) {
            case 1: return "High";
            case 2: return "Medium";
            case 3: return "Low";
            default: return "Unknown";
        }
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

// Main class to demonstrate the Task Scheduler
public class TaskScheduler {
    public static void main(String[] args) {
        System.out.println("=== Task Scheduler ===\n");
        
        TaskLinkedList taskList = new TaskLinkedList();
        
        // Adding tasks at different positions
        System.out.println("Adding tasks...");
        taskList.addAtEnd(101, "Complete Project Report", 1, LocalDate.of(2024, 1, 15));
        taskList.addAtEnd(102, "Review Code", 2, LocalDate.of(2024, 1, 20));
        taskList.addAtBeginning(100, "Urgent Bug Fix", 1, LocalDate.of(2024, 1, 10));
        taskList.addAtPosition(2, 103, "Team Meeting", 2, LocalDate.of(2024, 1, 18));
        taskList.addAtEnd(104, "Update Documentation", 3, LocalDate.of(2024, 1, 25));
        taskList.addAtEnd(105, "Client Presentation", 1, LocalDate.of(2024, 1, 12));
        
        // Display all tasks
        taskList.displayAllTasks();
        
        // View current task
        System.out.println("\n=== Current Task ===");
        taskList.viewCurrentTask();
        
        // Move to next task
        System.out.println("\n=== Moving to Next Task ===");
        taskList.moveToNextTask();
        taskList.moveToNextTask();
        
        // Search by priority
        System.out.println("\n=== Searching by Priority ===");
        taskList.searchByPriority(1); // High priority tasks
        
        // Remove a task
        System.out.println("\n=== Removing Task ===");
        taskList.removeByTaskId(102);
        
        // Display updated list
        taskList.displayAllTasks();
        
        // Test circular navigation
        System.out.println("\n=== Testing Circular Navigation ===");
        for (int i = 0; i < 8; i++) {
            taskList.moveToNextTask();
        }
        
        // Test edge cases
        System.out.println("\n=== Testing Edge Cases ===");
        taskList.removeByTaskId(999); // Non-existent task
        taskList.addAtPosition(10, 106, "Test Task", 2, LocalDate.of(2024, 1, 30)); // Invalid position
        taskList.addAtPosition(3, 106, "Valid Task", 2, LocalDate.of(2024, 1, 30)); // Valid position
        
        taskList.displayAllTasks();
    }
} 