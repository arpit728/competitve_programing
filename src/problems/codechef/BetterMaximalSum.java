package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by arpit on 13/11/16.
 */
public class BetterMaximalSum {

    static final int MAX=100000;
    static int[] a=new int[MAX];
    static long e[]=new long[MAX];
    static long s[]=new long[MAX];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int t,n;
        String s[];

        t=Integer.parseInt(br.readLine());

        while (t-->0){

            n=Integer.parseInt(br.readLine());
            s=br.readLine().split("\\s");

            for (int i = 0; i < n; i++) {
                a[i]=Integer.parseInt(s[i]);
            }

            System.out.println(solve(a,n));
        }

    }

    private static long solve(int[] a, int n) {

        for (int i = 0; i < n; i++)
            e[i]=s[i]=0;

        long prev=0,ans=Long.MIN_VALUE;

        e[0]=ans=a[0];
        s[n-1]=a[n-1];

        for (int i = 1; i <n  ; i++) {
            e[i]=Long.max(a[i],e[i-1]+a[i]);
            ans=Long.max(ans,e[i]);
        }

        for (int i=n-2;i>=0;i--){
            s[i]=Long.max(a[i],s[i+1]+a[i]);
            //System.out.println("xenny[i]= "+xenny[i]+"prev"+prev);
        }

        for (int i = 1; i <(n-1) ; i++) {
            ans=Long.max(ans,e[i-1]+s[i+1]);
            //System.out.println("ans = "+ans);
        }

        /*for (int i = 0; i < n; i++) {
            System.out.print(xenny[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(e[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print(s[i] + " ");
        }
        System.out.println();*/
        return ans;
    }
}
