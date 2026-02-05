public class Doublysearch {
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
    public boolean search(int val){
		Node current=head;//if backward bata search garnen vaye current=tail;
        
		while(current!=null)
		{
			if(val==current.val)
			{
				return true;
			}
            
			current=current.next;
		}
		return false;
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
        Doublysearch list = new Doublysearch();

        list.insertLast(10);
        list.insertLast(20);
        list.insertLast(30);
        list.insertLast(40);
    }
}
