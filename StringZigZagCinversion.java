/** Program to convert the given string into a pattern like : INTELLECTDESIGNARENA  I   L   T   I   R
 * 																					N E L C D S G A E A
 * 																					T   E   E   N   N
 * @author abhilash.agarwal
 *
 */
public class StringZigZagCinversion {
	
	public String toZigZag(String str){
		StringBuilder res= new StringBuilder("");
		
		int len = str.length();
		int numOfPat = len/4;
		for(int i=0;i<numOfPat;i++){
			
		}
		return str;
	}
	public static void main(String args[]){
		String str = new String("INTELLECTDESIGNARENA");
		StringZigZagCinversion obj = new StringZigZagCinversion();
		String res = obj.toZigZag(str);
		System.out.println("The ZigZsg String is : "+ res);
	}
}
