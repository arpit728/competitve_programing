package com.duotech.cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

import static java.lang.Integer.min;

/**
 * Created by bugkiller on 27/01/18.
 */
public class WarmHolesUsingTreeset {

    static int s[] = new int[100011];
    static int f[] = new int[100011];
    static TreeSet<Integer> vHoles = new TreeSet<>();
    static TreeSet<Integer> wHoles = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, x, y;
        String in[];
        in = br.readLine().split("\\s");
        n = Integer.parseInt(in[0]);
        x = Integer.parseInt(in[1]);
        y = Integer.parseInt(in[2]);
        for (int i = 0; i < n; i++) {
            in=br.readLine().split("\\s");
            s[i] = Integer.parseInt(in[0]);
            f[i] = Integer.parseInt(in[1]);
        }
        in = br.readLine().split("\\s");
        for (int i = 0; i < x; i++) {
            vHoles.add(Integer.parseInt(in[i]));
        }
        in = br.readLine().split("\\s");
        for (int i = 0; i < y; i++) {
            wHoles.add(Integer.parseInt(in[i]));
        }
        System.out.println(solve(s, f, n, vHoles, x, wHoles, y));
        vHoles.clear();
        wHoles.clear();
    }

    private static int solve(int[] s, int[] f, int n, TreeSet<Integer> v, int x, TreeSet<Integer> w, int y) {
        int totalTime = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            Integer t1 = vHoles.floor(s[i]);
            Integer t2 = wHoles.ceiling(f[i]);
            if (t1 != null && t2 != null) {
                totalTime = min(totalTime, t2 - t1 + 1);
            }
        }
        return totalTime;
    }
}
