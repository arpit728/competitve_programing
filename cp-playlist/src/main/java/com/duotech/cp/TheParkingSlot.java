package com.duotech.cp;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by bugkiller on 25/06/18.
 */
public class TheParkingSlot {

    static ArrayList<Edge> adj[] = new ArrayList[100001];
    static boolean vis[] = new boolean[100001];
    static long d[][] = new long[100001][2];
    private static final int DISTANCE =0, CAPACITY = 1;
    public static void main(String[] args) throws IOException {
        initGraph();
        Reader fr = new Reader();
        int n, m, f, k;
        String s[];
        n = fr.nextInt();
        m = fr.nextInt();
        f = fr.nextInt();
        for (int i = 0; i < n; i++) {
            d[i + 1][DISTANCE] = Long.MAX_VALUE;
            d[i + 1][1] = fr.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int u = fr.nextInt();
            int v = fr.nextInt();
            int w = fr.nextInt();
            adj[u].add(new Edge(v, w));
            adj[v].add(new Edge(u, w));
        }
        k = fr.nextInt();
        dijkstra(n);
        Arrays.sort(d, 1, n + 1, Comparator.comparingLong(o -> o[DISTANCE]));
        System.out.println(solve(n,k,f));
    }

    private static String solve(int n, int k, long parkingFee) {
        StringBuilder sbr = new StringBuilder();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (count == k) {
                break;
            }
            for (int j = 0; j < d[i][CAPACITY] && count < k; j++) {
                count++;
                sbr.append(parkingFee + d[i][DISTANCE]).append(" ");
            }
        }
        for (; count < k; count++) {
            sbr.append("-1").append(" ");
        }
        sbr.deleteCharAt(sbr.length() - 1);
        return sbr.toString();
    }

    private static void dijkstra(int n) {
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingLong(e -> e.w));
        d[1][DISTANCE] = 0;
        queue.add(new Edge(1, 0));
        while (!queue.isEmpty()) {
            Edge u = queue.poll();
            vis[u.v] = true;
            adj[u.v].forEach(edge -> {
                if (!vis[edge.v] && d[u.v][DISTANCE] + edge.w < d[edge.v][DISTANCE]) {
                    d[edge.v][DISTANCE] = Long.min(d[edge.v][DISTANCE], d[u.v][DISTANCE] + edge.w);
                    queue.add(new Edge(edge.v, d[edge.v][DISTANCE]));
                }
            });
        }
    }

    private static void initGraph() {
        for (int i = 0; i < 100001; i++) {
            adj[i] = new ArrayList<Edge>();
        }
    }
    static class Edge {
        int v;
        long w;

        Edge(int v, long w) {
            this.v = v;
            this.w = w;
        }
    }
    static class Reader {
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

