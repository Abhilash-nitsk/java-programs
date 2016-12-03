
public class Search2DSortedMatrix {

	public void searchSortedMatrix(int A[][],int x){

		for(int i=0;i<A.length;i++){
			if(A[i][A[i].length-1]==x){
				System.out.println("The index is row: "+i+" Col: "+(A[i].length-1));
				return;
			}
			if(A[i][A[i].length-1]>x){
				for(int j=(A[i].length-2);j>=0;j--){
					if(A[i][j]==x){
						System.out.println("The index is row: "+i+" Col: "+j);
						return;
					}
				}
			}
			if(A[i][A[i].length-1]<x){
			}
		}
		System.out.println("Number does not exist");

	}
	public static void main(String args[]){
		int A[][]=new int[][]{ {10, 20, 30, 40},
					            {15, 25, 35, 45},
					            {27, 29, 37, 48},
					            {32, 33, 39, 50},
					          };
		
		Search2DSortedMatrix obj = new Search2DSortedMatrix();
		obj.searchSortedMatrix(A, 32);
	}
}
