package com.duotech.cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SUMSUM {
    private static long t[][] = new long[28][200005];

    private static int a[] = new int[100001];
    static FastReader in;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        in = FastReader.SYSTEM_READER;
        int n, q;
        String s[];
        //s = br.readLine().split("\\s");
        n = in.nextInt();
        q = in.nextInt();
        //s = in.nextString().split("\\s");
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            update(i, a[i], n);
        }
        for (int i = 0; i < q; i++) {
            long ans = 0;
            //s = br.readLine().split("\\s");
            int queryType = in.nextInt();
            if (queryType == 1) {
                int x = in.nextInt();
                int p = in.nextInt();
                update(--p, x, n);
            } else {
                long ones, zeros, effectivePairs;
                int a, b;
                String op = in.nextString();
                a = in.nextInt();
                b = in.nextInt();
                --a;
                --b;
                for (int j = 0; j < 28; j++) {
                    effectivePairs = 0;
                    ones = query(a, b, j, n);
                    zeros = (b - a + 1) - ones;
                    if ("OR".equals(op)) {
                        effectivePairs = effectivePairs + ones * (ones - 1) / 2;
                        effectivePairs = effectivePairs + (ones * zeros);
                    } else if ("AND".equals(op)) {
                        effectivePairs = ones * (ones - 1) / 2;
                    } else {//xor
                        effectivePairs = ones * zeros;
                    }
                    ans += (1 << j) * effectivePairs;
                }
                System.out.println(ans);
            }
        }
    }

    private static int query(int l, int r, int j, int n) {
        l += n;
        r += n;
        int ans = 0;
        for (; l <= r; l >>= 1, r >>= 1) {
            if ((l & 1) == 1) {
                ans += t[j][l++];
            }
            if ((r & 1) != 1) {
                ans += t[j][r--];
            }
        }
        return ans;
    }

    public static void update(int i, int x, int n) {
        i += n;
        for (int j = 0; j < 28; j++) {
            int currentBit = ((1 << j) & x) > 0 ? 1 : 0;
            t[j][i] = currentBit;
            for (int k=i/2; k > 0; k >>= 1) {
                t[j][k] = t[j][k << 1] + t[j][(k << 1) + 1];
            }
        }
    }
}

final class FastReader {
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


