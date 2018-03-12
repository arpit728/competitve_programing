package com.duotech.cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.sort;

/**
 * Created by bugkiller on 11/03/18.
 */

public class JourneyToTheMoon {

    static int parent[] = new int[100002];
    static int suffix[] = new int[100002];
    static Integer countryCounts[] = new Integer[100002];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n,p;
        String s[];

        s = br.readLine().split("\\s");
        n = parseInt(s[0]);
        p = parseInt(s[1]);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < p; i++) {
            s = br.readLine().split("\\s");
            int u = parseInt(s[0]);
            int v = parseInt(s[1]);
            findUnion(u, v);
        }
        System.out.println(solve(n));

    }

    private static long solve(int n) {
        Map<Integer, Integer> count = new HashMap<>();
        int noOfCountries;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            findSet(i);
        }
        for (int i = 0; i < n; i++) {
            count.computeIfPresent(parent[i], (key, value) -> ++value);
            count.putIfAbsent(parent[i], 1);
        }
        count.values().toArray(countryCounts);
        noOfCountries = count.size();
        suffix[noOfCountries + 1] = 0;
        for (int i = noOfCountries - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + countryCounts[i];
        }
        for (int i = 0; i < noOfCountries - 1; i++) {
            ans += countryCounts[i] * suffix[i + 1];
        }
        return ans;
    }

    private static void findUnion(int u, int v) {
        parent[findSet(u)] = findSet(v);
    }

    private static int findSet(int x) {

        if (parent[x] == x) {
            return x;
        }
        parent[x] = findSet(parent[x]);
        return parent[x];
    }

}
