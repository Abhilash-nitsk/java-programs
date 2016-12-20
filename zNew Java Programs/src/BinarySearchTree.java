import java.util.Stack;

class BSTNode{
	int val;
	BSTNode left;
	BSTNode right;
	public BSTNode(int v){
		val=v;
		left=right=null;
	}
}
public class BinarySearchTree {
	
	//Method to display the BST 
	public void display(BSTNode root){
		if(root==null)
			return;
		display(root.left);
		System.out.print(root.val+" ");
		display(root.right);
	}
	
	//Method to insert a node in the BST without dups
	public BSTNode insertBST(BSTNode root, int node){
		if(root==null){
			root = new BSTNode(node);
			return root;
		}
		if(root.val>node)
			root.left= insertBST(root.left, node);
		else
			root.right= insertBST(root.right, node);
		return root;
	}
	
	//Method to return the node if it is present in the given binary search tree
	public BSTNode searchNode(BSTNode root, int node){
		if(root==null||root.val==node)
			return root;
		if(root.val>node)
			return searchNode(root.left,node);
		else
			return searchNode(root.right,node);
	}
	
	//Method to delete a given node from the given binary search tree
	public BSTNode deleteKey(BSTNode root, int key){
		if(root==null)
			return root;
		if(root.val>key)
			root.left=deleteKey(root.left,key);
		else if(root.val<key)
			root.right =deleteKey(root.right,key);
		else{
			if(root.left==null)
				return root.right;
			else if(root.right==null)
				return root.left;
			 root.val = minNode(root.right);
			 root.right = deleteKey(root.right, root.val);
		}
		return root;
	}
	
	//Method to return the value of the minimum node in the given binary search tree
	public int minNode(BSTNode root){
		if(root==null)
			return 0;
        while (root.left != null)
            root = root.left;
        return root.val;
	}
	
	//Method to return the value of the maximum node in the given binary search tree
	public int maxNode(BSTNode root){
		if(root==null)
			return 0;
		while(root.right!=null)
			root=root.right;
		return root.val;
	}
	
	//Method to find the inorder predecessor and inorder sucessor
	public void inorderPredSucc(BSTNode root, int key){
		if(root==null)
			return;
		BSTNode suc = new BSTNode(0);
		BSTNode pre = new BSTNode(0);
		inorderPredSuccUtil(root, key,suc,pre);
		System.out.println("The pre is : " + pre.val+"  Successor is : "+suc.val);
	}
	
	//Utility method
	public void inorderPredSuccUtil(BSTNode root, int key, BSTNode pre, BSTNode suc){
		if(root==null)
			return;
		
		if(root.val==key){
			if(root.left!=null){
				BSTNode rt = root.left;
				while(rt.right!=null)
					rt=rt.right;
				pre = rt;
				System.out.println("Inside the method the value of pre  " + pre.val);
			}
			
			if(root.right!=null){
				BSTNode lt = root.right;
				while(lt.left!=null)
					lt=lt.left;
				suc = lt;
				System.out.println("Inside the method the value of pre  " + suc.val);
			}
		}
		if(key<root.val){
			suc = root;
			inorderPredSuccUtil(root.left, key, pre, suc);
			
		}
		else{
			pre = root;
			inorderPredSuccUtil(root.right, key, pre, suc);
		}
		return;
	}
	
	
	//Method to check if the given binary tree is binary search tree or not
	public boolean isBSTNaive(BSTNode root){
		if(root==null)
			return true;
		if(root.left!=null&&maxNode(root.left)>root.val)
			return false;
		if(root.right!=null&&maxNode(root.right)<root.val)
			return false;
		if(!isBSTNaive(root.left)||!isBSTNaive(root.right))
			return false;
		return true;
		
	}
	
	//Method to check if the given binary tree is BST or not non-naive method (most efficient)
	public boolean isBST(BSTNode root){
		if(root==null)
			return true;
		boolean res = isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		return res;
	}
	
	//Utility Method fot isBST
	public boolean isBSTUtil(BSTNode root, int min, int max){
		if(root==null)
			return true;
		if(root.val>max||root.val<min)
			return false;
		return(isBSTUtil(root.left, min, root.val)&&isBSTUtil(root.right,root.val, max));
	}
	
	//Method to find the LCA of the given nodes in the given BST
	public BSTNode LCABST(BSTNode root, BSTNode key1, BSTNode key2){
		if(root==null)
			return root;
		if(root.val<key1.val && root.val<key2.val)
			return LCABST(root.right,key1,key2);
		if(root.val>key1.val && root.val>key2.val)
			return LCABST(root.left,key1,key2);
		return root;
	}
	
	//Method to print the k smallest node in the given binary search tree
	public void KSmallestRecur(BSTNode root, int k){
		if(root==null||k<0)
			return ;
		KSmallestRecur(root.left,k-1);
		if(k==0){
			System.out.print(root.val+" ");
			return;
		}
		KSmallestRecur(root.right,k-1);
	}
	
	//Method to print the Kth smallest node in the BST using iteration
	public void KSmallestIter(BSTNode root, int k){
		if(root==null)
			return;
		BSTNode t = null ;
		Stack<BSTNode> stk = new Stack<BSTNode>();
		while(root.left!=null){
			stk.push(root);
			root=root.left;
		}
		while(stk.size()>0&&k>1){
			t = stk.pop();
			k--;
			if(t.right!=null){
				root=t.right;
				while(root!=null){
					stk.push(root);
					root=root.left;
				}
			}
		}
		if(k>1)
			System.out.println("Sorry !!! K is more than number of elements");
		else
			System.out.println("Kth element is : "+ t.val);
	}
	
	
	
	//Method to print the values of the nodes where the range is given for the values of the nodes
	public void printRangeNodes(BSTNode root, BSTNode k1, BSTNode k2){
		if(root==null)
			return ;
		printRangeNodes(root.left, k1, k2);
		if(root.val>k1.val && root.val<k2.val)
			System.out.println(root.val);
		printRangeNodes(root.right, k1, k2);
	}
	
	//Method to convert the sorted array into the BST
	public BSTNode sortedArray2BST(int A[], int start, int end){
		if(A.length<=0)
			return null;
		if(start>end)
			return null;
		int mid = (start+end)/2;
		BSTNode node  = new BSTNode(A[mid]);
		node.left = sortedArray2BST(A, start, mid-1);
		node.right = sortedArray2BST(A, mid+1, end);
		return node;
	}
	
	public int getSize(BSTNode root){
		if(root==null)
			return 0;
		return (getSize(root.left)+getSize(root.right)+1);
	}
	//Method to return the size of the largest BST in the given binary tree
	public int sizeLargestBSTNaive(BSTNode root){
		if(root==null)
			return 0;
		int size = 0;
		if(isBST(root)){
			size = getSize(root);
			return size;
		}
		return (Math.max(sizeLargestBSTNaive(root.left), sizeLargestBSTNaive(root.right)));
		
	}
	
	//Method to remove the nodes in the given BST which does not lie in the given range
	public void removeNodesRange(BSTNode root, int min, int max){
		if(root==null)
			return;
		if(root.val<min||root.val>max)
			root = deleteKey(root,root.val);
		removeNodesRange(root.left, min, max);
		removeNodesRange(root.right, min, max);
		//removeNodesRange(root, min, max)
	}
	
	//Method to restore the BST in which already the two nodes are swapped
	public BSTNode restoreSwapped(BSTNode root){
		if(root==null)
			return null;
		BSTNode first , middle, last, prev;
		first=middle=last=prev=null;
		return restoreSwappedUtil(root, prev, first, middle,last);
	}
	
	//Utility method for the restoreSwapped
	public BSTNode restoreSwappedUtil(BSTNode root, BSTNode prev, BSTNode first, BSTNode middle, BSTNode last){
		if(root==null)
			return null;
		root.left = restoreSwappedUtil(root.left, root, first, middle, last);
		if(prev!=null&&root.val<prev.val){
			if(first==null){
				first = prev;
				middle = root;
			}
			else
				last = root;
		}
		prev = root;
		root.right = restoreSwappedUtil(root.right, root,first,middle,last);
		return root;
	}
	
	//Main Method to implement the BST utility methods
	public static void main(String args[]){
		BSTNode t1 = new BSTNode(1);
		BSTNode t2 = new BSTNode(2);
		BSTNode t3 = new BSTNode(3);
		BSTNode t4 = new BSTNode(4);
		BSTNode t5 = new BSTNode(50);
		BSTNode t6 = new BSTNode(60);
		BSTNode t7 = new BSTNode(70);
		t6.right=t7;
		t6.left=t5;
		t2.left=t1;
		t2.right=t3;
		t4.left=t2;
		t4.right=t6;
		t2.val=t6.val;
		t6.val = 2;
		BinarySearchTree obj = new BinarySearchTree();
		obj.display(t4);
		System.out.println();
		//obj.removeNodesRange(t4,2,7);
		//obj.display(t4);
		t4 = obj.restoreSwapped(t4);
		obj.display(t4);

		//int A[] = new int[]{1,2,3,4,5,6,7,8,9};
		//BSTNode tree = obj.sortedArray2BST(A, 0, A.length-1);
		//obj.display(tree);
		//System.out.println("size of the Largest BST is : " + obj.sizeLargestBSTNaive(t4));
		//System.out.println("The size of Tree is : "+obj.sizeOfTree(tree));
		//obj.printRangeNodes(t4,t4, t7);
		//BSTNode LCA = obj.LCABST(t4, t6, t1);
		//System.out.println("The Lca of the given node is : "+LCA.val);
		//System.out.println("Is the Given tree BST or not  : "+obj.isBST(t4));
		//obj.inorderPredSucc(t4, 69);
		//t4 = obj.deleteKey(t4,7);
		//obj.display(t4);
		//System.out.println("The minimum node in the given binary search tree is : "+obj.maxNode(t4));
		//t4 = obj.insertBST(t4,9);
		//System.out.println();
		//obj.display(t4);
	}
}

