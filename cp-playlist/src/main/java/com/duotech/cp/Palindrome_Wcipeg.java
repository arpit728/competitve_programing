package com.duotech.cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Integer.min;

/**
 * Created by bugkiller on 12/02/18.
 */

public class Palindrome_Wcipeg {
    static int[][] dp = new int[6101][6101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] s = br.readLine().toCharArray();
        System.out.println(solve(s, n));

    }

    private static int solve(char[] s, int n) {
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 0, n, -1);
        }
        return minCost(s, 0, n - 1);
    }

    private static int minCost(char[] s, int start, int end) {
        if (start >= end)
            return 0;

        if (dp[start][end] != -1)
            return dp[start][end];

        if (s[start] == s[end])
            dp[start][end] = minCost(s, start + 1, end - 1);

        else
            dp[start][end] = 1 + min(minCost(s, start, end - 1), minCost(s, start + 1, end));

        return dp[start][end];
    }

}
