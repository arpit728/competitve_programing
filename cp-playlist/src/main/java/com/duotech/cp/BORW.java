package com.duotech.cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.*;

public class BORW {

    static int a[] = new int[202];
    static int dp[][][] = new int[202][202][202];
    static final int UNDEFINED = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        String s[];
        while (true) {
            n = parseInt(br.readLine());
            if (n == -1) {
                break;
            }
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
        return n - maxColoredElements(n - 1, n, n + 1, n);
    }

    private static int maxColoredElements(int i, int li, int ld, int n) {
        if (i == -1) {
            return 0;
        }
        if (dp[i][li][ld] != UNDEFINED) {
            return dp[i][li][ld];
        }
        int temp = maxColoredElements(i - 1, li, ld, n);
        if (a[i] < a[li]) {
            temp = max(temp, 1 + maxColoredElements(i - 1, i, ld, n));
        }
        if (a[i] > a[ld]) {
            temp = max(temp, 1 + maxColoredElements(i - 1, li, i, n));
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
