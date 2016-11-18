import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Guess {
	public int guess(int i){
		int num = 56;
		if(i>num)
			return 1;
		else if(i<num)
			return -1;
		else
			return 0;
	}
	public static void main(String args[]) throws IOException{
		//InputStreamReader in = new InputStreamReader(System.in);
		Scanner in = new Scanner(System.in);
		Guess obj = new Guess();
		int c = 0;
		//int num = 56;
		System.out.println("Guess The Number (1-99)");
		do{
			int b = in.nextInt();
			int res = obj.guess(b);
			c++;
			if(res==0){
				System.out.println("Congrates You Got it Right in : "+ c + "  Chances");
				break;
			}
			else if(res<0)
				System.out.println("Sorry Try something Larger :(");
			else
				System.out.println("Sorry Try something Smaller :(");
		}while(true);
		in.close();
	}
}
