// defining circular linked list class
class CLL{

    // creating head of the linkedList
    Node head;
    Node tail;
    static class Node{
        int taskID;
        String taskName;
        boolean priority;    // priority is from 1-10;
        String dueDate;
        Node next;

        Node(int taskID, String taskName, boolean priority, String dueDate){
            this.taskID = taskID;
            this.taskName = taskName;
            this.priority = priority;
            this.dueDate = dueDate;
        }

        // Method to display a single node
        static void displayNode(Node node){
            System.out.println("Task Id : " + node.taskID);
            System.out.println("Task name : " + node.taskName);
            System.out.println("Task Priority : " + node.priority);
            System.out.println("Task dueDate : " + node.dueDate);
            System.out.println();
        }
    }

    // method to add element at the last
    public void addLast(int taskID, String taskName, boolean priority, String dueDate){
        // creating a node
        Node node = new Node(taskID, taskName, priority, dueDate);

        if(head == null){
            head = tail = node;
            tail.next = head;
            return;
        }

        tail.next = node;
        node.next = head;
        tail = node;
    }

    // method to add element at first
    public void addFirst(int taskID, String taskName, boolean priority, String dueDate){
        // creating a node
        Node node = new Node(taskID, taskName, priority, dueDate);

        if(head == null){
            head = tail = node;
            tail.next = head;
            return;
        }

        node.next = head;
        head = node;
        tail.next = head;

    }

    // Method to element on specific position
    public void add(int taskID, String taskName, boolean priority, String dueDate, int position){
        // invalid position
        if (position < 1) {
            System.out.println("Invalid position.");
            return;
        }

        if (position == 1) {
            addFirst(taskID, taskName, priority, dueDate);
            return;
        }

        // creating a node
        Node node = new Node(taskID, taskName, priority, dueDate);

        int idx = 1;
        Node temp = head;

        while(idx < position-1 && temp.next != head){
            temp = temp.next;
            idx++;
        }

        if(temp == null || temp.next == head){
            System.out.println("Can't add in this position");
            return;
        }

        if(temp == tail){
            addLast(taskID, taskName, priority, dueDate);
            return;
        }

        node.next = temp.next;
        temp.next = node;
    }

    // method to remove task by task id
    public void remove(int taskId){

        // if no task is present in the list
        if(head == null){
            System.out.println("Empty list. Nothing to remove.");
            return;
        }

        // if we want to remove head
        if(head.taskID == taskId){

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

        while (temp.next != head && temp.next.taskID != taskId) {
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

    // method to search task by priority
    public void priorityTask(){
        // if no task is present in the list
        if(head == null){
            System.out.println("No tsk in the list");
            return;
        }

        Node temp = head;

        System.out.println("Priority task are listed below : ");

        // using do-while loop to avoid infinite loop
        do {
            if (temp.priority) {
                Node.displayNode(temp);
            }
            temp = temp.next;
        } while (temp != head);

    }

    // method to display all elements
    public void displayTasks(){

        if(head == null){
            System.out.println("Empty list");
            return;
        }

        Node temp = head;

        // using do-while loop to avoid infinite loop
        do {
            Node.displayNode(temp);
            temp = temp.next;
        }while(temp != head);

    }
}

// Main class
public class TaskScheduler {
    public static void main(String[] args) {

        // creating object of circular linked list
        CLL cll = new CLL();

        // methods to add elements at the last
        cll.addLast(101, "Walk a dog", true, "29-01-2025");
        cll.addLast(102, "Buy groceries", false, "29-01-2025");

        // method to add elements at first
        cll.addFirst(103, "Study", true, "30-01-2025");

        // add element at specific position
        cll.add(104, "Journal", false, "29-01-2024",2);

        // remove node with taskId given below
        cll.remove(104);

        // view priority task
        cll.priorityTask();

        // display elements
        cll.displayTasks();
    }
}
