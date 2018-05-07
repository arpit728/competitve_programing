package com.duotech.cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;

public class PowerOfMatrix {

    private static final long M = 1000000007;
    static long x[][] = new long[50][50];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t, m, n;
        String s[];
        t = parseInt(br.readLine());
        while (t-- > 0) {
            s = br.readLine().split("\\s");
            m = parseInt(s[0]);
            n = parseInt(s[1]);
            for (int i = 0; i < m; i++) {
                s = br.readLine().split("\\s");
                for (int j = 0; j < m; j++) {
                    x[i][j] = parseInt(s[j]);
                }
            }
            long ans[][] = solve(x,m, n);
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(ans[i][j]+" ");
                }
                System.out.println();
            }
        }
    }

    private static long[][] solve(long[][] x, int m, int n) {

        return pow(x,m,n);
    }

    private static long[][] pow(long[][] x, int m, int n) {

        if (n == 1) {
            return x;
        }
        long[][] temp = pow(x, m, n / 2);
        temp = matrixMul(temp, temp, m);
        if (n % 2 == 1) {
            temp = matrixMul(x, temp, m);
        }
        return temp;
    }

    private static long[][] matrixMul(long[][] x, long[][] y, int m) {
        long ans[][] = new long[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    ans[i][j] = ((ans[i][j] % M) + (((x[i][k]) % M) * ((y[k][j] % M)) % M)) % M;
                }
            }
        }
        return ans;
    }
}
