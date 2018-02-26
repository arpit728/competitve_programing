package com.duotech.cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Integer.max;

/**
 * Created by bugkiller on 07/02/18.
 */
public class CalvinsGame {

    static int a[] = new int[1000005];
    static int dp[] = new int[1000005];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, k;
        String[] s;
        s = br.readLine().split("\\s");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        s = br.readLine().split("\\s");
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(s[i - 1]);
        }
        System.out.println(solve(a, n, k));
    }

    private static int solve(int[] a, int n, int k) {
        return maxScore(a, n, k);
    }

    private static int maxScore(int[] a, int n, int k) {
        if (n==1) return 0;
        if (n == 2) {
            if (k == 1) {
                return max(0, a[1]);
            }
            if (k==2)
                return a[1];
        }
        Arrays.fill(dp, 0);
        for (int i = k + 1; i <= n; i++) {
            dp[i] = max(dp[i - 1], dp[i - 2]) + a[i];
        }
        dp[n - 1] = max(dp[n - 1], dp[n] + a[n - 1]);
        for (int i = n - 2; i > 0; i--) {
            dp[i] = max(dp[i], max(dp[i + 1], dp[i + 2]) + a[i]);
        }
        if (k == 1) {
            return max(0, dp[1]);
        }
        return dp[1];
    }
}
