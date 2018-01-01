package examples.colletionframework;

import java.util.Comparator;
import java.util.TreeSet;



/**
 * @author Arpit
 *
 */
public class CompCompDemo {

	//This example demonstrates, how to apply default natural sorting order and customized order for user defined class.
	
	public static void main(String[] args) {
		
		Employee e1 = new Employee(100,"Arpit");
		Employee e2 = new Employee(200,"Sanchay");
		Employee e3 = new Employee(50,"Mahip");
		Employee e4 = new Employee(150,"Piyush");
		Employee e5 = new Employee(100,"Arpit");
		
		//This TreeSet object demonstrates default natural sorting order.
		TreeSet<Employee>t1=new TreeSet<Employee>();
		t1.add(e1);
		t1.add(e2);
		t1.add(e3);
		t1.add(e4);
		t1.add(e5);
		System.out.println(t1);
		
		//This code implements customized sorting order.
		Comparator<Employee>comparator=new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				String s1=o1.name;
				String s2=o2.name;
				return s1.compareTo(s2);
			}
		};
		TreeSet<Employee>t2=new TreeSet<Employee>(comparator);
		t2.add(e1);
		t2.add(e2);
		t2.add(e3);
		t2.add(e4);
		t2.add(e5);
		System.out.println(t2);
	}

}
class Employee implements Comparable<Employee>{
	int eid;
	String name;
	
	public Employee(int eid, String name) {
		super();
		this.eid = eid;
		this.name = name;
	}

	@Override
	public int compareTo(Employee o) {
		int eid1=this.eid;
		int eid2=o.eid;
		if (eid1<eid2) {
			return -1;
		}
		else if(eid1>eid2)return 1;
		else return 0;
	}

	@Override
	public String toString() {
		
		return eid+"--"+name;
	}
	
}
