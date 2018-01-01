package algo.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/**
 * Created by arpit on 15/8/16.
 */
public class IntegerKnapsack {


    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int v[]=new int[100],w[]=new int[100];
        int n,k,dp[][]=new int[101][101];
        String[]s1,s2;
        while (t-->0){
            n=Integer.parseInt(br.readLine());
            k=Integer.parseInt(br.readLine());
            s1=br.readLine().split("\\s");
            s2=br.readLine().split("\\s");

            for (int i = 0; i < n; i++) {
                v[i]=Integer.parseInt(s1[i]);
                w[i]=Integer.parseInt(s2[i]);
                Arrays.fill(dp[i],-1);
            }

            //System.out.println(recursiveKnapsack(v, w, n, k));
            System.out.println(knapsack(v,w,n,k,dp));
        }
    }
   /* //solution made during webengage interview preparation

    private static int knapsack(int[] v, int[] w, int n, int k, int[][] dp,int sum) {

        if (k == 0 || n == 0) {
            return sum;
        }
        if (dp[n-1][k]!=-1)
            return dp[n - 1][k];

        if (w[n-1]>k)
            return knapsack(v, w, n - 1, k, dp, sum);

        dp[n-1][k]=max(knapsack(v, w, n - 1, k, dp, sum), knapsack(v, w, n - 1, k - w[n - 1], dp, sum + v[n - 1]));

        return dp[n-1][k];

    }*/
    //This is the memoized top down solution to the integer knapsack problem.

   //original solution
    private static int knapsack(int[] v, int[] w, int n, int k, int[][] dp) {

        if (k==0 || n==0)return 0;

        if (dp[n-1][k]!=-1)return dp[n-1][k];

        if (w[n-1]>k)return knapsack(v,w,n-1,k,dp);

        else {
            dp[n-1][k]=Integer.max(v[n-1]+knapsack(v,w,n-1,k-w[n-1],dp),knapsack(v,w,n-1,k,dp));
        }
        return dp[n-1][k];
    }

    //This is the recursive solution to the integer knapsack problem which takes exponential time.
    private static int recursiveKnapsack(int[] v, int[] w, int n, int k) {

        if (n==0 || k==0)return 0;

        if (w[n-1]>k)return recursiveKnapsack(v,w,n-1,k);

        return Integer.max(v[n-1]+recursiveKnapsack(v,w,n-1,k-w[n-1]),recursiveKnapsack(v,w,n-1,k));
    }
}
