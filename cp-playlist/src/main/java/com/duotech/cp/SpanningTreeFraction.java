package com.duotech.cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class SpanningTreeFraction {

    static double edges[][] = new double[100000][5];
    static int parent[] = new int[100000];
    private static final int U_INDEX=0,V_INDEX=1,A_INDEX=2, B_INDEX = 3, W_INDEX = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m, u, v, a, b;
        String s[];
        s = br.readLine().split("\\s");
        n = parseInt(s[0]);
        m = parseInt(s[1]);
        for (int i = 0; i < m; i++) {
            s = br.readLine().split("\\s");
            u = parseInt(s[0]);
            v = parseInt(s[1]);
            a = parseInt(s[2]);
            b = parseInt(s[3]);

            edges[i][U_INDEX] = u;
            edges[i][V_INDEX] = v;
            edges[i][A_INDEX] = a;
            edges[i][B_INDEX] = b;
        }
        System.out.println(solve(n, m));
    }

    private static String solve(int n, int m) {

        double start = 0, end = 10000000;
        long A, B, finalA=0, finalB=0;
        boolean result;
        for (int itr = 0; itr < 100; itr++) {
            double mid = (start + end) / 2;
            setWeights(m, mid);
            Arrays.sort(edges, 0, m, (o1, o2) -> Double.compare(o2[W_INDEX], o1[W_INDEX]));
            initParent(n);
            A = 0;
            B = 0;
            for (int i = 0; i < m; i++) {
                int u = (int) edges[i][U_INDEX];
                int v = (int) edges[i][V_INDEX];
                if (findSet(u) != findSet(v)) {
                    union(u, v);
                    A += edges[i][A_INDEX];
                    B += edges[i][B_INDEX];
                }
            }
            result = A >= ((double)B * mid);
            if (result) {
                start = mid;
                finalA = A;
                finalB = B;
            } else {
                end = mid;
            }
        }
        long g = gcd(finalA, finalB);

        return (finalA / g) + "/" + (finalB / g);
    }

    static long gcd(long a, long b) {
        if (a == 0)
            return b;

        return gcd(b%a, a);
    }
    private static void initParent(int n) {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    private static void setWeights(int m, double c) {
        for (int i = 0; i < m; i++) {
            edges[i][W_INDEX] = edges[i][A_INDEX] - edges[i][B_INDEX] * c;
        }
    }

    static int findSet(int u) {

        if (parent[u] == u) {
            return u;
        }
        parent[u] = findSet(parent[u]);
        return parent[u];
    }

    static void union(int u, int v) {
        parent[findSet(u)] = findSet(v);
    }
}
