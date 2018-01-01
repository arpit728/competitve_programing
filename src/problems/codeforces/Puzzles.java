package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by arpit on 10/12/16.
 */
public class Puzzles {

    static int f[]=new int[50];

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n,m;
        String[]s;
        s=br.readLine().split("\\s");
        n=Integer.parseInt(s[0]);
        m=Integer.parseInt(s[1]);
        s=br.readLine().split("\\s");
        for (int i = 0; i < m; i++) {
            f[i]=Integer.parseInt(s[i]);
        }
        s=null;
        System.out.println(solve(n,m));
    }

    private static int solve(int n, int m) {
        int minValue=Integer.MAX_VALUE;
        Arrays.sort(f,0,m);

        for (int i = 0,j=n-1; i<=(m-n) ; i++,j++) {
            minValue=Integer.min(minValue,f[j]-f[i]);
        }
        return minValue;
    }
}
