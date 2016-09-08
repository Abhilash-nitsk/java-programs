import java.util.Stack;

class NGEUtil{
	public void findNGE(int A[]){
		Stack<Integer> stk = new Stack<Integer>();
		stk.push(A[0]);
		int next;
		int element;
		for(int i=1;i<A.length;i++){
			next = A[i];
			if(!stk.isEmpty()){
				element = stk.pop();
				while(element<next){
					System.out.println("Element : "+element + "   NGE : "+ next);
					if(stk.isEmpty())
						break;
					element = stk.pop();
				}
				if(element>next)
					stk.push(next);
			}
			stk.push(next);
		}
		while(!stk.empty()){
			int e = stk.pop();
			int nge = -1;
			System.out.println("Element : "+e + "   NGE : "+ e);
		}
	}
}
public class NGE {
	public static void main(String args[]){
		int A[]=new int[] {4, 5, 2, 25};
		NGEUtil obj = new NGEUtil();
		obj.findNGE(A);
	}
}
