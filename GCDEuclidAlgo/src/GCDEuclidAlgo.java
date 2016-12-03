
public class GCDEuclidAlgo {
	public int findGCD(int a,int b){
		if(b==0)
			return a;
		return(findGCD(b,a%b));
	}
	public static void main(String args[]){
		int a = 13392;
		int b = 99;
		GCDEuclidAlgo obj = new GCDEuclidAlgo();
		int gcd = obj.findGCD(a,b);
		System.out.println(gcd);
	}
}
