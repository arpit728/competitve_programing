package com.duotech.cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Integer.max;
import static java.lang.Integer.signum;
import static java.lang.Math.abs;

/**
 * Created by bugkiller on 10/02/18.
 */

public class AlternatingSequences {

    static int dp[]=new int[5000];
    static int a[] = new int[5000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        String[] s;
        Arrays.fill(dp, 1);
        n = Integer.parseInt(br.readLine());
        s = br.readLine().split("\\s");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        System.out.println(solve(a,n));
    }

    private static int solve(int[] a, int n) {
        return maxLength(a,n);
    }

    private static int maxLength(int[] a, int n) {
        int ans = 1;
        for (int i = 1; i < n; i++) {
            int signI = signum(a[i]);
            for (int j = i-1; j>=0 ; j--) {
                int signJ = signum(a[j]);
                if (abs(a[j]) < abs(a[i]) && signI != signJ) {
                    dp[i] = max(dp[i], dp[j] + 1);
                }
            }
            ans = max(ans, dp[i]);
        }
        return ans;
    }
}
