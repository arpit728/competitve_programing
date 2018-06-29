package com.duotech.cp;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class PowerfulArray {

    static int a[]=new int[200001];
    static int count[] = new int[1000001];
    static int query[][] = new int[200001][3];
    static long ansQuery[] = new long[200001];
    static long ans = 0;
    public static void main(String[] args) throws IOException {
        FastReader reader = FastReader.SYSTEM_READER;
        int t, n;
        n = reader.nextInt();
        t = reader.nextInt();
        int sqrtN = (int) Math.sqrt(n);
        ans = 0;
        for (int i = 0; i < n; i++) {
            a[i + 1] = reader.nextInt();
        }
        for (int i = 0; i < t; i++) {
            query[i][0] = i;
            query[i][1] = reader.nextInt();
            query[i][2] = reader.nextInt();
        }
        Arrays.sort(query, 0, t, (q1, q2) -> {
            int block1 = (q1[1] - 1) / sqrtN;
            int block2 = (q2[1] - 1) / sqrtN;
            //if both query lies in same block then use their R to break the tie.
            if (block1 == block2) {
                return Integer.compare(q1[2], q2[2]);
            }
            return Integer.compare(block1, block2);
        });
        int currentL = 0, currentR = 0;
        for (int i = 0; i < t; i++) {
            int l = query[i][1];
            int r = query[i][2];
            while (currentL < l) {
                remove(currentL);
                currentL++;
            }
            while (currentL > l) {
                currentL--;
                add(currentL);
            }
            while (currentR <= r) {
                add(currentR);
                currentR++;
            }
            while (currentR > (r + 1)) {
                currentR--;
                remove(currentR);
            }
            ansQuery[query[i][0]] = ans;
        }
        for (int i = 0; i < t; i++) {
            System.out.println(ansQuery[i]);
        }
    }

    private static void remove(int i) {
        count[a[i]]--;
        long x = count[a[i]];
        ans -= (((x + 1) * (x + 1) * a[i]) - (x * x * a[i]));
    }

    private static void add(int i) {
        count[a[i]]++;
        long x = count[a[i]];
        ans += ((x * x * a[i]) - ((x - 1) * (x - 1) * a[i]));
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
