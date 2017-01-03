import java.util.HashSet;


public class DifferenceInSets {
	public static void main(String[] args) {
		HashSet<Integer> dit = new HashSet<Integer>();
		HashSet<Integer> sit = new HashSet<Integer>();
		HashSet<Integer> notInsit = new HashSet<Integer>();
		sit.add(1);
		sit.add(2);
		sit.add(3);
		sit.add(4);
		sit.add(5);
		sit.add(6);
		sit.add(7);
		sit.add(8);
		sit.add(9);
		sit.add(10);
		
		dit.add(1);
		dit.add(2);
		dit.add(3);
		dit.add(4);
		dit.add(5);
		System.out.println(sit);
		System.out.println(dit);

		sit.removeAll(dit);
		System.out.println(sit);
		
		
	}
}
