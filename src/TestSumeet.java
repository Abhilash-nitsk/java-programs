import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;


 class TestSumeet {
	 public static int i=10;
	 private TestSumeet(){};
	 public static TestSumeet getA(){
		 return new TestSumeet();
	 }
	 
	 public static void main(String[] args) {
		 SimpleDateFormat dateFormatTR = new SimpleDateFormat("dd-MMM-yyyy", new Locale("tr","TR"));       
		 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		 
		 SimpleDateFormat dateFormatTR1 = new SimpleDateFormat("dd-MM-yyyy", new Locale("tr","TR"));       
		    SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
		    
		    for (int i = 1; i < 13; i++) {
		    	try {
					System.out.println(dateFormatTR.format(dateFormat1.parse("01-"+i+"-2016")));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
	}
 }