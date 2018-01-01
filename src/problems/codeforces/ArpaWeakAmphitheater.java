package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by arpit on 9/12/16.
 */
public class ArpaWeakAmphitheater {

    static final int MAX=1001;
    static Data a[]=new Data[MAX];
    static int dp[][]=new int[MAX][MAX];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[]s1,s2;
        int n,m,w;
        s1=br.readLine().split("\\s");
        n=Integer.parseInt(s1[0]);
        m=Integer.parseInt(s1[1]);
        w=Integer.parseInt(s1[2]);
        s1=br.readLine().split("\\s");//weight array
        s2=br.readLine().split("\\s");//beauty array
        for (int i = 0; i < n; i++) {//Integer.parseInt(s1[i]);Integer.parseInt(s2[i]);
            a[i]=new Data(Integer.parseInt(s1[i]),Integer.parseInt(s2[i]),i);
        }

        for (int i = 0; i < m; i++) {
            s1=br.readLine().split("\\s");
            union(Integer.parseInt(s1[0])-1,Integer.parseInt(s1[1])-1);
        }

        System.out.println(solve(n,m,w));

    }
    private static int solve(int n, int m, int w) {

        pathCompression(n);
        Arrays.sort(a,0,n);
        int bt,wt,count,set=1,start,j,end;

        for (int i = 0; i<n; i++) {
            bt=a[i].beauty;wt=a[i].weight;start=i;

            for (j = i+1; j<n; j++) {
                if (a[i].parent!=a[j].parent)break;
                bt+=a[j].beauty;
                wt+=a[j].weight;
            }
            end=j-1;
            i=j-1;

            //This part id to update dp table

            for (int k = 1; k<=w ; k++) {
                dp[set][k]=dp[set-1][k];//not choosing a single hos from this set.
                if (wt<=k)dp[set][k]=Integer.max(dp[set][k],dp[set-1][k-wt]+bt);//Choosing all the hoses in this set

                //Choosing only one hos.
                for (int l =start; l<=end ; l++) {
                    if (a[l].weight<=k)dp[set][k]=Integer.max(dp[set][k],dp[set-1][k-a[l].weight]+a[l].beauty);
                }
            }
            set++;
        }

        System.out.println("set  = "+set);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        System.out.println("set = "+set);
        for (int i = 1; i<=set; i++) {
            for (int k = 1; k<=w; k++) {
                System.out.print(dp[i][k] + " ");
            }
            System.out.println();
        }
        return dp[set-1][w];
    }
    private static void pathCompression(int n) {

        for (int i = 0; i < n; i++) {
            find(i);
        }
    }

    private static void union(int x, int y) {

        a[find(x)].parent=find(y);
    }

    private static int find(int x) {

        if (x==a[x].parent)return x;

        a[x].parent=find(a[x].parent);
        return a[x].parent;
    }



    static class Data implements Comparable<Data>{
        int beauty,weight;
        int parent;

        public Data(int weight,int beauty,  Integer parent) {
            this.beauty = beauty;
            this.weight = weight;
            this.parent = parent;
        }

        @Override
        public int compareTo(Data data) {
            return ((Integer)this.parent).compareTo(data.parent);
        }

        @Override
        public String toString() {
            return "Data{" +
                    "beauty=" + beauty +
                    ", weight=" + weight +
                    ", parent=" + parent +
                    '}';
        }
    }
}

