package com.duotech.cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by bugkiller on 11/02/18.
 */
public class HighwayBypass {

    static int a[][] = new int[300][300];
    static int dp[][] = new int[300][300];
    static final int M = 20011;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int r, c, d;
        String[] s;
        s = br.readLine().split("\\s");
        r = Integer.parseInt(s[0]);
        c = Integer.parseInt(s[1]);
        d = Integer.parseInt(s[2]);
        for (int i = 0; i < r; i++) {
            s = br.readLine().split("\\s");
            for (int j = 0; j < c; j++) {
                a[i][j] = Integer.parseInt(s[j]);
            }
        }
        System.out.println(solve(a, r, c, d));
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static int solve(int[][] a, int r, int c, int d) {
        for (int i = 0; i < r; i++) {
            Arrays.fill(dp[i], -1);
        }
        return totalPathBottomUp(a,r-1,c-1,d);
    }

    private static int totalPathBottomUp(int[][] a, int r, int c, int d) {
        for (int i = 0; i <= r; i++) {
            for (int j = 0; j <= c; j++) {
                if (a[i][j] == 0) {
                    dp[i][j] = 0;
                } else if (i == 0 && j == 0) {
                    dp[i][j] = 0;
                } else if (i == 0 ) {
                    if ( j <= d)
                        dp[i][j] = 1;
                    else dp[i][j] = 0;
                } else if (j == 0) {
                    if (i <= d)
                        dp[i][j] = 1;
                    else dp[i][j] = 0;
                }  else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    if (i - d - 1 >= 0) {
                        dp[i][j] -= dp[i - d - 1][j];
                    }
                    if (j - d - 1 >= 0) {
                        dp[i][j] -= dp[i][j - d - 1];
                    }
                }
            }
        }
        return dp[r][c];
    }
    private static int totalPath(int[][] a, int r, int c, int d) {
        if (r == 0 && c == 0)
            return 0;
        if (r >= 0 && c >= 0) {
            if (a[r][c]==0)
                return 0;
            if (r == 0) {
                if (c <= d) return 1;
                else return 0;
            }
            if (c == 0) {
                if (r <= d) return 1;
                else return 0;
            }

            if (dp[r][c]!=-1)
                return dp[r][c];

            if (a[r][c] == 1) {
                dp[r][c] = ((totalPath(a, r - 1, c, d) % M) + (totalPath(a, r, c - 1, d) % M)
                        -(totalPath(a, r - d - 1, c, d) % M) - (totalPath(a, r, c - d - 1, d) % M)) % M;
            } else dp[r][c] = 0;

            return dp[r][c];
        }
        return 0;
    }
}
