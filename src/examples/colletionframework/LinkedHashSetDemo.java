package examples.colletionframework;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetDemo {
	public static void main(String[] args) {
		LinkedHashSet set=new LinkedHashSet();
		set.add("A");
		set.add("B");
		set.add("C");
		set.add("D");
		set.add("E");
		set.add("F");
		set.add(null);
		set.add('p');
		set.add(10);
		Iterator itr=set.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next()); 
		}
	}
}	
