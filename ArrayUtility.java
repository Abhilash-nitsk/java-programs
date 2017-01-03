import java.util.ArrayList;
import java.util.LinkedHashSet;


public class ArrayUtility {

	public void display(int A[]){
		for(int i=0;i<A.length;i++)
			System.out.print(A[i]+" ");
		System.out.println();
	}
	
	//Method to degregate even and odd integers in the given arrays
	public void segregate(int A[]){
		if(A.length<=0)
			return;
		int low = 0;
		int high = A.length-1;
		while(low<high){
			while(A[low]%2==0&&low<high)
				low++;
			while(A[high]%2==1&&low<high)
				high--;
			if(low<high){
				int t = A[low];
				A[low] = A[high];
				A[high]=t;
			}
		}
	}
	
	
	//Method to print the distinct elements in the given integer array naive approach
	public void printDistinctNaive(int A[]){
		if(A.length<=0)
			return;
		for(int i=0;i<A.length;i++){
			int j;
			for(j=0;j<i;j++){
				if(A[i]==A[j])
					break;
			}
			if(i==j)
				System.out.print(A[i]+" ");
		}
	}
	
	//Method to print the distinct element in the given integer array using a hashset collection
	public void printDistinctHash(int A[]){
		if(A.length<=0)
			return;
		LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
		for(int i :A)
			set.add(i);
		System.out.println(set);
	}
	
	//Method to return the factorial of the given integer
	public int getFactorial(int A){
		if(A==0||A==1)
			return 1;
		return A*getFactorial(A-1);
	}
	
	//Method to return the number corresponding to the given factorial
	public int getNumForFactorial(int A){		
		int num = -1;
		for(int i=0;(i*i)<=A;i++){
			int f = getFactorial(i);
			if(f==A){
				num=i;
				break;
			}
		}
		return num;
	}
	
	//Method to construct the integer array form the given sum array
/*	public void arrFromSumArr(int A[]){
		if(A.length<=0)
			return;
		int ALen = A.length;
		int resLen = getNumForFactorial(A.length);
		int res[] = new int[resLen];
		int a = (A[0]+A[1]-A[resLen-2])/2;
		System.out.println(" a is : "+a);
		
	}*/
	
	//Method to print the common elements in the given three sorted integer arrays
	public void commonThreeSorted(int A[], int B[], int C[]){
		if(A.length<=0||B.length<=0||C.length<=0)
			return ;
		int a=0, b=0, c=0;
		int len = 0;
		ArrayList<Integer> common = new ArrayList<Integer>();
		while(a<A.length && b < B.length && c < C.length){
			if(A[a]==B[b]&&C[c]==A[a]){
				common.add(A[a]);
				a++;
				b++;
				c++;
				continue;
			}
			else if(A[a]<B[b])
				a++;
			else if(B[b]<C[c])
				b++;
			else
				c++;
		}
		System.out.println("The common list is : "+common);
	}
	
	//Method to count the number of 1 in sorted and an array of 0 and 1 only
	public int countNum1(int A[]){
		if(A.length<=0)
			return 0;
		int num = countNum1Util(A,0,A.length-1);
		return A.length-num-1;
	}
	
	//Utility method
	public int countNum1Util(int A[], int low, int high){
		if(low>high)
			return 0;
		int mid = low + (high-low)/2;
		if(A[mid]==0&&A[mid+1]==1)
			return mid;
		else if(A[mid]==0&&A[mid+1]==0)
			return countNum1Util(A, mid+1, high);
		return countNum1Util(A,low,mid-1);
	}
	
	//Method to perform the binary search of the given element in the given sorted array
	public int binarySearch(int A[], int low, int high, int num){
		if(A.length<=0)
			return -1;
		if(low>high)
			return -1;
		int mid = low + (high-low)/2;
		if(A[mid]==num)
			return mid;
		else if(A[mid]<num)
			return binarySearch(A, mid+1, high, num);
		return binarySearch(A, low,mid-1, num);
		
	}
	
	//Method to find the position of the given element in the given stream of infinite numbers
	public void posGivenNum(int A[], int num){
		if(A.length<=0)
			return;
		int i = 1,j;
		int low = 0;
		int index=-1;
		while(i<=A.length){
			index = binarySearch(A, low, i, num);
			if(index!=-1){
				System.out.println("The pos is : " + index);
				break;
			}
			low=i;
			i=i*2;
		}
		if(index==-1)
			System.out.println("The number doesnot exist in the given array");
	}
	
	//Method to replace the elements of the given array with the  product of the previous and and next
	public int[] replaceElement(int A[]){
		if(A.length<=0)
			return null;
		int prev = A[0];
		int i=1;
		A[0]=A[0]*A[1];
		while(i<A.length-1){
			int t = A[i];
			A[i] = prev * A[i+1];
			prev = t;
			i++;
		}
		A[i] = A[i]*prev;
		return A;
	}
	
	public static void main(String[] args) {
		int B[]= new int[]{1,2,3,4,5,6,7,8,9};
		int C[] = new int[]{8,9};
		int A[]=new int[]{4,5,7,8,9};
		int num0and1[] = new int[]{0,0,0,0,0,1,1,1,1,1,1,1,1};
		ArrayUtility obj = new ArrayUtility();
		obj.display(A);
		A = obj.replaceElement(A);
		obj.display(A);

		//obj.posGivenNum(B, 10);
		//System.out.println("The pos of the given num is : " + obj.binarySearch(B, 0,B.length-1, 9));
		//obj.commonThreeSorted(A, B, C);
		//int num = obj.countNum1(num0and1);
		//System.out.println("The number of 1 in array is : " + num);
		//System.out.println("The num correspondin num to fact of 24 is : " + obj.getNumForFactorial(6));
		//System.out.println("     "+obj.getFactorial(3));
		//obj.printDistinctHash(A);
		//obj.display(A);
		//obj.segregate(A);
		//obj.display(A);
	}
}
