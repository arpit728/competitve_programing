package com.duotech.cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Integer.min;

/**
 * Created by bugkiller on 27/01/18.
 */
public class WarmHoles {

    static int s[] = new int[100000];
    static int f[] = new int[100000];
    static int v[] = new int[100000];
    static int w[] = new int[100000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, x, y;
        String in[];
        in = br.readLine().split("\\s");
        n = Integer.parseInt(in[0]);
        x = Integer.parseInt(in[1]);
        y = Integer.parseInt(in[2]);
        for (int i = 0; i < n; i++) {
            try {
                in = br.readLine().split("\\s");
                s[i] = Integer.parseInt(in[0]);
                f[i] = Integer.parseInt(in[1]);
            } catch (Exception e) {

            }
        }
        in = br.readLine().split("\\s");
        for (int i = 0; i < x; i++) {
            v[i] = Integer.parseInt(in[i]);
        }

        in = br.readLine().split("\\s");
        for (int i = 0; i < y; i++) {
            w[i] = Integer.parseInt(in[i]);
        }
        Arrays.sort(v, 0, x);
        Arrays.sort(w, 0, y);
        System.out.println(solve(s, f, n, v, x, w, y));
    }

    private static int solve(int[] s, int[] f, int n, int[] v, int x, int[] w, int y) {
        int totalTime = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int t1 = floor(v, 0, x-1, s[i]);
            int t2 = ceil(w, 0, y-1,f[i]);
            if (t1 != -1 && t2 != -1) {
                totalTime = min(totalTime, t2 - t1 + 1);
            }
        }
        return totalTime;
    }

    public static int floor(int[] v, int start, int end, int key) {
        int ans = -1, mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (v[mid] <= key) {
                ans = v[mid];
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    public static int ceil(int[] w, int start, int end, int key) {
        int ans = -1, mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (w[mid] >= key) {
                ans = w[mid];
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
