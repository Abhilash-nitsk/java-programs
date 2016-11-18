//Program to check if the distance between two Given Strings is one or not

public class CheckEditDist1 {
	/*public boolean isEditDist1(String strA, String strB){
		int lenA = strA.length();
		int lenB = strB.length();
		if(Math.abs(lenA-lenB)>1)
			return false;
		if(strA.equals(strB))
			return false;
		int i=0,j=0;
		int flag = 0;
		while(i<lenA&&j<lenB){
			if(strA.charAt(i)!=strB.charAt(j)){
				flag++;
				if(flag>1)
					return false;
				if(lenA>lenB)
					j++;
				else if(lenA<lenB)
					i++;
				else{
					i++;
					j++;
				}
			}	
			else{
					i++;
					j++;
			}
		}
		if(i<lenA||j<lenB)
			flag++;
		if(flag==1)
			return true;
		return false;
	}*/
	public boolean isOneEditDistance(String s, String t) {
	    if(s==null || t==null)
	        return false;
	 
	    int m = s.length();
	    int n = t.length();
	 
	    if(Math.abs(m-n)>1){
	        return false;
	    }
	 
	    int i=0; 
	    int j=0; 
	    int count=0;
	 
	    while(i<m&&j<n){
	        if(s.charAt(i)==t.charAt(j)){
	            i++;
	            j++;
	        }else{
	            count++;
	            if(count>1)
	                return false;
	 
	            if(m>n){
	                i++;
	            }else if(m<n){
	                j++;
	            }else{
	                i++;
	                j++;
	            }
	        }
	    }
	 
	    if(i<m||j<n){
	        count++;
	    }
	 
	    if(count==1)
	        return true;
	 
	    return false;
	}
	public static void main(String args[]){
		String s1 = "Geieks";
		String s2 = "Geeks";
		CheckEditDist1 obj = new CheckEditDist1();
		boolean res = obj.isOneEditDistance(s1,s2);
		if(res)
			System.out.println("The Edit distance between both the strings is 1");
		else
			System.out.println("Sorry !! Edit Distance is not equal to 1");
	}
}
