package pattern11211112;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Pattern11211121 {
	void displayPattern(String str,int n){
		if(n<=0) return;
		//System.out.println();
		HashMap<Character,Integer> hmap = new HashMap<>();
		while(n-->0){
			StringBuilder strb = new StringBuilder("");
			hmap.clear();
			for(int i=0;i<str.length();i++){
				char c = str.charAt(i);
				Integer v = hmap.get(c);
				if(v==null) 
					hmap.put(str.charAt(i), 1);
				else 
					hmap.put(str.charAt(i), v + 1);
			}
			Set<Entry<Character,Integer>> set = hmap.entrySet();
			//System.out.println(hmap);
			for(Entry<Character,Integer> obj: set){
				char k = obj.getKey();
				int v = obj.getValue();
				strb=strb.append(v);
				strb=strb.append(k+"");
			}
			System.out.print(strb);
			//displayPattern(strb.toString(),--n);
			str=strb.toString();
		}
	}
	public static void main(String arg[]){
		String str = new String("1");
		int n=4;
		Pattern11211121 obj = new Pattern11211121();
		obj.displayPattern(str,n);
	}
}
