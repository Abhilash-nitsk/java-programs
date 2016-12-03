package Arrays1D;

public class RotateArray {
	
	//Method to display the Array passed to it as a parameter
	public void displayArray(int A[]){
		for(int i=0;i<A.length;i++){
			System.out.print(A[i]+" ");
		}
		System.out.println();
	}
	
	//Method to reverse the given array
	public void reverseArray(int A[],int l,int h){
		while(l<h){
			int t = A[l];
			A[l] = A[h];
			A[h] = t;
			l++;
			h--;
			}
		}
	
	//Method to rotate clockwise the given array by the given places using reversal method
	public void rotateByK(int A[], int k){
		reverseArray(A,0,k);
		reverseArray(A,k+1,A.length-1);
		reverseArray(A,0,A.length-1);
	}
	
	
	//Main Method to help run all the utility methods 
	public static void main(String args[]){
		int A[] = new int[]{1,2,3,4,5,6,7,8,9};
		RotateArray obj = new RotateArray();
		obj.rotateByK(A, 3);
		obj.displayArray(A);
	}
}
