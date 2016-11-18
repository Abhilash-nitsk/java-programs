
public class StringsUtility {
	
	public String revSpaceIntact(String str){
		char res[] = new char[str.length()];
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)==' ')
				res[i] = ' ';
		}
		int k=0;
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)!=' '){
					res[i] = str.charAt(i);
			}
		}
		
		String r = String.valueOf(res);
		return r;
	}
	public static void main(String args[]){
		String sentence = new String("My Name Is Abhilash Agarwal, I am in Hyderabad");
		StringsUtility obj = new StringsUtility();
		System.out.println(sentence);
		String res = obj.revSpaceIntact(sentence);
		System.out.println(res );
	}
}
