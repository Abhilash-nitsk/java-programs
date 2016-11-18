
public class SetRowsCols0 {

	public void printMatrix(int a[][]){
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[0].length;j++)
				System.out.print(a[i][j]+" ");
			System.out.println();
		}
	}
	public void setRowsCols0(int A[][]){
		boolean row0= false;
		boolean col0= false;
		for(int i=0;i<A.length;i++){
			if(A[i][0]==0){
				row0=true;
				break;
			}
		}
		for(int i=0;i<A[0].length;i++){
			if(A[0][i]==0){
				col0=true;
				break;
			}
		}
		for(int i=1;i<A.length;i++){
			for(int j=1;j<A.length;j++){
				if(A[i][j]==0){
					A[i][0]=0;
					A[0][j]=0;
				}
			}
		}
		for(int i=1;i<A.length;i++){
			if(A[i][0]==0){
				for(int j=0;j<A[i].length;j++)
					A[i][j]=0;
			}
		}
		for(int i=1;i<A[0].length;i++){
			if(A[0][i]==0){
				for(int j=0;j<A.length;j++)
					A[j][i]=0;
			}
		}
		System.out.println();
	}
	public static void main(String args[]){
		int matrix[][] = new int[][]{{1,1,0},{1,1,1},{1,0,0}};
		SetRowsCols0 obj = new SetRowsCols0();
		obj.printMatrix(matrix);
		obj.setRowsCols0(matrix);
		obj.printMatrix(matrix);
	}
}
