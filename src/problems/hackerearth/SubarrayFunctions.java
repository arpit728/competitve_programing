package problems.hackerearth;

import java.io.*;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.PriorityQueue;

public class SubarrayFunctions {

    static int[] a = new int[2001];//1 Based indexing is used

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Reader br = new Reader(System.in);
        int t, n, m, p;
        String[]s;
        t = br.nextInt();
        while (t-- > 0) {
//            s = br.readLine().split("\\s");
            n = br.nextInt();
            m = br.nextInt();
            p = br.nextInt();

//            s = br.readLine().split("\\s");
            for (int i = 1; i <=n; i++) {
                a[i] = br.nextInt();
            }
            System.out.println(solve(a, n, m, p));
        }
    }

    private static String solve(int[] a, int n, int m, int p) {

        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
        int ans = Integer.MIN_VALUE, l = 0, r = 0, mSmallestXor, pLargestXor;
        int maxMP = Integer.max(m, p);
        for (int i = 1,j; i <=n-maxMP+1; i++) {
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
            minQueue.clear();
            maxQueue.clear();

        }
        return l + " " + r + " " + ans;
    }
  }
class Reader {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;

    public Reader(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
        if (numChars == -1) {
            throw new InputMismatchException();
        }
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0) {
                return -1;
            }
        }
        return buf[curChar++];
    }

    public int nextInt() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public String readString() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    public boolean isSpaceChar(int c) {
        if (filter != null) {
            return filter.isSpaceChar(c);
        }
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public String next() {
        return readString();
    }

    public interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);
    }
}

