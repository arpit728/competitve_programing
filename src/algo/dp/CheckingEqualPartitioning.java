package algo.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by arpit on 16/8/16.
 */
public class CheckingEqualPartitioning {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int a[]=new int[100];
        int n,k;
        boolean dp[][]= new boolean[101][50001 ];
        String[]s1,s2;

        while (t-->0){
            int sum=0;
            n=Integer.parseInt(br.readLine());

            s1=br.readLine().split("\\s");

            for (int i = 0; i < n; i++) {
                a[i]=Integer.parseInt(s1[i]);
                sum+=a[i];
            }



            if (sum%2==1){
                System.out.println("NO");
                continue;
                //If sum of elements inside array is odd then obviously array cannot be partitioned equally
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= (sum/2+1); j++) {
                    dp[i][j]=false;
                }
            }

            /*if (partitionSum(a,n,sum/2))System.out.println("YES");

            else System.out.println("NO");*/

            if (partitionSumMemoized(a, n, sum / 2, dp))System.out.println("YES");

            else System.out.println("NO");


        }
    }

    private static boolean partitionSumMemoized(int[] a, int n, int sum, boolean[][] dp) {

        if (sum==0)
            return true;

        if (n == 0 && sum != 0)
            return false;

        if (dp[n-1][sum])return dp[n-1][sum];

        if (a[n-1]>sum)dp[n-1][sum]=partitionSumMemoized(a,n-1,sum,dp);

        else {
            dp[n-1][sum]=partitionSumMemoized(a,n-1,sum,dp)||partitionSumMemoized(a,n-1,sum-a[n-1],dp);
        }
        return dp[n-1][sum];
    }


    //Recursive version that takes exponential time
    private static boolean partitionSum(int[] a, int n, int sum) {

        if (sum==0)return true;

        if (n == 0 && sum != 0)
            return false;

        if (a[n-1]>sum)return partitionSum(a,n-1,sum);

        else {
            return partitionSum(a,n-1,sum)||partitionSum(a,n-1,sum-a[n-1]);
        }
    }
}

