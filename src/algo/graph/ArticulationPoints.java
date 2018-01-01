package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by arpit on 15/12/16.
 */
public class ArticulationPoints {

    static int d[]=new int[15];//d[u]Discovey time of u
    static int low[]=new int[15];//low[u] represents the smallest discovery time obtained form u or the vertex
    static int parent[]=new int[15];//parent[v] represents the parent of vertex v
    static boolean[]vis=new boolean[15];
    static   ArrayList<Integer>[]adj;
    static boolean []ap=new boolean[15]; //At the end this will have all the articulation points.
    static int timer=0;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int v,e;
        String[]s;

        //Input no. of vertices v and edges e
        s=br.readLine().split("\\s");
        v=Integer.parseInt(s[0]);
        e=Integer.parseInt(s[1]);

        adj=new ArrayList[v];
        ap= new boolean[v];
        Arrays.fill(parent,-1);

        for (int i = 0; i < v; i++) {
            adj[i]=new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            s=br.readLine().split("\\s");
            adj[Integer.parseInt(s[0])].add(Integer.parseInt(s[1]));
            adj[Integer.parseInt(s[1])].add(Integer.parseInt(s[0]));
        }
        findArticulationPoints();
        for (int i = 0; i < v; i++) {
            if (ap[i]) System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void findArticulationPoints() {

        for (int i = 0; i < adj.length; i++) {
            if (!vis[i])dfs(i);
        }
    }

    private static void dfs(int u) {

        vis[u]=true;
        d[u]=timer++;
        low[u]=d[u];
        int child=0;
        //System.out.println("discovery time"+u);
        for (int i = 0; i < adj[u].size(); i++) {
            int v=adj[u].get(i);
            if (!vis[v]){
                child++;
                dfs(v);
                low[u]=Integer.min(low[u],low[v]);
                parent[v]=u;
                if (parent[u]==-1 && child>=2){
                    ap[u]=true;//if us is root node with more than one children then add u to list of articulation points list
                }
                //if v is a child of u such that,
                // no vertex in sub tree rooted with v has a back edge to one of the ancestor of u.
                if (low[v]>=d[u])
                    ap[u]=true;
            }
            else low[u]=Integer.min(low[u],d[v]);
        }
    }
}
