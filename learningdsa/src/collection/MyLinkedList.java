package collection;

import java.util.HashSet;

public class MyLinkedList {
	Node head;
	private int size = 0;

	class Node {
		String data;
		Node next;

		Node(String data) {
			this.data = data;
			this.next = null;
		}
	}

	public void addFirst(String data) {
		size++;
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return;
		}
		newNode.next = head;
		head = newNode;
	}

	public void addLast(String data) {
		size++;
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return;
		}
		Node checkNode = head;
		while (checkNode.next != null) {
			checkNode = checkNode.next;
		}
		checkNode.next = newNode;
	}

	public void addMiddle(int index, String data) {
		size++;
		if (index == 0 || head == null) {

		}
		Node newNode = new Node(data);
		Node previous = head;
	}

	public void printlist() {
		if (head == null) {
			System.out.println("List is Empty");
			return;
		}
		if (head.next == null) {
			System.out.println(head.data);
			return;
		}
		Node checkNode = head;
		while (checkNode.next != null) {
			System.out.print(checkNode.data + " --> ");
			checkNode = checkNode.next;
		}
		System.out.print(checkNode.data);
		System.out.println();
	}

	public int size() {
		return this.size;
	}

	public void reverseIteratevely() {

		if (head == null || head.next == null) {
			return;
		}

		Node prevNode = head;
		Node currNode = head.next;
		while (currNode != null) {
			Node nextNode = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = nextNode;
		}
		head.next = null;
		head = prevNode;
	}
	public Node findNthNode(Node head, int nth) {
		System.out.println("Entered inside findNthNode================");
		int nthIndx=this.size-nth+1;
		int i=1;
		Node nthNode=head;
		while(i<nthIndx) {
			nthNode=nthNode.next;
			i++;
		}
		return nthNode;
	}
	public boolean makeLoop(Node head, int nth) {
		System.out.println("Entered inside makeLoop================");
		if(head==null) {
			return false;
		}
		Node nthNode=findNthNode(head, nth);
		System.out.println(nthNode.data);
		Node cNode=head;
		while(cNode.next!=null) {
			cNode=cNode.next;
		}
		cNode.next=nthNode;
		return true;
	}
	public boolean removeLoop1(Node head) {
		Node meetingpoint=checkLoop(head);
		HashSet<Node> set=new HashSet<>();
		if(meetingpoint==null) {
			return false;
		}
//		Node slow=head;
//		Node fast=meetingpoint;
		Node slow=head;
		while(slow!=meetingpoint) {
			if(set.contains(slow)) {
				slow.next=null;
				return true;
			}
			set.add(slow);
			slow=slow.next;
		}
		slow.next=null;
		return true;
	}
	public boolean removeLoop2(Node head) {
		Node ptr1=checkLoop(head);
		if(ptr1==null) {
			return false;
		}
		Node ptr2=head;
		while(ptr2.next!=ptr1) {
			ptr2=ptr2.next;
		}
		ptr1=ptr2;
		while(ptr1.next!=ptr2) {
			ptr1=ptr1.next;
		}
		ptr1.next=null;
		return true;
	}
	public static Node checkLoop(Node head) {
		System.out.println("Entered inside checkLoop================");
		if(head==null) {
			return null;
		}
		Node slow=head;
		Node fast=head;
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast) {
				return slow;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
//		list.addFirst("Khairuddin ");
//		list.addFirst("Mahammad ");
//		list.addFirst("I am ");
//		list.printlist();
		list.reverseIteratevely();
//		list.printlist();
		list.addLast("1");
		list.addLast("2");
		list.addLast("3");
		list.addLast("4");
		list.addLast("5");
		System.out.println(list.size());
		System.out.println("=========================Make loop=============================");
		System.out.println(list.makeLoop(list.head,1)==true?"Yes loop was maded":"No nodes");
		System.out.println("=========================check loop=============================");
//		list.printlist();
		System.out.println(list.checkLoop(list.head)==null?"No loop not exist":"Yes loop exist");
//		list.printlist();
		System.out.println(list.removeLoop1(list.head));
//		list.printlist();
//		System.out.println(list.removeLoop2(list.head));
		list.printlist();

	}
}
