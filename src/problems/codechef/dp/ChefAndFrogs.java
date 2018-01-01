package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by arpit on 9/12/16.
 *
 * Problem link:-https://www.codechef.com/problems/FROGV
 */
public class ChefAndFrogs {

    final static int MAX=100001;
    static int parent[]=new int[MAX];
    static Data a[]=new Data[MAX];
    static int maxDistance[]=new int[MAX];//Used for dp approach

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n,k,p;
        String s[];

        s=br.readLine().split("\\s");
        n=Integer.parseInt(s[0]);
        k=Integer.parseInt(s[1]);
        p=Integer.parseInt(s[2]);

        initParent(n);

        s=br.readLine().split("\\s");

        for (int i = 0; i < n; i++) {
            a[i]=new Data(Integer.parseInt(s[i]),i);
        }

        Arrays.sort(a,0,n);

        //This is the DSU approach
       /* constructDSU(n, k);
        pathCompression(n);

        while (p-->0){
            s=br.readLine().split("\\s");
            System.out.println(solveQuery(Integer.parseInt(s[0])-1,Integer.parseInt(s[1])-1));
        }*/

        //This is the DP approach
        preCompute(n,k);
        while (p-->0){
            s=br.readLine().split("\\s");
            System.out.println(queryUsingDp(Integer.parseInt(s[0])-1,Integer.parseInt(s[1])-1));
        }

        for (int i = 0; i < n; i++) {
            System.out.print(maxDistance[a[i].index] + " ");
        }
        System.out.println();

    }

    private static void pathCompression(int n) {
        for (int i = 0; i < n; i++) {
            findSet(i);
        }
    }

    private static String solveQuery(int a, int b) {

        if (findSet(a)==findSet(b))return "Yes";
        return "No";
    }

    private static void initParent(int n) {
        for (int i = 0; i < n; i++) {
            parent[i]=i;
        }
    }

    private static void constructDSU(int n, int k) {

        for (int i = 0; i < n; i++) {
            for (int j=i+1;j<n;j++){
                if ((a[j].x-a[i].x)<=k){
                    union(a[i].index,a[j].index);
                    i=j-1;
                }
                else break;
            }
        }
    }

    private static void union(int a, int b) {
        parent[findSet(a)]=findSet(b);
    }

    private static int findSet(int a) {

        if (parent[a]==a)return a;

        parent[a]=findSet(parent[a]);
        return parent[a];
    }

    //The problem can also be solved simply using dynamic programming,
    // The idea behind dp approach is that two frogs can only communicate if there maximum distance is equal.
    // We compute the maximum coordinate(distance) up to which frog can communicate.
    static void preCompute(int n,int k){

        maxDistance[a[n-1].index]=a[n-1].x+k;
        for (int i =n-2; i>=0; i--) {
            if ((a[i+1].x-a[i].x)<=k)maxDistance[a[i].index]=maxDistance[a[i+1].index];
            else maxDistance[a[i].index]=a[i].x+k;
        }
    }
    static String queryUsingDp(int p,int q){
        if (maxDistance[p]==maxDistance[q])return "Yes";
        return "No";
    }

    static class Data implements Comparable<Data>{
        int x,index;

        public Data(int x, int index) {
            this.x = x;
            this.index = index;
        }

        @Override
        public int compareTo(Data data) {
            return ((Integer)this.x).compareTo(data.x);
        }

        @Override
        public String toString() {
            return "Data{" +
                    "x=" + x +
                    ", index=" + index +
                    '}';
        }
    }
}
