package problems.hackerearth;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.PriorityQueue;

public class SubArrayFunctionWithFastIO {
    InputStream is;
    PrintWriter out;
    String INPUT = "";
    long M = 1000000007;

    void solve() {
        int t = ni();

        while (t-- > 0) {
            int n = ni();
            int m = ni();
            int p = ni();
            int[] a = na(n);
            System.out.println(solve(a, n, m, p));
        }
    }

    private static String solve(int[] a, int n, int m, int p) {


        int ans = Integer.MIN_VALUE, l = 0, r = 0, mSmallestXor, pLargestXor;
        int maxMP = Integer.max(m, p);
        for (int i = 1,j; i <=n-maxMP+1; i++) {
            PriorityQueue<Integer> minQueue = new PriorityQueue<>();
            PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
            maxQueue.add(a[i]);
            minQueue.add(a[i]);
            mSmallestXor = a[i];
            pLargestXor = a[i];
            int tempAns;
            for (j = i + 1; j <=n; j++) {
                if (minQueue.size() < p) {
                    minQueue.add(a[j]);
                    pLargestXor ^= a[j];
                }
                else {
                    if (minQueue.peek() < a[j]) {
                        int x = minQueue.poll();
                        minQueue.offer(a[j]);
                        pLargestXor ^= x;
                        pLargestXor ^= a[j];
                    }
                }
                if (maxQueue.size() < m) {
                    maxQueue.add(a[j]);
                    mSmallestXor ^= a[j];
                }
                else {
                    if (maxQueue.peek() > a[j]) {
                        int x = maxQueue.poll();
                        maxQueue.offer(a[j]);
                        mSmallestXor ^= x;
                        mSmallestXor ^= a[j];
                    }
                }

                if (minQueue.size()>=p && maxQueue.size()>=m){
                    tempAns = mSmallestXor & pLargestXor;
                    if (ans < tempAns) {
                        ans = tempAns;
                        l = i;
                        r = j;
                    } else if (ans == tempAns) {
                        if ((j - i + 1) > (r - l + 1)) {
                            l = i;
                            r = j;
                        }
                    }

                }
            }
            j--;
            tempAns = mSmallestXor & pLargestXor;
            if (ans < tempAns) {
                ans = tempAns;
                l = i;
                r = j;
            } else if (ans == tempAns) {
                if ((j - i + 1) > (r - l + 1)) {
                    l=i;
                    r = j;
                }
            }

        }
        return l + " " + r + " " + ans;
    }



    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);

        long s = System.currentTimeMillis();
        solve();
        out.flush();
        if (!INPUT.isEmpty())
            tr(System.currentTimeMillis() - s + "ms");
    }

    public static void main(String[] args) throws Exception {
        new SubArrayFunctionWithFastIO().run();
    }

    private byte[] inbuf = new byte[1024];
    public int lenbuf = 0, ptrbuf = 0;

    private int readByte() {
        if (lenbuf == -1)
            throw new InputMismatchException();
        if (ptrbuf >= lenbuf) {
            ptrbuf = 0;
            try {
                lenbuf = is.read(inbuf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenbuf <= 0)
                return -1;
        }
        return inbuf[ptrbuf++];
    }

    private boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    private int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b))
            ;
        return b;
    }

    private double nd() {
        return Double.parseDouble(ns());
    }

    private char nc() {
        return (char) skip();
    }

    private String ns() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != '
            // ')
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private char[] ns(int n) {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while (p < n) {
            if (!(isSpaceChar(b)))
                buf[p++] = (char) b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }

    private char[][] nm(int n, int m) {
        char[][] map = new char[n][];
        for (int i = 0; i < n; i++)
            map[i] = ns(m);
        return map;
    }

    private int[] na(int n) {
        int[] a = new int[n+1];
        for (int i = 1; i <=n; i++)
            a[i] = ni();
        return a;
    }

    private int[][] na(int n, int m) {
        int[][] a = new int[n][];
        for (int i = 0; i < n; i++)
            a[i] = na(m);
        return a;
    }

    private int ni() {
        int num = 0, b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
            ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private long nl() {
        long num = 0;
        int b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
            ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private static void tr(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }
}
