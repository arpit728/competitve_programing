package algo.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by arpit on 6/12/16.
 */
public class MaximumSumIncreasingSubsequences {

    static int a[]=new int[100];
    static int dp[]=new int[100];

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int n;
        String s[];
        while(t-->0){
            n=Integer.parseInt(br.readLine());
            s=br.readLine().split("\\s");
            for (int i = 0; i < n; i++) {
                a[i]=Integer.parseInt(s[i]);
                dp[i]=a[i];
            }
            System.out.println(solve(a, n));
        }
    }

    private static int solve(int[] a, int n) {

        return maxSum(a,n);
    }

    private static int maxSum(int[] a, int n) {

        int max=a[0];
        for (int i = 1; i < n; i++) {
            for (int j = i-1; j>=0; j--) {
                if (a[j]<a[i])
                    dp[i]=Integer.max(dp[i],dp[j]+a[i]);
            }
            max=Integer.max(max,dp[i]);
        }
        return max;
    }
}
