package com.duotech.cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

public class FENTREE {

    static long tree[] = new long[1000001];
    static int a[] = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, q;
        String s[];
        n = parseInt(br.readLine());
        s = br.readLine().split("\\s");
        for (int i = 0; i < n; i++) {
            a[i + 1] = parseInt(s[i]);
        }
        initTree(n);
        q = parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            s = br.readLine().split("\\s");
            if ("q".equals(s[0])) {
                int l = parseInt(s[1]);
                int r = parseInt(s[2]);
                System.out.println(prefixSum(r) - prefixSum(l - 1));
            } else {
                int idx = parseInt(s[1]);
                int value = parseInt(s[2]);
                update(idx, value, n);
            }
        }
    }

    private static void initTree(int n) {
        for (int i = 1; i <= n; i++) {
            update(i, a[i], n);
        }
    }

    //returns sum a[1...x]
    private static long prefixSum(int x) {
        long ans = 0;
        while (x > 0) {
            ans += tree[x];
            x -= x & -x;
        }
        return ans;
    }

    private static void update(int idx, int value, int n) {

        while (idx <= n) {
            tree[idx] += value;
            idx += idx & -idx;
        }

    }
}
