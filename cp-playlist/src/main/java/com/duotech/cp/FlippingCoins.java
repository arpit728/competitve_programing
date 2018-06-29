package com.duotech.cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FlippingCoins {

    static int tree[] = new int[262144];
    static int lazy[] = new int[262144];
    static final int UNDEFINED = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Reader reader = new Reader();
        StringBuilder sbr = new StringBuilder();
        int n, q;
        String s[];
        //s = br.readLine().split("\\s");
        n = reader.nextInt();
        q = reader.nextInt();
        Arrays.fill(lazy, 0, 262144, 0);
        for (int i = 0; i < q; i++) {
            //s = br.readLine().split("\\s");
            int type = reader.nextInt();
            int A = reader.nextInt();
            int B = reader.nextInt();
            if (type == 1) {
                sbr.append(query(1, 0, n - 1, A, B)).append("\n");
            } else {
                update(1, 0, n - 1, A, B);
            }
        }
        System.out.print(sbr.toString());
    }

    private static int query(int id, int start, int end, int a, int b) {
        if (a > end || b < start) {
            return 0;
        }
        if (start >= a && end <= b) {
            return tree[id];
        }
        if (lazy[id] > 0) {
            shift(id, start, end);
        }
        int mid = (start + end) / 2;
        return query(id << 1, start, mid, a, b) + query((id << 1) + 1, mid + 1, end, a, b);
    }

    private static void update(int id, int start, int end, int a, int b) {
        if (a > end || b < start) {
            return;
        }
        if (start >= a && end <= b) {
            updateNode(id, start, end);
            return;
        }
        if (lazy[id] > 0) {
            shift(id, start, end);
        }
        int mid = (start + end) / 2;
        update(id << 1, start, mid, a, b);
        update((id << 1) + 1, mid + 1, end, a, b);
        tree[id] = tree[id << 1] + tree[(id << 1) + 1];
    }

    private static void updateNode(int id, int start, int end) {
        lazy[id] = 1-lazy[id];
        tree[id] = (end - start + 1) - tree[id];
    }

    private static void shift(int id, int start, int end) {
        int mid = (start + end) / 2;
        lazy[id << 1] = 1 - lazy[id << 1];
        lazy[(id << 1) + 1] = 1 - lazy[(id << 1) + 1];
        tree[id << 1] = (mid - start + 1) - tree[id<<1];
        tree[(id << 1) + 1] = (end - (mid + 1) + 1) - tree[(id << 1) + 1];
        /*updateNode((id << 1), start, mid);
        updateNode((id << 1) + 1, start, mid);*/
        lazy[id] = 0;
    }
}

class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    Reader() {
        reader = new BufferedReader(
                new InputStreamReader(System.in) );
        tokenizer = new StringTokenizer("");
    }

    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            tokenizer = new StringTokenizer(
                    reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    public int[] nextIntArray(int n) throws IOException {
        int[] a = new int[n];
        for(int i=0;i<n;i++) a[i] = nextInt();
        return a;
    }
    public long[] nextLongArray(int n) throws IOException {
        long[] a = new long[n];
        for(int i=0;i<n;i++) a[i] = nextLong();
        return a;
    }
    public double[] nextDoubleArray(int n) throws IOException {
        double[] a = new double[n];
        for(int i=0;i<n;i++) a[i] = nextDouble();
        return a;
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}
/*
100 6
1 0 99
0 53 64
1 53 64
0 60 67
1 0 99
1 53 64

20 5
0 3 14
1 3 14
0 10 17
1 0 19
1 3 14

*/