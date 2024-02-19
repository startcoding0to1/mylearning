package queue;

public class CircularQueue {
	static class Queue{
		static int [] arr;
		static int size;
		static int front=-1;
		static int rear=-1;
		Queue(int n){
			this.arr=new int [n];
			this.size=n;
		}
		
		public static boolean isEmpty() {
			return front==-1 && rear==-1;
		}
		public static boolean isFull() {
			return (rear+1)%size==front;
		}
		
		//Enqueue-O(1)
		public static void add(int data) {
			if(isFull()) {
				System.out.println("Queue is full");
				return;
			}
			//1st Element
			if(front==-1) {
				front=0;
			}
			rear=(rear+1)%size;
			arr[rear]=data;
		}
		//Dequeue-O(1)
		public static int remove() {
			if(isEmpty()) {
				System.out.println("Queue is Empty");
				return -1;
			}
			int res=arr[front];
			if(rear==front) {
				rear=front=-1;
			}
			else {
				front=(front+1)%size;
			}
			return res;
		}
		public static int peek() {
			if(isEmpty()) {
				System.out.println("Queue is Empty");
				return -1;
			}
			return arr[front];
		}
	}
	public static void main(String[] args) {
		Queue q=new Queue(5);
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		System.out.println(q.remove());
		System.out.println(q.remove());
		q.add(6);
		q.add(7);
		while(!q.isEmpty()) {
			System.out.println(q.peek());
			q.remove();
		}
	}
}
