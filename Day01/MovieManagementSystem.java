// DLL class to define operations on doubly linked list
class Dll{

    Node head;
    Node tail;

    static class Node{
        String movieTitle;
        String director;
        int yearOfRelease;
        float rating;
        Node next;
        Node prev;     // prev pointer to tract previous node

        Node(String movieTitle,  String director, int yearOfRelease, float rating){
            this.movieTitle = movieTitle;
            this.director = director;
            this.yearOfRelease = yearOfRelease;
            this.rating = rating;
        }

        public static void displayMovie(Node node){
            System.out.println("Movie Title : " + node.movieTitle);
            System.out.println("Director : " + node.director);
            System.out.println("Year of Release : " + node.yearOfRelease);
            System.out.println("Rating : " + node.rating);
            System.out.println();
        }
    }

    // method to add element at last index
    public void addLast(String movieTitle,  String director, int yearOfRelease, float rating){
        // creating a node
        Node node = new Node(movieTitle, director, yearOfRelease, rating);

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
    public void addFirst(String movieTitle,  String director, int yearOfRelease, float rating){
        // creating a node
        Node node = new Node(movieTitle, director, yearOfRelease, rating);

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
    public void add(String movieTitle,  String director, int yearOfRelease, float rating, int position){
        // creating a node
        Node node = new Node(movieTitle, director, yearOfRelease, rating);

        // index value to track the index of the linkedList
        int idx = 1;

        Node temp = head;

        while(idx < position-1){
            temp = temp.next;
            idx++;
        }

        if(temp == tail){
            addLast(movieTitle, director, yearOfRelease, rating);
            return;
        }

        node.next = temp.next;
        node.next.prev = node;
        temp.next = node;
        node.prev = temp;

    }

    // method to delete movie
    public void delete(String movieTitle){
        // if list is empty
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        // Case 1: Deleting the first node
        if (head.movieTitle.equals(movieTitle)) {
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

        while (temp.next != null && !temp.next.movieTitle.equals(movieTitle)) {
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

    // method to search roll number in list
    public void search(String director){
        Node temp = head;

        while(temp.next != null && !temp.director.equals(director)){
            temp = temp.next;
        }

        if(temp.next != null){
            System.out.println("Record Found");
            Node.displayMovie(temp);
        }

        else{
            System.out.println("Record doesn't exist");
        }
    }

    // method to upgrade rating of movies
    public void updateRating(String movieTitle, float rating){
        Node temp = head;

        while(temp.next != null && !temp.movieTitle.equals(movieTitle)){
            temp = temp.next;
        }

        if(temp.movieTitle.equals(movieTitle)){
            System.out.println("Record Found");
            temp.rating = rating;
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


public class MovieManagementSystem {
    public static void main(String[] args) {

        // creating doubly linked list
        Dll dll = new Dll();

        // add elements in last
        dll.addLast("Fidda", "Aayush", 2020, 2);
        dll.addLast("Karan Arjun", "Anshik", 2000, 8);

        // add elements in first
        dll.addFirst("HouseFul", "Varsha", 2014, 9);

        // add element at specific index
        dll.add("Dhoom", "Ansh", 2012, 7, 2);

        // delete element
        dll.delete("Dhoom");

        // search element
        dll.search("Varsha");

        //update rating
        dll.updateRating("Karan Arjun", 10);

        // print nodes in forward direction
        dll.displayRecordForward();

        // print nodes in backward direction
        dll.displayRecordBackward();

    }

}
