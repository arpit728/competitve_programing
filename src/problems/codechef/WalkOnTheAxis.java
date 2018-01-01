package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 30/12/16.
 */
public class WalkOnTheAxis {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,n;
        t=Integer.parseInt(br.readLine());
        while (t-->0){
            n=Integer.parseInt(br.readLine());
            System.out.println(solve(n));
        }
    }

    private static long solve(int n) {

        return ((long)n*(n+1)/2)+n;
    }
}
