import java.util.ArrayList;


/** Program to print the Pascals triangle 
 *       1
 *      1 1
 *     1 2 1
 *    1 3 3 1
 *   1 4 6 4 1  
 * 	...
 * 
 * */
public class PrintPascalsTriangle {
	ArrayList<ArrayList<Integer>> pascalTriangle(int rowNum){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> pre = new ArrayList<Integer>();
		pre.add(1);
		result.add(pre);
		for(int i=2;i<=rowNum;i++){
			ArrayList<Integer> curr = new ArrayList<Integer>();
			curr.add(1);
			for(int j=0;j<pre.size()-1;j++){
				curr.add(pre.get(j)+pre.get(j+1));
			}
			curr.add(1);
			pre=curr;
			result.add(curr);
		}
		return result;
	}
	public static void main(String args[]){
		int size=5;
		PrintPascalsTriangle obj = new PrintPascalsTriangle();
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		res = obj.pascalTriangle(size);
		System.out.println(res);
	}
}
