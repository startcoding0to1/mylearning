package stack;

import stack.StackUsingAL.Stack;

public class StackUsingLL {
	static class Stack{
		Node head=null;
		class Node{
			int data;
			Node next;
			public Node(int data) {
				super();
				this.data = data;
				this.next =null;
			}
		}
		public void push(int data) {
			Node node=new Node(data);
			if(head==null) {
				head=node;
				return;
			}
			node.next=head;
			head=node;
		}
		public int pop() {
			int data=head.data;
			head=head.next;
			return data;
		}
		public int peek() {
			return head.data;
		}
		public boolean isEmpty() {
			return head==null;
		}
	}
	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(2);
		stack.pop();
		stack.push(3);
		stack.push(4);
		System.out.println(stack.peek());
		System.out.println(stack.isEmpty());
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
}
