class Node{
	int val;
	Node left;
	Node right;
	public Node(int v){
		val=v;
		left=right=null;
	}
}
public class LCA {
	public Node returnLCABinaryTree(Node root, Node n1, Node n2){
		if(root==null)
			return root;
		if(n1==n2)
			return n1;
		if(root==n1||root==n2)
			return root;
		Node leftLCA =returnLCABinaryTree(root.left,n1,n2);
		Node rightLCA =returnLCABinaryTree(root.right,n1,n2);
		if(leftLCA!=null&&rightLCA!=null)
			return root;
		if(leftLCA!=null)
			return leftLCA;
		else
			return rightLCA;
	}
	
	public Node returnLCABST(Node root,Node n1,Node n2){
		if(root==null)
			return root;
		if((n1.val<root.val&&n2.val>root.val)||(n1.val>root.val&&n2.val<root.val))
			return root;
		if(n1.val>root.val&&n2.val>root.val)
			return(returnLCABST(root.right,n1,n2));
		else//if(n1.val<root.val&&n2.val<root.val)
			return(returnLCABST(root.left,n1,n2));
		
	}
	
	public void display(Node root){
		if(root==null)
			return ;
		display(root.left);
		System.out.print(root.val+" ");
		display(root.right);
	}
	public static void main(String args[]){
		Node n0 = new Node(0);
		Node n1=new Node(1);
		Node n2=new Node(2);
		Node n3=new Node(3);
		Node n4=new Node(4);
		Node n5=new Node(5);
		n4.right=n5;
		n4.left=n3;
		n2.right=n4;
		n2.left=n1;
		n0.right=n2;
		LCA obj = new LCA();
		obj.display(n0);
		System.out.println();
		//Node l = obj.returnLCABinaryTree(n0, n1, n3);
		Node l = obj.returnLCABST(n0, n3, n5);
		System.out.println(l.val+ "");
	}
}