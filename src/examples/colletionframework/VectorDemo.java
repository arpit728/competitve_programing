package examples.colletionframework;

import java.util.*;
public class VectorDemo {
	
	public static void main(String[] args) {
		Vector v=new Vector();
		System.out.println(v.capacity());
		for (int i = 0; i < 10; i++) {
			v.addElement(i);
		}
		System.out.println(v.capacity());
		v.addElement("M");
		System.out.println(v.capacity());
		System.out.println(v);
		
		//Accessing elements one by one using enumeration.
		Enumeration e=v.elements();
		while (e.hasMoreElements()) {
			System.out.print(e.nextElement()+" ");
			
		}
		
		System.out.println();
		//Accessing elements one by one using iterator.
		Iterator itr=v.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next()+" ");
			
		}
	}

}
