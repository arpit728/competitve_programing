package com.duotech.cp;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.min;

public class SALMAN {

    private static int tree[][] = new int[200010][2];
    private static List<Integer> adj[] = new List[100001];
    private static int lazy[] = new int[200010];
    private static int salary[] = new int[100001];
    private static int id[] = new int[100001];
    private static int s[] = new int[100001];
    private static int e[] = new int[100001];
    private static int counter = 1;
    private static int MINIMUM = 0;
    private static int SUM = 1;
    private static int UNDEFINED[] = {Integer.MAX_VALUE, 0};

    public static void main(String[] args) {
        FastReader reader = FastReader.SYSTEM_READER;
        int t, n, q, c, v;
        t = reader.nextInt();
        for (int j = 0; j < t; j++) {
            counter = 1;
            reader.nextString();
            n = reader.nextInt();
            q = reader.nextInt();
            initSegmentTree(n);
            initGraph(n);
            for (int i = 1; i <= n; i++) {
                int p = reader.nextInt();
                int s = reader.nextInt();
                salary[i] = s;
                adj[p].add(i);
            }
            dfs(1);
            buildTree(1, 1, n);
            System.out.println("Case " + j + ":");
            for (int i = 0; i < q; i++) {
                c = reader.nextInt();
                v = reader.nextInt();
                if (c == 1) {
                    System.out.println(query(1, 1, n , s[v], e[v])[SUM]);
                } else {
                    int x = min(1000, query(1, 1, n, s[v], e[v])[MINIMUM]);
                    update(1, 1, n, s[v], e[v], x);
                }
            }
        }
    }

    private static void initSegmentTree(int n) {
        for (int i = 0; i < 200005; i++) {
            lazy[i] = 0;
        }
    }

    private static void buildTree(int nodeId, int start, int end) {
        lazy[nodeId] = 0;
        if (start == end) {
            tree[nodeId][MINIMUM] = salary[start];
            tree[nodeId][SUM] = salary[id[start]];
            return;
        }
        int left = nodeId << 1;
        int right = (nodeId << 1) + 1;
        int mid = (start + end) / 2;
        buildTree(left, start, mid);
        buildTree(right, mid + 1, end);
        int leftResult[] = tree[left];
        int rightResult[] = tree[right];
        tree[nodeId][MINIMUM] = min(leftResult[MINIMUM], rightResult[MINIMUM]);
        tree[nodeId][SUM] = leftResult[SUM] + rightResult[SUM];
    }

    private static void update(int id, int start, int end, int l, int r, int x) {
        if (end < l || start > r) {
            return;
        }
        if (start >= l && end <= r) {
            updateNode(id, start, end, x);
            return;
        }
        shift(id, start, end);
        int left = id << 1;
        int right = (id << 1) + 1;
        int mid = (start + end) / 2;
        update(left, start, mid, l, r, x);
        update(right, mid + 1, end, l, r, x);
        int leftResult[] = tree[left];
        int rightResult[] = tree[right];
        tree[id][MINIMUM] = min(leftResult[MINIMUM], rightResult[MINIMUM]);
        tree[id][SUM] = leftResult[SUM] + rightResult[SUM];
    }

    private static int[] query(int id, int start, int end, int l, int r) {
        if (end < l || start > r) {
            return UNDEFINED;
        }
        if (start >= l && end <= r) {
            return tree[id];
        }
        shift(id, start, end);
        int left = id << 1;
        int right = (id << 1) + 1;
        int mid = (start + end) / 2;
        int leftResult[] = query(left, start, mid, l, r);
        int rightResult[] = query(right, mid + 1, end, l, r);

        return new int[]{min(leftResult[MINIMUM], rightResult[MINIMUM]), leftResult[SUM] + rightResult[SUM]};
    }

    private static void updateNode(int id, int start, int end, int x) {
        lazy[id] += x;
        tree[id][SUM] += (end - start + 1) * x;
        tree[id][MINIMUM] += x;
    }
    private static void shift(int id, int start, int end) {
        int mid = (start + end) / 2;
        updateNode(id << 1, start, mid, lazy[id]);
        updateNode((id << 1) + 1, mid + 1, end, lazy[id]);
        lazy[id] = 0;
    }

    private static void dfs(int src) {
        s[src] = counter;
        id[counter] = src;
        int size = adj[src].size();
        for (int i = 0; i < size; i++) {
            int v = adj[src].get(i);
            counter++;
            dfs(v);
        }
        e[src] = counter;
    }

    private static void initGraph(int n) {
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public static final class FastReader {
        static final FastReader SYSTEM_READER = new FastReader(System.in);
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int pos, count;

        public FastReader(InputStream in) {
            this.in = in;
            pos = count = 0;
        }

        public int nextInt() {
            int c;
            while ((c = read()) < '0') ;
            int result = c - '0';
            while ((c = read() - '0') >= 0)
                result = 10 * result + c;
            return result;
        }

        public long nextLong() {
            int c;
            while ((c = read()) < '0') ;
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

/*
1

7 3
0 500
1 300
1 200
1 100
3 10
2 200
2 100
1 2
2 1
1 2*/
