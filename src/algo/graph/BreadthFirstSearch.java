package algo.graph;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BreadthFirstSearch {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Hey, enter the no. of vertices in your graph : ");
		int n=sc.nextInt();
		LinkedList<Vertex1>[]list=new LinkedList[n];
		Queue<Integer>queue=new LinkedList<Integer>();
		int start;
		int output[]=new int[n];
		int i=0;
		LinkedList<Vertex1> vertex1List =new LinkedList<Vertex1>();
		for (int j = 0; j < n; j++) {
			vertex1List.add(new Vertex1(0, j));
		}
		for (i = 0; i <n; i++) {
			list[i]=new LinkedList<Vertex1>();
			
			System.out.print("\nEnter the no. of vertices adjacent to vertex "+i+" ");
			int temp=sc.nextInt();
			System.out.print("Enter the vertices that are adjacent to vertex "+i+" : ");
			for(int j=0;j<temp;j++){
				list[i].add(vertex1List.get(sc.nextInt()));
			}
			System.out.println(list[i]);
			
		}
		System.out.println("\nEnter the starting point : ");
		start=sc.nextInt();
		vertex1List.get(start).setColor(1);
		queue.add(start);
		i=0;
		while (!queue.isEmpty()) {
			Iterator itr=list[queue.peek()].iterator();
			while (itr.hasNext()) {
				 Vertex1 v = (Vertex1) itr.next();
				 if (v.color==0) {
					 v.color=1;
					queue.add(v.val);
				}
				 
			}
			Vertex1 v= vertex1List.get(queue.poll());
			v.color=2;
			output[i]=v.val;
			i++;
		}
		
		System.out.println(Arrays.toString(output));
	}
	
}

class Vertex1 {
	int color,val;

	public Vertex1(int color, int val) {
		super();
		this.color = color;
		this.val = val;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	@Override
	public String toString() {
		return "Vertex1 [color=" + color + ", val=" + val + "]";
	}
}