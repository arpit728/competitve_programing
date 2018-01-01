package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 24/12/16.
 */
public class OpenTheDragonScroll {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,n,a,b;
        String[]s;
        t=Integer.parseInt(br.readLine());
        while (t-->0){
            s=br.readLine().split("\\s");
            n=Integer.parseInt(s[0]);
            a=Integer.parseInt(s[1]);
            b=Integer.parseInt(s[2]);
            System.out.println(solve(n,a,b));
        }
    }

    private static int solve(int n, int a, int b) {
        int  setBitsInA=0,setBitsInB=0,unsetBitsInA=0,unsetBitsInB=0;

        for (int i = 0; i<n; i++) {
            if (((1<<i)&a)>=1)setBitsInA++;
            else unsetBitsInA++;

            if (((1<<i)&b)>=1)setBitsInB++;
            else unsetBitsInB++;
        }

        int x=Integer.min(setBitsInA,unsetBitsInB);
        int y=Integer.min(setBitsInB,unsetBitsInA);
        int p=x+y;
        int ans=1<<p;
        ans--;
        ans=ans<<(n-p);
        return ans;
    }
}
