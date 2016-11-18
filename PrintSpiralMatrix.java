
public class PrintSpiralMatrix {
	/** Method to print the Given matrix in spiral form */
	public void printSpiralMatrix(int A[][]){
		int lr=0,hr=A.length-1;
		int lc=0, hc = A[0].length-1;
		int i,j;
		while(lr<hr&&lc<hc){
			for(i=lc;i<=hc;i++){
				System.out.print(A[lr][i]+" ");
			}
			lr++;
			for(i=lr;i<=hr;i++){
				System.out.print(A[i][hc]+" ");
			}
			hc--;
			for(i=hc;i>=0;i--){
				System.out.print(A[hr][i]+" ");
			}
			hr--;
			for(i=hr;i>=0;i--){
				System.out.print(A[i][lc]+" ");
			}
			lc++;
		}
	}
	
	/** Method to print the given matrix */
	public void printMatrix(int A[][]){
		for(int i=0;i<A.length;i++){
			for(int j=0;j<A[0].length;j++)
				System.out.print(A[i][j]+" ");
			System.out.println();
		}
	}
	
	/** Main Method to run all the utility methods defined */ 
	public static void main(String args[]){
		int A[][]=new int[][]{ 
				{1,  2,  3,  4,  5,  6},
		        {7,  8,  9,  10, 11, 12},
		        {13, 14, 15, 16, 17, 18}
		};
		PrintSpiralMatrix obj = new PrintSpiralMatrix();
		obj.printMatrix(A);
		obj.printSpiralMatrix(A);
	}
}
