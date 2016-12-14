import java.util.LinkedList;
import java.util.Queue;

class ModifiedTreeNode{
	int val;
	ModifiedTreeNode left;
	ModifiedTreeNode right;
	ModifiedTreeNode sibling;
	public ModifiedTreeNode(int v) {
		// TODO Auto-generated constructor stub
		val=v;
		left=right=sibling = null;
	}
}

public class ConnectNodesSameLevel {
	
	//method to display the tree in inorder fashion
	public void displayTree(ModifiedTreeNode root){
		if(root==null)
			return;
		displayTree(root.left);
		System.out.print(root.val+" ");
		displayTree(root.right);
	}
	
	
	//Method to connect the siblings of the given binary tree leftmost to rightmost
	public void connectSiblings(ModifiedTreeNode root){
		if(root==null)
			return;
		LinkedList<ModifiedTreeNode> nodeList = new LinkedList<ModifiedTreeNode>();
		LinkedList<Integer> depthList = new LinkedList<Integer>();
		nodeList.offer(root);
		depthList.offer(1);
		while(!nodeList.isEmpty()){
			ModifiedTreeNode topNode = nodeList.poll();
			int depth = depthList.poll();
			if(depthList.isEmpty()){
				topNode.sibling = null;
			}
			else if(depth<depthList.peek()){
				topNode.sibling = null;
			}
			else{
				topNode.sibling = nodeList.peek();
			}
			if(topNode.left!=null){
				nodeList.offer(topNode.left);
				depthList.offer(depth+1);
			}
			if(topNode.right!=null){
				nodeList.offer(topNode.right);
				depthList.offer(depth+1);
			}
		}
		System.out.println("Root left Sibling : "+root.left.sibling.val);
		System.out.println("Root left left Sibling : "+root.left.left.sibling.sibling.sibling.val);
	}
	
	
	
	//Main Method to implement the methods
	public static void main(String args[]){
		ModifiedTreeNode t1 = new ModifiedTreeNode(1);
		ModifiedTreeNode t2 = new ModifiedTreeNode(2);
		ModifiedTreeNode t3 = new ModifiedTreeNode(3);
		ModifiedTreeNode t4 = new ModifiedTreeNode(4);
		ModifiedTreeNode t5 = new ModifiedTreeNode(5);
		ModifiedTreeNode t6 = new ModifiedTreeNode(6);
		ModifiedTreeNode t7 = new ModifiedTreeNode(7);
		
		t2.left=t1;
		t2.right = t3;
		t6.left=t5;
		t6.right=t7;
		t4.left=t2;
		t4.right=t6;
		
		ConnectNodesSameLevel obj = new ConnectNodesSameLevel();
		obj.connectSiblings(t4);
		obj.displayTree(t4);
	}
}
