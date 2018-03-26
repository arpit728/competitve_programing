package com.duotech.cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class NewReform {

    static ArrayList<Integer> adj[] = new ArrayList[100001];
    static boolean vis[] = new boolean[100001];
    static int parent[] = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m, u, v;
        String s[];
        s = br.readLine().split("\\s");
        n = parseInt(s[0]);
        m = parseInt(s[1]);
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            s = br.readLine().split("\\s");
            u = parseInt(s[0]);
            v = parseInt(s[1]);
            adj[u].add(v);
            adj[v].add(u);
        }
        System.out.println(solve(m, n));

    }

    private static int solve(int m, int n) {
        Arrays.fill(parent, 1, n + 1, -1);
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                if (!dfs(i)) {
                    ans++;
                }

            }
        }
        return ans;
    }

    //return true if connected component contains cycle
    private static boolean dfs(int u) {

        boolean cycle = false;
        vis[u] = true;
        int size = adj[u].size();
        for (int i = 0; i < size; i++) {
            int v = adj[u].get(i);
            if (!vis[v]) {
                parent[v] = u;
                cycle |= dfs(v);
            }
            else if (vis[v] && parent[u] != v) {
                cycle = true;
            }
        }
        return cycle;
    }

}
