package algo.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by arpit on 14/11/16.
 */
public class BalancedPartition {


    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int t,n,a[];
        String s[];
        t=Integer.parseInt(br.readLine());

        while (t-->0){
            n=Integer.parseInt(br.readLine());
            s=br.readLine().split("\\s");
            a=new int[n];

            for (int i = 0; i < n; i++) {
                a[i]=Integer.parseInt(s[i]);
            }

            System.out.println(solve(a,n));

        }

    }

    private static int solve(int[] a, int n) {

        boolean dp[][]= new boolean[n][2501];
        int sum=calSum(a,n);

        partitionDP(a, dp, n,sum);
        /*for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }*/

        return findMinimum(dp,a,n,sum);
    }

    //This function finds the sum that is closest to sum/2 and
    // returns the minimum difference between two subsets that can be achieved.
    private static int findMinimum(boolean[][] dp, int[] a, int n, int sum) {

        int diff=0;

        for (int j=sum/2;j>=0;j--){

            if (dp[n-1][j]){

                diff=sum-2*j;
                break;
            }
        }
        return diff;
    }


    //This function fills the table dp with the appropriate boolean values(Bottom up).
    private static void partitionDP(int[] a, boolean[][] dp, int n, int sum) {

        for (int i = 0; i <n; i++) {
            dp[i][0]=true;
        }
        dp[0][a[0]]=true;

        for (int i = 1; i < n; i++) {
            for (int j=1;j<=sum;j++){

                dp[i][j]=dp[i-1][j];

                if (j>=a[i]){
                    dp[i][j]=dp[i-1][j]||dp[i-1][j-a[i]];
                }
            }
        }
    }

    //This function returns the sum of all the elements of the array
    private static int calSum(int[] a, int n) {

        int sum=0;
        for (int i = 0; i < n; i++) {
            sum+=a[i];
        }
        return sum;
    }


    /*The function partition is the recursive solution to the balanced partition problem, it considers that for each
    element we have to choices either we can put an element in set 1 or set 2*/
    private static int partition(int[] a, int n, int sum1, int sum2) {


        if (n==0)return Math.abs(sum1-sum2);

        return Integer.min(partition(a,n-1,sum1+a[n-1],sum2),partition(a,n-1,sum1,sum2+a[n-1]));
    }
}
