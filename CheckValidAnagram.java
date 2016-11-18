import java.util.HashMap;


public class CheckValidAnagram {
	
	public boolean checkIfAnagram(String s1, String s2){
		if(s1.length()!=s2.length())
			return false;
		HashMap<Character,Integer> hmap = new HashMap<Character, Integer>();
		for(char i: s1.toCharArray()){
			if(hmap.containsKey(i))
				hmap.put(i, hmap.get(i)+1);
			else
				hmap.put(i, 1);
		}
		for(char i: s2.toCharArray()){
			if(hmap.containsKey(i)&&hmap.get(i)>0)
				hmap.put(i, hmap.get(i)-1);
			else
				return false;
		}
		return true;
	}
	
	public static void main(String args[]){
		String st1 = "AAAAAABBBBBB";
		String st2 = "ABABABABABAA";
		CheckValidAnagram obj = new CheckValidAnagram();
		boolean res = obj.checkIfAnagram(st1,st2);
		System.out.println("The strings are valid anagram : " + res);
	}
}
