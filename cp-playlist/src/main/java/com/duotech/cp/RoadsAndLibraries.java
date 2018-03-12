package com.duotech.cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.lang.Long.min;

/**
 * Created by bugkiller on 11/03/18.
 */

public class RoadsAndLibraries {

    static List<Integer>[] adj = new List[100001];
    static boolean vis[] = new boolean[100001];

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
                adj[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                s = br.readLine().split("\\s");
                int u = parseInt(s[0]);
                int v = parseInt(s[1]);
                adj[u].add(v);
                adj[v].add(u);
            }
            System.out.println(solve(n, cLib, cRoad));
        }
    }

    private static long solve(int n, int cLib, int cRoad) {
        Arrays.fill(vis, false);
        return totalCost(n,cLib,cRoad);
    }

    private static long totalCost(int n, int cLib, int cRoad) {
        long cost = 0;
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                long componentSize = dfs(i);
                cost += min(cLib * componentSize, cRoad * (componentSize - 1) + cLib);
            }
        }
        return cost;
    }

    private static int dfs(int u) {
        int componentSize = 1;
        vis[u] = true;
        int size = adj[u].size();
        for (int i = 0; i < size; i++) {
            int v = adj[u].get(i);
            if (!vis[v]) {
                componentSize += dfs(v);
            }
        }
        return componentSize;
    }

}
