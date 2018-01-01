package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by arpit on 22/12/16.
 */
public class ChefAndWay {

    static int a[]=new int[100011];
    static long dp[]=new long[100011];

    static BigInteger []dp2=new BigInteger[100011];
    static final int M=1000000007;


    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n,k;
        String[]s;

        s=br.readLine().split("\\s");
        n=Integer.parseInt(s[0]);
        k=Integer.parseInt(s[1]);

        s=br.readLine().split("\\s");

        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        System.out.println(solve(a, n, k));

    }

    private static long solve(int[] a, int n, int k) {

        PriorityQueue<Pair>pq=new PriorityQueue<>();

        pq.add(new Pair(Math.log(a[n-1]),n-1));
        dp[n-1]=a[n-1];

        for (int i =n-2; i>=0; i--) {
            while (pq.peek().idx>(i+k))pq.poll();
            long  min=dp[pq.peek().idx];
            dp[i]=(a[i]*min)%M;
            pq.add(new Pair(pq.peek().logValue+Math.log(a[i]),i));
        }

        return dp[0];
    }

    //This solution is only for small sub task.

    private static int solve1(int a[],int n,int k){

        dp2[n-1]=new BigInteger(a[n-1]+"");

        for (int i =n-2; i>=0  ; i--) {
            BigInteger min=dp2[i+1];
            dp2[i]=new BigInteger(a[i]+"");
            for (int j = i+1; j<n && j<=(i+k); j++) {
                if (dp2[j].compareTo(min)<0)min=dp2[j];
            }
           // System.out.println(i);
            dp2[i]=dp2[i].multiply(min);
        }
/*
        for (int i = 0; i < n; i++) {
            System.out.print(dp2[i] + " ");
        }
        System.out.println();*/
        return dp2[0].mod(BigInteger.valueOf(1000000007)).intValue();
    }


    static class Pair implements Comparable<Pair>{
        int idx;
        double logValue;

        public Pair(double logValue,int idx) {
            this.idx = idx;
            this.logValue = logValue;
        }

        @Override
        public int compareTo(Pair pair) {
           return Double.compare(this.logValue,pair.logValue);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "idx=" + idx +
                    ", logValue=" + logValue +
                    '}';
        }
    }
}
