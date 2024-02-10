package collection;

import java.util.ArrayList;

public class StackUsingAL {
	static class Problem1 {
		public static void recursion() {

		}

		public static void pushAtBottom() {

		}
	}

	static class Stack {
		static ArrayList<Integer> list = new ArrayList<Integer>();

		public void push(int num) {
			list.add(num);
		}

		public int pop() {
			if (isEmpty()) {
				return -1;
			}
			int pop = list.remove(list.size() - 1);
			return pop;
		}

		public boolean isEmpty() {
			return list.size() == 0;
		}

		public int top() {
			return list.get(list.size() - 1);
		}

		public int size() {
			return list.size();
		}
	}
	public static void pushAtBottom(int data,Stack stack) {
		if(stack.isEmpty()) {
			stack.push(data);
			return;
		}
		int pop=stack.pop();
		pushAtBottom(data,stack);
		stack.push(pop);
	}

	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(2);
		stack.pop();
		stack.push(3);
		stack.push(4);
		pushAtBottom(5, stack);
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

}
