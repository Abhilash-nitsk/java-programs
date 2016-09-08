import java.util.Stack;

class node{
	int val;
	node next;
	public node(int v){
		val=v;
	}
	public void display(){
		if(this==null) return;
		System.out.println(this.val);
		if(this.next!=null)
			this.next.display();
	}
	
}

public class sortStack {
	public void reverse(Stack<Integer> stk){
		if(stk.isEmpty())
			return;
		int v = stk.pop();
		reverse(stk);
		insertBottom(stk,v);
	}
	public void insertBottom(Stack<Integer> stk,int v){
		if(stk.isEmpty()) 
			stk.push(v);
		else{
			int temp = stk.pop();
			insertBottom(stk,v);
			stk.push(temp);
		}
	}
	public void sortedInsert(Stack<Integer> stk,int v){
		if(stk.isEmpty()||stk.peek()<v){
			stk.push(v);
			return;
		}
		int temp = stk.pop();
		sortedInsert(stk,v);
		stk.push(temp);
	}
	public void sort(Stack<Integer> stk){
		if(stk.isEmpty()) return;
		int temp = stk.pop();
		sort(stk);
		sortedInsert(stk,temp);
		
	}
	public static void main(String args[]){
		Stack<Integer> stk = new Stack<Integer>();
		stk.add(1);
		stk.add(4);
		stk.add(3);
		stk.add(2);
		stk.add(5);
		System.out.println(stk);
		sortStack obj = new sortStack();
		obj.sort(stk);
		System.out.println(stk);
	}

}
