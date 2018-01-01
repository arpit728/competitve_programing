package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 6/12/16.
 */
public class ArpasHardExam {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        System.out.println(solve(n));
    }

    private static int solve(int n) {
        if (n==0)return 1;
        if (n%4==1)return 8;
        if (n%4==2)return 4;
        if (n%4==3)return 2;
        if (n%4==0)return 6;
        return 0;
    }
}
