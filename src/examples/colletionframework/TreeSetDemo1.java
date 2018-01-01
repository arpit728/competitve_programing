package examples.colletionframework;

import java.util.TreeSet;

/**
 * @author Arpit
 *
 */
public class TreeSetDemo1 {
	
	/*this example will throw ClassCastException because when we depend on default natural sorting order,
	the objects should be homogeneous and comparable(implement comparable interface)*/
	
	public static void main(String[] args) {
		TreeSet t=new TreeSet();
		t.add(new StringBuffer("A"));
		t.add(new StringBuffer("B"));
		t.add(new StringBuffer("C"));
		t.add(new StringBuffer("D"));
		t.add(new StringBuffer("a"));
	
	}

}
