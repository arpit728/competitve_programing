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
        Arrays.fill(dp, 0);
        for (int i = k+1; i <=n ; i++) {
            dp[i] = max(dp[i - 1], dp[i - 2]) + a[i];
        }
        int maxScore = 0, maxScoreIndex = k;
        for (int i = k; i <=n; i++) {
            if (dp[i] > maxScore) {
                maxScore = dp[i];
                maxScoreIndex = i;
            }
        }
        Arrays.fill(dp, 0);
        for (int i = maxScoreIndex - 1; i > 0; i--) {
            dp[i] = max(dp[i + 1], dp[i + 2]) + a[i];
        }
        return dp[1] + maxScore;
    }
}
