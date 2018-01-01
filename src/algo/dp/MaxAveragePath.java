package algo.dp;

import java.util.Arrays;

/**
 * Created by arpit on 6/12/16.
 */
public class MaxAveragePath {

    public static void main(String[] args) {

        int a[][]={ {1, 2, 3},{6, 5, 4},{7, 3, 9}};

        System.out.println(solve(a,a.length));
    }

    private static float solve(int[][] a, int n) {

        int dp[][]=new int[n][n];
        for (int i = 0; i <n ; i++) {
            Arrays.fill(dp[i],-1);
        }
        dp[0][0]=a[0][0];

        return (float)maxAvgPathDp(dp,a,n-1,n-1)/(2*n-1);
        //return (float)maxAvgPath(a, n - 1, n - 1)/(2*n-1);
    }

    //This is recursive solution that takes exponential time
    static int maxAvgPath(int a[][],int i,int j){

        if (i<0 ||j<0)return Integer.MIN_VALUE;
        if (i==0 && j==0) return a[0][0];
        return Integer.max(maxAvgPath(a, i - 1, j),maxAvgPath(a, i, j - 1))+a[i][j];
    }

    //This is top down dp memoized dp solution
    private static int maxAvgPathDp(int[][] dp,int a[][], int i, int j) {

        if (i<0 || j<0)return Integer.MIN_VALUE;

        if (i==0 && j==0) return dp[0][0];

        if (dp[i][j]!=-1)return dp[i][j];

        dp[i][j]=Integer.max(maxAvgPathDp(dp, a, i - 1, j), maxAvgPathDp(dp, a, i, j - 1))+a[i][j];

        return dp[i][j];
    }
}
