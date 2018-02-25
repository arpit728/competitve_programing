package com.duotech.cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Integer.max;

/**
 * Created by bugkiller on 17/02/18.
 */
// http://www.spoj.com/problems/RENT/
public class RENT {

    static Triple a[] = new Triple[10000];
    static int dp[] = new int[10000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10000; i++) {
            a[i] = new Triple();
        }
        int t = Integer.parseInt(br.readLine()), n;
        String[] s;
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                s = br.readLine().split("\\s");
                a[i].setValues(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]));
            }
            System.out.println(solve(a,n));
        }
    }

    private static int solve(Triple[] a, int n) {
        Arrays.sort(a, 0, n);
        return maxProfit(a, n);
    }

    private static int maxProfit(Triple[] a, int n) {
        int ans;
        dp[0] = a[0].profit;
        ans = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = a[i].profit;
            for (int j = i - 1; j >= 0; j--) {
                if (a[j].end <= a[i].start) {
                    dp[i] = max(dp[i], dp[j] + a[i].profit);
                }
            }
            ans = max(dp[i], ans);
        }
        return ans;
    }

    static class Triple implements Comparable<Triple> {

        int start;
        int end;
        int profit;

        Triple() { }

        @Override
        public int compareTo(Triple o) {
            return Integer.compare(this.end, o.end);
        }

        void setValues(int start, int duration, int profit) {
            this.start = start;
            this.end = duration + start;
            this.profit = profit;
        }

        @Override
        public String toString() {
            return "Tupple{" +
                    "start=" + start +
                    ", end=" + end +
                    ", profit=" + profit +
                    '}';
        }
    }
}
