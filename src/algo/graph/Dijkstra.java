package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by arpit on 11/12/16.
 */

public class Dijkstra {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Pair>[]adj;
        int n,e;
        String[]s;
        s=br.readLine().split("\\s");
        
        //input no. of vertices and edges
        n=Integer.parseInt(s[0]);
        e=Integer.parseInt(s[1]);

        adj=new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i]=new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            s=br.readLine().split("\\s");
            adj[Integer.parseInt(s[0])].add(new Pair(Integer.parseInt(s[1]),Integer.parseInt(s[2])));
            adj[Integer.parseInt(s[1])].add(new Pair(Integer.parseInt(s[0]), Integer.parseInt(s[2])));
        }

        System.out.println(getShortestPath(adj,0));
        System.out.println(Arrays.toString(adj));


    }

    private static int[] getShortestPath(ArrayList<Pair>[] adj, int source) {

        PriorityQueue<Pair>pq=new PriorityQueue<>();
        int d[]=new int[adj.length];
        boolean []vis=new boolean[adj.length];

        Arrays.fill(d,Integer.MAX_VALUE);
        pq.add(new Pair(source,0));
        d[source]=0;
        while (!pq.isEmpty()){
            Pair p=pq.poll();
            int u=p.v;
            vis[u]=true;
            for (int i = 0; i < adj[u].size(); i++) {
                int v=adj[u].get(i).v;
                int w=adj[u].get(i).w;
                if (!vis[v]){
                    d[v]=Integer.min(d[v],d[u]+w);
                    pq.add(new Pair(v,d[v]));
                }
            }
        }
        return d;
    }

    static class Pair implements Comparable<Pair>{

        int v,w;

        public Pair(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Pair pair) {
            return ((Integer)this.w).compareTo(pair.w);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "v=" + v +
                    ", w=" + w +
                    '}';
        }
    }
}
