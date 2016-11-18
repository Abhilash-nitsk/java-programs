import java.util.ArrayList;


public class ReverseOnlyVowels { 
	public static void main(String args[]){
		ArrayList<Character> vowList = new ArrayList<Character>();
		vowList.add('a');
		vowList.add('e');
		vowList.add('i');
		vowList.add('o');
		vowList.add('u');
		vowList.add('A');
		vowList.add('E');
		vowList.add('I');
		vowList.add('O');
		vowList.add('U');
		char A[]=new char[]{'a','c','e','y','i','n','o','w','u','l'};
		int start =0;
		int end = A.length-1;
		//ReverseOnlyVowels obj = new ReverseOnlyVowels();
		while(start<end){
			if(!vowList.contains(A[start])){
				start++;
				continue;
			}
			if(!vowList.contains(A[end])){
				end--;
				continue;
			}
			char t = A[start];
			A[start] = A[end];
			A[end] = t;
			start++;
			end--;
		}
		for(int i=0;i<A.length;i++)
			System.out.print(A[i]+" ");
	}
}
