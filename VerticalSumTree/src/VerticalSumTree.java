import java.util.HashMap;

class Node{
	int val;
	Node left;
	Node right;
	public Node(int v){
		val=v;
		left=right=null;
	}
}
public class VerticalSumTree {

	/** Method to print the given tree */
	public void display(Node n){
		if(n==null)
			return;
		display(n.left);
		System.out.print(n.val+" ");
		display(n.right);
	}
	
	/** Utility Method to display the vertical SUm of the columns of the tree */
	public void verticalSumUtil(Node root, int dis, HashMap<Integer,Integer> mp){
		if(root==null)
			return;
		if(mp.containsKey(dis)){
			int v = mp.get(dis);
			v = v + root.val;
			mp.put(dis, v);
		}
		else
			mp.put(dis, root.val);
		verticalSumUtil(root.left, dis-1, mp);
		verticalSumUtil(root.right, dis+1, mp);
	}
	
	/** Method to print the Vertical Sum of the tree columns */
	public void verticalSum(Node root){
		if(root==null)
			return;
		int dis=0;
		HashMap<Integer,Integer> mp = new HashMap<Integer,Integer>();
		verticalSumUtil(root,dis, mp);
		System.out.println(mp);
	}
	
	/** Main Method to Run the other Utility methods */
	public static void main(String args[]){
		Node n1=new Node(1);
		Node n2=new Node(2);
		Node n3=new Node(3);
		Node n4=new Node(4);
		Node n5=new Node(5);
		Node n6=new Node(6);
		n5.left=n4;
		n5.right=n6;
		n3.right=n5;
		n2.left=n1;
		n2.right=n3;
		VerticalSumTree obj = new VerticalSumTree();
		obj.display(n2);
		obj.verticalSum(n2);
	}
}

