import java.util.ArrayDeque;
import java.util.Deque;

class findMaxFromK{
	public void findMax(int A[],int k){
		//ArrayDeque<Integer>dq = new ArrayDeque<Integer>();
		int i,j;
		int max;
		for(i=0;i<A.length-k+1;i++){
			j=0;
			max=A[i];
			while(++j<k&&(i+j)<A.length){
				if(A[j+i]>max){
					max=A[j+i];
				}
			}
			System.out.println("Max : "+max);
		}
	}
}

public class findMaxFromSubarrays {
	public static void main(String args[]){
		int A[]=new int[]{1,2,3,4,5,6,7};
		int k=3;
		findMaxFromK obj = new findMaxFromK();
		obj.findMax(A,k);
	}
}
