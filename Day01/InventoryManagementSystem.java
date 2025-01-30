class LL{
    // creating a head
    Node head;
    static int totalAmount = 0;

    static class Node{

        String itemName;
        int itemID;
        int quantity;
        int price;
        Node next;

        // constructor to create a node
        Node(String itemName, int itemID, int quantity, int price){
            this.itemName = itemName;
            this.itemID = itemID;
            this.quantity = quantity;
            this.price = price;
            totalAmount += (price * quantity);
        }

        // method to display specific Node
        static void displayNode(Node node){

            System.out.println("Item name : " + node.itemName);
            System.out.println("Item ID : " + node.itemID);
            System.out.println("Item quantity " + node.quantity);
            System.out.println("Item price : " + node.price);
            System.out.println();

        }
    }

    // method to add element at last index
    public void addLast(String itemName, int itemID, int quantity, int price){

        // creating a node
        Node node = new Node(itemName, itemID, quantity, price);

        if(head == null){
            head = node;
            return;
        }

        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }

        temp.next = node;
    }

    // method to add element at first index
    public void addFirst(String itemName, int itemID, int quantity, int price){
        // creating a node
        Node node = new Node(itemName, itemID, quantity, price);

        node.next = head;
        head = node;
    }

    // method to add student at specific index
    public void add(String itemName, int itemID, int quantity, int price, int position){
        // creating a node
        Node node = new Node(itemName, itemID, quantity, price);

        // index value to track the index of the linkedList
        int idx = 1;

        Node temp = head;

        while(idx < position-1){
            temp = temp.next;
            idx++;
        }

        node.next = temp.next;
        temp.next = node;

    }

    // method to delete item ID
    public void delete(int itemID){
        Node temp = head;

        while(temp.next != null && temp.next.itemID != itemID){
            temp = temp.next;
        }

        if(temp.next != null){
            temp.next = temp.next.next;
            System.out.println("Deleted the record");
        }

        else{
            System.out.println("Item ID doesn't exist.");
        }
    }

    // method to upgrade quantity of item
    public void updateQuantity(int itemID, int quantity){
        Node temp = head;

        while(temp.next != null && temp.itemID != itemID){
            temp = temp.next;
        }

        if(temp.next != null){
            System.out.println("Record Found");
            temp.quantity = quantity;
            Node.displayNode(temp);
        }

        else{
            System.out.println("Record doesn't exist");
        }
    }

    // method to search itemID in list
    public void search(int itemID){
        Node temp = head;

        while(temp.next != null && temp.itemID != itemID){
            temp = temp.next;
        }

        if(temp.next != null){
            System.out.println("Record Found");
            Node.displayNode(temp);
        }

        else{
            System.out.println("Record doesn't exist");
        }
    }

    public void sort(){
        head = sortList(head);
        displayRecord();
    }

    // sort list based on price

    public Node sortList(Node head) {
        if(head==null || head.next==null){
            return head;
        }
        Node mid=getMid(head);
        Node left=sortList(head);
        Node right=sortList(mid);
        return merge(left, right);

    }
    static Node merge(Node list1, Node list2){

        Node dummyhead=new Node("", 0, 0,0);
        Node tail=dummyhead;

        while(list1 != null && list2 != null){

            if(list1.price < list2.price){

                tail.next=list1;
                list1=list1.next;
                tail=tail.next;

            }
            else {

                tail.next=list2;
                list2=list2.next;
                tail=tail.next;

            }

        }

        tail.next=(list1!=null)?list1:list2;
        return dummyhead.next;
    }
    static Node getMid(Node head){
        Node midPrev=null;

        while(head!=null && head.next!=null){
            midPrev=(midPrev==null) ? head : midPrev.next;
            head=head.next.next;
        }

        assert midPrev != null;
        Node mid=midPrev.next;
        midPrev.next=null;

        return mid;
    }

    // method to display Item
    public void displayRecord(){
        Node temp = head;
        int i = 1;
        while(temp != null){
            System.out.println("Item : " + i);
            Node.displayNode(temp);
            System.out.println();
            temp = temp.next;
            i++;
        }
    }
}
public class InventoryManagementSystem {
    public static void main(String[] args) {

        // creating object of linkedList
        LL ll = new LL();

        // add elements at last
        ll.addLast("Soup", 101, 4, 40);
        ll.addLast("Shampoo", 102, 2, 100);
        ll.addLast("Chips", 103, 10, 20);

        // add elements at first
        ll.addFirst("Butter", 104, 3, 150);
        ll.addFirst("Bottle", 105, 1, 100);

        // add element at specific position
        ll.add("Bag", 106, 1, 1000, 3);

        // remove item based on itemID
        ll.delete(102);

        // update item quantity based on item ID
        ll.updateQuantity(104, 11);

        // search item based on itemID
        ll.search(106);

        System.out.println();
        System.out.println("Total amount = " + LL.totalAmount);
        System.out.println();

        // sort the item
        ll.sort();
    }
}
