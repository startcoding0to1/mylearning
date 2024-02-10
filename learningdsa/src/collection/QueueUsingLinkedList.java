package collection;

import collection.CircularQueue.Queue;

public class QueueUsingLinkedList {
	
	static class Node{
		int data;
		Node next;
		Node(int data) {
			this.data=data;
			this.next=null;
		}
	}
	static class Queue{
		static Node head=null;
		static Node tail=null;
		
		public static boolean isEmpty() {
			return head==null && tail==null;
		}
		public static void add(int data) {
			Node newNode=new Node(data);
			 if(isEmpty()) {
				 tail=head=newNode;
				 return;
			 }
			 tail.next=newNode;
			 tail=newNode;
		}
		public static int remove() {
			if(isEmpty()) {
				 System.out.println("Queue is empty");
				 return -1;
			 }
			int res=head.data;
			if(head==tail) {
				tail=null;
			}
			head=head.next;
			return res;
		}
		public static int peek() {
			if(isEmpty()) {
				System.out.println("Queue is Empty");
				return -1;
			}
			return head.data;			
		}
		public static void main(String[] args) {
			Queue q=new Queue();
			q.add(1);
			q.add(2);
			q.add(3);
			q.add(4);
			q.add(5);
			while(!q.isEmpty()) {
				System.out.println(q.peek());
				q.remove();
			}
		}
	}
}
