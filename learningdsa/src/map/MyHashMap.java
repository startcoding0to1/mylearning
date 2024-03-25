package map;
import java.util.*;

public class MyHashMap {
	
	public static void main(String[] args) {
		//creation
		//country(key), population(value)
		HashMap<String,Integer> map=new HashMap<>();
		
		//Insertion
		map.put("India",120);
		map.put("US",30);
		System.out.println(map.put("China", 150));//return null
		//print
		System.out.println(map);
		
		//update/add
		System.out.println(map.put("China", 180));//return 150 previous val
		System.out.println(map);
		
		//Searching
		if(map.containsKey("China")) {
			System.out.println("Yes key is present"); //true
		}
		else {
			System.out.println("No key does not present"); //false
		}
		
		//fetch value with key
		System.out.println(map.get("India"));//key exists -- val
		System.out.println(map.get("Indonesia"));// key doesnot exists - null
		
		//Iteration-1
		for(Map.Entry<String, Integer> e:map.entrySet()) {
			System.out.println(e.getKey()+"  "+e.getValue());
		}
		
		//Iterator-2
		Set<String> keys=map.keySet();
		for(String key:keys) {
			System.out.println(key+"  "+map.get(key));
		}
		
		//Remove
		System.out.println(map.remove("China"));
		System.out.println(map);
	}	
}
