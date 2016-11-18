
public class CircularPrime {
	public boolean isPrime(int num){
		if(num<2)
			return false;
		for(int i=2; i*i<=num;i++){
			if(num%i==0)
				return false;
		}
		return true;
	}
	public int rotateNum(int n){
		if((int)(Math.log(n))==0)
			return n;
		int numOfDigits = (int)(Math.log10(n));
		int man = (int) Math.pow(10, numOfDigits);
		int firstDigit = (n/man);
		n=n%man;
		n=n*10;;
		n=n+firstDigit;
		return n;
	}
	public boolean isCircularPrime(int n){
		int numOfDigit = (int)(Math.log10(n));
		for(int i=0;i<numOfDigit+1;i++){
			if(!isPrime(n))
				return false; 
			n=rotateNum(n);
		}
		return true;
	}
	public static void main(String args[]){
		int a = 999;
		int n  =  (int)(Math.log10(a));
		CircularPrime obj = new CircularPrime();
		System.out.println("Is circular prime : " + obj.isCircularPrime(17));
	}
}
