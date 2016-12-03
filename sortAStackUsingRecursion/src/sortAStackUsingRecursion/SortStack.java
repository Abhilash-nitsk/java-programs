package sortAStackUsingRecursion;

import java.util.Stack;

public class SortStack {
	void insertAtBottom(Stack<Integer> stk,int v)
	{
	    if (stk.isEmpty())
	        stk.push(v);
	    else
	    {
	        int temp = stk.pop();
	        insertAtBottom(stk,v);
	        stk.push(temp);
	    }
	}

	void reverse(Stack<Integer> stk)
	{
	    if (!stk.isEmpty())
	    {
	        int temp = stk.pop();
	        reverse(stk);
	        insertAtBottom(stk, temp);
	    }
	}
	public void sortInsert(Stack<Integer> stk,int val){
		if(stk.isEmpty()||stk.peek()<val){
			stk.push(val);
			return;
		}
		int temp = stk.pop();
		sortInsert(stk, val);
		stk.add(temp);
	}
	public void sort(Stack<Integer> stk){
		if(!stk.isEmpty()){
			int x=stk.pop();
			sort(stk);
			sortInsert(stk, x);
		}
	}
	public static void main(String args[]){
		Stack<Integer> stk = new Stack<Integer>();
		stk.add(1);
		stk.add(2);
		stk.add(5);
		stk.add(3);
		stk.add(6);
		stk.add(4);
		SortStack obj = new SortStack();
		System.out.println(stk);
		//obj.reverse(stk);
		//System.out.println(stk);
		obj.sort(stk);
		System.out.println(stk);

	}
}
