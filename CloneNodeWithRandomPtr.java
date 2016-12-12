import java.util.HashMap;

class TreeNodeRandom{
	int val;
	TreeNodeRandom left;
	TreeNodeRandom right;
	TreeNodeRandom random;
	public TreeNodeRandom(int v) {
		val=v;
		left=right=random=null;
	}
}
public class CloneNodeWithRandomPtr {
	public void displayTree(TreeNodeRandom root){
		if(root==null)
			return;
		displayTree(root.left);
		System.out.print(root.val+" ");// ->  " +root.random.val );
		displayTree(root.right);

	}
	
	//Utility Method to map the left and right nodes of the given binary tree to the given map
	public TreeNodeRandom treeNodesHash(TreeNodeRandom root,HashMap<TreeNodeRandom, TreeNodeRandom> map){
		if(root==null)
			return null;
		TreeNodeRandom r = new TreeNodeRandom(root.val);
		map.put(root,r);
		r.random = root.random;
		r.left= treeNodesHash(root.left,map);
		r.right = treeNodesHash(root.right,map);
		return r;
	}
	
	//Utility Method to copy the random pointers of the given binary tree
	/*public void copyRandom(TreeNodeRandom root, TreeNodeRandom cloneNode, HashMap<TreeNodeRandom, TreeNodeRandom> map){
		if(cloneNode==null)
			return;
		cloneNode.random = map.get(root.random);	
		copyRandom(root.left, cloneNode.left, map);
		copyRandom(root.right, cloneNode.right, map);

	}*/
	
	//Method to clone the binary tree with random pointers 
	public TreeNodeRandom cloneNodeHashmap(TreeNodeRandom root){
		if(root==null)
			return null;
		TreeNodeRandom clone = new TreeNodeRandom(root.val);
		HashMap<TreeNodeRandom, TreeNodeRandom> map = new HashMap<TreeNodeRandom, TreeNodeRandom>();
		clone = treeNodesHash(root, map);
		//copyRandom(root, clone, map);
		return clone;
		
	}
	
	//Method to clone the binary tree with random pointers without using the hashmap
	public TreeNodeRandom cloneLeftRight(TreeNodeRandom root){
		if(root==null)
			return null;
		//TreeNodeRandom clone = new TreeNodeRandom(root.val);
		TreeNodeRandom left = root.left;
		root.left = new TreeNodeRandom(root.val);
		root.left.left=left;
		root.left.left=left;
		if(left!=null)
			left.left=cloneLeftRight(left);
		root.left.right = cloneLeftRight(root.right);
		return root.left;
	}
	
	public static void main(String[] args) {
		/*TreeNodeRandom t1 = new TreeNodeRandom(1);
		TreeNodeRandom t2 = new TreeNodeRandom(2);
		TreeNodeRandom t3 = new TreeNodeRandom(3);
		TreeNodeRandom t4 = new TreeNodeRandom(4);
		t3.left=t4;
		t2.right=t3;
		t2.left=t1;
		t3.random=t2;
		t2.random = t4;
		t4.random = t1;
		t1.random=t3;*/
		
		
		TreeNodeRandom tree = new TreeNodeRandom(10);
		TreeNodeRandom n2 = new TreeNodeRandom(6);
		TreeNodeRandom n3 = new TreeNodeRandom(12);
		TreeNodeRandom n4 = new TreeNodeRandom(5);
		TreeNodeRandom n5 = new TreeNodeRandom(8);
		TreeNodeRandom n6 = new TreeNodeRandom(11);
	    TreeNodeRandom n7 = new TreeNodeRandom(13);
	    TreeNodeRandom n8 = new TreeNodeRandom(7);
	    TreeNodeRandom n9 = new TreeNodeRandom(9);
	    tree.left = n2;
	    tree.right = n3;
	    tree.random = n2;
	    n2.left = n4;
	    n2.right = n5;
	    n2.random = n8;
	    n3.left = n6;
	    n3.right = n7;
	    n3.random = n5;
	    n4.random = n9;
	    n5.left = n8;
	    n5.right = n9;
	    n5.random = tree;
	    n6.random = n9;
	    n9.random = n8;
		
		
		CloneNodeWithRandomPtr obj = new CloneNodeWithRandomPtr();
		obj.displayTree(tree);
		System.out.println();
		TreeNodeRandom temp = tree;
		TreeNodeRandom c = obj.cloneLeftRight(tree);
		//TreeNodeRandom c = obj.cloneNodeHashmap(tree);
		obj.displayTree(tree);
	}
}
