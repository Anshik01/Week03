import java.util.ArrayList;
class Linkedist{

    static class Node{

        String userId;
        String name;
        int age;
        ArrayList<String> friendList;
        Node next;

        public Node(String userId, String name, int age) {

            this.userId = userId;
            this.name = name;
            this.age = age;
            this.friendList = new ArrayList<>();
            this.next = null;

        }

    }

    // head pointer to point the start
    private Node head;

    // add new user to instagram
    void addUser(String userId, String name, int age) {

        if (!checkId(userId)) {
            System.out.println("User with ID " + userId + " already exists.");
            return;
        }

        Node newNode = new Node(userId, name, age);

        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }

    }


    // Finding the friend using the user id
    Node findFriend(String friendId) {

        Node current = head;
        while (current != null) {
            if (current.userId.equals(friendId)) {
                return current;
            }
            current = current.next;
        }
        return null;

    }

    // Add the connection between the two user
    void addConnection(String user1Id, String user2Id) {

        Node user1 = findFriend(user1Id);
        Node user2 = findFriend(user2Id);

        if (user1 == null) {
            System.out.println("User with ID " + user1Id + " not found.");
            return;
        }

        if (user2 == null) {
            System.out.println("User with ID " + user2Id + " not found.");
            return;
        }

        if (user1Id.equals(user2Id)) {
            System.out.println("A user cannot be friends with themselves.");
            return;
        }

        if (!user1.friendList.contains(user2Id)) {
            user1.friendList.add(user2Id);
        }

        if (!user2.friendList.contains(user1Id)) {
            user2.friendList.add(user1Id);
        }

    }
    // Check id is available or not
    public boolean checkId(String id) {

        Node current = head;
        while (current != null) {
            if (current.userId.equals(id)) {
                return false;
            }
            current = current.next;
        }

        return true;

    }

    // method to remove one user from another user
    void removeConnection(String user1Id, String user2Id) {

        Node user1 = findFriend(user1Id);
        Node user2 = findFriend(user2Id);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        user1.friendList.remove(user2Id);
        user2.friendList.remove(user1Id);
        System.out.println("Connection removed between " + user1Id + " and " + user2Id);

    }

    // method to find mutual user
    void findMutualFriends(String user1Id, String user2Id) {

        Node user1 = findFriend(user1Id);
        Node user2 = findFriend(user2Id);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        System.out.println("Mutual friends between " + user1.name + " and " + user2.name + ":");
        for (String friendId : user1.friendList) {
            if (user2.friendList.contains(friendId)) {
                Node mutualFriend = findFriend(friendId);
                if (mutualFriend != null) {
                    System.out.println("- " + mutualFriend.name + " (ID: " + mutualFriend.userId + ")");
                }
            }
        }

    }

    // Display the friendList of the user
    public void displayFriends(String userId) {

        Node user = findFriend(userId);
        if (user != null) {
            System.out.println("Friends of " + user.name + " (ID: " + user.userId + "):");
            for (String friendId : user.friendList) {
                Node friend = findFriend(friendId);
                if (friend != null) {
                    System.out.println("- " + friend.name + " (ID: " + friend.userId + ")");
                }
            }
        }

        else {
            System.out.println("User not found.");
        }

    }
}

public class SocialMediaManager {
    public static void main(String[] args) {

        Linkedist Instagram = new Linkedist();

        // adding users
        Instagram.addUser("anshik07", "Anshik Jaiswal", 20);
        Instagram.addUser("ayush1", "Aayush Kumar Shrivastav", 21);
        Instagram.addUser("d2024", "depesh", 22);
        Instagram.addUser("durgesh", "durgesh", 22);
        Instagram.addUser("vipin", "Bipin", 22);

        // adding a connection
        Instagram.addConnection("anshik07", "ayush1");
        Instagram.addConnection("ayush1", "d2024");
        Instagram.addConnection("anshik07", "vipin");

        // adding a connection
        Instagram.addConnection("d2024", "durgesh");
        Instagram.addConnection("d2024", "vipin");
        Instagram.findMutualFriends("anshik07","ayush1");

        Instagram.addConnection("vipin", "durgesh");

        Instagram.removeConnection("anshik07","ayush1");

        // Display friends of a user
        Instagram.displayFriends("anshik07");

    }
}