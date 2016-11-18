import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

class Interval1{
	int start;
	int end;
	public Interval1(int a, int b){
		start = a;
		end = b;
	}
}

public class mergeInterval {
	public ArrayList<Interval1> merge(ArrayList<Interval1> intervals) {
        ArrayList<Interval1>result = new ArrayList<Interval1>();
        if(intervals==null||intervals.size()==0)
            return result;
        Comparator<Interval1> comp = new Comparator<Interval1>() {

			@Override
			public int compare(Interval1 o1, Interval1 o2) {
				 if(o1.start!=o2.start)
		                return o1.start-o2.start;
		            else
		                return o1.end-o2.end;
			}
        	
		};
    	Collections.sort(intervals, comp);
    	int i;
    	for(i=0;i<intervals.size()-1;i++){
    		if(intervals.get(i+1).start>intervals.get(i).end){
    			result.add(intervals.get(i));
    		}
    		else{
    			Interval1 n = new Interval1(intervals.get(i).start,Math.max(intervals.get(i).end, intervals.get(i+1).end));
    			result.add(n);
    		}
    	}
        return result;
    }
	public void display(ArrayList<Interval1> i){
		for(Interval1 o:i){
			System.out.println(" Start: "+o.start+" End : "+o.end);
		}
		
	}
	public static void main(String args[]){
		Interval1 a = new Interval1(1,3);
		Interval1 c = new Interval1(8,10);
		Interval1 b = new Interval1(2,6);
		Interval1 d = new Interval1(15,18);
		ArrayList<Interval1> i = new ArrayList<Interval1>();
		i.add(a);
		i.add(c);
		i.add(b);
		i.add(d);
		
		mergeInterval obj = new mergeInterval();
		obj.display(i);
		i=obj.merge(i);
		obj.display(i);
	}
}
