package com.duotech.cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Long.max;

/**
 * Created by bugkiller on 19/02/18.
 */

public class SpecialSum {

    static long a[] = new long[1000002];
    static long b[] = new long[1000002];
    static long pre[] = new long[1000002];
    static long diff[] = new long[1000002];
    static long sum[] = new long[1000002];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        String s1[], s2[];
        n = Integer.parseInt(br.readLine());
        s1 = br.readLine().split("\\s");
        s2 = br.readLine().split("\\s");
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(s1[i - 1]);
            b[i] = Integer.parseInt(s2[i - 1]);
        }
        System.out.println(solve(a, b, n));
    }

    private static long solve(long[] a, long[] b, int n) {
        fillPrefix(b, n);
        fillDiff(a, n);
        fillSum(a, n);
        return specialSum(a, b, n);
    }


    private static long specialSum(long[] a, long[] b, int n) {
        long sSum = Long.MIN_VALUE;
        for (int i = 1; i <=n; i++) {
            sSum = max(sSum, a[i]);//i=j
            if (i > 1)
                sSum = max(sSum, diff[i - 1] + pre[i - 1] + a[i]);//[i,j]i<j
            if (i < n)
                sSum = max(sSum, sum[i + 1] + a[i] + pre[i - 1] + pre[n]);//[i,j]i>j
        }
        return sSum;
    }

    private static void fillSum(long[] a, int n) {
        sum[n + 1] = Long.MIN_VALUE;
        for (int i = n; i > 0; i--) {
            sum[i] = max(sum[i + 1], a[i] - pre[i]);
        }
    }

    private static void fillDiff(long[] a, int n) {
        diff[0] = Long.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            diff[i] = max(diff[i - 1], a[i] - pre[i]);
        }
    }

    private static void fillPrefix(long[] b, int n) {
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + b[i];
        }
    }
}
