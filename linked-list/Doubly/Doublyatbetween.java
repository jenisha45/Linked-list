public class Doublyatbetween {
    class Node
    {
        Node prev;
        int val;
        Node next;

        public Node(int val)
        {
            this.val=val;
            this.next=null;
            this.prev= null;
        }
    }
    private Node head;
    private Node tail;
    public boolean isEmpty()
    {
        return head==null;
    }
    public void addFirst(int val)
    {
        if(isEmpty())
            {
                head= new Node(val);
                tail=head;
                return;
            }
            Node newNode = new Node(val);
            newNode.next=head;
            head.prev= newNode;
            head=newNode;
    }
    public void between(int pos,int val)
    {
        if(pos==1)
        {
            addFirst(val);
            return;
        }
    	Node current= head;
		int count=1;
		while(count < pos - 1)
		{
			count++;
			current=current.next;
		}
        Node newNode= new Node(val);
        newNode.next=current.next;
        newNode.prev= current;
        current.next.prev=newNode;
        current.next=newNode;
        
        //or for above
        // Node n= current.next;
        // current.next=newNode;
        // newNode.prev=current;
        // newNode.next=n;
        // n.prev=newNode;
    }
    public void disp()
    {
        Node current= head;
        while(current!=null)
        {
            System.out.print(current.val+"=>");
            current=current.next;
        }
        System.out.print("null");
    }
    public static void main(String[] args) {
        Doublyatbetween list= new Doublyatbetween();
        //4 10 2 99 13
        list.addFirst( 4);
        list.addFirst( 10);
        list.addFirst( 2);
        list.addFirst( 99);
        list.addFirst( 13);

        list.between(3, 8);
        list.disp();
    }
}
