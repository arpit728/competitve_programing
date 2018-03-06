package com.duotech.cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by bugkiller on 06/03/18.
 */

public class PermutationCycles {
    static int a[] = new int[1001];
    static boolean vis[] = new boolean[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        String[] s;
        Arrays.fill(vis, false);
        n = Integer.parseInt(br.readLine());
        s = br.readLine().split("\\s");
        for (int i = 0; i < n; i++) {
            a[i + 1] = Integer.parseInt(s[i]);
        }
        System.out.print(solve(n));
    }

    private static String solve(int n) {
        StringBuilder result = new StringBuilder();
        int cycles = 0;
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                cycles++;
                dfs(i, result);
                result.append(i);
                result.append("\n");
            }
        }
        result.insert(0, cycles + "\n");
        return result.toString();
    }

    private static void dfs(int s, StringBuilder result) {

        if (!vis[s]) {
            vis[s] = true;
            result.append(s).append(" ");
            dfs(a[s], result);
        }
    }
}
