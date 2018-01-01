package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * Created by hardCode on 2/27/2016.
 */
public class KingdomUnity {

    static int[] parent;
    static int[] low;
    static int[] disc;
    int m;
    static int n;
    int timer;
    int at;
    int cost;
    static boolean[] vis;
    static boolean[] atSet;
    //static ArrayList<Integer>[] adj;
    static boolean adj[][];
    static BufferedReader br;
    final static int MAX=3001;
    static FastReader in;

    public KingdomUnity(int n, int m, int cost) {

        this.m = m;
        this.n = n;
        this.cost=cost;
        //System.out.println("length = "+adj.length);

      /*  for (int i = 0; i < n; i++) {
            adj[i]=new ArrayList<>();
        }*/

        for (int i = 0; i < n; i++) {
            Arrays.fill(adj[i],0,n,false);
        }

        Arrays.fill(parent,0,n,-1);
        Arrays.fill(disc,0,n,0);
        Arrays.fill(low,0,n,0);
        Arrays.fill(vis,0,n,false);
        Arrays.fill(atSet,0,n,false);
        //System.out.println(Arrays.toString(disc)+Arrays.toString(low));

    }

    public static void main(String[] args) throws IOException {

        parent=new int[MAX];
        low=new int[MAX];
        disc=new int[MAX];
        atSet=new boolean[MAX];

        vis= new boolean[MAX];
        adj=new boolean[MAX][MAX];
        //System.out.println(adj.length);
        in=FastReader.SYSTEM_READER;
        //br=new BufferedReader(new InputStreamReader(System.in));
        int t,n,m,cost;
        String s[];

        t=in.nextInt();

        while (t-->0){

            /*s=br.readLine().split("\\s");
            n=Integer.parseInt(s[0]);
            m=Integer.parseInt(s[1]);
            cost=Integer.parseInt(s[2]);*/
            n=in.nextInt();
            m=in.nextInt();
            cost=in.nextInt();
            new KingdomUnity(n,m,cost).solve();

        }
    }

    public void solve() throws IOException {

        String s[];
        int x,y;

        for (int i = 0; i < m; i++) {

            x=in.nextInt();
            y=in.nextInt();
            adj[x][y]=true;
            adj[y][x]=true;

        }

        parent[0]=-1;
        dfs(0);

        System.out.println(cost*at);
    }

    public void dfs(int u) {

        vis[u]=true;

        disc[u]=timer;
        low[u]=timer;
        timer++;

        //System.out.println(Arrays.toString(low)+" "+Arrays.toString(disc)+" timer = "+timer);
        int child=0;

        for (int v = 0; v <n; v++) {

            //v=adj[u].get(i);

            if ((adj[u][v])){
                if ((!vis[v])){

                    child++;
                    parent[v]=u;
                    dfs(v);
                    low[u]=Math.min(low[u], low[v]);

                    if ((parent[u]==-1 && child>1)&& !atSet[u]){
                        at++;
                        atSet[u]=true;

                    }

                    else if ((parent[u]!=-1 && low[v]>=disc[u])&&!atSet[u]){
                        at++;
                        atSet[u]=true;
                    }

                }

                else if(v!=parent[u]) low[u]=Math.min(low[u],disc[v]);
            }

        }
        //adj[u].clear();
    }
}

final class FastReader {
    public static final FastReader SYSTEM_READER = new FastReader(System.in);
    private final InputStream in;
    private final byte[] buffer = new byte[1 << 16];
    private int pos, count;

    public FastReader(InputStream in) {
        this.in = in;
        pos = count = 0;
    }

    public int nextInt() {
        int c;
        while ((c = read()) < '0');
        int result = c - '0';
        while ((c = read() - '0') >= 0)
            result = 10 * result + c;
        return result;
    }
    public long nextLong() {
        int c;
        while ((c = read()) < '0');
        long result = c - '0';
        while ((c = read() - '0') >= 0)
            result = 10 * result + c;
        return result;
    }

    public String nextString() {
        StringBuilder s = new StringBuilder();
        int c;
        while ((c = read()) >= 33)
            s.append((char) c);
        return s.toString();
    }

    private void fillBuffer() {
        try {
            count = in.read(buffer, pos = 0, buffer.length);
        } catch (Exception e) {
        }
    }

    public int read() {
        if (pos == count)
            fillBuffer();
        return buffer[pos++];
    }
}


