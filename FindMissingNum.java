import java.util.Arrays;


public class FindMissingNum {
	
	//Finding the missing number brute force
	public int missingNumBrute(int A[]){
		if(A.length==0)
			return 1;
		Arrays.sort(A);
		int i;
		for(i=1;i<A.length;i++){
			if(A[i-1]!=i)
				break;
		}
		return i;
	}
	
	//Finding the missing number in the sequence using sum
	public int missingNumSum(int A[]){
		int s=0,i;
		for(i=0;i<A.length+2;i++)
			s=s+i;
		for(i=0;i<A.length;i++)
			s=s-A[i];
		return s;
	}
	
	//Finding the missing Number in the sequence using XOR technique
	public int missingNumXOR(int A[]){
		int s=0,i;
		for(i=0;i<A.length;i++)
			s=s^A[i];
		for(i=1;i<A.length+2;i++)
			s=s^i;
		return s;
	}
	public static void main(String args[]){
		int A[]= new int[]{1,2,3,4,5,6,8,9,10};
		int B[] = new int[]{1,2,3,5,6};
		FindMissingNum obj = new FindMissingNum();
		int missNum = obj.missingNumXOR(A);
		System.out.println("The missing number is : "+missNum);
	}
}
