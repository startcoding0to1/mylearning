package Sorting;

public class InsertionSort {
	public static void main(String[] args) {
		int [] arr= {8,2,15,32,22};
		for(int i=1;i<arr.length;i++) {
//			int sPartIndx=i-1;//sorted part
//			int usPartIndx=i;//unsorted part element
//			while(sPartIndx>=0 && arr[usPartIndx]<arr[sPartIndx]) {
//				int temp=arr[sPartIndx];
//				arr[sPartIndx--]=arr[usPartIndx];
//				arr[usPartIndx]=temp;
//				
//			}
//			System.out.println(i);
			for(int j=0;j<i && arr[i]<arr[j];System.out.println(j++)) {
				if(arr[i]<arr[j]) {
					int temp=arr[j];
					arr[j]=arr[i];
					arr[i]=temp;
				}
			}
			
		}
		for(int res:arr) {
			System.out.print(res+" ");
		}
	}
}
