import java.util.HashMap;


public class CheckIsomorphicString {
	public boolean isIsomorphic(String s1, String s2){
		if(s1.length()!=s2.length())
			return false;
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		for(int i=0;i<s1.length();i++){
			char c1 = s1.charAt(i);
			char c2 = s2.charAt(i);
			System.out.println("C1 : "+c1 + " C2 : "+c2);
			if(map.containsKey(c1)){
				if(map.get(c1)!=c2)
					return false;
			}
			else{
				if(map.containsValue(c2)) //if c2 is already being mapped
	                return false;
				map.put(c1, c2);
			}
		}
		System.out.println(map);
		return true;
		
	}
	public static void main(String args[]){
		String st1 = "ab";
		String st2 = "aa";
		CheckIsomorphicString obj = new CheckIsomorphicString();
		boolean res = obj.isIsomorphic(st1,st2);
		System.out.println("Are given Strings Isomorphic : "+res);
	}
}
