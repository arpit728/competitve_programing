package com.duotech.cp;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import static java.lang.Math.sqrt;

public class DQuery {

    static int query[][] = new int[200000][3];
    static int a[] = new int[30001];
    static int count[] = new int[1000001];
    static int ansQuery[] = new int[200000];
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FastReader reader = FastReader.SYSTEM_READER;
        int n, q;
        n = reader.nextInt();
        Arrays.fill(count, 0, n + 1, 0);
        String s[];
        //s = br.readLine().split("\\s");
        for (int i = 1; i <= n; i++) {
            a[i] = reader.nextInt();
        }
        q = reader.nextInt();
        for (int i = 0; i < q; i++) {
            //s = br.readLine().split("\\s");
            query[i][0] = i;
            query[i][1] =reader.nextInt();
            query[i][2] = reader.nextInt();;
        }
        int sqrtn = (int) sqrt(n);
        Arrays.sort(query, 0, q, (q1, q2) -> {
            int block1 = (q1[1] - 1) / sqrtn;
            int block2 = (q2[1] - 1) / sqrtn;
            if (block1 == block2) {
                return Integer.compare(q1[2], q2[2]);
            }
            return Integer.compare(block1, block2);
        });
        int currentL = 0;
        int currentR = 0;
        ans = 0;
        for (int i = 0; i < q; i++) {
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
        for (int i = 0; i < q; i++) {
            System.out.println(ansQuery[i]);
        }

    }

    private static void remove(int i) {
        if (i > 0) {
            count[a[i]]--;
            if (count[a[i]] == 0) {
                ans--;
            }
        }
    }
    private static void add(int i) {
        if (i > 0) {
            count[a[i]]++;
            if (count[a[i]] == 1) {
                ans++;
            }
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

