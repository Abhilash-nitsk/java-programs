//import java.io.ObjectInputStream.GetField;
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

/** Class so that we can pass around the value of maxSum in multiple recursion calls */
class maxSum{
	int v;
}

public class BinaryTreeUtil {
	
	/** Method to display the Tree */
	public void displayTree(Node n){
		if(n==null) return;
		if(n.left!=null)
			displayTree(n.left);
		System.out.print(n.val+" ");
		if(n.right!=null)
			displayTree(n.right);
	}
	
	/** Method to return the level of the given node in tree, if node exists in the tree else return 0 */
	public int getLevelNodeUtil(Node tree,int c,Node n){
		if(n==null|| tree==null) return 0;
		int d=0;
		if(n==tree) return c;
		if(tree.left!=null) 
			d=getLevelNodeUtil(tree.left,c+1,n);
		if(d!=0)
			return d;
		if(tree.right!=null) 
			d=getLevelNodeUtil(tree.right,c+1,n);	
		return d;
		}
	
	/** Method to display ancestors of the given node and return true if ancestor exist else return 0 */
	public boolean printAncestors(Node tree,Node n){
		if(tree==null) return false;
		if(tree.val==n.val)
			return true;
		if(printAncestors(tree.left,n)||printAncestors(tree.right,n)){
			System.out.print(tree.val+" ");
			return true;
		}
		return false;
		
	}
	
	/** Methos to return true if the given trees are identical else return false */
	public boolean isIdentical(Node root,Node n){
		if(root==null&&n==null) 
			return true;
		if(root==null||n==null)
			return false;
		return((root.val==n.val)&&isIdentical(root.left, n.left)&&isIdentical(root.right, n.right));
	}
	
	/** Method to return true when the given tree is the subtree of the first passed tree else return false */
	public boolean checkSubtree(Node root,Node n){
		if(n==null)
			return true;
		if (root == null)
	        return false;
		if(isIdentical(root, n)) 
			return true;
		return(checkSubtree(root.left, n)||checkSubtree(root.right, n));
		
	}
	
	/** Method to return true if the given tree is leaf else return false */
	public boolean isLeaf(Node root){
		if(root==null)
			return false;
		if(root.left==null&&root.right==null)
			return true;
		return false;
	}
	
	/** Method to check whether a given binary tree is complete binary tree or not */
	public boolean checkCompleteBT(Node root){
		if(root==null) 
			return true;
		if(isLeaf(root))
			return true;
		boolean flag =true;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()){
			Node t = q.poll();
			if(t.left!=null){
				if(!flag)
					return false;
				q.add(t.left);
			}
			else
				flag=false;
			if(t.right!=null){
				if(!flag)
					return false;
				q.add(t.right);
			}
			else
				flag=false;
		}
		return true;
	}
	
	/** Method to return true if the tree is singly else return false */
	public boolean isSingly(Node n,int c){
		if(n==null)
			return true;
		boolean leftC = isSingly(n.left,c);
		boolean rightC = isSingly(n.right,c);
		if(!leftC||!rightC)
			return false;
		if(n.left!=null&&n.val!=n.left.val)
			return false;
		if(n.right!=null&&n.val!=n.right.val)
			return false;
		c++;
		return true;
	}
	
	/** Method to return the sum of all the left leaf nodes in the given tree */
	public int sumLeftLeaves(Node n, boolean isLeft, int sum){
		if(n==null)
			return 0;
		if(isLeaf(n)&&isLeft)
			return (sum+n.val);
		return (sumLeftLeaves(n.left,true,sum) + sumLeftLeaves(n.right, false, sum));
	}
	
	/** Method to check if the given tree is symmetric or not */
	public boolean checkSymmetric(Node n){
		if(n==null)
			return true;
		if(isLeaf(n))
			return true;
		if(n.left!=null&&n.right!=null){
			return((n.left.val==n.right.val)&&checkSymmetric(n.left)&&checkSymmetric(n.right));
		}
		return false;
	}
	
	/** Method to check whether the given tree is full or not */
	public boolean isFullTree(Node n){
		if(n==null)
			return true;
		if(isLeaf(n))
			return true;
		if(n.left!=null&&n.right!=null && isFullTree(n.left)&& isFullTree(n.right))
			return true;
		return false;
	}
	
	/** Method to print the Left View of the Given Binary Tree */
	public void printLeftView(Node n){
		if(n==null)
			return;
		System.out.print(n.val+" ");
		if(n.left!=null)
				printLeftView(n.left);
		else if(n.right!=null){
				printLeftView(n.right);
		}
	}
	
	/** Method to print the leaves of the given binary tree */
	public void printLeaves(Node n){
		if(n==null)
			return;
		if(isLeaf(n))
			System.out.print(n.val+" ");
		if(n.left!=null)
			printLeaves(n.left);
		if(n.right!=null)
			printLeaves(n.right);
		
	}
	
	/** Method to print the Right View of the Given Binary Tree */
	public void printRightView(Node n){
		if(n==null)
			return;
		if(n.right!=null){
				printRightView(n.right);
				System.out.print(n.val+" ");
		}		
		else if(n.left!=null){
			printRightView(n.left);
				System.out.print(n.val+" ");

		}
	}
	
	
	/** Method to print the boundary elements of the given binary tree */
	public void printBoundary(Node n){
		if(n==null)
			return;
		System.out.print(n.val + " ");
		if(n.left!=null)
			printLeftView(n.left);
		else
			printLeftView(n.right);
		printLeaves(n.left);
		//printLeaves(n.right);
		if(n.right!=null)
			printLeftView(n.right);
		else
			printLeftView(n.left);
	}
	
	/** Method to return the largest element in the given BST */
	public Node largestNode(Node BST){
		if(BST==null)
			return BST;
		if(BST.right!=null){
			return largestNode(BST.right);
		}
		return BST;
	}
	
	/** Method to return the node with Smallest value in a given BST */
	public Node smallestNode(Node tree){
		if(tree==null)
			return tree;
		if(tree.left!=null){
			return smallestNode(tree.left);
		}
		return tree;
	}
	
	
	/** Method to print the ancestors of the given node in a given BST Iteratively */
	/*public void printAncestorsIter(Node tree, Node n){
		if(tree==null) 
			return;
		Stack<Node> stk = new Stack<Node>();
		//stk.push(tree);
		while(true){
			while(tree!=null&&tree.val!=n.val){
				stk.push(tree);
				if(tree.left!=null)
					tree=tree.left;
			}
			if(tree.val==n.val)
				break;
			if(stk.peek().right==null){
				tree=stk.pop();
			}
			while(!stk.isEmpty()&&stk.peek().right==tree)
				
			Node n = stk.pop();
		}
		
	}*/
	
	/** Main Method to run the program */
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
		//t1.right=t1;
		
		BinaryTreeUtil obj=new BinaryTreeUtil();
		obj.displayTree(n2);
		System.out.println();
		obj.printBoundary(n2);
		System.out.println("The smallest Node is : "+(obj.smallestNode(n2)).val);
		System.out.println();
		obj.maxSumPath(n2);
		//obj.printRightView(n2);
		//obj.printLeaves(n2);
		//System.out.println("Is Full or Not : "+obj.isFullTree(t1));
		//System.out.println("The Sum Of left Leaves are : "+obj.sumLeftLeaves(n2,false,0));
		//System.out.println(obj.checkSymmetric(t1));
		//int l = obj.getLevelNodeUtil(n2, 0, n3);
		//boolean b = obj.printAncestors(n2, n3);
		//System.out.println("are Identical or not : "+ obj.checkSubtree(n2, n3));

	}
}
