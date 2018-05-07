package com.duotech.cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

import static java.lang.Integer.parseInt;

public class PetyaAndRepairmentOfRoads {
    private static int edges[][] = new int[200001][3];
    private static int parent[] = new int[100001];
    private static boolean milkMen[] = new boolean[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m, source, t, p;
        String s[];
        t = parseInt(br.readLine());
        while (t-- > 0) {
            s = br.readLine().split("\\s");
            n = parseInt(s[0]);
            m = parseInt(s[1]);
            s = br.readLine().split("\\s");
            for (int i = 1; i <= n; i++) {
                if ("1".equals(s[i - 1])) {
                    milkMen[i] = true;
                }
            }
            for (int i = 0; i < m; i++) {
                s = br.readLine().split("\\s");
                edges[i][0] = parseInt(s[0]);
                edges[i][1] = parseInt(s[1]);
                edges[i][2] = parseInt(s[2]);
                if (milkMen[edges[i][0]] && milkMen[edges[i][1]]) {
                    edges[i][2] = 0;
                }
            }
            System.out.println(solve(n, m));
        }
    }

    private static String solve(int n, int m) {
        int milkyCities = 0;
        Arrays.sort(edges, 0, m, Comparator.comparingInt(o -> o[2]));
        for (int i = 1; i <=n; i++) {
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
        for (int i = 1; i <= n; i++) {
            findSet(i);
            if (milkMen[parent[i]]) {
                milkyCities++;
            }
        }
        if (milkyCities < n) {
            return "impossible";
        }

        return ans + "";
    }

    private static void findUnion(int u, int v) {

        if (milkMen[parent[u]]) {
            parent[findSet(v)] = findSet(u);
        } else {
            parent[findSet(u)] = findSet(v);
        }
    }

    private static int findSet(int x) {

        if (x != parent[x]) {
            parent[x] = findSet(parent[x]);
        }
        return parent[x];
    }

}
/*
1
5 7
0 1 0 1 0
1 2 11
1 3 1
1 5 17
2 3 1
3 5 18
4 5 3
2 4 5
*/