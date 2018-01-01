package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 13/11/16.
 */
public class AreYouLucky {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int t,n,x,y;
        String[]s;

        t=Integer.parseInt(br.readLine());
        n=Integer.parseInt(br.readLine());

        while (t-->0){
            s=br.readLine().split(" ");
            x=Integer.parseInt(s[0]);
            y=Integer.parseInt(s[1]);
            System.out.println(solve(x,y,n));
        }
    }

    private static long solve(int x, int y, int n) {

        long ans=x;
        for (int i = 1; i<y; i++) {

            ans=((ans%n)*(x%n))%n;
        }

        return ans;
    }
}
