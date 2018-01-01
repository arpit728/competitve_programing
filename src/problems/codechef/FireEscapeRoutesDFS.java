package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by hardCode on 2/24/2016.
 */
public class FireEscapeRoutesDFS {

    static ArrayList<Integer>adj[];
    final static int MAX=100001;
    final static long M=1000000007;

    int n,m,size;
    static boolean visited[];
    static BufferedReader br;


    public FireEscapeRoutesDFS(int n, int m) {
        this.n = n;
        this.m = m;
        for (int i = 1; i <=n ; i++) {
            adj[i]=new ArrayList<>();
        }
        Arrays.fill(visited,1,n+1,false);
    }

    public static void main(String[] args) throws IOException {



        adj=new ArrayList[MAX];
        visited=new boolean[MAX];
        new Thread(null, new Runnable() {
            public void run() {
                String s[];
                br=new BufferedReader(new InputStreamReader(System.in));
                int t= 0;
                try {
                    t = Integer.parseInt(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int n,m;
                try {
                    while (t--> 0){
                        s=br.readLine().split("\\s");
                        n=Integer.parseInt(s[0]);
                        m=Integer.parseInt(s[1]);
                        new FireEscapeRoutesDFS(n,m).solve();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (StackOverflowError e) {
                    System.out.println("RTE");
                }
            }
        }, "1", 1 << 26).start();



    }

    void solve() throws IOException {

        String s[];
        int x,y,cc=0;
        long prod=1;

        for (int i = 0; i < m; i++) {

            s=br.readLine().split("\\s");
            x=Integer.parseInt(s[0]);
            y=Integer.parseInt(s[1]);
           // System.out.println(adj[x]+" "+adj[y]);
            adj[x].add(y);
            adj[y].add(x);
            //System.out.println(adj[x]+" "+adj[y]);
        }
/*
        for (int i = 1; i <=n ; i++) {
            System.out.println(adj[i]);

        }*/
        for (int u = 1; u <=n; u++) {

            if (!visited[u]){

                cc++;
                size=0;
                //System.out.println(u);
                dfs(u);
                prod*=size;

                if (prod>=M){
                    prod%=M;
                }
            }
        }

        System.out.println(cc+" "+prod);
    }

    private void dfs(int u) {
        visited[u]=true;
        size++;
        //System.out.println(u);
        int s=adj[u].size();
        for (int i = 0; i<s; i++) {
            int v=adj[u].get(i);
            if (!visited[v]){
                dfs(v);
            }

        }
    }

}
