package com.duotech.cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by bugkiller on 04/02/18.
 */
public class SUPW {

    static int a[] = new int[200000];
    static int dp[] = new int[200000];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        String[] s;
        n = Integer.parseInt(br.readLine());
        s = br.readLine().split("\\s");
        for (int i = 0; i < n; i++) {
            try {
                a[i] = Integer.parseInt(s[i]);
            } catch (Exception e) {
                a[i] = 0;
            }
        }
        System.out.println(solve(a, n));
    }

    private static int solve(int[] a, int n) {
        Arrays.fill(dp, 0, n, 0);
        return minimumTime(a, dp, n);
    }

    private static int minimumTime(int[] a, int[] dp, int n) {
        if (n <= 2) {
            return 0;
        }
        dp[0] = a[0];
        dp[1] = a[1];
        dp[2] = a[2];
        for (int i = 3; i < n; i++) {
            dp[i] = a[i] + Integer.min(Integer.min(dp[i - 1], dp[i - 2]), dp[i - 3]);
        }
        return Integer.min(Integer.min(dp[n - 1], dp[n - 2]), dp[n - 3]);
    }

}