package algo.dp;

import java.util.Arrays;

/**
 * Created by arpit on 6/12/16.
 *
 * problem link:- http://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/
 */
public class MinimumCostPath {

    static int dp[][]=new int[3][3];

    public static void main(String[] args) {
        int cost[][]={ {1, 2, 3},{4, 8, 2},{1, 5, 3} };
        int n=cost.length,m=cost[0].length;

        System.out.println(solve(cost,n,m ));
    }

    static int min(int a,int b,int c){

        if (a<=b && a<=c)return a;

        if (b<=a && b<=c)return b;

        return c;
    }

    private static int solve(int[][] cost, int n, int m) {

        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);

        return minCostDp(cost,n-1,m-1);
        //return minCost(cost, n - 1, m - 1);
    }


    //This is the recursive approach that generates all the paths and chooses the min cost path.
    private static int minCost(int[][] cost, int i, int j) {

        if (i<0||j<0)return Integer.MAX_VALUE;
        if (i==0 && j==0)return cost[0][0];

        return min(minCost(cost,i-1,j-1),minCost(cost,i,j-1),minCost(cost,i-1,j))+cost[i][j];
    }

    //This is the top down dp that uses memoization.
    static int minCostDp(int[][] cost, int i, int j){
        if (i<0||j<0)return Integer.MAX_VALUE;
        if (i==0 && j==0)return cost[0][0];

        if (dp[i][j] != -1) return dp[i][j];

        dp[i][j]=min(minCost(cost,i-1,j-1),minCost(cost,i,j-1),minCost(cost,i-1,j))+cost[i][j];
        return dp[i][j];
    }

}
