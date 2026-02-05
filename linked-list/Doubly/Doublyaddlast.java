public class Doublyaddlast {
    static class Node {
        Node prev;
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.prev = null;
            this.next = null;
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
    public void disp()
    {
        Node current = head;
        while (current!=null) {
            System.out.print(current.val+"=>");
            current=current.next;
        }
        System.out.print("null");
    }
    public static void main(String[] args) {
        //4 10 2 99 13
        Doublyaddlast list =new Doublyaddlast();
        // Node a= new Node ( 4);
        // Node b= new Node ( 10);
        // Node c= new Node ( 2);
        // Node d= new Node ( 99);
        // Node e= new Node ( 13);
        // a.prev=null;
        // a.next=b;
        // b.prev=a;
        // b.next=c;
        // c.prev=b;
        // c.next=d;
        // d.prev=c;
        // d.next=e;
        // e.prev=d;
        // e.next=null;
        // list.head=a;
        // list.tail=e;
        //rather than the above this can also be used
            // Existing data
        list.addlast(4);
        list.addlast(10);
        list.addlast(2);
        list.addlast(99);
        list.addlast(13);

        // Add one more at the end
        list.addlast(8);
        
        list.disp();
    }
}
