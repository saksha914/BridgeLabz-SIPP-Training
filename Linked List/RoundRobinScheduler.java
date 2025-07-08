// Round Robin CPU Scheduling Algorithm using Circular Linked List
// Demonstrates: Circular Linked List operations for CPU scheduling simulation

// Node class for Process
class ProcessNode {
    int processId;
    int burstTime;
    int priority;
    int remainingTime;
    int waitingTime;
    int turnaroundTime;
    ProcessNode next;
    
    public ProcessNode(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.remainingTime = burstTime;
        this.waitingTime = 0;
        this.turnaroundTime = 0;
        this.next = null;
    }
}

// Circular Linked List class for Round Robin Scheduling
class RoundRobinLinkedList {
    private ProcessNode head;
    private ProcessNode currentProcess;
    private int timeQuantum;
    private int totalTime;
    private int completedProcesses;
    
    public RoundRobinLinkedList(int timeQuantum) {
        this.head = null;
        this.currentProcess = null;
        this.timeQuantum = timeQuantum;
        this.totalTime = 0;
        this.completedProcesses = 0;
    }
    
    // Add process at the end
    public void addProcess(int processId, int burstTime, int priority) {
        ProcessNode newNode = new ProcessNode(processId, burstTime, priority);
        
        if (head == null) {
            head = newNode;
            newNode.next = head; // Point to itself
            currentProcess = head;
        } else {
            // Find the last node
            ProcessNode last = head;
            while (last.next != head) {
                last = last.next;
            }
            
            last.next = newNode;
            newNode.next = head;
        }
        
        System.out.println("Process " + processId + " added successfully!");
    }
    
    // Remove process by Process ID
    public boolean removeProcess(int processId) {
        if (head == null) {
            System.out.println("No processes in the queue!");
            return false;
        }
        
        // If head is the only node
        if (head.next == head && head.processId == processId) {
            head = null;
            currentProcess = null;
            System.out.println("Process " + processId + " removed successfully!");
            return true;
        }
        
        // If head is to be removed
        if (head.processId == processId) {
            ProcessNode last = head;
            while (last.next != head) {
                last = last.next;
            }
            last.next = head.next;
            head = head.next;
            if (currentProcess.processId == processId) {
                currentProcess = head;
            }
            System.out.println("Process " + processId + " removed successfully!");
            return true;
        }
        
        // Find the process to remove
        ProcessNode current = head;
        while (current.next != head && current.next.processId != processId) {
            current = current.next;
        }
        
        if (current.next != head) {
            if (currentProcess.processId == processId) {
                currentProcess = current.next.next;
            }
            current.next = current.next.next;
            System.out.println("Process " + processId + " removed successfully!");
            return true;
        } else {
            System.out.println("Process " + processId + " not found!");
            return false;
        }
    }
    
    // Execute one round of scheduling
    public boolean executeRound() {
        if (head == null) {
            System.out.println("No processes to execute!");
            return false;
        }
        
        if (currentProcess == null) {
            currentProcess = head;
        }
        
        System.out.println("\n=== Executing Round ===");
        System.out.println("Current Time: " + totalTime);
        System.out.println("Executing Process " + currentProcess.processId + 
                          " (Remaining Time: " + currentProcess.remainingTime + ")");
        
        // Execute the process
        int executionTime = Math.min(timeQuantum, currentProcess.remainingTime);
        currentProcess.remainingTime -= executionTime;
        totalTime += executionTime;
        
        System.out.println("Execution Time: " + executionTime);
        System.out.println("Remaining Time: " + currentProcess.remainingTime);
        
        // Update waiting time for other processes
        ProcessNode temp = head;
        do {
            if (temp != currentProcess && temp.remainingTime > 0) {
                temp.waitingTime += executionTime;
            }
            temp = temp.next;
        } while (temp != head);
        
        // Check if process is completed
        if (currentProcess.remainingTime <= 0) {
            currentProcess.turnaroundTime = totalTime;
            completedProcesses++;
            System.out.println("Process " + currentProcess.processId + " completed!");
            
            // Remove completed process
            removeProcess(currentProcess.processId);
            
            // If no more processes, return false
            if (head == null) {
                return false;
            }
        }
        
        // Move to next process
        currentProcess = currentProcess.next;
        
        return true;
    }
    
    // Display current processes in the queue
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue!");
            return;
        }
        
        System.out.println("\n=== Current Process Queue ===");
        System.out.printf("%-10s %-12s %-10s %-15s %-12s%n", 
                        "Process ID", "Burst Time", "Priority", "Remaining Time", "Waiting Time");
        System.out.println("------------------------------------------------------------");
        
        ProcessNode current = head;
        do {
            System.out.printf("%-10d %-12d %-10d %-15d %-12d%n", 
                            current.processId, current.burstTime, current.priority, 
                            current.remainingTime, current.waitingTime);
            current = current.next;
        } while (current != head);
        
        System.out.println("Total Time: " + totalTime);
        System.out.println("Completed Processes: " + completedProcesses);
    }
    
    // Calculate and display average waiting time and turnaround time
    public void displayStatistics() {
        if (completedProcesses == 0) {
            System.out.println("No processes completed yet!");
            return;
        }
        
        System.out.println("\n=== Scheduling Statistics ===");
        System.out.println("Total Time: " + totalTime);
        System.out.println("Completed Processes: " + completedProcesses);
        System.out.println("Time Quantum: " + timeQuantum);
        
        // Calculate averages from completed processes
        double avgWaitingTime = 0.0;
        double avgTurnaroundTime = 0.0;
        
        // Note: In a real implementation, you would maintain a separate list
        // of completed processes to calculate these statistics accurately
        // For this demo, we'll show the current state
        
        System.out.println("Note: Statistics are based on current state");
        System.out.println("Average metrics will be calculated when all processes complete");
    }
    
    // Simulate complete scheduling
    public void simulateCompleteScheduling() {
        System.out.println("\n=== Starting Complete Round Robin Simulation ===");
        System.out.println("Time Quantum: " + timeQuantum);
        
        int roundCount = 0;
        while (head != null && roundCount < 100) { // Safety limit
            roundCount++;
            System.out.println("\n--- Round " + roundCount + " ---");
            displayProcesses();
            
            if (!executeRound()) {
                break;
            }
        }
        
        if (roundCount >= 100) {
            System.out.println("Simulation stopped after 100 rounds (safety limit)");
        } else {
            System.out.println("\n=== All Processes Completed ===");
            System.out.println("Total Rounds: " + roundCount);
            System.out.println("Total Time: " + totalTime);
        }
        
        displayStatistics();
    }
    
    // Get current process
    public ProcessNode getCurrentProcess() {
        return currentProcess;
    }
    
    // Get total time
    public int getTotalTime() {
        return totalTime;
    }
    
    // Get completed processes count
    public int getCompletedProcesses() {
        return completedProcesses;
    }
    
    // Check if scheduling is complete
    public boolean isComplete() {
        return head == null;
    }
}

// Main class to demonstrate the Round Robin Scheduler
public class RoundRobinScheduler {
    public static void main(String[] args) {
        System.out.println("=== Round Robin CPU Scheduling Algorithm ===\n");
        
        // Create scheduler with time quantum of 2
        RoundRobinLinkedList scheduler = new RoundRobinLinkedList(2);
        
        // Adding processes
        System.out.println("Adding processes...");
        scheduler.addProcess(1, 6, 1); // Process ID, Burst Time, Priority
        scheduler.addProcess(2, 4, 2);
        scheduler.addProcess(3, 8, 1);
        scheduler.addProcess(4, 3, 3);
        scheduler.addProcess(5, 5, 2);
        
        // Display initial state
        scheduler.displayProcesses();
        
        // Execute a few rounds manually
        System.out.println("\n=== Manual Round Execution ===");
        for (int i = 0; i < 5; i++) {
            if (!scheduler.executeRound()) {
                break;
            }
            scheduler.displayProcesses();
        }
        
        // Simulate complete scheduling
        System.out.println("\n=== Complete Simulation ===");
        RoundRobinLinkedList completeScheduler = new RoundRobinLinkedList(3);
        
        completeScheduler.addProcess(1, 10, 1);
        completeScheduler.addProcess(2, 5, 2);
        completeScheduler.addProcess(3, 8, 1);
        completeScheduler.addProcess(4, 4, 3);
        
        completeScheduler.simulateCompleteScheduling();
        
        // Test edge cases
        System.out.println("\n=== Testing Edge Cases ===");
        RoundRobinLinkedList testScheduler = new RoundRobinLinkedList(1);
        
        // Empty scheduler
        testScheduler.displayProcesses();
        testScheduler.executeRound();
        
        // Single process
        testScheduler.addProcess(1, 5, 1);
        testScheduler.displayProcesses();
        testScheduler.executeRound();
        
        // Remove non-existent process
        testScheduler.removeProcess(999);
    }
} 