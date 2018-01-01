package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by arpit on 12/12/16.
 */
public class KruskalsAlgorithm {

    static int parent[]=new int[100];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n,e;//No of edges and vertices
        String[]s;
        Edge[]edge;
        s=br.readLine().split("\\s");
        n=Integer.parseInt(s[0]);
        e=Integer.parseInt(s[1]);
        edge=new Edge[e];

        for (int i = 0; i < e; i++) {
            s=br.readLine().split("\\s");
            edge[i]=new Edge(Integer.parseInt(s[0]),Integer.parseInt(s[1]),Integer.parseInt(s[2]));
        }
        ArrayList<Edge>mstEdges= getMST(edge, n, e);
        System.out.println(mstEdges);

    }

    private static ArrayList<Edge> getMST(Edge[] edge, int n, int e) {

        Arrays.sort(edge,0,e);
        ArrayList<Edge>mst=new ArrayList<>();
        initParent(n);
        for (int i = 0; i < e; i++) {
            if (findSet(edge[i].u)!=findSet(edge[i].v)){
                mst.add(edge[i]);
                union(edge[i].u,edge[i].v);
            }
        }
        return mst;
    }

    private static void initParent(int n) {
        for (int i = 0; i < n; i++) {
            parent[i]=i;
        }
    }

    private static void union(int u, int v) {

        parent[findSet(u)]=findSet(v);
    }

    private static int findSet(int u) {

        if (u==parent[u])return u;

        parent[u]=findSet(parent[u]);
        return parent[u];
    }

    static class Edge implements Comparable<Edge>{
        int u,v,weight;

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge edge) {
            return ((Integer)this.weight).compareTo(edge.weight);
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "u=" + u +
                    ", v=" + v +
                    ", weight=" + weight +
                    '}';
        }
    }
}
