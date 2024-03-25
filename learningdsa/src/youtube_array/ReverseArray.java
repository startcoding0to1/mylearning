package youtube_array;

public class ReverseArray {
	public static void main(String[] args) {
		int arr[]={1,2,3,4,5,6};//Reverse-{6,5,4,3,2,1}	
		
		for(int f=0,l=arr.length-1;f<arr.length/2;f++,l--) {
			int temp=arr[f];//1
			//swap
			arr[f]=arr[l];//6 last index value
			arr[l]=temp;//1 0th index value
		}		
		for(int res:arr) {
			System.out.print(res+", ");
		}
	}
}
