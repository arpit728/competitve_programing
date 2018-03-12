package com.duotech.cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;
import static java.lang.Long.min;
import static java.util.Arrays.sort;

/**
 * Created by bugkiller on 11/03/18.
 */

public class RoadsAndLibrariesDsu {

    static int parent[] = new int[100002];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m, n, q,cLib,cRoad;
        String s[];
        q = parseInt(br.readLine());
        while (q-- > 0) {
            s = br.readLine().split("\\s");
            n = parseInt(s[0]);
            m = parseInt(s[1]);
            cLib = parseInt(s[2]);
            cRoad = parseInt(s[3]);
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
            for (int i = 0; i < m; i++) {
                s = br.readLine().split("\\s");
                int u = parseInt(s[0]);
                int v = parseInt(s[1]);
                findUnion(u, v);
            }
            System.out.println(solve(n, cLib, cRoad));
        }
    }

    private static long solve(int n, int cLib, int cRoad) {
        return totalCost(n, cLib, cRoad);
    }

    private static long totalCost(int n, long cLib, long cRoad) {
        long cost = 0;
        int start = 1, end = 1;
        long size = 0;
        for (int i = 1; i <= n; i++) {
            findSet(i);
        }
        sort(parent, 0, n + 1);
        while (end <=n) {
            if (parent[start] == parent[end]) {
                end++;
                size++;
            }
            else {
                start = end;
                cost += min(cLib * size, cRoad * (size - 1) + cLib);
                size = 0;
            }
        }
        cost += min(cLib * size, cRoad * (size - 1) + cLib);
        return cost;
    }

    private static void findUnion(int u, int v) {
        parent[findSet(u)] = findSet(v);
    }

    private static int findSet(int x) {

        if (parent[x] == x) {
            return x;
        }
        parent[x] = findSet(parent[x]);
        return parent[x];
    }

}
