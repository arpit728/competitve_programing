package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 13/11/16.
 */
public class TaskForAlexey {

    static final int MAX=500;
    static int a[]=new int[MAX];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,n;
        String s[];
        t=Integer.parseInt(br.readLine());

        while(t-->0){
            n=Integer.parseInt(br.readLine());
            s=br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                a[i]=Integer.parseInt(s[i]);
            }

            System.out.println(solve(a,n));
        }

    }

    private static long solve(int[] a, int n) {

        long mul,ans=Long.MAX_VALUE;
        int g;
        for (int i = 0; i <(n-1); i++) {
            for (int j = i+1; j < n; j++) {
                mul=(long)a[i]*a[j];

                if (a[i]==1 || a[j]==1)
                    g=1;

                else
                    g=gcd(a[i],a[j]);

                ans=Long.min(ans,mul/g);
            }
        }
        return ans;
    }

    static int gcd(int a, int b)
    {
        if (a == 0)
            return b;

        return gcd(b%a, a);
    }
}
