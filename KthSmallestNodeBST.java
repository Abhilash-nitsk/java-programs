import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Definition for an interval.*/
  class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
 }
 
public class KthSmallestNodeBST {
    
	/** comparator method to compare between two of the Intervals object */
	Comparator<Interval> startComparator = new Comparator<Interval>() {         
        @Override         
        public int compare(Interval i1, Interval i2) {             
            return (i1.start>i2.start?1:-1);           
        }     
    };
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        
		ArrayList<Interval> result = new ArrayList<Interval>();
        Collections.sort(intervals,startComparator);
        //result.add(intervals.get(0));
        Interval pre = intervals.get(0);
        for(int i=1;i<intervals.size();i++){
        	Interval curr = intervals.get(i);
        	if(pre.end<curr.start){
        		result.add(pre);
        		pre = curr;
        	}
        	else{
        		Interval n = new Interval();
        		n.start=pre.start;
        		n.end = (Math.max(pre.end, curr.end));
        		pre=n;
        	}
        }
        result.add(pre);
		return result;
        
    }
	public void display(ArrayList<Interval> l){
		for(Interval i: l){
			System.out.println(i.start+" "+i.end);
		}
	}
    public static void main(String args[]){
    	Interval i1=  new Interval(1,2);
    	Interval i2=  new Interval(5,9);
    	Interval i3=  new Interval(4,5);
    	//Interval i4=  new Interval(2,4);
    	ArrayList<Interval> l = new ArrayList<Interval>();
    	l.add(i1);
    	l.add(i2);
    	l.add(i3);
    	//l.add(i4);
    	//System.out.println(l);
    	KthSmallestNodeBST obj = new KthSmallestNodeBST();
    	obj.display(l);
    	System.out.println();
    	//Collections.sort(l,obj.startComparator);
    	//obj.display(l);
    	l=obj.merge(l);
    	obj.display(l);
    }
}