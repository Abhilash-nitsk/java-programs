import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/** Program to find the Duplicate Words and Number of their repetations */
public class DupsWordsAndNum {
	public HashMap<String, Integer> numOfWords(String sentence){
		HashMap<String, Integer> map =new HashMap<String, Integer>();
		String[] words = sentence.split(" ");
		for(String i: words){
			if(map.containsKey(i))
				map.put(i, map.get(i)+1);
			else
				map.put(i, 1);
		}
		return map;
	}
	
	public void printDupWordsAndNum(String Str){
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map=numOfWords(Str);
		Set<Map.Entry<String, Integer>> S = map.entrySet();
		for(Map.Entry<String, Integer> m: S){
			String key = m.getKey();
			int val = m.getValue();
			if(val>1)
				System.out.println("Key  : "+key+"  Value : "+ val);
		}	
	}
	public static void main(String args[]){
		String sentence = "My Name Is Abhi MY Name is Alok I am Abhi He Has is Abhi";
		DupsWordsAndNum obj= new DupsWordsAndNum();
		obj.printDupWordsAndNum(sentence);
	}
}
