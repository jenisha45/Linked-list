public class Doublydeletefirst {

    class Node {
        Node prev;
        int val;
        Node next;

        Node(int val) {
            this.next = null;
            this.prev = null;
            this.val = val;
        }
    }

    private Node head;
    private Node tail;

    public boolean isEmpty() {
        return head == null;
    }

    public  void addlast(int val) {
        if (isEmpty()) {
            head = new Node(val);
            tail = head;
            return;
        }
        Node newNode= new Node(val);
        tail.next= newNode;
        newNode.prev=tail;
        newNode.next=null;
        tail=newNode;
    }

    public int deleteFirst() {
        if (isEmpty()) {
            throw new RuntimeException("list is empty");
        }

        Node current = head;
        head = head.next;

        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }

        current.next = null;
        return current.val;
    }

    public void disp() {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + "=>");
            current = current.next;   // ⭐ THIS was missing
        }
        System.out.print("null");
    }

    public static void main(String[] args) {
        Doublydeletefirst list = new Doublydeletefirst();

        list.addlast(2);
        list.addlast(21);
        list.addlast(23);
        list.addlast(5);

        list.deleteFirst();
        list.disp();
    }
}
