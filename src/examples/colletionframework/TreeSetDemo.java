package examples.colletionframework;

import java.util.TreeSet;

public class TreeSetDemo {

	public static void main(String[] args) {
		TreeSet t=new TreeSet();
		t.add("A");
		t.add("a");
		t.add("B");
		t.add("C");
		t.add("Z");
		//t.add(10);//This statement will throw ClassCastException
		//t.add(null);//this statement will throw NPE.
		System.out.println(t);
	}

}
