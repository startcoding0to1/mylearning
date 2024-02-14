package queue;


import java.util.Stack;

//Queue using two stacks
public class QueueUsingTwoStacks{
	static Stack<Integer> stack1=new Stack<>();
	static Stack<Integer> stack2=new Stack<>();
	public void Stack1(int  data) {
		while(!stack1.isEmpty()) {
			int i=(Integer) stack1.pop();
			stack2.push(i);
		}
		stack1.push(data);
		while(!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
	}
	
	public void add(Integer data) {
		Stack1(data);
	}
	public Integer remove() {
		return stack1.pop();
	}
	public static void main(String[] args) {
		QueueUsingTwoStacks stack=new QueueUsingTwoStacks();
		stack.add(1);
		stack.add(2);
		stack.add(3);
		
		System.out.println(stack.remove());
	}
}
