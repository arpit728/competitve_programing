package examples.colletionframework;

import java.util.*;

public class StackDemo {

	public static void main(String[] args) {
		Stack s=new Stack();
		s.push("A");
		s.push("B");
		s.push("c");
		s.push("d");
		System.out.println(s);
		System.out.println(s.search("d"));
		System.out.println(s.peek());
		System.out.println(s);
		System.out.println(s.pop());
		System.out.println(s);
		System.out.println(s.search('d'));
	}
}
