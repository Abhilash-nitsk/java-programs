import java.util.*;
import java.util.Map.*;

public class sortOnFreq {
	
    public static void main(String args[ ])  {
    	int A[] = new int[]{3,1,1,1,2,3,3,2,2,2,2,3,1};
    	HashMap<Integer,Integer> map = new LinkedHashMap<Integer,Integer>();
    	for(int obj: A){
    		Integer v = map.get(obj);
    		if(v==null){
    			map.put(obj,1);
    		}
    		else
    			map.put(new Integer(obj), v+1);
    	}
    	System.out.println(map);
    	myComparator m = new myComparator(map);
    	TreeMap<Integer,Integer> t = new TreeMap<Integer, Integer>(m);
    	t.putAll(map);
    	System.out.println(t);
    	/*Set<Entry<Integer,Integer>> obj=t.entrySet();
    	for(Entry<Integer,Integer> map1: obj){
    		System.out.println("Key: " + map1.getKey());
    		System.out.println("Value: " + map1.getValue());
    	}*/

    }
}
class myComparator implements Comparator<Integer>{
	HashMap<Integer,Integer> map = null;
	myComparator(HashMap m){
		map=m;
	}
	public int compare(Integer a, Integer b){
		int val1 = Integer.valueOf(map.get(a));
		int val2 = Integer.valueOf(map.get(b));
		if(val1>val2)
			return -1;
		else
			return 1;
	}
}