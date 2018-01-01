package examples.colletionframework;

import java.util.Comparator;
import java.util.TreeSet;

public class IncreasingStringLengthTreeSet {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		@SuppressWarnings({ "rawtypes" })
		TreeSet t=new TreeSet(new Comparator() {

			@Override
			public int compare(Object arg0, Object arg1) {
				String s1=arg0.toString();
				String s2=arg1.toString();
				int l1=s1.length(),l2=s2.length();
				if (l1==l2)return s1.compareTo(s2);
				else return l1<l2?-1:1;
			}
		});
		t.add("A");
		t.add(new StringBuffer("ABC"));
		t.add(new StringBuffer("AA"));
		t.add("XX");
		t.add("ABCD");
		t.add("A");
		t.add(2);
		System.out.println(t);
		
	}
}
