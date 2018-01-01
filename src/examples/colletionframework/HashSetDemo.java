package examples.colletionframework;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {
	public static void main(String[] args) {
		HashSet set=new HashSet();
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
