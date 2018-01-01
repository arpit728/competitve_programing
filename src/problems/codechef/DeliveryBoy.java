package problems.codechef;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by arpit on 13/8/16.
 */
public class DeliveryBoy {

    final static int INFINITY=1<<20;

    static class pair implements Comparable<pair>{
        Integer u,w;

        public pair(int u, int w) {
            this.u = u;
            this.w = w;
        }

        @Override
        public int compareTo(pair pair) {
            return this.w.compareTo(pair.w);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n,t[][],m;
        String s[];
        n=Integer.parseInt(br.readLine());

        t=new int[n][n];
        for (int i = 0; i < n; i++) {
            s=br.readLine().split("\\s");

            for (int j = 0; j < n; j++) {
                t[i][j]=Integer.parseInt(s[j]);
            }
        }

        m=Integer.parseInt(br.readLine());


        //pre-computation using warshall's all pair shortest path algorithm
        warshall(t,n);

        while (m-->0){
            s=br.readLine().split("\\s");
            int src=Integer.parseInt(s[0]);
            int g=Integer.parseInt(s[1]);
            int d=Integer.parseInt(s[2]);
            System.out.println(solve(t, n, src, g, d));
        }

    }

    static void warshall(int t[][],int n){

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    t[i][j]=Integer.min(t[i][k]+t[k][j],t[i][j]);
                }
            }
        }
    }

    private static String solve(int[][] t, int n, int s, int g, int d) {
        int x=t[s][g]+t[g][d];
        int y=x-t[s][d];
        return x+" "+y;

    }


    /*
        //This function solves the given problem using dijkstra's algorithm,
        but the no. of queries are too much so this solution doesn't work and
        therefore we go for all pair shortest path(Floyd warshall's algorithm)
    */
    private static String solveDihkstra(int[][] t, int n, int s, int g, int d) {

        PriorityQueue<pair> pq=new PriorityQueue<>();
        int dis[]=new int[n];
        boolean vis[]=new boolean[n];

        Arrays.fill(dis,INFINITY);
        dis[s]=0;
        pq.add(new pair(s,0));
        while (!pq.isEmpty()){

            int u=pq.poll().u;
            //System.out.println("Hey");
            for (int v = 0; v < n; v++) {

                if (!vis[v] && dis[v]>dis[u]+t[u][v]){
                    dis[v]=dis[u]+t[u][v];
                    pq.add(new pair(v,t[u][v]));
                }
            }
            vis[u]=true;
        }

        //System.out.println("dis 1"+Arrays.toString(dis));
        int disD=dis[d], disG=dis[g];

        Arrays.fill(dis,INFINITY);
        Arrays.fill(vis,false);
        pq.clear();
        pq.add(new pair(g,0));
        dis[g]=0;
        while (!pq.isEmpty()){
            int u=pq.poll().u;

            for (int v = 0; v < n; v++) {

                if (!vis[v] && dis[v]>dis[u]+t[u][v]){
                    dis[v]=dis[u]+t[u][v];
                    pq.add(new pair(v,t[u][v]));
                }
            }
            vis[u]=true;
        }
        //System.out.println("dis 2"+Arrays.toString(dis));


        int x=disG+dis[d],y=disD;

        return x+" "+(x-y);
    }
}
