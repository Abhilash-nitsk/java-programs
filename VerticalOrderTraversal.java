import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

class Node{
	int val;
	Node left;
	Node right;
	public Node(int v){
		val=v;
		left=right=null;
	}
}
class Max{
	int max;
	public Max(){
		max=0;
	}
}
class Min{
	int min;
	public Min(){
		min=0;
	}
}
public class VerticalOrderTraversal {
	
	public void inorderDisplay(Node root){
		if(root==null)
			return;
		inorderDisplay(root.left);
		System.out.print(root.val+" ");
		inorderDisplay(root.right);
	}
	
	public void maxWidth(Node root, Max max, Min min, int hd){
		if(root==null)
			return;		
		if(max.max<hd)
			max.max=hd;
		if(min.min>hd)
			min.min=hd;
		maxWidth(root.left, max, min, hd-1);
		maxWidth(root.right, max, min, hd+1);
	}
	
	/** Method to Print the vertical traversal of the binarty tree using resursion */
	/*public void verOrderDisplayUtl(Node root, int d, int hd){
		if(root==null)
			return;
		verOrderDisplayUtl(root.left, d-1, hd);
		if(d==hd)
			System.out.print(root.val+" ");
		verOrderDisplayUtl(root.right, d+1, hd);
	}
	public void verOrderDisplay(Node root,Max max, Min min){
		for(int i=min.min;i<=max.max;i++){
			verOrderDisplayUtl(root,0,i);
		}
	}*/
	
	
	
	
	public static void main(String args[]){
		Node n1=new Node(1);
		Node n2=new Node(2);
		Node n3=new Node(3);
		Node n4=new Node(4);
		Node n5=new Node(5);
		Node n6=new Node(6);
		Node n7=new Node(7);
		Node n8=new Node(8);
		n7.right=n8;
		n7.left=n6;
		n5.right=n7;
		n5.left=n4;
		n1.right=n2;
		n3.left=n1;
		n3.right=n5;
		VerticalOrderTraversal obj = new VerticalOrderTraversal();
		obj.inorderDisplay(n3);
		Max max = new Max();
		Min min = new Min();
		obj.maxWidth(n3, max, min, 0);
		System.out.println("max is: "+ max.max+"  min is : "+ min.min);
		//obj.verOrderDisplay(n3, max,min);
		//System.out.println("The max width is : "+obj.maxWidth(n3,0,0) );
	}
}
