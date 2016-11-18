
public class GivenStringsAreRotation {
	boolean rotationOrNot(String st1, String st2){
		if(st1.length()!=st2.length())
			return false;
		int i=0;
		String sb = new String(st2);
		
		boolean flag = false;
		while(i++<st1.length()){
			if(st1.equals(sb)){
				flag=true;
				break;
			}
			char c = sb.charAt(0);
			sb=sb.substring(1);
			sb=sb+c;
			System.out.println("Intermediate String : " + sb);
		}
		return flag;
	}
	
	//Method to check if the given strings are rotations of each other using substring concept
	
	public boolean checkRotation2(String st1, String st2){
		st2=st2+st2;
		
		if(st2.indexOf(st2)>-1)
			return true;
		return false;
	}
	public static void main(String args[]){
		String st1 = new String("STRING");
		String st2 = new String("TRINGS");
		GivenStringsAreRotation obj = new GivenStringsAreRotation();
		boolean res = obj.checkRotation2(st1,st2);
		System.out.println("The given Strins are rotation ro not : "+res);
	}
}
