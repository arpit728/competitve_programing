package com.duotech.cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by bugkiller on 03/02/18.
 */
public class AggressiveCows {

    static int a[] = new int[100000];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t, n, c;
        String[] s;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            s = br.readLine().split("\\s");
            n = Integer.parseInt(s[0]);
            c = Integer.parseInt(s[1]);
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(br.readLine());
            }
            System.out.println(solve(a, n, c));
        }
    }

    private static int solve(int[] a, int n, int c) {
        Arrays.sort(a, 0, n);
        return binarySearch(0,a[n-1]-a[0],a,n,c);
    }

    private static int binarySearch(int low, int high, int[] a, int n, int c) {

        int mid = (low + high) / 2;
        if (low <= high) {
            if (isMinimumDistancePossible(mid, a, n, c)) {
                return Integer.max(mid, binarySearch(mid + 1, high, a, n, c));
            }
            else
                return binarySearch(low, mid - 1, a, n, c);
        }
        return 0;
    }

    private static boolean isMinimumDistancePossible(int x, int[] a, int n, int c) {
        long nextElement = a[0] + x, count = 1;
        for (int i = 1; i < n; i++) {
            if (a[i] >= nextElement) {
                count++;
                nextElement = a[i] + (long)x;
            }
            if (c == count) {
                return true;
            }
        }
        return false;
    }
}
