package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 10/1/17.
 */
public class CountSubstrings {


    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,n;
        String s;
        t=Integer.parseInt(br.readLine());
        while (t-->0){

            n=Integer.parseInt(br.readLine());
            s=br.readLine();
            System.out.println(solve(s, n));
        }
    }

    private static long solve(String ch, int n) {
        int ones=0;

        for (int i = 0; i < n; i++) {
            if (ch.charAt(i)=='1')ones++;
        }
        return (long)ones*(ones+1)/2;
    }
}
