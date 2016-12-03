import java.util.LinkedList;
import java.util.Queue;

class Node{
	int val;
	Node left;
	Node right;
	public Node(int v){
		val=v;
		left=right=null;
	}
}

class Index{
	int index;
}

public class ReverseAlternateLevelNodes {
	
	Index indexObj = new Index();
	
	/** Method to store the alternate levels in a given array */
	public void storeAlternateNodes(Node root, int oddLevels[], int level, Index i){
		if(root==null)
			return;
			storeAlternateNodes(root.left, oddLevels, level+1, i);
			if(level%2!=0){
				oddLevels[i.index]=root.val;
				i.index++;
			}
	}
	
	/** Method to reverse the given array */
	public void reverse(int A[], Index index){
		int l=0;
		int h=index.index;
		while(l<h){
			int t = A[l];
			A[l] = A[h];
			A[h] = t;
			h--;
			l++;
		}
	}
	
	/** Method to Modify the tree */
	public void modifyTree(Node root, int A[], Index in, int l){
		if(root==null)
			return;
		modifyTree(root.left,A, in,l+1);
	//	storeAlternateNodes(root.left);
	}
	
	/** Method to display the Tree */
	public void displayTree(Node n){
		if(n==null) return;
		if(n.left!=null)
			displayTree(n.left);
		System.out.print(n.val+" ");
		if(n.right!=null)
			displayTree(n.right);
	}

	public static void main(String args[]){
		Node n1=new Node(1);
		Node n2=new Node(2);
		Node n3=new Node(3);
		Node n4=new Node(4);
		Node n5=new Node(5);
		n4.left=n3;
		n4.right=n5;
		n2.left=n1;
		n2.right=n4;
		Node t1 = new Node(1);
		Node t2=new Node(2);
		t1.left=t2;
		ReverseAlternateLevelNodes obj=new ReverseAlternateLevelNodes();
		obj.displayTree(n2);
		System.out.println();
		
	}
}