package test;

class node{
	int val;
	node next;
	public node(int v){
		next=null;
		val=v;
	}
}
public class test{  
	public void displayList(node n){
		if(n==null)
			return;
		System.out.print(n.val+" ");
		displayList(n.next);
	}
	
	public void t(node root){
		if(root==null)
				return;
		System.out.print(root.val+" ");
		if(root.next!=null){
			t(root.next.next);
		}
		
		System.out.print(root.val+" ");
	}
public static void main(String args[]){  
  node n1=new node(1);
  node n2=new node(2);
  node n3=new node(3);
  node n4=new node(4);
  node n5=new node(5);
  n4.next=n5;
  n3.next=n4;
  n2.next=n3;
  n1.next=n2;
  test obj = new test();
  obj.displayList(n1);
  System.out.println();
  obj.t(n1);
}  
} 