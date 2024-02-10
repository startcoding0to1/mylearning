package stack;

import java.util.Stack;

public class StackUsingJCF {
	static Stack<Integer> stack=new Stack<>();
	public static void reverse(Stack<Integer> stack) {
		if(stack.isEmpty()) {
			return;
		}
		int pop=stack.pop();
		reverse(stack);
		System.out.println("POP :"+pop);
		stack.push(pop);
	}
	public static void main(String[] args) {
		stack.push(1);
		stack.push(2);
		stack.push(2);
		stack.push(3);
		stack.push(4);
//		while (!stack.isEmpty()) {
//			System.out.println(stack.pop());
//		}
		reverse(stack);
		System.out.println("==========================================");
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}	
}
