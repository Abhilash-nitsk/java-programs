import java.util.HashMap;
import java.util.HashSet;

class node{
	int val;
	node next;
	//constructor for the list
	public node(int v){
		val=v;
	}
	//Display the list 
	public void display(){
		if(this==null)return;
		System.out.print(this.val+" ");
		if(this.next!=null)
			this.next.display();
	}
	//check the equality of he list
	public boolean equals(node n){
		if(n==null)
			return false;
		if(this.val==n.val&&this.next==n.next)
			return true;
		return false;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return val+"";
	}
//	@Override
//	public int hashCode() {
//		
//		return this.val;
//	}
	
	//find the length of the list
	public int length(){
		if(this==null)
			return 0;
		if(this.next!=null)
			return(1+this.next.length());
		return 1;
	}
	//linked list insertion in the given position
	public node insert(int pos,int num){
		node newNode = new node(num);
		if(pos==0||this==null){
			newNode.next=this;
			return newNode;
		}
		
		node temp =this;
		temp=this;
		while(temp!=null&&pos>1){
			temp=temp.next;
			pos--;
		}
		//temp.display();
		if(temp==null){
			temp.next=newNode;
		}
		else{
			node buff = new node(pos);
			buff=temp.next;
			newNode.next=buff;
			temp.next=newNode;
		}
		return this;
	}
//	public node deleteGivenPos(int pos){
//		if(pos>=this.length()){
//			
//		}
//			
//	}\
	public node reverseLL(){
		if(this==null||this.next==null)
			return this;
		node current ;
		node prev ;
		node fast ;
		prev=null;
		current = this;
		fast = null;
		while(current!=null){
			fast=current.next;
			current.next=prev;
			prev=current;
			current=fast;
		}
		
	    return prev;	
	}
	//reverse a Linked list recursively
	public node reverseList(node head) {
	    if(head==null || head.next == null)
	        return head;
	 
	    //get second node    
	    node second = head.next;
	    //set first's next to be null
	    head.next = null;
	 
	    node rest = reverseList(second);
	    second.next = head;
	 
	    return rest;
	}
	//Program to Check if the duplicate nodes exist in the list
	public boolean checkDups(){
		//boolean result = false;
		//HashMap<node,node> map = new HashMap<node,node>();
		HashSet<node> set = new HashSet<node>();
		node t = this;
		while(t!=null){
			if(set.contains(t)){
				return true;
			}
			else{
				set.add(t);
			}
			t=t.next;
			
		}
		return false;
		
	}
	//Program to find if loop exists in the given linked list or not using floyd warshall algorithm
	public boolean loopExists(){
		boolean result = false;
		node list=this;
		node fast=list;
		node slow=list;
		while(fast!=null&&fast.next!=null&&slow!=null&&fast.next.next!=null){
			fast=fast.next.next;
			slow=slow.next;
			if(fast.equals(slow)){ 
				while(list!=slow){
					list=list.next;
					slow=slow.next;
					
				}
				System.out.println("The node with Start for the Loop is : "+ list.val);
				return true;
			}
		}
		
		return result;
	}
}

public class LinkedListLoop {
	public static void main(String args[]){
		node n1 = new node(1);
		node n2 = new node(2);
		node n3 = new node(3);
		node n4 = new node(4);
		node n5 = new node(5);
		node n6 = new node(6);
		n5.next=n6;
		n4.next=n5;
		n3.next=n4;
		n2.next=n3;
		n1.next=n2;
		node rever = n1.reverseList(n1);
		rever.display();
		//boolean dups = n1.checkDups();
		//System.out.println("Dups exist or Not : " + dups);
		//n6.next=n3;
		//boolean isLoop=n1.loopExists();
		//System.out.println("Value : "+isLoop);
		//n1.display();
		//n1.display();
		/*if(n4.equals(n2)) 
			System.out.println("both nodes are same");
		else 
			System.out.println("not same");*/
		//System.out.println("Length of the li is: "+n1.length());
		//n1=n1.insert(1,9);
		//n1.display();
		//boolean r = n1.checkDups(n1);
		//System.out.println("Result if dups exist : "+ r);
		//n1=n1.reverseLL();
		//n1.display();
	}
}
