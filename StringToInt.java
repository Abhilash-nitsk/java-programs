
public class StringToInt {
	public int stringToInt(String str){
		int val = 0;
		for(int i = 0;i<str.length();i++){
			char c = str.charAt(i);
			val = val*10 + (int)(c-48);
		}
		return val;
	}
	public static void main(String args[]){
		String str = "00010";
		StringToInt obj = new StringToInt();
		System.out.println("The String to Integer is : " + obj.stringToInt(str));
	}
}
