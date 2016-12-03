package minTimeToRotAllOranges;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
class orange{
	int x;
	int y;
	public orange(int X,int Y){
		x=X;
		y=Y;
	}
	
}
public class MinTimeToRotAllOranges {
	final int MAX_C=5;
	final int MAX_R=5;
	public boolean isValid(int x,int y){
		if(x>=0&&x<MAX_R&&y>=0&&y<MAX_C)
			return true;
		return false;
	}
	
	public boolean isDelim(orange o){
		if(o.x==-1&&o.y==-1)
			return true;
		else return false;
	}
	
	public boolean checkCanRot(int A[][]){
		for(int i=0;i<A.length;i++){
			for(int j=0;j<A[0].length;j++){
				if(A[i][j]==1)
					return true;
			}
		}
		return false;
	}
	public int rotAllElement(int A[][]){
		int ans=0;
		Queue<orange> q=new LinkedList<orange>();
		for(int i=0;i<A.length;i++){
			for(int j=0;j<A[0].length;j++){
				if(A[i][j]==2){
					orange o = new orange(i,j);
					q.add(o);
				}
			}
		}
		orange delim = new orange(-1,-1);
		q.add(delim);
		while(!q.isEmpty()){
			boolean flag=false;
			while(!isDelim(q.peek())){
				orange temp=q.element();
				q.po
				if(isValid(temp.x+1, temp.y)&&A[temp.x+1][temp.y]==1){
					if(!flag){
						flag=true;
						ans++;
						
					}
					A[temp.x+1][temp.y] = 2;
				}
			}
		}
		return ans;
	}
	public static void main(String args[]){
	    int arr[][] = { {2, 1, 0, 2, 1},
                		{1, 0, 1, 2, 1},
                		{1, 0, 0, 2, 1}};
	    MinTimeToRotAllOranges obj = new MinTimeToRotAllOranges();
	    int ans = obj.rotAllElement(arr);
	    System.out.println(ans);
	}
}
