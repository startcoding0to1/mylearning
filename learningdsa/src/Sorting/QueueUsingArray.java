package Sorting;

public class QueueUsingArray {
	static class Queue{
		static int arr[];
		static int size;
		static int rear=-1;
		Queue(){};
		Queue(int n){
			this.arr=new int [n];
			this.size=n;
		}
		public static boolean isEmpty(){
			return rear ==-1;
		}
		//enqueue
		public static void add(int data) {
			if(rear==size-1){
				System.out.println("Queue is full");
				return;
			}
			rear++;
			arr[rear]=data;
		}
		//dequeue - O(n)
		public static int remove() {
			if(isEmpty()) {
				System.out.println("Queue is empty");
				return -1;
			}
			int front=arr[0];
			for(int i=0;i<rear;i++) {
				arr[i]=arr[i+1];
			}
			rear--;
			return front;
		}
		public static int peek() {
			if(isEmpty()) {
				System.out.println("Queue is empty");
				return -1;
			}
			return arr[0];
		}
	}
	public static void main(String[] args) {
		Queue q=new Queue(5);
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		
		while(!q.isEmpty()) {
			System.out.println(q.remove());
		}
	}
}
