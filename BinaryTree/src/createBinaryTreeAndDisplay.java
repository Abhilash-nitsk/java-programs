class treeNode{
	int val;
	treeNode left;
	treeNode right;
	treeNode(int v){ val=v; left=null; right=null;}
	public void display(){
		if(this==null) 
			return; 
		System.out.print(this.val+" "); 
		if(this.left!=null)
			this.left.display();
		if(this.right!=null)
			this.right.display();
	} 
}
public class createBinaryTreeAndDisplay {
	public static void main(String args[]){
	treeNode t1 = new treeNode(1);
	treeNode t2 = new treeNode(2);
	treeNode t3 = new treeNode(3);
	treeNode t4 = new treeNode(4);
	treeNode t5 = new treeNode(5);
	t3.left=t4;
	t3.right=t5;
	t1.right=t3;
	t1.left=t2;
	t1.display();
	}
}
