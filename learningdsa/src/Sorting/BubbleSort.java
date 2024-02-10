package Sorting;

public class BubbleSort {
	public static void main(String[] args) {
		int [] arr= {18,32,-11,6,68,2,-34};
		
		for(int i=0;i<arr.length-1;i++) {
			boolean swap=false;//Efficient part
			for(int j=0;j<arr.length-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					swap=true;
				}
			}
			if(!swap) {
				System.out.println("I am there");
				break;
			}
		}
		for(int res:arr) {
			System.out.print(res+" ");
		}
	}
}
