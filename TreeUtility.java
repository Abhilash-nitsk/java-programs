import java.awt.List;
import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;


// Class for simulate Each Node of the binary tree
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int v){
		val=v;
		left=right=null;
	}
}

// Class to use its object so that they can contain the value even after changed in any method such as maximum width
class MinMax{
	int min;
	int max;
	MinMax(){
		min=0;max=0;
	}
}

//class to use its object so that we can use it as reference
class LeafLevel{
	int leafLevel;
	public LeafLevel(){
		leafLevel=0;
	}
}


//Class to implement the Methods of the Tree Utility
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
	
	//Method to print the maximum width of the given binary tree using the very naive recursive level order traversal approach
	public int maxWidthNaive(TreeNode root){
		if(root==null)
			return 0;
		int maxWidth=0, width=0;
		int h = getHeight(root);
		for(int i=0;i<=h;i++){
			width=getWidth(root, i);
			if(width>maxWidth)
				maxWidth = width;
		}
		return maxWidth;
	}
	
	//Method to return the width of the given level of the given binary tree
	public int getWidth(TreeNode root, int level){
		if(root==null)
			return 0;
		if(level==1)
			return 1;
		return (getWidth(root.left, level-1)+getWidth(root.right,level-1));
	}
	
	//Method to return the width of the given binary tree using the optimized level order traversal which is using queue
	public int maxWidthQueue(TreeNode root){
		if(root==null)
			return 0;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		int maxWidth=0;
		q.add(root);
		while(q.size()>0){
			int n = q.size();
			if(n>maxWidth)
				maxWidth=n;	
			while(n>0){
				TreeNode t = q.poll();
				if(t.left!=null)
					q.add(t.left);
				if(t.right!=null)
					q.add(t.right);
				n--;
			}
		}
		return maxWidth;
	}
	
	//Method to return true is the given two trees are structurally similar
	public boolean isStructurallySame(TreeNode t1, TreeNode t2){
		if(t1==null&&t2==null)
			return true;
		if(t1!=null&&t2!=null&&isStructurallySame(t1.left, t2.left)&&isStructurallySame(t1.right, t2.right))
			return true;
		return false;
	}
	
	//Method to return true if the given tree is foldable otherwise return false
	public boolean isFoldable(TreeNode root){
		if(root==null)
			return true;
		return(isFoldable(root.left)&&isFoldable(root.right)&&isStructurallySame(root.left,root.right));
	}
	
	//Method to print the nodes of the given binary tree whose distance is k from the root
	public void printNodesDistK(TreeNode root, int k){
		if(root==null)
			return;
		levelOrderUtil(root, k);
	}
	
	 //Method to find the level of the given node in the given binary tree
	public int getLevel(TreeNode root, int node){
		if(root ==null)
			return 0;
		return getLevelUtil(root, node, 1);
	}
	
	 //Utility Method to find the level of the given node in the given binary tree
	public int getLevelUtil(TreeNode root, int node, int level){
		if(root==null)
			return 0;
		if(root.val==node)
			return level;
		int leftLevel = getLevelUtil(root.left, node, level+1);
		if(leftLevel!=0)
			return leftLevel;
		leftLevel = getLevelUtil(root.right, node, level+1);
		return leftLevel;
	}
	
	
	//Method to print the ancestors of the given node in the given binary tree
	public boolean printAncestors(TreeNode root, int node){
		if(root==null)
			return false;

		if(printAncestors(root.left, node)||printAncestors(root.right, node)){
			System.out.print(root.val + " ");
			return true;
		}
		if(root.val==node){
			System.out.print(root.val+" ");
			return true;
		}
		return false;
	}
	
	
	//Method to check if the given binary tree is a sum tree or not
	public boolean isSumTree(TreeNode root){
		if(root==null)
			return true;
		if(isLeaf(root))
			return true;
		int sum=0;
		if(root.left!=null)
			sum=root.left.val;
		if(root.right!=null)
			sum=sum+root.right.val;
		return(isSumTree(root.left)&&isSumTree(root.right)&&(sum==root.val));
	}
	

	//Method to check if the given tree is the subtree of the other given tree
	public boolean isSubtree(TreeNode parent, TreeNode child){
		if(parent==null&&child==null)
			return true;
		if(parent==null&&child!=null)
			return false;
		if(isIdentical(parent, child))
			return true;
		return(isSubtree(parent.left, child)||isSubtree(parent.right, child));
	}
	
	//Method to print the sum of the nodes lying vertically on the same line
	public void sumVertical(TreeNode root){
		if(root==null)
			return;
		HashMap<Integer, Integer> sumMap = new HashMap<Integer,Integer>();
		sumVerticalUtil(root,sumMap,0);
		System.out.println(sumMap);
	}
	
	//Utility Method to sum the nodes lying at the same horizontal distance from the root 
	public void sumVerticalUtil(TreeNode root, HashMap<Integer,Integer> sumMap, int h){
		if(root==null)
			return;
		if(sumMap.containsKey(h)){
			sumMap.put(h,sumMap.get(h)+root.val);
		}
		else
			sumMap.put(h,root.val);
		sumVerticalUtil(root.left, sumMap, h-1);
		sumVerticalUtil(root.right, sumMap, h+1);
	}
	
	//Method to find the maximum sum path in given binary tree
	public boolean isComplete(TreeNode root){
		if(root==null)
			return true;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		boolean flag = false;
		while(q.size()>0){
			TreeNode node = q.poll();
			if(node.left!=null){
				if(flag==true)
					return false;
				q.offer(node.left);
			}
			else
				flag=true;
			if(node.right!=null){
				if(flag==true)
					return false;
				q.offer(node.right);
			}
			else
				flag=true;
		}
		return true;
	}
	
	//Method to print the leftView of the given binary tree
	public void printLeftView(TreeNode root){
		if(root==null)
			return;
		System.out.print(root.val+" ");
		if(root.left!=null){
			printLeftView(root.left);
		}
		else if(root.right!=null){
			//System.out.println(root.val+" ");
			printLeftView(root.right);
		}
	}
	
	//Method to print the rightView of the given binary tree
	public void printRightView(TreeNode root){
		if(root==null)
			return;
		if(root.right!=null)
			printRightView(root.right);
		else if(root.left!=null)
			printRightView(root.left);
		System.out.print(root.val + " ");

	}
	
	
	//Method to print the left view of the given binary tree iteratively
	public void printLeftViewIter(TreeNode root){
		if(root==null)
			return;
		while(root!=null){
			System.out.print(root.val+" ");
			if(root.left!=null)
				root=root.left;
			else
				root=root.right;
		}
	}
	
	//Method to print the bottom view of the given binary tree
	public void printBottomView(TreeNode root){
		if(root==null)
			return;
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		printBottomViewUtil(root, map,0);
		//System.out.println(map);
		Set<Entry<Integer,Integer>> obj = map.entrySet();
		for(Entry<Integer,Integer> i : obj){
			int v = i.getValue();
			System.out.print(v+" ");
		}
	}
	
	//Utility Method to print the bottom view of the given binary tree
	public void printBottomViewUtil(TreeNode root, TreeMap<Integer,Integer> map, int dist){
		if(root==null)
			return;
		map.put(dist, root.val);
		printBottomViewUtil(root.left, map, dist-1);
		printBottomViewUtil(root.right, map, dist+1);
	}
	
	//Method to print the boundary traversal of the given binary tree
	public void boundaryTraversal(TreeNode root){
		if(root==null)
			return;
		printLeftView(root);
		printBottomView(root);
		printRightView(root);
	}
	
	//Method to print the Preorder traversal of the given binary tree iteratively
	public void preorderIter(TreeNode root){
		if(root==null)
			return;
		Stack<TreeNode> stk = new Stack<TreeNode>();
		//System.out.println(root.val+" ");
		stk.add(root);
		while(!stk.isEmpty()){
			TreeNode node  = stk.pop();
			System.out.print(node.val+" ");

			if(node.right!=null)
				stk.push(node.right);
			if(node.left!=null)
				stk.push(node.left);
		}
	}
	
	//Method to print the reverse level order traversal of the given binary tree
	public void reverseLevelOrder(TreeNode root){
		if(root==null)
			return;
		Stack<TreeNode> stk = new Stack<TreeNode>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while(!q.isEmpty()){
			TreeNode node = q.poll();
			stk.add(node);
			if(node.right!=null)
				q.add(node.right);
			if(node.left!=null)
				q.add(node.left);
		}
		while(!stk.isEmpty())
			System.out.print(stk.pop().val+" ");
	}
	
	//Method to check if the given 2 binary treea are isomorphic or not
	public boolean isIsomorphic(TreeNode t1, TreeNode t2){
		if(t1==null&&t2==null)
			return true;
		if(t1==null||t2==null)
			return false;
		if((isIsomorphic(t1.left, t2.left)&&isIsomorphic(t1.right, t2.right))||(isIsomorphic(t1.left, t2.right)&&isIsomorphic(t1.right, t2.left))&& t1.val==t2.val)
			return true;
		return false;
	}
	
	
	//Method to find the height of the binary tree iteratively
	public int heightIter(TreeNode root){
		if(root==null)
			return 0;
		int height=0;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while(true){
		int nodeC = q.size();
		if(nodeC==0)
			break;
		height++;
			while(nodeC>0){
				TreeNode node = q.poll();
				nodeC--;
				if(node.left!=null){
					q.add(node.left);
				}
				if(node.right!=null){
					q.add(node.right);
				}
			}

		}
		return height;
	}
	
	//Method to find the depth of the deepest odd level node in the given binary tree
	public int depthOfDeepestOddLeaf(TreeNode root){
		return depthOfDeepestOddLeafUtil(root,1,1);
	}
	
	public int depthOfDeepestOddLeafUtil(TreeNode root, int level, int maxLevel){
		if(root==null)
			return 1;
		if(level%2==0&&isLeaf(root)&& level>maxLevel)
			return level;
		return Math.max(depthOfDeepestOddLeafUtil(root.left, level+1,maxLevel),depthOfDeepestOddLeafUtil(root.right, level+1,maxLevel));
	}
	
	// Method to check if all the leaves of the given binary tree are at the same level or not
	public boolean checkLeavesAtSameLevel(TreeNode root){
		if(root==null)
			return false;
		LeafLevel l = new LeafLevel();
		return(checkLeavesAtSameLevelUtil(root,l,1));
	}
	
	
	
	//Utility Method to check if all the leaves of the given binary tree are at the same level or not
	public boolean checkLeavesAtSameLevelUtil(TreeNode root, LeafLevel leaf, int curLevel){
		if(root==null)
			return true;
		if(isLeaf(root)){
			if(leaf.leafLevel==0){
				leaf.leafLevel=curLevel;
				return true;
			}
			else{
				if(curLevel!=leaf.leafLevel)
					return false;
				return true;
			}
		}
		else{
			return (checkLeavesAtSameLevelUtil(root.left, leaf,curLevel+1)&&checkLeavesAtSameLevelUtil(root.right, leaf, curLevel+1));
		}
	}
	
	//Method to return the deepest left leaf node in the given binary tree
	TreeNode result = new TreeNode(0);
	public TreeNode deepestLeftLeaf(TreeNode root){
		if(root==null)
			return root;
		MinMax max = new MinMax();
		max.max=0;
		deepestLeftLeafUtil(root, 0, max, false);
		System.out.println("The deepest left leaf is :  "+ result.val);
		return result;
	}
	public void deepestLeftLeafUtil(TreeNode root, int level, MinMax maxLevel, boolean isLeft){
		if(root==null)
			return;
		if(isLeft && level > maxLevel.max && isLeaf(root)){
			maxLevel.max=level;
			result =root;
			return;
		}
		deepestLeftLeafUtil(root.left, level+1, maxLevel, true);
		deepestLeftLeafUtil(root.right, level+1, maxLevel, false);
	}
	
	//Method to print the next right node of the given node in the given binary tree
	public TreeNode nextRightNode(TreeNode root, int input){
		if(root==null)
			return null;
		Queue<TreeNode> qn = new LinkedList<TreeNode>();
		Queue<Integer> ql = new LinkedList<Integer>();
		qn.add(root);
		ql.add(0);
		while(!qn.isEmpty()){
			TreeNode node = qn.poll();
			int level = ql.poll();
			if(node.val==input){
				if(ql.size()==0||ql.peek()!=level)
					return null;
				return qn.peek();
			}
			if(node.left!=null){
				qn.add(node.left);
				ql.add(level+1);
			}
			if(node.right!=null){
				qn.add(node.right);
				ql.add(level+1);
			}
		}
		return null;
	}
	
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
		/*t5.left=t4;
		t5.right=t6;
		t2.left=t1;
		t2.right=t3;
		t3.right=t5;*/
		t6.left=t5;
		t6.right=t7;
		t2.right=t3;
		t2.left=t1;
		t4.left=t2;
		t4.right=t6;
		
		
		TreeUtility obj = new TreeUtility();
		obj.displayTree(t4);
		System.out.println();
		TreeNode res = obj.nextRightNode(t4,1);
		if(res==null)
			System.out.println("does not exist");
		else
			System.out.println("Next Node to the right of the node is  "+ res.val);
		//System.out.println("The height is : "+obj.heightIter(t2));
		//System.out.println("Is Isomorphic + "+obj.isIsomorphic(t4,s4));
		//obj.preorderIter(t4);
		//System.out.println("The left view : \n");
		//obj.boundaryTraversal(t4);
		//System.out.println("The tree is complete : "+obj.isComplete(t4));
		//obj.sumVertical(t4);
		//System.out.println("are identical : "+ obj.isSubtree(t4, s6));
		//System.out.println("is Sum Tree : "+obj.isSumTree(t2));
		//boolean t = obj.printAncestors(t4, 7);
		//System.out.println("The height is : "+ obj.getLevel(t4, 3));
		//System.out.println("tree is foldable or not :  " + obj.isFoldable(t4));
		//System.out.println("is Structurally same : " + obj.isStructurallySame(t4,s4));
		//System.out.println("The max width is : " + obj.maxWidthQueue(t4));
		//System.out.println("The width is : "+obj.maxWidthNaive(t4));
		//obj.doubleTree(t2);
		//obj.displayTree(t2);
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
