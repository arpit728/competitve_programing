package com.duotech.cp;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.max;

public class TEMPLEQ {

    private static int tree[] = new int[400005];
    private static int lazy[] = new int[400005];
    static Pair a[] = new Pair[100005];
    private static final int UNDEFINED = MAX_VALUE;
    private static Map<Integer, Integer> realIndices = new HashMap<>();

    public static void main(String[] args) {
        for (int i = 0; i < 100005; i++) {
            a[i] = new Pair();
        }
        FastReader fr = FastReader.SYSTEM_READER;
        StringBuilder sbr = new StringBuilder();
        int n, q;
        n = fr.nextInt();
        q = fr.nextInt();
        for (int i = 0; i < n; i++) {
            a[i].init(i, fr.nextInt());
        }
        Arrays.sort(a, 0, n, Comparator.comparingInt(o -> o.value));
        buildTree(a,1, 0, n-1);
        for (int i = 0; i < n; i++) {
            realIndices.put(a[i].idx, i);
        }
        for (int i = 0; i < q; i++) {
            int type = fr.nextInt();
            int value = fr.nextInt();
            answerQuery(sbr,type, value, n);
        }
        System.out.print(sbr.toString());
    }
    private static void buildTree(Pair[] a, int id, int start, int end) {
        if (start == end) {
            tree[id] = a[start].value;
            return;
        }
        int mid = mid(start, end);
        int left = id << 1;
        int right = (id << 1) + 1;
        buildTree(a, left, start, mid);
        buildTree(a, right, mid + 1, end);
        tree[id] = max(tree[left], tree[right]);
    }
    private static int mid(int start, int end) { return (start + end) / 2; }
    private static void updateNode(int id, int l, int r, int x) {
        lazy[id] += x;
        tree[id] += (r - l + 1) * x;
    }
    private static void shift(int id, int start, int end) {
        int mid = mid(start, end);
        updateNode(id << 1, start, mid, lazy[id]);
        updateNode((id << 1) + 1, mid+1, end, lazy[id]);
        lazy[id] = 0;
    }
    private static void rangeUpdate(int id, int start, int end, int l, int r, int x) {
        if (start > r || end < l) {
            return;
        }
        if (start >= l && end <= r) {
            updateNode(id, start, end, x);
            return;
        }
        shift(id, start, end);
        int mid = mid(start, end);
        int left = id << 1;
        int right = (id << 1) + 1;
        rangeUpdate(left, start, mid, l, r, x);
        rangeUpdate(right, mid + 1, end, l, r, x);
        tree[id] = max(tree[left], tree[right]);
    }

    //this function returns smallest index that has value >=x
    private static int smallestIndex(int id, int start, int end, int x) {
        if (start == end) {
            if (tree[id] >= x) {
                return start;
            }
            return UNDEFINED;
        }
        shift(id, start, end);
        if (tree[id]<x) {
            return UNDEFINED;
        }
        int mid = mid(start, end);
        int temp = smallestIndex(id << 1, start, mid, x);
        if (temp != UNDEFINED) {
            return temp;
        }
        temp = smallestIndex((id << 1) + 1, mid + 1, end, x);
        return temp;
    }
    private static void answerQuery(StringBuilder sbr, int type, int value, int n) {
        if (type == 1) {
            int idx = realIndices.get(value - 1);
            rangeUpdate(1, 0, n - 1, idx, idx, 1);
        } else if (type == 2) {
            int idx = smallestIndex(1, 0, n - 1, value);
            if (idx != UNDEFINED) {
                sbr.append(n - idx);
                sbr.append("\n");
                return;
            }
            sbr.append(0);
            sbr.append("\n");
        } else {
            int idx = smallestIndex(1, 0, n - 1, value);
            if (idx != UNDEFINED) {
                rangeUpdate(1, 0, n - 1, idx, n - 1, -1);
            }
        }
    }


    static class Pair{
        int idx;
        int value;
        void init(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
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