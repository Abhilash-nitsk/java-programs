package programs;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;


public class FindDuplicateinConstant {
	
	public int repeatedNumber(final List<Integer> a) {
		int slow=0;
		int fast =0;
		do{
			slow = a.get(slow);
			fast = a.get(a.get(fast));
		}while(slow!=fast);
		int find=0;
		while(find!=slow){
			slow=a.get(slow);
			find=a.get(find);
		}
		return find;
		
	}
	
	public static void main(String args[]){
		List<Integer> lst  = new LinkedList<Integer>();
		lst.add(1);
		lst.add(2);
		lst.add(3);
		lst.add(4);
		lst.add(3);
		FindDuplicateinConstant obj = new FindDuplicateinConstant();
		int res = obj.repeatedNumber(lst);
		System.out.println(res+" ");
		//-----------------------
		HashSet<Integer> hs= new HashSet<Integer>();
		Comparator<Integer> c = new Comparator<Integer>() {

			@Override
			public int compare(Integer a, Integer b) {
				// TODO Auto-generated method stub
				if(a>b)return a;
				else return b;
			}
			
		};
		lst.sort(c);
	}
}
