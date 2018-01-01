package examples.colletionframework;

import java.util.Comparator;
import java.util.TreeSet;

public class ComparatorDemo {

	public static void main(String[] args) {
		TreeSet<Integer>t=new TreeSet<Integer>(new MyComparator());
		for (int i = 1; i <=10; i++) {
			t.add(i);
		}
		System.out.println(t);
	}


}
class MyComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer arg0, Integer arg1) {
		if (arg0<arg1) {
			return 1;
		}
		else if (arg0>arg1) {
			return -1;	
		}
		else return 0;
		
		//More combinations for customized sorting
		//return arg0.compareTo(arg1) ascending order
		//return -arg0.compareTo(arg1)descending order
		//return arg1.compareTo(arg0)descending order
		//return -arg1.compareTo(arg0)ascending order
		//return 1 insertion order
		//return -1 reverse of insertion order
		//return 0 only first element will be inserted and all other elements will be considered as duplicates.
	}
	
}
