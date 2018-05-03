package com.duotech.cp;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.max;

public class FrequentValues_FastIO {

    private static int a[] = new int[100001];
    private static int tree[] = new int[200005];
    private static Map<Integer, Integer> firstOccurence = new HashMap<>();
    private static Map<Integer, Integer> lastOccurence = new HashMap<>();

    private static Map<Integer, Integer> freq = new HashMap<>();
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        int n, q;
        while (true) {
            n = reader.nextInt();
            if (n == 0) {
                break;
            }
            q = reader.nextInt();
            for (int i = 0; i < n; i++) {
                a[i] = reader.nextInt();
                freq.putIfAbsent(a[i], 0);
                freq.compute(a[i], (k, v) -> ++v);
            }
            for (int i = 0; i < n; i++) {
                lastOccurence.put(a[i], i);
                firstOccurence.put(a[n - i - 1], n - i - 1);
            }
            constructTree(freq, n);
            for (int i = 0; i < q; i++) {

                int u = reader.nextInt();
                int v = reader.nextInt();
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

    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
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

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
}