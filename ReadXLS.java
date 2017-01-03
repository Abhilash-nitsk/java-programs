import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;


public class ReadXLS {
	private static final String DIT = "D:\\DIT_PROCEDURES.txt";
	private static final String SIT = "D:\\SIT_PROCEDURES.txt";

	public static void main(String[] args) {
		
		HashSet<String> sit = new HashSet<String>();
		HashSet<String> dit = new HashSet<String>();
		ArrayList<String> sitList = new ArrayList<String>();
		ArrayList<String> ditList = new ArrayList<String>();

		try{
			BufferedReader br = new BufferedReader(new FileReader(DIT));
			String sCurrentLine;
			int c=0;
			while ((sCurrentLine = br.readLine()) != null) {
					ditList.add(sCurrentLine);
			}
			br = new BufferedReader(new FileReader(SIT));
			while ((sCurrentLine = br.readLine()) != null) {
					sitList.add(sCurrentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		//System.out.println(sitList.size()+"  "+ditList.size());
	ditList.removeAll(sitList);
	
	System.out.println(sitList.size()+"   "+ditList.size());
	}
}
