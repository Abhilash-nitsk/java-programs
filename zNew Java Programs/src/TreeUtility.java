import java.awt.List;
import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int v){
		val=v;
		left=right=null;
	}
}
public class TreeUtility {

	//Method to print the given tree in inorder travarsal
	public void displayTree(TreeNode root){
		if(root==null)
			return;
		displayTree(root.left);
		System.out.print(root.val+" ");
		displayTree(root.right);
	}

	
	//Method to print the given tree in PreOrder traversal
	public void displayPreOrder(TreeNode root){
		if(root==null)
			return;
		System.out.print(root.val + " ");
		displayPreOrder(root.left);
		displayPreOrder(root.right);
	}
	
	//Method to display the tree in Postorder Traversal
	public void displayPostOrder(TreeNode root){
		if(root==null)
			return;
		displayPostOrder(root.left);
		displayPostOrder(root.right);
		System.out.print(root.val + " ");
		
	}
	
	//Method to check if a given leaf is leaf or not
	public boolean isLeaf(TreeNode root){
		if(root.left==null&&root.right==null&&root!=null)
			return true;
		else
			return false;
	}
	
	//Method to display the tree in Inorder traversal without using recursion 
	public void displayInorderIter(TreeNode root){
		if(root==null)
			return;
		Stack<TreeNode> stk = new Stack<TreeNode>();
		while(root!=null){
			stk.push(root);
			root=root.left;
		}
		while(stk.size()!=0){
			root = stk.pop();
			System.out.print(root.val+" ");
			if(root.right!=null){
				root=root.right;
				while(root!=null){
					stk.push(root);
					root=root.left;
				}
			}
		}
	}
	
	//Method to return the height of the given binary tree
	public int getHeight(TreeNode root){
		if(root==null)
			return 0;
		int lh = getHeight(root.left);
		int rh = getHeight(root.right);
		if(lh>rh)
			return lh+1;
		return rh+1;
	}
	
	
	//Method to print the level order traversal of the given binary tree using recursion
	public void levelOrder(TreeNode root){
		if(root==null)
			return;
		int h = getHeight(root);
		for(int i=0;i<=h;i++){
			levelOrderUtil(root,i);
		}
		
	}
	
	public void levelOrderUtil(TreeNode root, int curHeight){
		if(root==null)
			return;
		if(curHeight==0)
			System.out.print(root.val+" ");
		levelOrderUtil(root.left,curHeight-1);
		levelOrderUtil(root.right,curHeight-1);

	}
	
	//Method to print the tree level order wise without using recursion
	public void levelOrderIter(TreeNode root){
		if(root==null)
			return;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while(q.size()>0){
			TreeNode t = q.poll();
			System.out.print(t.val+" ");
			if(t.left!=null)
				q.add(t.left);
			if(t.right!=null)
				q.add(t.right);
		}
	}
	
	//Method to print the size of the tree
	public int sizeTree(TreeNode root){
		if(root==null)
			return 0;
		return (sizeTree(root.left)+sizeTree(root.right)+1);
	}
	
	//Method to print the level order Traversal of hte given tree line by line
	public void levelOrderLineByLine(TreeNode root){
		if(root==null)
			return;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while(true){
			int nodeC = q.size();
			if(nodeC==0)
				break;
			while(nodeC>0){
				TreeNode t = q.poll();
				System.out.print(t.val+" ");
				if(t.left!=null)
					q.add(t.left);
				if(t.right!=null)
					q.add(t.right);
				nodeC--;
			}
			System.out.println();
		}
	}
	
	//Method to display weather the given two trees are identical or not
	public boolean isIdentical(TreeNode t1, TreeNode t2){
		if(t1==null&&t2==null)
			return true;
		if(t1==null||t2==null)
			return false;
		return(isIdentical(t1.left,t2.left)&&isIdentical(t1.right,t2.right)&&t1.val==t2.val);
	}
	
	//Method to convert the tree into into its mirror tree
	public TreeNode mirrorTree(TreeNode root){
		if(root==null)
			return root;
		TreeNode left = null , right = null;
		TreeNode l = mirrorTree(root.left);
		TreeNode r = mirrorTree(root.right);
		root.left = r;
		root.right = l;
		return root;
	}
	
	//Method to print the given array
	public void displayArray(int A[], int len){
		if(len==0)
			return;
		for(int i=0;i<len;i++)
			System.out.print(A[i]+" ");
		System.out.println();
	}
	
	
	//Method to print paths from root to every leaf in the given binary tree
	public void printPathLeaves(TreeNode root){
		if(root==null)
			return;
		ArrayList<Integer> list = new ArrayList<Integer>();
		int path[] = new int[1000];
		printPathLeavesUtil(root,path,0);
		
	}
	
	//Utility method for the printing the root to leaf path for every leaf in the given binary tree
	public void printPathLeavesUtil(TreeNode root, int[] path, int len){
		if(root==null)
			return;
		path[len] = root.val;
		if(isLeaf(root))
			displayArray(path,len+1);
		printPathLeavesUtil(root.left,path,len+1);
		printPathLeavesUtil(root.right,path, len+1);
	}
	
	//Method to count the leaf nodes in the given binary tree
	public int countLeafNode(TreeNode root){
		if(root==null)
			return 0;
		if(isLeaf(root))
			return 1;
		return (countLeafNode(root.left) + countLeafNode(root.right));
	}
	
	//Method to perform level Order Traversal in spiral order 
	public void levelOrderSpiral(TreeNode root){
		if(root==null)
			return;
		Stack<TreeNode> st1 = new Stack<TreeNode>();
		Stack<TreeNode> st2 = new Stack<TreeNode>();
		st1.push(root);
		while(st1.size()>0 || st2.size()>0){
			while(st1.size()>0){
				TreeNode t = st1.pop();
				System.out.print(t.val+" ");
				if(t.left!=null)
					st2.push(t.left);
				if(t.right!=null)
					st2.push(t.right);
			}
			while(st2.size()>0){
				TreeNode t = st2.pop();
				System.out.print(t.val+" ");
				if(t.right!=null)
					st1.push(t.right);
				if(t.left!=null)
					st1.push(t.left);
			}
		}
	}
	
	//Method to find the diameter of the given binary tree
	public int getDiameter(TreeNode root){
		if(root==null)
			return 0;
		int d = diameterUtil(root);
		return d;
	}
	
	//Utility Method for determination of the diameter of the binary tree
	public int diameterUtil(TreeNode root){
		 if(root==null)
			 return 0;
		 int lh = getHeight(root.left);
		 int rh = getHeight(root.right);
		 int ld = diameterUtil(root.left);
		 int rd = diameterUtil(root.right);
		 return(Math.max(lh+rh+1, Math.max(ld, rd)));
		 
	}
	
	//Method to find if the given tree is height balanced or not
	public boolean isHeightBalanced(TreeNode root){
		if(root==null)
			return true;
		boolean l = isHeightBalanced(root.left);
		boolean r = isHeightBalanced(root.right);
		if(!l||!r)
			return false;
		int lh = getHeight(root.left);
		int rh = getHeight(root.right);
		if(Math.abs(lh-rh)<=1)
			return true;
		return false;
	}
	
	public void printArray(int array[],int len){
		if(len==0)
			return;
		for(int i=0;i<len;i++)
			System.out.print(array[i]+" ");
	}
	
	//Method to return true if the sum of the path from root to any of the leaf is equal to the given path else return false
	public boolean hasPathGivenSum(TreeNode root, int sum){
		if(root==null){
			if(sum==0)
				return true;
			else
				return false;
		}
		return(hasPathGivenSum(root.left, sum-root.val)||hasPathGivenSum(root.right, sum-root.val));
		
	}
	
	//Method to input the tree and return the double tree of the given tree
	public void doubleTree(TreeNode root){
		if(root==null)
			return;
		doubleTree(root.left);
		doubleTree(root.right);
		TreeNode left = root.left;
		root.left=new TreeNode(root.val);
		root.left.left = left;
	}
	
	//Method to return the 
	
//---------------------------------------------------------------------------------------------------------------------------------------------	
	
	
	
	
	//Main Method for the execution of the methods
	public static void main(String args[]){
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);

		t5.left=t4;
		t5.right=t6;
		t2.left=t1;
		t2.right=t3;
		t3.right=t5;
		/*t6.left=t5;
		t6.right=t7;
		t2.right=t3;
		t2.left=t1;
		t4.left=t2;
		t4.right=t6;*/
		TreeUtility obj = new TreeUtility();
		obj.displayTree(t2);
		System.out.println();
		obj.doubleTree(t2);
		obj.displayTree(t2);
		//int path[] = new int[200];
		//System.out.println("The "+obj.hasPathGivenSum(t4,89));
		//System.out.println("The Diameter  : "+obj.diameterUtil(t4));
		//System.out.println("Height is : "+obj.getHeight(t4));
		//obj.levelOrderSpiral(t4);
		//System.out.println("Total Num of Leaves are : "+obj.countLeafNode(t3));
		//obj.printPathLeaves(t2);
		//TreeNode t = obj.mirrorTree(t2);
		//obj.displayTree(t);
		//System.out.println("Are Trees Identical :  "+ obj.isIdentical(t3, t2));
		//obj.levelOrderLineByLine(t2);
		//System.out.println(obj.sizeTree(t2));
		//System.out.println("The Height : "+obj.getHeight(t2));
		//obj.displayInorderIter(t2);
		//obj.displayTree(t2);
		//System.out.println("Is Root : " + obj.isLeaf(t2) + " is Leaf"+ obj.isLeaf(t6));
		//obj.displayPreOrder(t2);
		//System.out.println();
		//obj.displayPostOrder(t2);
		//obj.displayInorderIter(t2);
		
	}
}
