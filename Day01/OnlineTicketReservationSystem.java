class Ticket{
    Node head;
    Node tail;
    int totalTickets;

    static class Node{
        int ticketID;
        String customerName;
        String movieName;
        String seatNumber;
        String bookingTime;
        Node next;

        public Node(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
            this.ticketID = ticketID;
            this.customerName = customerName;
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.bookingTime = bookingTime;
            this.next = null;
        }
    }

    // method to add tickets

    void addTicket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime){

        Node node = new Node(ticketID, customerName, movieName, seatNumber, bookingTime);

        if(head == null){
            head = tail = node;
            tail.next = head;
        }

        else{
            tail.next = node;
            tail = node;
            tail.next = head;
        }
        totalTickets++;
        System.out.println("Ticket Booked.");

    }

    // method to delete ticket

    void removeTicket(int ticketID) {
        if (head == null) {
            System.out.println("Empty list");
            return;
        }

        Node current = head;
        Node previous = tail;
        do {
            if (current.ticketID == ticketID) {
                if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else if (current == tail) {
                    tail = previous;
                    tail.next = head;
                } else {
                    previous.next = current.next;
                }
                totalTickets--;
                System.out.println("Ticket removed.");
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);

        System.out.println("Ticket not found");
    }

    // Display the current tickets in the list
    void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked yet");
            return;
        }

        Node current = head;

        do {
            System.out.println("Ticket ID: " + current.ticketID + ", Customer Name: " + current.customerName + ", Movie Name: " + current.movieName + ", Seat: " + current.seatNumber + ", Booking Time: " + current.bookingTime);
            current = current.next;
        } while (current != head);
    }

    // Search for a ticket by Customer Name or Movie Name
    void searchTicket(String keyword) {
        if (head == null) {
            System.out.println("No tickets booked yet.");
            return;
        }

        Node current = head;
        boolean found = false;
        do {
            if (current.customerName.equalsIgnoreCase(keyword) || current.movieName.equalsIgnoreCase(keyword)) {
                System.out.println("Ticket ID: " + current.ticketID + ", Customer Name: " + current.customerName + ", Movie Name: " + current.movieName + ", Seat: " + current.seatNumber + ", Booking Time: " + current.bookingTime);
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("Ticket not found");
        }
    }

    // total number of booked tickets
    public int getTotalTickets() {
        return totalTickets;
    }
}

public class OnlineTicketReservationSystem {
    public static void main(String[] args) {
        Ticket system = new Ticket();

        // Adding tickets
        system.addTicket(1, "Anshik", "Avatar", "A1", "12:12");
        system.addTicket(2, "Aayush", "Titanic", "B2", "01:01");
        system.addTicket(3, "Durgesh", "Avatar", "A2", "03:30");

        // Displaying tickets
        system.displayTickets();

        // Searching for a ticket
        system.searchTicket("Avatar");

        // Removing a ticket
        system.removeTicket(2);

        // Displaying tickets after removal
        system.displayTickets();

        // Total tickets count
        System.out.println("\nTotal number of tickets: " + system.getTotalTickets());
    }
}
