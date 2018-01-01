package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 24/4/17.
 */
public class BearAndAB {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,n,k;
        char[]a;
        String[]s;
        t=Integer.parseInt(br.readLine());
        while (t-->0){
            s=br.readLine().split("\\s");
            n=Integer.parseInt(s[0]);
            k=Integer.parseInt(s[1]);
            a=br.readLine().toCharArray();
            System.out.println(solve(a,n,k));
        }

    }

    private static long solve(char[] a, int n, int k) {

        long x=0,ans;
        long cntb=0,cnta=0;
        for (int i = n - 1; i >= 0; i--) {
            if (a[i]=='b')
              cntb++;
            else if (a[i]=='a')
            {
                cnta++;
                x+=cntb;
            }

        }

        ans=x*k+(((long)k*(k-1)/2)*cnta*cntb);
        return ans;
    }
}
