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
		BinarySearchTree obj = new BinarySearchTree();
		obj.display(t4);
		System.out.println();
		System.out.println("Is the Given tree BST or not  : "+obj.isBSTNaive(t4));
		//obj.inorderPredSucc(t4, 69);
		//t4 = obj.deleteKey(t4,7);
		//obj.display(t4);
		//System.out.println("The minimum node in the given binary search tree is : "+obj.maxNode(t4));
		//t4 = obj.insertBST(t4,9);
		//System.out.println();
		//obj.display(t4);
	}
}
