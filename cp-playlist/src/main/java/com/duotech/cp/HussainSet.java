package com.duotech.cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by bugkiller on 30/01/18.
 */

public class HussainSet {

    static final int MAX = 1000005;
    static long a[] = new long[MAX];
    static long q[] = new long[MAX];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        String[] s;
        s = br.readLine().split("\\s");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        s = br.readLine().split("\\s");
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(s[i]);
        }
        for (int i = 0; i < m; i++) {
            q[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(solve(a, n, q, m));
    }

    private static String solve(long[] a, int n, long[] q, int m) {

        Queue<Long> queue1 = new LinkedList<>();
        Queue<Long> queue2 = new LinkedList<>();
        StringBuilder sbr=new StringBuilder();
        Arrays.sort(a, 0, n);
        for (int i = 0; i < n; i++) {
            queue1.add(a[n - i - 1]);
        }
        long i = 1;
        int j = 0;
        while (!(queue1.isEmpty() && queue2.isEmpty())) {
            if (queue1.isEmpty() || queue2.isEmpty()) {
                if (queue1.isEmpty()) {
                    Long head2 = queue2.poll();
                    if (i == q[j]) {
                        sbr.append(head2).append("\n");
                        j++;
                    }
                    if (head2 > 1) {
                        queue1.add(head2 / 2);
                    }
                    Queue<Long> temp = queue1;
                    queue1 = queue2;
                    queue2 = temp;
                } else {
                    Long head1 = queue1.poll();
                    if (i == q[j]) {
                        sbr.append(head1).append("\n");
                        j++;
                    }
                    if (head1 > 1) {
                        queue2.add(head1 / 2);
                    }
                }
                i++;
            }
            Long head1 = queue1.peek();
            Long head2 = queue2.peek();

            if (head1 != null && head2 != null) {
                if (head1 >= head2) {
                    if (i == q[j]) {
                        sbr.append(head1).append("\n");
                        j++;
                    }
                    if (head1 > 1) {
                        queue2.add(head1 / 2);
                    }
                    queue1.poll();
                } else {
                    if (i == q[j]) {
                        sbr.append(head2).append("\n");
                        j++;
                    }
                    if (head2 > 1) {
                        queue2.add(head2 / 2);
                    }
                    queue2.poll();
                }
                i++;
            }
        }
        sbr.deleteCharAt(sbr.length() - 1);
        return sbr.toString();
    }

}
