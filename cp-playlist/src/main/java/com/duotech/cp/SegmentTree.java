package com.duotech.cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;
import static java.lang.Math.min;

public class SegmentTree {

    static int t[] = new int[200005];
    static int a[] = new int[200005];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, l, r, q, x, y;
        String s[];

        s = br.readLine().split("\\s");
        n = parseInt(s[0]);
        q = parseInt(s[1]);

        s = br.readLine().split("\\s");
        for (int i = 0; i < n; i++) {
            a[i] = parseInt(s[i]);
        }

        buildTree(a, n);
        for (int i = 0; i < q; i++) {
            s = br.readLine().split("\\s");
            if ("q".equals(s[0])) {
                l = parseInt(s[1]);
                r = parseInt(s[2]);
                System.out.println(query(--l, --r, n));
            } else {
                x = parseInt(s[1]);
                y = parseInt(s[2]);
                update(--x, y, n);
            }
        }
    }

    private static void update(int x, int y, int n) {


        x += n;//to go to appropriate leaf node in the tree
        t[x] = y;//update the leaf node

        //below for loop updates the chain from leaf to root
        for (x >>= 1; x > 0; x >>= 1) {
            t[x] = min(t[x << 1], t[(x << 1) + 1]);
        }
    }

    private static int query(int l, int r,int n) {

        int ans = Integer.MAX_VALUE;
        for (l += n, r += n; l <= r; l >>= 1, r >>= 1) {
            if ((l & 1) == 1) {
                ans = min(ans, t[l++]);
            }
            if ((r & 1) != 1) {
                ans = min(ans, t[r--]);
            }
        }
        return ans;
    }

    private static void buildTree(int[] a, int n) {
        Arrays.fill(t, 0, 2 * n + 1, MAX_VALUE);
        System.arraycopy(a, 0, t, n, n);
        for (int i = n - 1; i > 0; i--) {
            t[i] = min(t[i << 1], t[(i << 1) + 1]);
        }
    }
}
