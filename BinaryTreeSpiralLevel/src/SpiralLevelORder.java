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
public class SpiralLevelORder {
	public void spiralLevelOrder(Node n){
		if(n==null)
			return;
		boolean flag = true;
		Queue<Node> qt = new LinkedList<Node>();
		Queue<Node> qf = new LinkedList<Node>();
		qt.add(n);
		while(!qt.isEmpty()||!qf.isEmpty()){
			if(flag){
				if(qt.isEmpty()) break;
				Node temp=qt.poll();
				System.out.println(temp.val+" ");
				if(temp.left!=null)
					qf.add(temp.left);
				if(temp.right!=null)
					qf.add(temp.right);
			}
			else{
				if(qf.isEmpty()) break;
				Node temp=qf.poll();
				System.out.println(temp.val+" ");
				if(temp.left!=null)
					qt.add(temp.left);
				if(temp.right!=null)
					qt.add(temp.right);
			}
			flag=!flag;
		}
		while(!qf.isEmpty()){
			System.out.println(qf.poll().val+" ");
		}
		while(!qt.isEmpty()){
			System.out.println(qt.poll().val+" ");
		}
	}
	public static void main(String args[]){
		Node n1=new Node(1);
		Node n2=new Node(2);
		Node n3=new Node(3);
		Node n4=new Node(4);
		Node n5=new Node(5);
		Node n6=new Node(6);
		Node n7=new Node(7);
		Node n8=new Node(8);
		Node n9=new Node(9);
		n8.left=n7;
		n8.right=n9;
		n7.right=n8;
		n6.right=n7;
		n5.right=n6;
		n4.right=n5;
		n4.left=n3;
		n2.right=n4;
		n2.left=n1;
		SpiralLevelORder obj = new SpiralLevelORder();
		obj.spiralLevelOrder(n2);
	}
}
