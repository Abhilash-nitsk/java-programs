
class Node{
	int val;
	Node left;
	Node right;
	public Node(int v){
		val=v;
		left=right=null;
	}
}

public class DiffOddEvenLevel {
	
	/** Method to return the sum of the Nodes in the same level */
	public int sumNodesSameLevel(Node root,int level){
		if(root==null)
			return 0;
		if(level==0)
			return root.val;
		return(sumNodesSameLevel(root.left, level-1)+sumNodesSameLevel(root.right, level-1));
	}
	
	/** Method to print the given Binary tree Inorder */
	public void printTree(Node root){
		if(root==null)
			return;
		printTree(root.left);
		System.out.print(root.val+" ");
		printTree(root.right);
	}
	
	/** Method to find the height of the given binary tree */
	public int heightTree(Node root){
		if(root==null)
			return 0;
		int lh = heightTree(root.left);
		int rh = heightTree(root.right);
		if(lh>rh)
			return lh+1;
		return rh+1;
	}
	/** Method to find the difference between odd and even level of the binary tree */
	public int diffOddEvenLevel(Node root){
		int evenSum=0,oddSum=0, k=0;
		for(int i=0;i<heightTree(root);i++){
			if(k%2==0)
				evenSum += sumNodesSameLevel(root, i);
			else
				oddSum += sumNodesSameLevel(root, i);
			k++;
		}
		
		return oddSum-evenSum;
	}
	
	/** Main Method to run all the utility methods */
	public static void main(String args[]){
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		//n5.left=n4;
		//n5.right=n6;
		//n3.right=n5;
		n2.left=n1;
		n2.right=n3;
		DiffOddEvenLevel obj = new DiffOddEvenLevel();
		obj.printTree(n2);
		int sum = obj.sumNodesSameLevel(n2, 3);
		//System.out.println(" Sum is : "+sum);
		System.out.println("Height : "+obj.diffOddEvenLevel(n2));
	}
}
