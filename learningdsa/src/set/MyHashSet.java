package set;
import java.util.HashSet;
import java.util.Iterator;

public class MyHashSet {
	public static void main(String[] args) {
		//creating
		HashSet<Integer> set=new HashSet<>();
		
		//Insert - add
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(1);//duplicates not allowed
		
		//size
		System.out.println("Size of the set: "+set.size());
			
		//print all elements
		System.out.println(set);
		
		//Search - contains
		if(set.contains(1)) {
			System.out.println("Set Contains 1");
		}
		else {
			System.out.println("Set does not Contains 1");
		}
		
		//Delete
		System.out.println("Remove:  "+set.remove(1));
		System.out.println(set);
		
		//Iterator
		Iterator it=set.iterator();
		//hasNext; next;
		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}
		System.out.println();
		//isEmpty
		System.out.println(set.isEmpty());
		
	}
}
