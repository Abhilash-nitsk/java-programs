import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class EncodingString {
	//Method to encode the string as A-Z, B-Y, C-X, ..., Z-A
	public String encodeReverse(String str){
		char temp[] = str.toCharArray();
		for(int i=0;i<str.length();i++){
			int v = (int)(str.charAt(i));
			temp[i] = (char)(90-(v-65));
		}
		return String.valueOf(temp);
	}
	
	//Method to encode the given string such that 1st char =2nd char 2nd equal to 2nd + 2 char ...
	// Eg: ABHI : BIBI
	public String encodeString(String str){
		char temp[] = str.toCharArray();
		for(int i=0;i<str.length();i++){
			temp[i]=str.charAt((2*i+1)%str.length());
		}
		return String.valueOf(temp);

	}
	
	//Method to encode the string in the format as: ABHI : BDKM
	public String encodeAlphabet(String str){
		char temp[] = str.toCharArray();
		for(int i=0;i<str.length();i++){
			int v = (int)(str.charAt(i));
			v=v-65+i+1;
			v=v%26;
			v=v+65;
			temp[i] = (char)(v);
		}
		return String.valueOf(temp);
	}
	
	//Method to print the age for the given corresponding date
	public void dateToAge(String date){
		String DATE_FORMAT = "dd-MMM-yyyy";
		String d=null;
	    SimpleDateFormat sdf =  new SimpleDateFormat(DATE_FORMAT);
	    try {
			 d = sdf.format((Date)sdf.parse(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//String s[] = 
	}
	public static void main(String args[]){
		String str = "ABHILASH";
		EncodingString obj = new EncodingString();
		System.out.println("The Encoded String is : "+obj.encodeAlphabet(str));
		//System.out.println(obj.dateToAge());
	}
}
