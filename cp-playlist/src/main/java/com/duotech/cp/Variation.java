package com.duotech.cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Math.abs;

/**
 * Created by bugkiller on 27/01/18.
 */
public class Variation {

    static int a[] = new int[650000];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, k;
        String[] s;
        s = br.readLine().split("\\s");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        s = br.readLine().split("\\s");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(a, 0, n);
        System.out.println(solve(a, n, k));
    }

    private static int solve(int[] a, int n, int k) {
        return countVariations(a, n, k);
    }

    private static int countVariations(int[] a, int n, int k) {
        int i = 0, j = 0, count = 0;
        while (i < n) {
            if (abs(a[i] - a[j]) < k) {
                j++;
            } else {
                count += n - j;
                i++;
            }
        }
        return count;
    }

}
