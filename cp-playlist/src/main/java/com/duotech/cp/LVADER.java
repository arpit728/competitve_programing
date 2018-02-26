package com.duotech.cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by bugkiller on 16/02/18.
 */

public class LVADER {
    static final int MAX = 200005;
    static final long P = 1000000007;
    static long factorial[] = new long[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t, x1, y1, x2, y2, i = 1;
        String[] s;
        t = Integer.parseInt(br.readLine());
        fillFactorial();
        while (t-- > 0) {
            s = br.readLine().split("\\s");
            x1 = Integer.parseInt(s[0]);
            y1 = Integer.parseInt(s[1]);
            x2 = Integer.parseInt(s[2]);
            y2 = Integer.parseInt(s[3]);
            System.out.println("Case " + i + ": " + solve(x1, y1, x2, y2));
            i++;
        }
        System.exit(0);
    }

    private static long solve(int x1, int y1, int x2, int y2) {
        return totalPaths(x2 - x1, y2 - y1);
    }

    private static long totalPaths(int m, int n) {
        int k = Integer.min(m, n);
        long ans = 0;
        for (int i = 0; i <= k; i++) {
            int x = m + n - i;
            long tempAns = (nCR(x, m) * nCR(m, i)) % P;
            ans = (ans + tempAns) % P;
        }
        return ans;
    }

    static long nCR(int n, int r) {
        return (((factorial[n] * pow(factorial[r], P - 2)) % P) * pow(factorial[n - r], P - 2)) % P;
    }

    public static long pow(long a, long n) {
        if (n > 0) {
            long temp = pow(a, n / 2);
            temp = (temp * temp) % P;
            if ((n & 1) == 1) {
                temp = (temp * a) % P;
            }
            return temp;
        }
        return 1;
    }

    private static void fillFactorial() {
        factorial[0] = 1;
        for (int i = 1; i < MAX; i++) {
            factorial[i] = (factorial[i - 1] * i) % P;
        }
    }



}
