package examples.colletionframework;

import java.util.*;
public class IteratorDemo {
	public static void main(String[] args) {
		ArrayList list=new ArrayList();
		
		for (int i = 0; i < 10	; i++) {
			list.add(i);
		}
		Iterator itr = list.iterator();
		System.out.println(list);
		
		while (itr.hasNext()) {
			int i = (int) itr.next();
			if(i%2==0)System.out.print(i+" ");
			else itr.remove();
			
		}
		System.out.println(list);
	}
}
