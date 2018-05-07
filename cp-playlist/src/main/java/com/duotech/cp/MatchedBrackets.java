package com.duotech.cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

public class MatchedBrackets {

    private static int a[] = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        String s[];
        n = parseInt(br.readLine());
        s = br.readLine().split("\\s");
        for (int i = 1; i <= n; i++) {
            a[i] = parseInt(s[i - 1]);
        }
        System.out.println(solve(a, n));
    }

    private static String solve(int[] a, int n) {
        int nestingDepth = 0, weight = 0, start = 1, end, maxSymbols = 0, firstBracket = 0, finalStart = 0;
        for (int i = 1; i <= n; i++) {
            if (a[i] == 1) {
                weight++;
            }
            if (weight > nestingDepth) {
                firstBracket = i;
                nestingDepth = weight;
            }
            if (a[i] == 2) {
                weight--;
            }
            if (weight == 0) {
                end = i;
                if (end - start + 1 > maxSymbols) {
                    maxSymbols = end - start + 1;
                    finalStart = start;
                }
                start = i + 1;
            }
        }
        return nestingDepth + " " + firstBracket + " " + maxSymbols + " " + finalStart;
    }
}