package com.duotech.cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Integer.MIN_VALUE;
import static java.lang.Integer.max;

/**
 * Created by bugkiller on 08/03/18.
 */
public class WealthDisparity {

    static int a[] = new int[100001];
    static int p[] = new int[100001];
    static int diff[] = new int[100001];
    static int MAX[] = new int[100001];
    static final int NOT_DEFINED = MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[];
        int n;
        s = br.readLine().split("\\s");
        n = Integer.parseInt(s[0]);
        for (int i = 1,j=1; i < s.length; i++) {
            if (i <= n) {
                a[i] = Integer.parseInt(s[i]);
            }
            else {
                p[j++] = Integer.parseInt(s[i]);
            }
        }
        System.out.println(solve(a, p, n));
    }

    private static int solve(int[] a, int[] p, int n) {
        Arrays.fill(MAX, NOT_DEFINED);
        int ans = MIN_VALUE;
        if (n == 1) {
            return 0;
        }
        for (int i = 1; i <= n; i++) {
            maxUpToRoot(i);
            if (p[i] != -1) {
                ans = max(ans, MAX[p[i]] - a[i]);
            }
        }
        return ans;
    }

    private static int maxUpToRoot(int s) {

        if (p[s] == -1) {
            return MAX[s] = a[s];
        }
        if (MAX[s] != NOT_DEFINED) {
            return MAX[s];
        }
        MAX[s] = max(a[s], maxUpToRoot(p[s]));
        return MAX[s];
    }

   /* private static int solve(int[] a, int[] p, int n) {

        if (n == 1) {
            return 0;
        }
        int ans = MIN_VALUE;
        Arrays.fill(diff, MIN_VALUE);
        for (int i = 1; i <= n; i++) {
            if (p[i] != -1) {
                ans = max(ans, getDiff(i));
            }
        }
        return ans;
    }

    private static int getDiff(int i) {

        if (p[p[i]] == -1) {
            diff[i] = a[p[i]] - a[i];
            return diff[i];
        }
        if (diff[i] != NOT_DEFINED) {
            return diff[i];
        }
        if (diff[p[i]] != NOT_DEFINED) {
            diff[p[i]] = getDiff(p[i]);
        }
        int temp = diff[p[i]] + a[p[i]];
        diff[i] = temp - a[i];
        diff[i] = max(diff[i], a[p[i]] - a[i]);
        return diff[i];
    }*/

}
