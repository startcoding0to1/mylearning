package youtube_array;

public class minAndMaxNumofArray {
	public static void main(String[] args) {
		int arr[]= {2,4,3,6,7,5};
		
		int min=arr[0];//2 4 6 7
		int max=arr[0];//2 
		
		for(int i=1;i<arr.length-1;i++) {
			if(arr[i]>max) { //4>2 3>4 6>4 7>6 5>7
				max=arr[i+1];//4 6 7			
			}
			if(arr[i]<min) {//4<2 3<2 6<2 7<2
				min=arr[i+1];
			}
		}
		System.out.println("Max: "+max+" "+"Min: "+min);
	}
}
