package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 31/12/16.
 */
public class SumQueries {


    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n,m;
        long q;
        String[]s=br.readLine().split("\\s");
        n=Integer.parseInt(s[0]);
        m=Integer.parseInt(s[1]);//no of queries;

        for (int i = 0; i < m; i++) {
            q=Long.parseLong(br.readLine());
            System.out.println(solve(n,q));
        }

    }

    private static long solve(int n, long q) {

        if (q<=(n+1) )return 0;
        if (q>(n+1) && q<=2*n) return q-(n+1);
        return ((long)3*n+1)-q;
    }
}
