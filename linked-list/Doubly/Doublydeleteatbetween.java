public class Doublydeleteatbetween {
    class Node{
        int val;
        Node prev;
        Node next;
        Node (int val)
        {
            this.val=val;
            this.next=null;
            this.prev=null;
        }
    }
    private Node head;
    private Node tail;
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

    public int deletebetween(int pos)
    {
        	if(isEmpty())
		{
			throw new RuntimeException("list is empty");
		}
		if(pos==1)
		{
			return deleteFirst();
		}
        Node current=head;
        int count=1;
        while(count<pos)
        {
            current=current.next;
            count++;  
        }
       current.prev.next=current.next;
       current.next.prev=current.prev;
       current.next=null;
       current.prev=null;
        return current.val;
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
        Doublydeleteatbetween list = new Doublydeleteatbetween();

        list.insertLast(10);
        list.insertLast(20);
        list.insertLast(30);
        list.insertLast(40);

        list.deletebetween(2);
        list.disp();         
    }
}
