import java.util.ArrayList;
import java.util.HashMap;


public class intersectionOfArrays {
	//Using Brute force
	public Integer[] interBrut(int A[], int B[]){
		ArrayList<Integer> inter = new ArrayList<Integer>();
		for(int i=0;i<A.length;i++){
			for(int j=0;j<B.length;j++){
				if(A[i]==B[j]&&B[j]>0){
					inter.add(A[i]);
					B[j]=-1*B[j];
					break;
				}
			}
		}
		Integer res[] = new Integer[inter.size()];
		res = inter.toArray(res);
		return res;
	}
	
	//Using HashMap
	public void interHashMap(int A[], int B[]){
		HashMap<Integer,Integer> AMap = new HashMap<Integer,Integer>();
		for(int i=0;i<A.length;i++){
			if(AMap.containsKey(A[i]))
				AMap.put(A[i], AMap.get(A[i])+1);
			else
				AMap.put(A[i],1);
		}
		HashMap<Integer,Integer> l = new HashMap<Integer, Integer>();
		for(int i :B){
			if(AMap.containsKey(i)){
				if(l.containsKey(i)){
					l.put(i,l.get(i)+1 );
				}
				else
					l.put(i,1);
			}
		}
		System.out.print(l);
	}

	//Using HahsSet
	public void interHashSet(int A[], int B[]){
		
	}
	public static void main(String args[]){
		int A[] = new int[]{1,2,2,2,3,4,5,6,7,7,7,7};
		int B[] = new int[]{2,2,4,7,7};
		intersectionOfArrays obj = new intersectionOfArrays();
		/*Integer C[] = obj.intersection(A,B);
		for(int i=0;i<C.length;i++)
			System.out.print(C[i]+"  ");*/
		obj.interHashMap(A, B);
	}
}
