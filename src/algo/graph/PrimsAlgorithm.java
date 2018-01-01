package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by arpit on 13/12/16.
 */
public class PrimsAlgorithm
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, e;
        String[] s;
        ArrayList<Pair>adj[];
        s=br.readLine().split("\\s");
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
        System.out.println(getMST(adj,n));
    }

    private static ArrayList<Pair> getMST(ArrayList<Pair>[] adj,int n) {
        PriorityQueue<Pair>q=new PriorityQueue<>();
        q.add(new Pair(0,0));
        
        for (int i = 1; i < n; i++) {
        }
        return null;
    }

    static class Pair implements Comparable<Pair>{
        int v,weight;

        public Pair(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair pair) {
            return ((Integer)this.weight).compareTo(pair.weight);
        }
    }


}
