class LL1{
    Node head;
    Node tail;
    static int totalBook = 0;

    static class Node{
        String bookTitle;
        String author;
        String genre;
        int bookID;
        boolean availabilityStatus;
        Node next;
        Node prev;     // prev pointer to tract previous node

        Node(String bookTitle,  String author, String genre, int bookID, boolean availabilityStatus){
            this.bookTitle = bookTitle;
            this.author = author;
            this.genre = genre;
            this.bookID = bookID;
            this.availabilityStatus = availabilityStatus;
            totalBook += 1;
        }

        public static void displayMovie(Node node){
            System.out.println("Book Title : " + node.bookTitle);
            System.out.println("Author : " + node.author);
            System.out.println("Genre : " + node.genre);
            System.out.println("Book ID : " + node.bookID);
            System.out.println("Availability : " + node.availabilityStatus);
            System.out.println();
        }
    }

    // method to add element at last index
    public void addLast(String bookTitle,  String author, String genre, int bookID, boolean availabilityStatus){
        // creating a node
        Node node = new Node(bookTitle, author,genre, bookID, availabilityStatus);

        if(head == null){
            node.prev = node.next = null;
            head = node;
            head.next = tail;
            tail = head;
            return;
        }

        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }

        temp.next = node;
        node.prev = temp;
        tail = node;
    }

    // method to add element at first index
    public void addFirst(String bookTitle,  String author, String genre, int bookID, boolean availabilityStatus){
        // creating a node
        Node node = new Node(bookTitle, author,genre, bookID, availabilityStatus);

        node.next = head;
        node.prev = null;
        if(head != null){
            head.prev = node;
        }

        if (head == null){
            node.next = tail;
            tail.prev = node;
        }

        head = node;
    }

    // method to add element at specific index
    public void add(String bookTitle,  String author, String genre, int bookID, boolean availabilityStatus, int position){
        // creating a node
        Node node = new Node(bookTitle, author,genre, bookID, availabilityStatus);

        // index value to track the index of the linkedList
        int idx = 1;

        Node temp = head;

        while(idx < position-1){
            temp = temp.next;
            idx++;
        }

        if(temp == tail){
            addLast(bookTitle, author,genre, bookID, availabilityStatus);
            return;
        }

        node.next = temp.next;
        node.next.prev = node;
        temp.next = node;
        node.prev = temp;

    }

    // method to delete movie
    public void delete(int bookID){
        // if list is empty
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        // Case 1: Deleting the first node
        if (head.bookID == bookID) {
            head = head.next; // Move head forward

            if (head != null) {
                head.prev = null; // Update new head's prev pointer
            } else {
                tail = null; // If the list is now empty, update tail
            }

            System.out.println("Deleted the record");
            return;
        }

        // Case 2: Deleting a node in the middle or end
        Node temp = head;

        while (temp.next != null && temp.next.bookID != bookID) {
            temp = temp.next;
        }

        // If the movie is not found
        if (temp.next == null) {
            System.out.println("Movie title not found.");
            return;
        }

        // If deleting the last node
        if (temp.next == tail) {
            tail = temp;
            tail.next = null;
        } else {
            // Standard deletion
            temp.next = temp.next.next;
            if (temp.next != null) {
                temp.next.prev = temp; // Ensure the new next node points back to temp
            }
        }

        System.out.println("Deleted the record");
    }

    // method to search
    public void search(String author){
        Node temp = head;

        while(temp != null && !temp.author.equals(author)){
            temp = temp.next;
        }

        if(temp != null){
            System.out.println("Record Found");
            Node.displayMovie(temp);
        }

        else{
            System.out.println("Record doesn't exist");
        }
    }

    // method to update availability of book

    public void updateAvailability(String author, boolean availability){
        Node temp = head;

        while(temp.next != null && !temp.author.equals(author)){
            temp = temp.next;
        }

        if(temp.author.equals(author)){
            System.out.println("Record Found");
            temp.availabilityStatus = availability;
            Node.displayMovie(temp);
        }

        else{
            System.out.println("Record doesn't exist");
        }
    }

    // method to display record forward
    public void displayRecordForward(){
        Node temp = head;
        int i = 1;
        while(temp != null){
            System.out.println("Movie : " + i);
            Node.displayMovie(temp);
            temp = temp.next;
            i++;
        }
    }

    // method to display record backward
    public void displayRecordBackward(){
        Node temp = tail;

        while(temp != null){
            Node.displayMovie(temp);
            temp = temp.prev;
        }
    }

}

// Main class
public class LibraryManagementSystem {
    public static void main(String[] args) {

        // creating object of linked list
        LL1 ll = new LL1();

        // add nodes at last
        ll.addLast("Good vibes good life", "Vex king", "Self Help", 101, true);
        ll.addLast("Attitude is everything", "Jeff Keller", "Self Help", 102, true);

        // add nodes at first
        ll.addFirst("Alcamist", "Anshik", "Adventure",103, false);

        // add nodes at specific position
        ll.add("Wings on fire", "APJ abdul kalam", "Biograpghy", 104, true, 3);

        // delete node
        ll.delete(101);

        // search node
        ll.search("Jeff Keller");

        // update Availability of code
        ll.updateAvailability("Jeff Keller", false);

        // print record forward
        ll.displayRecordForward();

        // print record backward
        ll.displayRecordBackward();

    }

}
