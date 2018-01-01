package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.TreeSet;

/**
 * Created by arpit on 23/1/17.
 */
public class TouristsInMancunia1 {

    final static int MAX=100000;
    static TreeSet<Integer> adj[]=new TreeSet[MAX];
    static HashSet<Edge> tour=new HashSet<>();
    static boolean vis[]=new boolean[MAX];
    static Edge edge[]=new Edge[200000];
    static int deg[]=new int[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n,e;
        String[]s;

        s=br.readLine().split("\\s");
        n=Integer.parseInt(s[0]);
        e=Integer.parseInt(s[1]);
        for (int i = 0; i < n; i++) {
            adj[i]=new TreeSet<>();
        }

        //this part only constructs adjacency list of the corresponding graph
        for (int i = 0; i < e; i++) {
            s=br.readLine().split("\\s");
            int u=Integer.parseInt(s[0])-1;
            int v=Integer.parseInt(s[1])-1;
            edge[i]=new Edge(u,v);
            deg[u]++;
            deg[v]++;
            adj[u].add(v);
            adj[v].add(u);
        }
        //System.out.println(Arrays.toString(adj));
        solve(n, e);
    }

    private static void solve(int n, int e) {

        /*for (int i = 0; i < n; i++) {
            System.out.print(deg[i]+" ");
        }*/
        StringBuilder sbr=new StringBuilder();
        if (!oddDegrees(n)){
            System.out.println("NO");
            return;
        }
        if (!isConnected(n)){
            System.out.println("NO");
            return;
        }
        findTour(0);
        for (int i = 0; i < n; i++) {

            if (adj[i].size()>0){
                System.out.println("NO");
                return;
            }

        }
        sbr.append("YES\n");
        //System.out.println("YES");
        for (int i = 0; i < e; i++) {
            if (tour.contains(edge[i])) {
                sbr.append((edge[i].u + 1) + " " + (edge[i].v + 1)+"\n");
                //System.out.println((edge[i].u + 1) + " " + (edge[i].v + 1));
            }
            else{
                sbr.append((edge[i].v+1)+" "+(edge[i].u+1)+"\n");
                //System.out.println((edge[i].v+1)+" "+(edge[i].u+1));
            }
        }
        System.out.print(sbr);
    }

    private static void findTour(int u) {

        //System.out.println(u+" "+size);
        int v=0;
        Iterator<Integer>adju=adj[u].iterator();

        while (adju.hasNext()){
            v=adju.next();
            adju.remove();
            adj[v].remove(u);
            tour.add(new Edge(u,v));
            findTour(v);
        }
    }

    private static boolean isConnected(int n) {

        dfs(0);
        for (int i = 0; i < n; i++) {
            if (!vis[i])return false;
        }
        return true;
    }

    private static void dfs(int u) {

        vis[u]=true;
        int size=adj[u].size();
        Iterator<Integer>adju=adj[u].iterator();
        while (adju.hasNext()){
            int v=adju.next();
            if (!vis[v])
                dfs(v);
        }

    }

    private static boolean oddDegrees(int n) {

        for (int i = 0; i < n; i++) {
            if ((deg[i]&1)==1)return false;
        }
        return true;
    }


    static class Edge {

        int u,v;

        public Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }

        @Override
        public int hashCode() {
            return ((Integer)(u*v*31)).hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (this.hashCode()==o.hashCode()){
                Edge e= (Edge) o;
                if (this.u==e.u && this.v==e.v)return true;
            }
            return false;
        }
    }
}

