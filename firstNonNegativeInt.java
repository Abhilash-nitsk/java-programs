import java.util.ArrayList;
import java.util.TreeSet;


 class firstNonNegativeInt {
	public int firstMissingPositive(ArrayList<Integer> a) {
		int missNum=1;
		for(int i=1;i<a.size()+1;i++){
			if(a.contains(i)==false){
				missNum=i;
				break;
			}
		}
		return missNum;
	}
	public static void main(String args[]){
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(0);
		a.add(1);
		a.add(3);
		firstNonNegativeInt obj = new firstNonNegativeInt();
		int missNum = obj.firstMissingPositive(a);
		System.out.println("lkasdfuisdf");
	}
}
