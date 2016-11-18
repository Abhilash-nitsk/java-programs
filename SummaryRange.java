import java.util.ArrayList;

class A{
	public void PPP(){
		LLL();
		System.out.println("PPP");
	}
	public void LLL(){
		PPP();
		System.out.println("LLL");
	}
	public void run(){
		System.out.println("Inside run of A");
	}
}
class B extends A{
	public void run(){
		System.out.println("Inside run of B");
	}
}
class C extends B{
}
public class SummaryRange {
	
	// Method to print the Summary Range of the given Array
	public ArrayList<String> findSummaryRange(int A[]){
		ArrayList<String> res = new ArrayList<String>();
		if(A.length==0)
			return res;
		if(A.length==1){
			res.add(A[0]+"");
			return res;
		}
		int i=0,j=1;
		int start = A[0];
		int end = A[0];
		while(A[j]==(A[i]+1)){
			
		}
		return res;
	}
	
	public static void main(String args[]){
		int A[]={1,2,3,5,6,8};
		long a = 1234L;
		byte b = (byte)a;
		System.out.println(b);
		//System.out.println("Float : "+ b + "  Integer conversion : "+ (int)b);
		//res = obj.findSummaryRange(A);
		//System.out.println(res);
	}
}
