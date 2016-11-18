
public class SearchElementInSOrtedMatrix {
	
	/** Method to print the given matrix */
	public void displayMatrix(int A[][]){
		int i,j;
		for(i=0;i<A.length;i++){
			for(j=0;j<A[0].length;j++)
				System.out.print(A[i][j]+" ");
			System.out.println();
		}
	}
	
	/** Method to search for an element from the sorted matrix(rows and colums are sorted) */
	public void searchSorted(int A[][],int num){
		int i=0;
		int j=A[0].length-1;
		while(i<A.length&&j>=0){
			if(A[i][j]<num)
				i++;
			else if(A[i][j]==num){
				System.out.println("The Index of the element in given sorted matrix is : "+i + " "+j);
				return;
			}
			else
				j--;
		}
		System.out.println("Number does not exist in the matrix");
	}
	
	/** Main Method to run all the utility methods */ 
	public static void main(String args[]){
		int A[][]=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		SearchElementInSOrtedMatrix obj = new SearchElementInSOrtedMatrix();
		obj.searchSorted(A,1);
		
	}
}
