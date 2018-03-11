package com.duotech.cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;

/**
 * Created by bugkiller on 10/03/18.
 */

public class SequenceLand {

    static Set<Integer> a[] = new Set[301];
    static boolean vis[] = new boolean[301];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[];
        int n, k;
        s = br.readLine().split("\\s");
        n = parseInt(s[0]);
        k = parseInt(s[1]);
        for (int i = 0; i < n; i++) {
            s = br.readLine().split("\\s");
            a[i] = new HashSet<>();
            for (int j = 1; j <= parseInt(s[0]); j++) {
                a[i].add(parseInt(s[j]));
            }
        }
        System.out.println(solve(n,k));

    }

    private static int solve(int n, int k) {
        Arrays.fill(vis, false);
        return bfs(n,k);
    }

    private static int bfs(int n, int k) {
        int ans = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int x = queue.poll();
            vis[x] = true;
            List adj = adjElementsOf(x, n, k);
            ans += adj.size();
            queue.addAll(adj);
        }
        return ans;
    }

    private static List<Integer> adjElementsOf(int x, int n, int k) {

        List<Integer> adjElements = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                if (isAdj(i, x, k)) {
                    adjElements.add(i);
                }
            }
        }
        return adjElements;
    }

    //is i could be included in adj list of x
    private static boolean isAdj(int i, int x, int k) {
        int cnt = 0;
        for (int d : a[x]) {
            if (a[i].contains(d)) {
                cnt++;
            }
        }
        if (cnt >= k) {
            vis[i] = true;
            return true;
        }
        return false;
    }

}
