package com.duotech.cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

import static java.lang.Integer.parseInt;

public class CSTREET {
    static int edges[][] = new int[300001][3];
    static int parent[] = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m, source, t, p;
        String s[];
        t = parseInt(br.readLine());
        while (t-- > 0) {
            p = parseInt(br.readLine());
            n = parseInt(br.readLine());
            m = parseInt(br.readLine());
            for (int i = 0; i < m; i++) {
                s = br.readLine().split("\\s");
                edges[i][0] = parseInt(s[0]);
                edges[i][1] = parseInt(s[1]);
                edges[i][2] = parseInt(s[2]);
            }
            System.out.println(solve(n, m, p));
        }
    }

    private static long solve(int n, int m, int p) {
        Arrays.sort(edges, 0, m, Comparator.comparingInt(o -> o[2]));
        for (int i = 0; i <=n; i++) {
            parent[i] = i;
        }
        long ans = 0;
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            if (findSet(u) != findSet(v)) {
                ans += edges[i][2];
                findUnion(u, v);
            }
        }
        return p * ans;
    }

    private static void findUnion(int u, int v) {
        parent[findSet(u)] = findSet(v);
    }

    private static int findSet(int x) {

        if (x != parent[x]) {
            parent[x] = findSet(parent[x]);
        }
        return parent[x];
    }

}
