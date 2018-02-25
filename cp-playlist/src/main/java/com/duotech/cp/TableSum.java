package com.duotech.cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Integer.max;

/**
 * Created by bugkiller on 24/02/18.
 */

//problem link :- https://www.codechef.com/INOIPRAC/problems/INOI1202

public class TableSum {
    static final int MAX = 200005;
    static int a[] = new int[MAX];
    static int pre[] = new int[MAX];
    static int suff[] = new int[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        String[] s;
        n = Integer.parseInt(br.readLine());
        s = br.readLine().split("\\s");
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(s[i - 1]);
        }
        System.out.println(solve(a, n));
    }

    private static String solve(int[] a, int n) {
        Arrays.fill(pre, 0, n + 1, 0);
        Arrays.fill(suff, 0, n + 1, 0);
        fillPreFix(a, n);
        fillSuffix(a, n);
        StringBuilder sbr = new StringBuilder();
        for (int i = n; i >= 1; i--) {
            int j = n - i + 1;
            sbr.append(max(pre[i] + j - 1, suff[i + 1] + j - 1 - n) + " ");
        }
        sbr.deleteCharAt(sbr.length() - 1);
        return sbr.toString();
    }

    private static void fillPreFix(int[] a, int n) {
        for (int i = 1; i <= n; i++) {
            pre[i] = max(a[i] + i, pre[i - 1]);
        }
    }

    private static void fillSuffix(int[] a, int n) {
        for (int i = n; i >= 1; i--) {
            suff[i] = max(a[i] + i, suff[i + 1]);
        }
    }
}
