package problems.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by hardCode on 4/15/2016.
 */
public class TheCoinChangeProblem {

    public static void main(String[] args) throws IOException {
        int n,m,coins[];
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s[]=br.readLine().split("\\s");
        n=Integer.parseInt(s[0]);
        m=Integer.parseInt(s[1]);
        coins=new int[m];
        s=br.readLine().split("\\s");
        for (int i = 0; i < m; i++) {
            coins[i]=Integer.parseInt(s[i]);
        }
        System.out.println(solve(n,m,coins));

    }

    private static long solve(int n, int m, int[] coins) {
        long dp[][]=new long[m][n+1];
        for (int i = 1; i <= n; i++) if (i % coins[0] == 0) dp[0][i] = 1;
        for (int i = 0; i < m; i++) dp[i][0] = 1;

        for (int i = 1; i <m; i++) {

            for (int j = 1; j <=n; j++) {
                if (j>=coins[i])
                    dp[i][j]=dp[i][j-coins[i]]+dp[i-1][j];

                else dp[i][j]=dp[i-1][j];
            }
        }
        return dp[m-1][n];
    }
}
