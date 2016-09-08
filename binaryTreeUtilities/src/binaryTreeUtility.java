import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node{
	int val;
	Node left;
	Node right;
	public Node(int v){
		val=v;
		left=null;
		right=null;
	}
	public Node(){
		val=0;
		left=right=null;
	}

}
public class binaryTreeUtility {
	
	//Method to display the given tree
	public void display(Node n){
		if(n==null)
			return;
		if(n.left!=null)
			display(n.left);
		System.out.print(n.val+" ");
		if(n.right!=null)
			display(n.right);
	}
	
	//Method to find the number of nodes in the given tree
	public int sizeOfTree(Node Tree){
		if(Tree==null)
			return 0;
		return (sizeOfTree(Tree.left)+1 + sizeOfTree(Tree.right));
		//return 0;
	}
	
	//Method to find the height of the given tree
	public int height(Node n){
		if(n==null) 
			return 0;
		int lh = height(n.left);
		int rh = height(n.right);
		if(lh>rh)
			return lh+1;
		else
			return rh+1;
	}
	
	//Program to print the nodes in the given level of the given tree
	public void printGivenLevel(Node n,int level){
		if(n==null||level<0)
			return;
		if(level==0)
			System.out.print(n.val+" ");
		printGivenLevel(n.left,level-1);
		printGivenLevel(n.right,level-1);
	}
	
	//Program to print the Level order traversal of the binary tree
	public void levelOrder(Node n){
		if(n==null)
			return;
		int h = height(n);
		for(int i=0;i<h;i++){
			printGivenLevel(n,i);
			System.out.println();
		}
	}
	
	//Method to determine if two trees are identical
	public boolean isIdentical(Node n1,Node n2){
		if(n1==null&&n2==null)
			return true;
		if(n1==null||n2==null)
			return false;
		if(n1.val==n2.val&&isIdentical(n1.left,n2.left)&&isIdentical(n1.right,n2.right))
			return true;
		return false;
			
	}
	
	//Method to return the mirror image of the given binary tree
	public Node mirror(Node  n){
		if(n==null)
			return n;
		Node left=mirror(n.left);
		Node right=mirror(n.right);
		n.left=right;
		n.right=left;
		return n;
	}
	
	//Method to check if the given node is a leaf node or not
	public boolean isLeaf(Node n){
		if(n==null) 
			return false;
		if(n.left==null&&n.right==null)
			return true;
		return false;
	}
	
	//Method to print the elements of the given array
	public void printArray(ArrayList<Integer> A){
		if(A==null) 
			return;
		for(int i=0;i<A.size();i++)
			System.out.print(A.get(i)+" ");
		System.out.println();
	}
	//Method to print all the paths from root to all the leaves
	public void root2Leaf(Node n){
		ArrayList<Integer> A=new ArrayList<Integer>();
		if(n==null) 
			return;
		root2LeafUtil(n,A);
	}
	//Utility method used for helping the root2Leaf() method print the path 
	public void root2LeafUtil(Node n,ArrayList<Integer> A){
		if(n==null)
			return;
		A.add(n.val);
		if(isLeaf(n)){
			printArray(A);
			A.remove(A.size()-1);
			return;
		}
		else{
			root2LeafUtil(n.left, A);
			root2LeafUtil(n.right, A);
			A.remove(A.size()-1);
		}
	}
	
	//Method to count the number of leaf nodes in the given tree
	public int countLeaves(Node n){
		if(n==null)
			return 0;
		if(isLeaf(n))
			return 1;
		return(countLeaves(n.left)+countLeaves(n.right));
		
	}
	
	//Method To Perform Level Order Traversal using Queue
	public void levelOrderQ(Node n){
		if(n==null)
			return;
		Queue<Node> q = new LinkedList<Node>();
		q.add(n);
		while(!q.isEmpty()){
			Node temp = q.poll();
			System.out.print(temp.val+" ");
			if(temp.left!=null)
				q.add(temp.left);
			if(temp.right!=null)
				q.add(temp.right);
		}
	}
	
	//Method for printing the given binary tree in spiral level order way
	public void spiralLevelOrder(Node n){
		if(n==null)
			return;
		boolean flag=true;
		Stack<Node> stkT = new Stack<Node>();
		Stack<Node> stkF = new Stack<Node>();
		stkT.push(n);
		while(!stkT.isEmpty()||!stkF.isEmpty()){

				while(!stkT.isEmpty()){
					Node temp = stkT.pop();
					System.out.print(temp.val+" ");
					if(temp.right!=null)
						stkF.push(temp.right);
					if(temp.left!=null)
						stkF.push(temp.left);
				}
				while(!stkF.isEmpty()){
					Node temp = stkF.pop();
					System.out.print(temp.val+" ");
					if(temp.left!=null)
						stkT.push(temp.left);
					if(temp.right!=null)
						stkT.push(temp.right);
				}
			flag=!flag;
		}
	}
	//Main Method for the execution of the program 
	public static void main(String args[]){
		Node n0=new Node(0);
		Node n1=new Node(1);
		Node n2=new Node(2);
		Node n3=new Node(3);
		Node n4=new Node(4);
		Node n5=new Node(5);
		Node n6=new Node(6);
		Node n7=new Node(7);
		Node n8=new Node(8);
		n7.left=n6;
		n7.right=n8;
		n5.right=n7;
		n4.right=n5;
		n3.right=n4;
		n1.left=n0;
		n1.right=n2;
		n3.left=n1;
		//n3.display();
		binaryTreeUtility obj = new binaryTreeUtility();
		obj.spiralLevelOrder(n3);
		//System.out.println("The number of Leaves are : "+obj.countLeaves(n3));
		//obj.root2Leaf(n3);
		//System.out.println("Leaf or not : " + obj.isLeaf(n1)+"  "+obj.isLeaf(n2));
		//System.out.println(obj.sizeOfTree(n3));
		//obj.printGivenLevel(n3, 0);
		//System.out.println("Height="+obj.height(n3));
		//obj.levelOrder(n3);
		//System.out.println("Is identical trees : "+ obj.isIdentical(n3, n1));
//		n1.display();
//		n1=obj.mirror(n1);
//		n1.display();
	}
}
