package examples.colletionframework;

import java.util.Comparator;
import java.util.TreeSet;

public class HeterogeneousTreeSetDemo {

	public static void main(String[] args) {
		TreeSet t=new TreeSet(new Comparator() {

			@Override
			public int compare(Object arg0, Object arg1) {
				// TODO Auto-generated method stub
				return 1;
			}
		});
		t.add("A");
		t.add("b");
		t.add(1);
		t.add(3);
		t.add(null);
		System.out.println(t);
	}
}
