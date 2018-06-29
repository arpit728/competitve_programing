package com.duotech.cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;

public class CentroidDecomposition {

    private static List<Integer> adj[] = new List[100];
    private static List<Integer> centroidTree[] = new List[100];
    private static boolean vis[] = new boolean[100];
    private static boolean centroid[] = new boolean[100];
    private static int subTreeSize[] = new int[100];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m, n, u, v;
        String s[];
        s = br.readLine().split("\\s");
        n = parseInt(s[0]);
        m = parseInt(s[1]);
        for (int i = 0; i < m; i++) {
            s = br.readLine().split("\\s");
            u = parseInt(s[0]);
            v = parseInt(s[1]);
            adj[u].add(v);
            adj[v].add(u);
        }
        decompose(0, n);
    }

    private static int decompose(int src,int n) {
        Arrays.fill(vis, 0, n, false);
        dfs(src);
        int c = getCentroid(src, subTreeSize[src]);
        centroid[c] = true;

        for (int i = 0; i < adj[src].size(); i++) {
            int v = adj[src].get(i);
            if (!centroid[v]) {
                int subTreeCentroid = decompose(v, n);
                centroidTree[subTreeCentroid].add(c);
                centroidTree[c].add(subTreeCentroid);
            }
        }
        return c;
    }

    private static int getCentroid(int src, int n) {

        for (int i = 0; i < adj[src].size(); i++) {
            int v = adj[src].get(i);
            if (!vis[v] && !centroid[v]) {
                if (subTreeSize[v] > n / 2) {
                    return getCentroid(v, subTreeSize[v]);
                }
            }
        }
        return src;
    }

    private static int dfs(int src) {
        vis[src] = true;
        int subTree = 1;
        int size = adj[src].size();
        for (int i = 0; i < size; i++) {
            int v = adj[src].get(i);
            if (!vis[v] && !centroid[v]) {

                subTree += dfs(v);
            }
        }
        return subTreeSize[src] = subTree;
    }

}
