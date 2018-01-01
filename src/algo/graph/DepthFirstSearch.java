package algo.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DepthFirstSearch {

	private ArrayList<Integer> adj[];
	private int path[],color[],n,m;
	private static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	private final int BLACK=2,GRAY=1,WHITE=0;


	DepthFirstSearch(int n,int m){
		path=new int[n];
		color=new int[n];
		adj=new ArrayList[n];
		this.n=n;
		this.m=m;
		Arrays.fill(path,-1);
		for (int i = 0; i < n; i++) {
			adj[i]=new ArrayList<>();
		}
	}



	void inputGraph() throws IOException {
		String s[];
		int from,to;
		for (int i = 0; i < m; i++) {
			s=br.readLine().split("\\s");
			from=Integer.parseInt(s[0]);
			to=Integer.parseInt(s[1]);
			adj[from].add(to);
			adj[to].add(from);
		}
	}

	void dfs(int start){

		color[start]=GRAY;
		System.out.print(start +" ");

		for (int i = 0; i < adj[start].size(); i++) {
			int v=adj[start].get(i);
			if (color[v]==WHITE){
				dfs(v);
				path[v]=start;
			}

		}
		color[start]=BLACK;
	}

	void printPath(){

		for (int i = 0; i < n; i++) {
			traversPath(i);
			System.out.println();
		}

	}

	void traversPath(int start){
		if (path[start]!=-1){

			traversPath(path[start]);
			System.out.print(start+" ");
		}
		else System.out.print(start+" ");
	}

	public  void  solve() throws IOException {
		this.inputGraph();
		this.dfs(0);
		System.out.println();
	}

	void printAdjacencyList(){
		for (int i = 0; i < n; i++) {
			System.out.println(adj[i]);
		}
	}

	public static void main(String[] args) throws IOException {

		String s[];
		s=br.readLine().split("\\s");
		int n=Integer.parseInt(s[0]),m=Integer.parseInt(s[1]);
		DepthFirstSearch dfs= new DepthFirstSearch(n,m);
		dfs.solve();
		dfs.printPath();

	}

}

