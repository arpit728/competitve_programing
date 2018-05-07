package com.duotech.cp;

import java.io.IOException;
import java.io.InputStream;

import static java.lang.Integer.MIN_VALUE;
import static java.lang.Integer.max;

public class GSS1 {

    private static final int MAX_SUM =0,SUM=1, MAX_PREFIX =2, MAX_SUFFIX = 3;

    private static int tree[][] = new int[200010][4];

    private static int minResult[] = new int[]{MIN_VALUE, MIN_VALUE, MIN_VALUE, MIN_VALUE};

    private static int a[] = new int[50001];

    public static void main(String[] args) throws IOException {
        FastReader fr = FastReader.SYSTEM_READER;
        int n, m, l, r;
        n = fr.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = fr.nextInt();
        }
        buildTree(1, 0, n);
        m = fr.nextInt();
        for (int i = 0; i < m; i++) {
            // [l,r)
            l = fr.nextInt() - 1;
            r = fr.nextInt();
            System.out.println(query(1, 0, n, l, r)[MAX_SUM]);
        }
    }

    private static int[] query(int id, int start, int end, int l, int r) {

        if (end <= l || start >= r) {
            return minResult;
        }

        if (start >= l && end <= r) {
            return tree[id];
        }

        int mid = (start + end) / 2;
        int lc = id << 1;         //left child node
        int rc = (id << 1) + 1;  //right child node

        int left[] = query(lc, start, mid, l, r);
        int right[] = query(rc, mid, end, l, r);

        int maxSum, sum, maxPrefix, maxSuffix;


        maxSum = max(max(left[MAX_SUM], right[MAX_SUM]),
                left[MAX_SUFFIX] + right[MAX_PREFIX]);

        sum = left[SUM] + right[SUM];
        maxPrefix = max(left[MAX_PREFIX], left[SUM] + right[MAX_SUFFIX]);
        maxSuffix = max(right[MAX_SUFFIX], right[SUM] + left[MAX_SUFFIX]);

        return new int[]{maxSum, sum, maxPrefix, maxSuffix};
    }

    private static void buildTree(int id, int l, int r) {
        if (r - l < 2) {
            tree[id][MAX_SUM] = a[l];
            tree[id][SUM] = a[l];
            tree[id][MAX_PREFIX] = a[l];
            tree[id][MAX_SUFFIX] = a[l];
            return;
        }
        int mid = (l + r) / 2;
        int left = id << 1;
        int right = (id << 1) + 1;
        buildTree(left, l, mid);
        buildTree(right, mid, r);
        tree[id][MAX_SUM] = max(max(tree[left][MAX_SUM], tree[right][MAX_SUM]),
                                tree[left][MAX_SUFFIX] + tree[right][MAX_PREFIX]);
        tree[id][SUM] = tree[left][SUM] + tree[right][SUM];
        tree[id][MAX_PREFIX] = max(tree[left][MAX_PREFIX], tree[left][SUM] + tree[right][MAX_SUFFIX]);
        tree[id][MAX_SUFFIX] = max(tree[right][MAX_SUFFIX], tree[right][SUM] + tree[left][MAX_SUFFIX]);
    }

    public static final class FastReader {
        static final FastReader SYSTEM_READER = new FastReader(System.in);
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int pos, count;

        FastReader(InputStream in) {
            this.in = in;
            pos = count = 0;
        }

        public int nextInt() {
            int ret = 0;
            int c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() {
            try {
                count = in.read(buffer, pos = 0, buffer.length);
            } catch (Exception e) {
            }
        }

        public int read() {
            if (pos == count)
                fillBuffer();
            return buffer[pos++];
        }
    }
}
