package examples.colletionframework;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author Arpit
 *
 */
public class SBTreeSetDemo {

	//This example demonstrate how to use TreeSet for storing stringBuffer object
	
	public static void main(String[] args) {
		TreeSet<StringBuffer> t=new TreeSet<StringBuffer>(new Comparator<StringBuffer>() {

			@Override
			public int compare(StringBuffer arg0, StringBuffer arg1) {
				String s1=arg0.toString();
				String s2=arg1.toString();
				return s2.compareTo(s1);
			}
		});
		t.add(new StringBuffer("A"));
		t.add(new StringBuffer("l"));
		t.add(new StringBuffer("I"));
		t.add(new StringBuffer("M"));
		System.out.println(t);
	}
}
