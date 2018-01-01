package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 14/12/16.
 */
public class VladikAndFlights {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n,a,b;
        char[]ch;
        String[]s;
        s=br.readLine().split("\\s");
        n=Integer.parseInt(s[0]);
        a=Integer.parseInt(s[1]);
        b=Integer.parseInt(s[2]);
        ch=br.readLine().toCharArray();

        System.out.println(solve(ch,n,a,b));
    }

    private static int solve(char[] ch, int n, int a, int b) {

        if (a==b || ch[a-1]==ch[b-1])return 0;

        return 1;
    }
}
