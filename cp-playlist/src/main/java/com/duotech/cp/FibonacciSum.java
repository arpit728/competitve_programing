package com.duotech.cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;
import static java.lang.StrictMath.abs;

public class FibonacciSum {

    private static final int M = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t, n, m;
        String s[];
        t = parseInt(br.readLine());
        while (t-- > 0) {
            s = br.readLine().split("\\s");
            n = parseInt(s[0]);
            m = parseInt(s[1]);
            System.out.println(solve(n, m));
        }
    }

    public static long solve(int n, int m) {

        long temp = fibSum(m) - fibSum(n - 1);
        if (temp < 0) {
            return M - (abs(temp) % M);
        }
        return temp;
    }

    public static long fibSum(int n) {

        long ans = fib(n + 2);
        if (ans == 0) {
            return M - 1;
        }
        return ans - 1;
    }

    public static long fib(int n) {
        if (n==0) return 0;
        if (n==1) return 1;
        long base[][] = {{1, 1}, {1, 0}};
        long temp[][] = pow(base, n - 1);
        return temp[0][0];
    }

    public static long[][] pow(long[][] base, int n) {

        if (n == 1) {
            return base;
        }
        long[][] temp = pow(base, n / 2);
        temp = matrixMul(temp, temp);
        if (n % 2 == 1) {
            temp = matrixMul(base, temp);
        }
        return temp;
    }

    private static long[][] matrixMul(long[][] x, long[][] y) {
        long ans[][] = new long[2][2];
        ans[0][0] = ((((x[0][0] % M) * (y[0][0] % M)) % M) + (((x[0][1] % M) * (y[1][0] % M)) % M)) % M;
        ans[0][1] = ((((x[0][0] % M) * (y[1][0] % M)) % M) + (((x[0][1] % M) * (y[1][1] % M)) % M)) % M;
        ans[1][0] = ((((x[1][0] % M) * (y[0][0] % M)) % M) + (((x[1][1] % M) * (y[1][0] % M)) % M)) % M;
        ans[1][1] = ((((x[1][0] % M) * (y[0][1] % M)) % M) + (((x[1][1] % M) * (y[1][1] % M)) % M)) % M;
        return ans;
    }

}
