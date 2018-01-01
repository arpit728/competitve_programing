package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by arpit on 19/12/16.
 */
public class MOSAlgorithm {

    static final int MAX=311111;
    static Query[]queries=new Query[MAX];
    static int[]a=new int[MAX];
    static int[]count=new int[MAX];
    static int ans[]=new int[MAX],answer =0;
    static int blockSize;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n,m;
        String[]s;
        n=Integer.parseInt(br.readLine());

        s=br.readLine().split("\\s");//Input array
        for (int i = 0; i < n; i++) {
            a[i]=Integer.parseInt(s[i]);
        }
        m=Integer.parseInt(br.readLine());

        //Input queries
        for (int i = 0; i < m; i++) {
            s=br.readLine().split("\\s");
            queries[i]=new Query(Integer.parseInt(s[0]),Integer.parseInt(s[1]),i);
        }

        blockSize= (int) Math.sqrt(n);

        solve(n,m);


    }

    private static void solve(int n, int m) {

        Arrays.sort(queries,0,m);

        for (int i = 0; i < m; i++) {
            System.out.print(queries[i] + " ");
        }
        System.out.println();

        int currentL=0,currentR=0;

        for (int i = 0; i < m; i++) {

            while (currentL<queries[i].l){
                remove(currentL);
              //  System.out.println("remove called from l++");
                currentL++;
            }

            while (currentL>queries[i].l){
                add(currentL-1);
               // System.out.println("add called from l--");

                currentL--;
            }

            while (currentR<=queries[i].r){
                add(currentR);
               // System.out.println("add called from r++");
                currentR++;
            }
            while (currentR>(queries[i].r+1)){
                remove(currentR-1);
               // System.out.println("remove called from r--");
                currentR--;
            }

            ans[queries[i].i]=answer;

        }

        for (int i = 0; i < m; i++) {
            System.out.println(ans[i]);
        }

    }

    private static void add(int pos) {
        int temp=a[pos];
        count[temp]++;
        if (count[a[pos]]==1)
            answer++;
    }

    private static void remove(int pos) {
        count[a[pos]]--;
        if (count[a[pos]]==0) answer--;
    }

    static class Query implements Comparable<Query>{

        int l,r,i;

        public Query(int l, int r, int i) {
            this.l = l;
            this.r = r;
            this.i = i;
        }

        @Override
        public int compareTo(Query query) {
            if ((this.l/blockSize)!=(query.l/blockSize))
                return ((Integer) (this.l/blockSize)).compareTo(query.l/blockSize);

            return ((Integer)(this.r)).compareTo(query.r);
        }

        @Override
        public String toString() {
            return "Query{" +
                    "l=" + l +
                    ", r=" + r +
                    ", i=" + i +
                    '}';
        }
    }
}
