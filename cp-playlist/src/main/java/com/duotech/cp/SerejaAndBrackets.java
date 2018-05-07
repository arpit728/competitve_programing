package com.duotech.cp;

import java.io.IOException;
import java.io.InputStream;

import static java.lang.Integer.min;

public class SerejaAndBrackets {

    static int tree[] = new int[4000002];
    static int o[] = new int[4000002];
    static int c[] = new int[4000002];
    static char a[] = new char[1000000];

    public static void main(String[] args) throws IOException {
        FastReader br = FastReader.SYSTEM_READER;
        String s, temp[];
        int m, l, r, n;
        s = br.nextString();
        n = s.length();
        s.getChars(0, n, a, 0);
        buildTree(1, 0, n);
        m = br.nextInt();
        for (int i = 0; i < m; i++) {
            //temp = br.readLine().split("\\s");
            l = br.nextInt();
            r = br.nextInt();
            System.out.println(query(1, 0, n, l - 1, r)[0]*2);
        }

    }

    //return value description -> t[maximumBracket subsequence length, no. of open brackets in range, no. of closed brackets in range]
    //start end represents the range covered by the node id
    //l and r is the range of the query asked
    private static int[] query(int id, int start, int end, int l, int r) {
        if (start >= r || end <= l) {
            return new int[]{0, 0, 0};
        }
        if (start >= l && end <= r) {
            return new int[]{tree[id], o[id], c[id]};
        }
        int mid = (start + end) / 2;
        int leftChild = id << 1, rightChild = (id << 1) + 1;
        int left[] = query(leftChild, start, mid, l, r);
        int right[] = query(rightChild, mid, end, l, r);
        //min of no. of open brackets in left child and closed brackets in right child
        int tmp = min(left[1], right[2]);
        int o = left[1] + right[1] - tmp;
        int c = left[2] + right[2] - tmp;
        int t = left[0] + right[0] + tmp;
        return new int[]{t, o, c};
    }
    private static void buildTree(int id, int l, int r) {
        if (r - l < 2) {
            if (a[l] == '(') {
                o[id] = 1;
            } else {
                c[id] = 1;
            }
            return;
        }
        int mid = (l + r) / 2;
        int leftChild = id << 1, rightChild = (id << 1) + 1;
        buildTree(leftChild, l, mid);
        buildTree(rightChild, mid, r);
        int tmp = min(o[id << 1], c[(id << 1) + 1]);
        o[id] = o[leftChild] + o[rightChild] - tmp;
        c[id] = c[leftChild] + c[rightChild] - tmp;
        tree[id] = tree[leftChild] + tree[rightChild] + tmp;
    }

    static final class FastReader {
        public static final FastReader SYSTEM_READER = new FastReader(System.in);
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int pos, count;

        public FastReader(InputStream in) {
            this.in = in;
            pos = count = 0;
        }

        public int nextInt() {
            int c;
            while ((c = read()) < '0');
            int result = c - '0';
            while ((c = read() - '0') >= 0)
                result = 10 * result + c;
            return result;
        }
        public long nextLong() {
            int c;
            while ((c = read()) < '0');
            long result = c - '0';
            while ((c = read() - '0') >= 0)
                result = 10 * result + c;
            return result;
        }

        public String nextString() {
            StringBuilder s = new StringBuilder();
            int c;
            while ((c = read()) >= 33)
                s.append((char) c);
            return s.toString();
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
