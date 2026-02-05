package Singly;
public class Singlydemo {
	class Node
	{
		int val;
		Node next;
		Node(int val)
		{
			this.val=val;
		}
	}
	private Node head;
	private Node tail;
	public void addFirst(int val)
	{
		if(isEmpty())
		{
			head= new Node(val);
			tail=head;
			return;
		}
		Node newNode = new Node(val);
		newNode.next = head;
		head=newNode;
	}
	
	public void addlast(int val)
	{
		if(isEmpty())
		{
			head= new Node(val);
			tail=head;
			return;
		}
		Node newNode = new Node(val);
		tail.next= newNode;
		tail=newNode;
	}
	public void add(int pos,int val)
	{
		if(pos==1)
		{
			addFirst(val);
			return;
		}
		Node current= head;
		int count=1;
		while(count<pos-1)
		{
			count++;
			current=current.next;
		}
		Node newNode= new Node(val);
		newNode.next= current.next;
		current.next=newNode;
	}
	public int deleteFirst()
	{
		if(isEmpty())
		{
			throw new RuntimeException("list is empty");
		}
		Node current= head;
		head= head.next;
		current.next=null;
		if(isEmpty())
		{
			tail=null;
		}
		return current.val;
	}
	public int deleteLast()
	{
		if(isEmpty())
		{
			throw new RuntimeException("list is empty");
		}
		if(head==tail)
		{
			@SuppressWarnings("unused")
			int val= head.val;
			head=null;
		}
		Node current= head;
		Node prev= null;
		while(current.next!=null)
		{
			prev=current;
			current=current.next;
		}
		prev.next=null;
		tail=prev;
		return current.val;
	}
	public int delete(int pos)
	{
		if(isEmpty())
		{
			throw new RuntimeException("list is empty");
		}
		if(pos==1)
		{
			deleteFirst();
		}
		Node current=head;
		Node prev=null;
		int count=1;
		while(count<pos)
		{
		count++;
		prev=current;
		current=current.next;
		}
		prev.next=current.next;
		current.next=null;
		return current.val;
	}
	public boolean search(int val){
		Node current=head;
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
	public boolean isEmpty()
	{
		return head==null;
	}
	public void print()
	{
		Node current=head;
		while(current!=null)
		{
			System.out.println(current.val+"=>");
			current =current.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Singlydemo li= new Singlydemo();
		li.addFirst(20);
		System.out.println("after adding 20 at first=");
		li.print();
	}

}
