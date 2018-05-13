package com.duotech.cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.*;

public class BAT2 {
    static int a[] = new int[105];
    static int dp[][][] = new int[105][105][105];
    static final int UNDEFINED = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, t;
        String s[];
        t = parseInt(br.readLine());
        while (t-- > 0) {
            n = parseInt(br.readLine());
            a[n] = MAX_VALUE;
            a[n + 1] = MIN_VALUE;
            fillDp(n + 2);
            s = br.readLine().split("\\s");
            for (int i = 0; i < n; i++) {
                a[i] = parseInt(s[i]);
            }
            System.out.println(solve(n));
        }
    }

    private static int solve(int n) {
        return maxColoredElements(n - 1, n, n + 1);
    }

    private static int maxColoredElements(int i, int li, int ld) {
        if (i == -1) {
            return 0;
        }
        if (dp[i][li][ld] != UNDEFINED) {
            return dp[i][li][ld];
        }
        int temp = maxColoredElements(i - 1, li, ld);
        if (a[i] < a[li]) {
            temp = max(temp, 1 + maxColoredElements(i - 1, i, ld));
        }
        if (a[i] > a[ld]) {
            temp = max(temp, 1 + maxColoredElements(i - 1, li, i));
        }
        return dp[i][li][ld] = temp;
    }

    private static void fillDp(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dp[i][j][k] = UNDEFINED;
                }
            }
        }
    }
}
