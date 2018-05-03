package com.duotech.cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.max;
import static java.lang.Integer.parseInt;

public class FrequentValues {

    private static int a[] = new int[100001];
    private static int tree[] = new int[200005];
    private static Map<Integer, Integer> firstOccurence = new HashMap<>();
    private static Map<Integer, Integer> lastOccurence = new HashMap<>();

    private static Map<Integer, Integer> freq = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, q;
        String s[];

        while (true) {
            s = br.readLine().split("\\s");
            if (s.length==1)
                break;
            n = parseInt(s[0]);
            q = parseInt(s[1]);
            s = br.readLine().split("\\s");
            for (int i = 0; i < n; i++) {
                a[i] = parseInt(s[i]);
                freq.putIfAbsent(a[i], 0);
                freq.compute(a[i], (k, v) -> ++v);
            }
            for (int i = 0; i < n; i++) {
                lastOccurence.put(a[i], i);
                firstOccurence.put(a[n - i - 1], n - i - 1);
            }
            constructTree(freq, n);
            for (int i = 0; i < q; i++) {
                s = br.readLine().split("\\s");
                int u = parseInt(s[0]);
                int v = parseInt(s[1]);
                --u;
                --v;
                System.out.println(maxOccurenceInRange(a, n, u, v));
            }
            freq.clear();
        }
    }

    private static int maxOccurenceInRange(int[] a, int n, int u, int v) {

        int newU = u;
        int newV = v;
        if (a[u] == a[v]) {
            return v - u + 1;
        }

        if (u > 0 && a[u] == a[u - 1]) {
            newU = lastOccurence.get(a[u]) + 1;
        }

        if (v < n && a[v] == a[v + 1]) {
            newV = firstOccurence.get(a[v]) - 1;
        }

        return max(max(lastOccurence.get(a[u]) - u + 1, v - firstOccurence.get(a[v]) + 1),
                query(newU, newV, n));
    }

    private static int query(int u, int v, int n) {
        u += n;
        v += n;
        int ans = 0;
        for (; u <= v; u >>= 1, v >>= 1) {
            if ((u & 1) == 1) {
                ans = max(ans, tree[u--]);
            }
            if ((v & 1) != 1) {
                ans = max(ans, tree[v--]);
            }
        }
        return ans;
    }
    private static void constructTree(Map<Integer, Integer> freq, int n) {
        for (int i = 0; i < n; i++) {
            tree[n + i] = freq.get(a[i]);
        }
        for (int i = n - 1; i > 0; i--) {
            tree[i] = max(tree[i << 1], tree[(i << 1) + 1]);
        }
    }
}


