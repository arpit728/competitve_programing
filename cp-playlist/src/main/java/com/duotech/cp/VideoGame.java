package com.duotech.cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by bugkiller on 23/01/18.
 */

public class VideoGame {

    static int a[] = new int[100000];
    static int commands[] = new int[100000];
    static final int HOLDING = 1;
    static final int EMPTY = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, h, commandLength = 0;
        String[] s;
        s = br.readLine().split("\\s");
        n = Integer.parseInt(s[0]);
        h = Integer.parseInt(s[1]);
        s = br.readLine().split("\\s");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        s = br.readLine().split("\\s");
        for (int i = 0; i < s.length; i++) {
            commands[i] = Integer.parseInt(s[i]);
            if (commands[i] == 0) {
                commandLength = i + 1;
                break;
            }
        }
        System.out.println(solve(a, commands, h, n, commandLength));
    }

    private static String solve(int[] a, int[] commands, int h, int n, int commandLength) {
        int cranePosition = 0, craneStatus = EMPTY;
        boolean finished = false;
        for (int i = 0; (i < commandLength) && !finished; i++) {
            switch (commands[i]) {
                case 0:
                    finished = true;
                    break;
                case 1:
                    if (cranePosition > 0) {
                        cranePosition--;
                    }
                    break;

                case 2:
                    if (cranePosition < n - 1) {
                        cranePosition++;
                    }
                    break;

                case 3:
                    if (craneStatus == EMPTY && a[cranePosition] > 0) {
                        craneStatus = HOLDING;
                        a[cranePosition]--;
                    }
                    break;

                case 4:
                    if (craneStatus == HOLDING && a[cranePosition] < h) {
                        craneStatus = EMPTY;
                        a[cranePosition]++;
                    }
                    break;
            }
        }
        StringBuilder sbr = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sbr.append(a[i]).append(" ");
        }
        sbr.deleteCharAt(sbr.length() - 1);
        return sbr.toString();
    }

}

