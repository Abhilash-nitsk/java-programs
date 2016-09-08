import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;



public class firstNonRepeatingChar {
	 
	public static void main(String args[]){
	Hashtable<String, String> map = new Hashtable<String, String>();
	String keys ="abcdbac" ;
	String values[] = {"1","2","3"};
	for(int i = 0 ;i <keys.length; i++){
	map.put(keys[i], values[i]);
	}
	//Retrieving values
	Iterator it = map.entrySet().iterator();
	   while (it.hasNext()) {
	       Map.Entry pair = (Map.Entry)it.next();
	       System.out.println(pair.getKey() + " = " + pair.getValue());
	       it.remove(); // avoids a ConcurrentModificationException
	   }
	 
	}
}
