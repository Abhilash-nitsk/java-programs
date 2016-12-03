package programs;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class EqualsHashCod {              
    private static int magic;              
    private int total;              
               
    	public static void main(String[] args) { LinkedList list = new LinkedList();
        list.add(new Integer(2));
       list.add(new Integer(8));
       list.add(new Integer(5));
       list.add(new Integer(1));
       Iterator i = list.iterator();
       Collections.reverse(list);
       Collections.sort(list);
        while(i.hasNext())
       System.out.print(i.next() + " ");}              
      void changeTheValue(int a){                     
       a = a + 20;                     
       System.out.println("Value one: " + a);                     
        int c;                     
        // iWillAlsoChange(c);             
    }              
       void iWillAlsoChange(int b){                     
       b = b+20;                     
      System.out.println("Final Value: " +new java.util.Date());            }       
}