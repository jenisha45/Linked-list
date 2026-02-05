public class Doublydeletelast {
    class Node {
        int val;
        Node next;
        Node prev;

        Node(int val) {
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    private Node tail;
    private Node head;

    public boolean isEmpty() {
        return head == null;
    }

    public void insertLast(int val) {
        Node node = new Node(val);

        if (isEmpty()) {
            head = node;
            tail = node;
            return;
        }

        tail.next = node;
        node.prev = tail;
        tail = node;
    }

    public int deleteLast() {
        if (isEmpty()) {
            throw new RuntimeException("list is empty");
        }
        int val = tail.val;
        if (head == tail) {
            head = null;
            tail = null;
            return val;
        }

        tail = tail.prev;
        tail.next = null;
        return val;
    }

   public void disp()
    {
        Node current = head;
        while (current!=null) {
            System.out.print(current.val+"=>");
            current=current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
         Doublydeletelast list = new Doublydeletelast();

        list.insertLast(10);
        list.insertLast(20);
        list.insertLast(30);
        list.insertLast(40);
        list.disp();              

        list.deleteLast();
        list.disp();              

    }
}
