package com.duotech.cp;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class UPDATEIT {

    static int tree[] = new int[40010];
    static int lazy[] = new int[40010];

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FastReader reader = FastReader.SYSTEM_READER;
        int t, n, u, v, q;
        String s[];
        t = reader.nextInt();
        while (t-- > 0) {
            StringBuilder sbr = new StringBuilder();
            //s = br.readLine().split("\\s");
            n = reader.nextInt();
            u = reader.nextInt();
            Arrays.fill(lazy, 0, 2 * n + 10, 0);
            Arrays.fill(tree, 0, 2 * n + 10, 0);
            for (int i = 0; i < u; i++) {
                //s = br.readLine().split("\\s");
                int l = reader.nextInt();
                int r = reader.nextInt();
                int val = reader.nextInt();
                update(1, 0, n - 1, l, r, val);
            }
            q = reader.nextInt();
            for (int i = 0; i < q; i++) {
                int idx = reader.nextInt();
                sbr.append(query(1, 0, n - 1, idx, idx)).append("\n");
            }
            System.out.print(sbr.toString());
        }
    }
    private static void update(int id, int start, int end, int l, int r, int val) {
        if (end < l || start > r) {
            return;
        }
        if (start >= l && end <= r) {
            updateNode(id,start,end,val);
            return;
        }
        shift(id, start, end);
        int mid = (start + end) / 2;
        update(id << 1, start, mid, l, r, val);
        update((id << 1) + 1, mid + 1, end, l, r, val);
        tree[id] = tree[id << 1] + tree[(id << 1) + 1];
    }
    private static int query(int id, int start, int end, int l, int r) {
        if (end < l || start > r) {
            return 0;
        }
        if (start >= l && end <= r) {
            return tree[id];
        }
        shift(id, start, end);
        int mid = (start + end) / 2;
        return query(id << 1, start, mid, l, r) + query((id << 1) + 1, mid + 1, end, l, r);
    }
    private static void shift(int id, int start, int end) {
        int mid = (start + end) / 2;
        updateNode(id << 1, start, mid, lazy[id]);
        updateNode((id << 1) + 1, mid + 1, end, lazy[id]);
        lazy[id] = 0;
    }
    private static void updateNode(int id, int start, int end, int val) {
        lazy[id] += val;
        tree[id] += (end - start + 1) * val;
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
/*
1
10000 5
1 10 500
0 9999 700
100 200 800
300 500 100
0 9999 100000
10
9999
8999
6543
1381
5326
8545
3211
1456
1321
8888
*/