package com.duotech.cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by bugkiller on 30/01/18.
 */

public class HussainSet {

    static final int MAX = 1000005;
    static PriorityQueue<Long> queue = new PriorityQueue<>(Comparator.reverseOrder());
    static int q[] = new int[1000005];
    static long ans[] = new long[1000005];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        String[] s;
        s = br.readLine().split("\\s");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        s = br.readLine().split("\\s");
        for (int i = 0; i < n; i++) {
            queue.add(Long.parseLong(s[i]));
        }
        for (int i = 0; i < m; i++) {
            q[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(solve(queue, n, q, m));
        queue.clear();
    }

    private static String solve(PriorityQueue<Long> queue, int n, int[] q, int m) {

        long temp;
        int i = 1;
        while (!queue.isEmpty()) {
            temp = queue.poll();
            if (i<MAX) {
                ans[i++] = temp;
            }
            temp /= 2;
            if (temp > 0) {
                queue.add(temp);
            }
        }
        StringBuilder sbr = new StringBuilder();
        for (int j = 0; j < m; j++) {
            sbr.append(ans[q[j]]).append("\n");
        }
        sbr.deleteCharAt(sbr.length() - 1);
        return sbr.toString();
    }

}
