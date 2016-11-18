import java.util.ArrayList;
import java.util.Arrays;


public class makeMatrixZero {
	
		public void setZeroes(ArrayList<ArrayList<Integer>> a) {
		    ArrayList<Integer> row = new ArrayList<Integer>();
		    ArrayList<Integer> col = new ArrayList<Integer>();
		    for(int i=0;i<a.size();i++){
		        for(int j=0;j<a.get(i).size();j++){
		            if(a.get(i).get(j)==0){
		            	row.add(i);
		            	row.add(j);
		            }
		        }
		       
		    }
		    for(int i=0;i<row.size();i++){
		    	for(int j=0;j<a.get(0).size();j++){
		    		a.get(i).set(j,0);
		    	}
		    }
		    
		    for(int i=0;i<col.size();i++){
		    	for(int j=0;j<a.size();j++){
		    		//a.get(i).get(j)=0;
		    		a.get(j).set(i,0);
		    	}
		    }
		}
	public void display(int A[][]){
		for(int i =0;i<A.length;i++){
			for(int j=0;j<A[0].length;j++){
				System.out.print(A[i][j]+" ");
			}
			System.out.println();
		}
	}
	public void display(ArrayList<ArrayList<Integer>> l){
		for(int i = 0;i<l.size();i++){
			for(int j=0;j<l.get(i).size();j++){
				System.out.print(l.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}
	public static void main(String args[]){
		int A[][]=new int[][]{{1,0, 1},
							   {1,1,1},
							   {1,1,1}};
		makeMatrixZero obj = new makeMatrixZero();
		//obj.display(A);
		ArrayList<ArrayList<Integer>> l = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		ArrayList<Integer> l3 = new ArrayList<Integer>();
		l1.add(1);
		l1.add(0);
		l1.add(1);
		l2.add(1);
		l2.add(1);
		l2.add(1);
		l3.add(1);
		l3.add(1);
		l3.add(1);
		l.add(l1);
		l.add(l2);
		l.add(l3);
		Integer a1[]=l1.toArray(new Integer[0]);
		Integer a2[]=l2.toArray(new Integer[0]);
		Integer a3[]=l3.toArray(new Integer[0]);
		Integer ar[][] = l.toArray(new Integer[0][0]);
		for(int i=0;i<ar.length;i++){
			for(int j=0;j<ar[0].length;j++)
				System.out.print(ar[i]+" ");
			System.out.println();
		}
		//obj.setZeroes(l);
		//obj.display(l);
		obj.setZeroes(l);
		//obj.display(l);

	}
}
