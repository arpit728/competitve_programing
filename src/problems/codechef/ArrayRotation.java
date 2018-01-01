package problems.codechef;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayRotation {
	public static String readInputDemo(){
		BufferedInputStream b=new BufferedInputStream(System.in);
		StringBuilder s=new StringBuilder();
		long val=0;
		try {
			int c=b.read();
			while(c!='\n'){
				s.append((char)c);
				c=b.read();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return s.toString();
	}

	public static void main(String[] args) {
		int n,q,t=0,l=0,r=0;
		String s[]=readInputDemo().split("\\s");
		
		n=Integer.parseInt(s[0]);
		q=Integer.parseInt(s[1]);
		
		n++;
		ArrayList<Integer> list=new ArrayList<Integer>(n);
		list.add(-1);
		String p[]=readInputDemo().split("\\s");
		for (int i=0;i<n-1;i++)list.add(Integer.parseInt(p[i])); 
		System.out.println(list+" "+list.size());
		
		while(q-->0){
			ArrayList<Integer> tempList=new ArrayList<Integer>(n);
			tempList.add(-1);
			
			String query[]=readInputDemo().split("\\s");
			
			t=Integer.parseInt(query[0]);
			l=Integer.parseInt(query[1]);
			r=Integer.parseInt(query[2]);
			System.out.println(t+" "+l+" "+r);
			System.out.println("size : "+list.size());
			if (t==1) {
				tempList.addAll(list.subList(l, r+1));
				tempList.addAll(list.subList(1, l));
				tempList.addAll(list.subList(r+1,n));
				
			}
			else{
				tempList.addAll(list.subList(1,l));
				tempList.addAll(list.subList(r+1,n));
				tempList.addAll(list.subList(l, r+1));
			}
			System.out.println(tempList);
			list=tempList;
		}
		Iterator iterator=list.listIterator(1);
		while (iterator.hasNext())System.out.print(iterator.next()+" ");
	}
	
}
