public class Doublyaddfirst {
    class Node {
        Node prev;
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;

    private boolean isEmpty() {
        return head == null;
    }

    public void addFirst(int val) {
        if (isEmpty()) {
            head = new Node(val);
            tail = head;
            return;
        }
        Node newNode = new Node(val);
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void disp() {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + "=>");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Doublyaddfirst list = new Doublyaddfirst();
        list.head = list.new Node(10);
        list.tail = list.head;
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);

        list.disp();
    }
}
