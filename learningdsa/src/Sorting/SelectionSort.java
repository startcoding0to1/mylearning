package Sorting;

public class SelectionSort {
	public static void main(String[] args) {
		int [] arr= {18,32,-11,6,68,2,-34};
		for(int i=0;i<arr.length;i++) {
			int sei=i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[sei]>arr[j]) {
					sei=j;
				}
			}
			int temp=arr[i];
			arr[i]=arr[sei];
			arr[sei]=temp;
		}
		for(int res:arr) {
			System.out.print(res+" ");
		}
	}
}
