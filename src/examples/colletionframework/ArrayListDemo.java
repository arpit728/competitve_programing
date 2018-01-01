package examples.colletionframework;

import java.util.ArrayList;

public class ArrayListDemo {
	
	public static void main(String[] args) {
		ArrayList arrayList=new ArrayList();
		System.out.println(arrayList.size());
		arrayList.add("A");
		arrayList.add("b");
		arrayList.add("c");
		arrayList.add("d");
		System.out.println(arrayList.get(2));
		System.out.println(arrayList);
		System.out.println(arrayList.size());
	}
}
