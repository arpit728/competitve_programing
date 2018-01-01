package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created by arpit on 28/12/16.
 */
public class EstimatingProgress {

    final static int MAX=50000;
    static TreeSet<Integer>set=new TreeSet<>();
    static Integer a[]=new Integer[MAX];
    static Query q[]=new Query[MAX];
    static long queryAns[]=new long[MAX];
    static int counts[]=new int[1000010];
    static int blockSize;
    static long ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n,m;
        String []s;

        n=Integer.parseInt(br.readLine());
        s=br.readLine().split("\\s");
        for (int i = 0; i < n; i++) {
            a[i]=Integer.parseInt(s[i]);
        }

        //input no. of queries
        m=Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            s=br.readLine().split("\\s");
            q[i]=new Query(Integer.parseInt(s[0])-1,Integer.parseInt(s[1])-1,i);
        }

        blockSize= (int) Math.sqrt(n);

        solve(n, m);

    }

    private static void solve(int n, int m) {

        Arrays.sort(q,0,m);

       /* for (int i = 0; i < m; i++) {
            System.out.print(q[i] + " ");
        }
        System.out.println();*/

       /* int currL=q[0].l,currR=q[0].r;
        for (int i =currL; i <=currR ; i++) {
            add(i);
        }
        queryAns[q[0].idx]=ans;
        currR++;*/

        int currL=0,currR=0;
        for (int i = 0; i <m ; i++)
        {
            int l=q[i].l,r=q[i].r;

            while (currL<l){
                remove(currL);
                currL++;
            }

            while (currL>l){
                add(currL-1);
                currL--;
            }

            while (currR<=r){
                add(currR);
                currR++;
            }

            while (currR>(r+1)){
                remove(currR-1);
                currR--;
            }
            queryAns[q[i].idx]=ans;
        }

        for (int i = 0; i < m; i++) {
            System.out.println(queryAns[i]);
        }
    }

    private static void remove(int pos) {

        counts[a[pos]]--;

        if (counts[a[pos]]==0){
            set.remove(a[pos]);
            Integer prev=set.lower(a[pos]);
            Integer next=set.higher(a[pos]);

            if (prev!=null){
                ans-=(long)(a[pos]-prev)*(a[pos]-prev);
            }
            if (next!=null){
                ans-=(long)(next-a[pos])*(next-a[pos]);
            }
            if (next!=null && prev!=null)
                ans+=(long)(next-prev)*(next-prev);
        }
    }

    private static void add(int pos) {

        //System.out.println(pos+" "+xenny[pos]);
        if (counts[a[pos]]>0) {
            counts[a[pos]]++;
            return;
        }
        counts[a[pos]]++;
        set.add(a[pos]);
        Integer prev=set.lower(a[pos]);
        Integer next=set.higher(a[pos]);

        if (prev!=null){
            ans+=(long)(a[pos]-prev)*(a[pos]-prev);
        }
        if (next!=null){
            ans+=(long)(next-a[pos])*(next-a[pos]);
        }
        if (next!=null && prev!=null)
            ans-=(long)(next-prev)*(next-prev);

        /*if (set.add(xenny[pos]))
        {
            Integer prev=set.lower(xenny[pos]);
            Integer next=set.higher(xenny[pos]);

            if (prev!=null){
                ans+=(long)(xenny[pos]-prev)*(xenny[pos]-prev);
            }
            if (next!=null){
                ans+=(long)(next-xenny[pos])*(next-xenny[pos]);
            }
            if (next!=null && prev!=null)
                ans-=(long)(next-prev)*(next-prev);
        }*/
    }


    static class Query implements Comparable<Query>{

        Integer l,r,idx;

        public Query(Integer l, Integer r, Integer idx) {
            this.l = l;
            this.r = r;
            this.idx = idx;
        }

        @Override
        public int compareTo(Query query) {

            Integer a=this.l/blockSize;
            Integer b=query.l/blockSize;

            if (a!=b)
               return a.compareTo(b);

            return this.r.compareTo(query.r);
        }

        @Override
        public String toString() {
            return "Query{" +
                    "l=" + l +
                    ", r=" + r +
                    ", idx=" + idx +
                    '}';
        }
    }
}
