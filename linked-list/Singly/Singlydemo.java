package Singly;
import java.util.Scanner;
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
		if(isEmpty())//after deleting this check whether only link list is left or not
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
    Singlydemo li = new Singlydemo();
    Scanner sc = new Scanner(System.in);

    while (true) {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Add First");
        System.out.println("2. Add Last");
        System.out.println("3. Add at Position");
        System.out.println("4. Delete First");
        System.out.println("5. Delete Last");
        System.out.println("6. Delete at Position");
        System.out.println("7. Search");
        System.out.println("8. Print");
        System.out.println("9. Exit");
        System.out.print("Enter choice: ");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter value: ");
                li.addFirst(sc.nextInt());
                break;

            case 2:
                System.out.print("Enter value: ");
                li.addlast(sc.nextInt());
                break;

            case 3:
                System.out.print("Enter position: ");
                int pos = sc.nextInt();
                System.out.print("Enter value: ");
                int val = sc.nextInt();
                li.add(pos, val);
                break;

            case 4:
                System.out.println("Deleted: " + li.deleteFirst());
                break;

            case 5:
                System.out.println("Deleted: " + li.deleteLast());
                break;

            case 6:
                System.out.print("Enter position: ");
                int dpos = sc.nextInt();
                System.out.println("Deleted: " + li.delete(dpos));
                break;

            case 7:
                System.out.print("Enter value to search: ");
                int s = sc.nextInt();
                System.out.println(li.search(s) ? "Found" : "Not Found");
                break;

            case 8:
                li.print();
                break;

            case 9:
                System.out.println("Exiting...");
                sc.close();
                return;

            default:
                System.out.println("Invalid choice!");
        }
    }
}
