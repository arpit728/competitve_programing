package com.duotech.cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by bugkiller on 23/01/18.
 */

public class TheLeadGame {

    private static int player1[] = new int[10000];
    private static int player2[] = new int[10000];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            s = br.readLine().split("\\s");
            player1[i] = Integer.parseInt(s[0]);
            player2[i] = Integer.parseInt(s[1]);
        }
        System.out.println(solve(player1, player2, n));
    }

    private static String solve(int[] player1, int[] player2, int n) {

        int sum1 = 0, sum2 = 0, winner = 0, lead = 0;
        for (int i = 0; i < n; i++) {
            sum1 += player1[i];
            sum2 += player2[i];
            if (Math.abs(sum1 - sum2) > lead) {
                lead = Math.abs(sum1 - sum2);
                if (sum1 > sum2) {
                    winner = 1;
                }else {
                    winner = 2;
                }
            }
        }
        return winner + " " + lead;
    }
}
