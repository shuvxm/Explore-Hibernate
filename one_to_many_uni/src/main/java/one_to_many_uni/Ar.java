package one_to_many_uni;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Ar {
	public static void main(String[] args) {
		HashMap<Integer, String> hm = new HashMap<>();
		hm.put(1, "abc");
		hm.put(1, "xyz");
		hm.put(3, "lulum");
		hm.put(4, "savi");
		hm.put(5, "1234");
		
		 // Using Iterator to iterate through the HashMap
        Iterator<Map.Entry<Integer, String>> itr = hm.entrySet().iterator();
        
        while (itr.hasNext()) {
            Map.Entry<Integer, String> entry = itr.next();
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
		
		
	}

}
