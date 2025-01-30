class LinkedList{

    // creating a head
    StudentNode head;

    static class StudentNode{

        // declaring data members of the node
        int rollNumber;
        String name;
        int age;
        char grade;
        StudentNode next;

        StudentNode(int rollNumber, String name, int age, char grade){
            this.rollNumber = rollNumber;
            this.name = name;
            this.age = age;
            this.grade = grade;
        }

        // method to display a student node
        public static void displayStudent(StudentNode node){
            System.out.println("Roll number : " + node.rollNumber);
            System.out.println("Name : " + node.name);
            System.out.println("Age : " + node.age);
            System.out.println("Grade : " + node.grade);
        }

    }

    // method to add element at last index
    public void addLast(int rollNumber, String name, int age, char grade){
        // creating a node
        StudentNode node = new StudentNode(rollNumber, name, age, grade);

        if(head == null){
            head = node;
            return;
        }

        StudentNode temp = head;
        while(temp.next != null){
            temp = temp.next;
        }

        temp.next = node;
    }

    // method to add element at first index
    public void addFirst(int rollNumber, String name, int age, char grade){
        // creating a node
        StudentNode node = new StudentNode(rollNumber, name, age, grade);

        node.next = head;
        head = node;
    }

    // method to add student at specific index
    public void add(int rollNumber, String name, int age, char grade, int position){
        // creating a node
        StudentNode node = new StudentNode(rollNumber, name, age, grade);

        // index value to track the index of the linkedList
        int idx = 1;

        StudentNode temp = head;

        while(idx < position-1){
            temp = temp.next;
            idx++;
        }

        node.next = temp.next;
        temp.next = node;

    }

    // method to delete roll number
    public void delete(int rollNumber){
        StudentNode temp = head;

        while(temp.next != null && temp.next.rollNumber != rollNumber){
            temp = temp.next;
        }

        if(temp.next != null){
            temp.next = temp.next.next;
            System.out.println("Deleted the record");
        }

        else{
            System.out.println("Roll Number doesn't exist.");
        }
    }

    // method to search roll number in list
    public void search(int rollNumber){
        StudentNode temp = head;

        while(temp.next != null && temp.rollNumber != rollNumber){
            temp = temp.next;
        }

        if(temp.next != null){
            System.out.println("Record Found");
            StudentNode.displayStudent(temp);
        }

        else{
            System.out.println("Record doesn't exist");
        }
    }

    // method to upgrade grades of Student
    public void updateGrade(int rollNumber, char grade){
        StudentNode temp = head;

        while(temp.next != null && temp.rollNumber != rollNumber){
            temp = temp.next;
        }

        if(temp.next != null){
            System.out.println("Record Found");
            temp.grade = grade;
            StudentNode.displayStudent(temp);
        }

        else{
            System.out.println("Record doesn't exist");
        }
    }

    // method to display record of student
    public void displayRecord(){
        StudentNode temp = head;
        int i = 1;
        while(temp != null){
            System.out.println("Student : " + i);
            StudentNode.displayStudent(temp);
            System.out.println();
            temp = temp.next;
            i++;
        }
    }
}
// main class to implement features of LinkedList
public class StudentRecordManagement {
    public static void main(String[] args) {

        // creation of linkedList
        LinkedList linkedList = new LinkedList();

        // adding elements at last
        linkedList.addLast(101, "Anshik", 20, 'A');
        linkedList.addLast(102, "Ayush", 20, 'A');
        linkedList.addLast(103, "Durgesh", 20, 'A');
        linkedList.addLast(104, "Varsha", 20, 'A');
        linkedList.addLast(105, "Unknown", 20, 'A');

        // adding elements at first
        linkedList.addFirst(106, "Aman", 23, 'A');

        // adding elements at specific position
        linkedList.add(107, "Ashu", 22, 'D', 4);

        // delete element
        linkedList.delete(102);

        // search element
        linkedList.search(102);

        // upgrade grades
        linkedList.updateGrade(104, 'F');

        // display records
        linkedList.displayRecord();

    }
}