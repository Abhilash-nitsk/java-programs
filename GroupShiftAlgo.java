import java.util.HashMap;
import java.util.LinkedList;


public class GroupShiftAlgo {
	public HashMap<Integer,LinkedList<String>> groupShift(String[] input){
		HashMap<Integer,LinkedList<String>> h = new HashMap<Integer,LinkedList<String>>();
		for(String st: input){
			int l = st.length();
			if(h.containsKey(l)){
				LinkedList<String> s = new  LinkedList<String>();
				s = h.get(l);
				s.add(st);
				h.put(l, s);
			}
			else{
				LinkedList<String> s = new  LinkedList<String>();
				s.add(st);
				h.put(l, s);
			}
		}
		return h;
	}
	public static void main(String args[]){
		String s1 = new String("x");
		String s2 = new String("y");
		String s3 = new String("z");
		String s4 = new String("xy");
		String s5 = new String("wx");
		String s6 = new String("yz");
		String s7 = new String("abc");
		String s8 = new String("cde");
		String s9 = new String("efg");
		String s10 = new String("hij");
		String s11 = new String("uvwx");
		String[] input = new String[]{s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11};
		GroupShiftAlgo obj = new GroupShiftAlgo();
		HashMap<Integer, LinkedList<String>> res = new HashMap<Integer, LinkedList<String>>();
		res = obj.groupShift(input);
		System.out.println(res);
	}
}
