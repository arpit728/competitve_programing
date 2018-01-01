package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by arpit on 7/12/16.
 */
public class MergingCommunities {

    static int x[]=new int[100000];//parent array
    static int p[]=new int[100000];//population
    static int stack[]=new int[100000];

    static BufferedReader br;//Buffered reader is declared here because we need to take i/p in multiple functions.
    public static void main(String[] args) throws IOException {

         br=new BufferedReader(new InputStreamReader(System.in));
        int n,q;
        String[]s;
        s=br.readLine().split("\\s");
        n=Integer.parseInt(s[0]);
        q=Integer.parseInt(s[1]);
        solve(n,q);
    }

    private static void solve(int n, int q) throws IOException {
        String[]s;

        Arrays.fill(x,0,n,-1);//Initialize parent array
        Arrays.fill(p,0,n,1);//Initialize population array

        for (int i = 0; i < q; i++) {
            s=br.readLine().split("\\s");
            if (s.length==3)
                mQuery(Integer.parseInt(s[1])-1,Integer.parseInt(s[2])-1);

            else //length will be equal to two
                System.out.println(qQuery(Integer.parseInt(s[1])-1));
        }
    }

    private static int qQuery(int a) {
        return p[findSet(a)];
    }

    private static void mQuery(int a, int b) {
        union(a,b);
    }

    static int findSet(int a){

        if (x[a]<0)return a;

        x[a]=findSet(x[a]);

        return x[a];
    }

    private static void union(int a,int b){

        int r1=findSet(a);
        int r2=findSet(b);

        if (r1==r2)return;

        if (x[r1]<x[r2]){
            x[r2]=r1;//setting r2 parent to r1
            p[r1]+=p[r2];//updating parent's population
        }


        else {
            if (x[r1] == x[r2])
                x[r2]--;//if height of both trees are same then height of the parent increases by -1

            x[r1] = r2;//setting r2 as a parent
            p[r2] += p[r1];//updating parent's population

        }
    }
}
