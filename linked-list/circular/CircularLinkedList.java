import java.util.Scanner;

public class CircularLinkedList {

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    // Check if list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Insert at beginning
    public void addFirst(int val) {
        Node newNode = new Node(val);

        if (isEmpty()) {
            head = tail = newNode;
            tail.next = head;
            return;
        }

        newNode.next = head;
        head = newNode;
        tail.next = head;
    }

    // Insert at end
    public void addLast(int val) {
        Node newNode = new Node(val);

        if (isEmpty()) {
            head = tail = newNode;
            tail.next = head;
            return;
        }

        tail.next = newNode;
        tail = newNode;
        tail.next = head;
    }

    // Insert at position
    public void addAtPosition(int pos, int val) {

        if (pos == 1) {
            addFirst(val);
            return;
        }

        Node current = head;
        int count = 1;

        while (count < pos - 1 && current.next != head) {
            current = current.next;
            count++;
        }

        Node newNode = new Node(val);
        newNode.next = current.next;
        current.next = newNode;

        if (current == tail) {
            tail = newNode;
            tail.next = head;
        }
    }

    // Delete first node
    public int deleteFirst() {

        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }

        Node temp = head;

        if (head == tail) {
            head = tail = null;
            return temp.val;
        }

        head = head.next;
        tail.next = head;

        return temp.val;
    }

    // Delete last node
    public int deleteLast() {

        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }

        if (head == tail) {
            int val = head.val;
            head = tail = null;
            return val;
        }

        Node current = head;
        Node prev = null;

        while (current.next != head) {
            prev = current;
            current = current.next;
        }

        prev.next = head;
        tail = prev;

        return current.val;
    }

    // Delete at position
    public int deleteAtPosition(int pos) {

        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }

        if (pos == 1) {
            return deleteFirst();
        }

        Node current = head;
        Node prev = null;
        int count = 1;

        while (count < pos && current.next != head) {
            prev = current;
            current = current.next;
            count++;
        }

        prev.next = current.next;

        if (current == tail) {
            tail = prev;
            tail.next = head;
        }

        return current.val;
    }

    // Search value
    public boolean search(int val) {

        if (isEmpty())
            return false;

        Node current = head;

        do {
            if (current.val == val)
                return true;

            current = current.next;

        } while (current != head);

        return false;
    }

    // Display list
    public void print() {

        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;

        do {
            System.out.print(current.val + " => ");
            current = current.next;
        } while (current != head);

        System.out.println("(back to head)");
    }

    // Main method (menu driven)
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CircularLinkedList list = new CircularLinkedList();

        int choice;

        do {

            System.out.println("\n--- Circular Linked List Menu ---");
            System.out.println("1. Insert First");
            System.out.println("2. Insert Last");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete First");
            System.out.println("5. Delete Last");
            System.out.println("6. Delete at Position");
            System.out.println("7. Search");
            System.out.println("8. Display");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value: ");
                    int v1 = sc.nextInt();
                    list.addFirst(v1);
                    break;

                case 2:
                    System.out.print("Enter value: ");
                    int v2 = sc.nextInt();
                    list.addLast(v2);
                    break;

                case 3:
                    System.out.print("Enter position: ");
                    int pos = sc.nextInt();
                    System.out.print("Enter value: ");
                    int val = sc.nextInt();
                    list.addAtPosition(pos, val);
                    break;

                case 4:
                    System.out.println("Deleted: " + list.deleteFirst());
                    break;

                case 5:
                    System.out.println("Deleted: " + list.deleteLast());
                    break;

                case 6:
                    System.out.print("Enter position: ");
                    int dpos = sc.nextInt();
                    System.out.println("Deleted: " + list.deleteAtPosition(dpos));
                    break;

                case 7:
                    System.out.print("Enter value to search: ");
                    int s = sc.nextInt();
                    System.out.println(list.search(s) ? "Value Found" : "Value Not Found");
                    break;

                case 8:
                    list.print();
                    break;

                case 9:
                    System.out.println("Program Ended");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 9);

        sc.close();
    }
}