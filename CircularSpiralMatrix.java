
public class CircularSpiralMatrix {

	public void displaySpiral(int[][] matrix){
		if(matrix==null)
			return;
		int maxrow = matrix.length-1;
		int maxcol = matrix[0].length-1;
		int minrow=0;
		int mincol=0;
		int k=0;
		while(minrow<maxrow&&mincol<maxcol){
			if(k%4==0){
				for(int i=mincol;i<=maxcol;i++){
					System.out.print(matrix[minrow][i]+" ");
				}
				k++;
				minrow++;
			}
			if(k%4==1){
				for(int i=minrow;i<=maxrow;i++){
					System.out.print(matrix[i][maxcol] +" ");
				}
				k++;
				maxcol--;;
			}
			if(k%4==2){
				for(int i=maxcol;i>=mincol;i--){
					System.out.print(matrix[maxrow][i]+" ");
				}
				k++;
				maxrow--;
			}
			if(k%4==3){
				for(int i=maxrow;i>=minrow;i--){
					System.out.print(matrix[i][mincol]+" ");
				}
				k++;
				mincol++;
			}
		}
			if(matrix.length==matrix[0].length)
				System.out.print(matrix[matrix.length/2][matrix.length/2]+" ");
	}
	public static void main(String args[]){
		int matrix[][]={{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		CircularSpiralMatrix obj = new CircularSpiralMatrix();
		obj.displaySpiral(matrix);
	}
}
