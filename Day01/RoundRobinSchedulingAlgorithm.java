class LL2{
    // creating head of the linkedList
    Node head;
    Node tail;

    static class Node{
        int processID;
        double burstTime;
        int priority;    // priority is from 1-10;
        Node next;

        Node(int processID, double burstTime, int priority){
            this.processID = processID;
            this.burstTime = burstTime;
            this.priority = priority;
        }

        // Method to display a single node
        static void displayNode(Node node){
            System.out.println("Process Id : " + node.processID);
            System.out.println("Burst Time : " + node.burstTime);
            System.out.println("Priority : " + node.priority);
            System.out.println();
        }
    }

    // method to add element at the last
    public void addLast(int processID, double burstTime, int priority){
        // creating a node
        Node node = new Node(processID, burstTime, priority);

        if(head == null){
            head = tail = node;
            tail.next = head;
            return;
        }

        tail.next = node;
        node.next = head;
        tail = node;
    }

    // method to remove task by task id
    public void remove(int processID){

        // if no task is present in the list
        if(head == null){
            System.out.println("Empty list. Nothing to remove.");
            return;
        }

        // if we want to remove head
        if(head.processID == processID){

            if(head == tail){
                head = tail = null;
            }
            else{
                head = head.next;
                tail.next = head;
            }
            return;
        }

        Node temp = head;

        while (temp.next != head && temp.next.processID != processID) {
            temp = temp.next;
        }

        if(temp.next == head){
            System.out.println("Recode not found.");
            return;
        }

        // removing tail
        if (temp.next == tail) {
            tail = temp;
            tail.next = head;
        } else {
            temp.next = temp.next.next; // Bypass the node
        }

    }

    // Simulate Round Robin Scheduling
    public void simulateRoundRobin(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to execute.");
            return;
        }

        Node current = head;
        int totalWaitingTime = 0;
        int totalTurnAroundTime = 0;
        int completedProcesses = 0;

        System.out.println("Simulating Round Robin Scheduling:");
        while (head != null) {
            System.out.println("Executing Process " + current.processID + " with Burst Time " + current.burstTime);

            if (current.burstTime <= timeQuantum) { // Process finishes in this cycle
                totalTurnAroundTime += completedProcesses * timeQuantum + current.burstTime;
                totalWaitingTime += completedProcesses * timeQuantum;
                int processID = current.processID;
                current = current.next; // Move to the next process
                remove(processID); // Remove the completed process
                completedProcesses++;
            } else { // Process requires more time
                current.burstTime -= timeQuantum;
                current = current.next; // Move to the next process
            }

            displayProcesses(); // Display the queue after each round
        }

        System.out.println("\nAverage Waiting Time: " + (double) totalWaitingTime / completedProcesses);
        System.out.println("Average Turn-Around Time: " + (double) totalTurnAroundTime / completedProcesses);
    }

    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        Node current = head;
        System.out.println("Processes in the queue:");
        do {
            System.out.println("Process ID: " + current.processID + ", Burst Time: " + current.burstTime
                    + ", Priority: " + current.priority);
            current = current.next;
        } while (current != head);
    }
}
public class RoundRobinSchedulingAlgorithm {
    public static void main(String[] args) {
        // creating object of linked list
        LL2 ll = new LL2();

        // Add processes
        ll.addLast(1, 10.0, 3);
        ll.addLast(2, 5.0, 2);
        ll.addLast(3, 8.0, 1);

        // Display initial processes
        System.out.println("Initial Processes:");
        ll.displayProcesses();

        // Simulate Round Robin Scheduling with a time quantum of 4
        System.out.println("\nStarting Round Robin Scheduling with Time Quantum = 2:");
        ll.simulateRoundRobin(2);
    }
}
