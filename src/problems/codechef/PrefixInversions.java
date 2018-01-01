package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 27/5/17.
 */
public class PrefixInversions {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        s=br.readLine();

        System.out.println(solve(s));
    }

    private static int solve(String s) {

        int cnt=0,n=s.length();
        for (int i = 0; i < n-1; i++) {
            if (s.charAt(i)!=s.charAt(i+1))
                cnt++;
        }

        if (s.charAt(n-1)=='1')return cnt+1;
        return cnt;
    }
}
