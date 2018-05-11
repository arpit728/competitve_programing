package com.duotech.cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.min;


public class Palindrome {

    static int dp[][] = new int[3][5000];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] s = br.readLine().toCharArray();
        System.out.println(solve(s, n));
    }

    private static int solve(char[] s, int n) {
        return minCost(s, n);
    }

    private static int minCost(char[] s, int n) {

        //dp[len][x] represents the min cost of making string with length len starting from x
        for (int i = 0; i < n; i++) {
            dp[0][i] = 0;
            dp[1][i] = 0;
        }
        for (int len = 2; len <= n; len++) {
            Arrays.fill(dp[2], 0, n, MAX_VALUE);
            for (int j = 0; j + len - 1 < n; j++) {
                if (s[j] == s[j + len - 1]) {
                    dp[2][j] = dp[0][j + 1];
                } else {
                    dp[2][j] = 1 + min(dp[1][j + 1], dp[1][j]);
                }
            }
            System.arraycopy(dp[1], 0, dp[0], 0, n);
            System.arraycopy(dp[2], 0, dp[1], 0, n);
        }
        return dp[1][0];
    }

}
