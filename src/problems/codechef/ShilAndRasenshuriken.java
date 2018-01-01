package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 13/11/16.
 */
public class ShilAndRasenshuriken {

    final static int MAX=100000;
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

        long even=0,odd=0,ans=0;

        for (int i = 0; i < n; i++) {
            if ((a[i]&1)==1)odd++;
            else even++;
        }

        ans=even*(even-1)/2;
        ans+=even*odd;
        return ans;
    }
}
