class TextEditor {

    static class Node{
        String text;
        Node prev;
        Node next;

        public Node(String text) {
            this.text = text;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;
    private Node current;
    private int size = 0;

    // method to add text
    public void addState(String newText) {
        Node newState = new Node(newText);

        if (head == null) {
            head = newState;
            current = head;
        }

        else {

            // remove all redo states
            current.next = null;

            // adding a new state
            newState.prev = current;
            current.next = newState;
            current = newState;
        }

        size++;
        // limit the size to 10
        int maxSize = 10;
        if (size > maxSize) {
            // Remove the oldest state
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    // Undo functionality
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        } else {
            System.out.println("No more actions to undo.");
        }
    }

    // Redo functionality
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        } else {
            System.out.println("No more actions to redo.");
        }
    }

    // Display the current state
    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current State: " + current.text);
        } else {
            System.out.println("No text available.");
        }
    }
}
public class UndoRedoFunctionality {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        // adding new states
        editor.addState("Hello");
        editor.addState("My name is ");
        editor.addState("Anshik Jaiswal");

        // display the current state
        editor.displayCurrentState();

        // performing undo operations
        editor.undo();
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        // performing redo operations
        editor.redo();
        editor.displayCurrentState();

        // adding a new state after undo
        editor.addState("New State Added");
        editor.displayCurrentState();

        editor.redo();
    }
}
