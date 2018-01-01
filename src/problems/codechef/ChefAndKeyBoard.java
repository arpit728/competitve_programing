package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 20/12/16.
 */
public class ChefAndKeyBoard {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[]s;
        int n,m,c,t;
        t=Integer.parseInt(br.readLine());
        while (t-->0){
            s=br.readLine().split("\\s");
            n=Integer.parseInt(s[0]);
            m=Integer.parseInt(s[1]);
            c=Integer.parseInt(s[2]);
            System.out.println(solve(n,m,c));
        }
    }

    private static int solve(int n, int m, int c) {

        int count =0;
        for (int i = 1; i <= c; i++) {
            if (c%i==0){
                if ((i <= n) && ((c / i) <= m))
                    count++;
            }
        }
        return count;
    }
}
