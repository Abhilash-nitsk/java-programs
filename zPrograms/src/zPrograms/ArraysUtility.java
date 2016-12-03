package zPrograms;

import java.util.HashMap;
import java.util.Map;

class ArraysMethods{
	
	/**--------------------------check given sum exists in pair -------------- */
	//Method to check if the pair exist with the given sum in the given array
	public void checkPairGivenSum(int A[], int sum){
		int left=0,right=A.length-1;
		while(left<right){
			int s = A[left]+A[right];
			if(s==sum){
				System.out.println("The pair having the given sum are :  "+A[left] + "  "+A[right]);
				break;
			}
			else if(s<sum)
				left++;
			else
				right--;
		}
	}
	
	//Method to check if the pair with the given sum exists in the given array using hashmap
	public void checkPairGivenSumMap(int A[], int sum){
		if(A.length==0)
			return;
		boolean map[] = new boolean[1000];
		for(int i: A){
			if(map[sum-i]==true)
				System.out.println("The pair is :  "+i+"  "+(sum-i));
			else
				map[i]=true;
		}
	}
	
	
	/**----------------Majority Element------------*/
	
	//Method to display the majority element in the given array naive approach
	public static int majorityNaive(int A[]){
		int maxCount = 0;
		int count=0;
		int num=A[0];
		for(int i=0;i<A.length;i++){
			count=0;
			for(int j=i+1;j<A.length;j++){
				if(A[i]==A[j])
					count++;
				if(count>maxCount){
					maxCount = count;
					num=A[i];
				}
			}
		}
		if(maxCount>(A.length/2))
			return num;
		else
			return -1;
	}
	
	//Method to display the majority element using moore's voting algorithm
	public int majorityMoore(int A[]){
		int majIndex = 0;
		int numIndex=0;
		int c=1;
		for(int i=1;i<A.length;i++){
			if(A[i]==A[majIndex])
				c++;				
			else
				c--;
			if(c==0){
				c=1;
				majIndex = i;
			}
		}
		return majIndex;
	}
	
	/**----------------- Find number occuring odd nummber of times ----------*/
	//Method to return the first integer which occurs odd number of times in a given array
	public int firstOddNumOccuringNaive(int A[]){
		int c=1;
		int num=-1;
		for(int i=0;i<A.length;i++){
			c=1;
			for(int j=i+1;j<A.length;j++){
				if(A[i]==A[j]&&A[j]>0){
					c++;
					A[j]=A[j]*-1;
				}
			}
			if(c%2==1){
				num=A[i];
				break;
			}
		}
		return num;
	}
	
	//Method to return the first which occurs odd number of times using hashmap
	public int oddNumberHashMap(int A[]){
		int num=-1;
		if(A.length<=0)
			return -1;
		HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<A.length;i++){
			if(map.containsKey(A[i])){
				map.put(A[i],map.get(A[i])+1);
			}
			else{
				map.put(A[i],1);
			}
		}
		for (Map.Entry<Integer, Integer> rec : map.entrySet()){
			int val = rec.getValue();
			if(val%2==1){
				int key = rec.getKey();
				num = key;
				break;
			}
		}
		return num;
	}
}





public class ArraysUtility {
	
	public static void main(String args[]){
		int A[] = new int[]{1, 2, 3, 2, 3, 1, 3};
		ArraysMethods obj = new ArraysMethods();
		System.out.println("The number appearing odd number of times is : "+obj.oddNumberHashMap(A));
		//System.out.println("Num Occuring odd number of times are : "+obj.firstOddNumOccuringNaive(A));
		//System.out.println("Majority element is:  "+obj.majorityMoore(A));
		//int sum=11;
		//obj.checkPairGivenSumMap(A, sum);
		
	}

}
