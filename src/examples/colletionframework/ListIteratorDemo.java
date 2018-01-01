package examples.colletionframework;

import java.util.LinkedList;
import java.util.ListIterator;

public class ListIteratorDemo {
	public static void main(String[] args) {
		LinkedList list=new LinkedList();
		list.add("Arpit");
		list.add("Payu");
		list.add("Bhai");
		list.add("mahip");
		list.add("sanchay");
		list.add("Ninad");
		list.add("Piyush");
		System.out.println(list);
		ListIterator listIterator=list.listIterator();
		while (listIterator.hasNext()) {
			String s = (String) listIterator.next();
			System.out.println(s);
			if(s.equals("Ninad"))listIterator.remove();
			else if (s.equals("Payu")) {
				listIterator.add("babu");
			}
			else if (s.equals("Bhai")) {
				listIterator.set("mayur");
			}System.out.println(list);
		}
		System.out.println(list);
	}

}
