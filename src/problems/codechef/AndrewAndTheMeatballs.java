package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by arpit on 18/1/17.
 *
 * problem link:- https://www.codechef.com/problems/AMMEAT
 */
class AndrewAndTheMeatballs {

    static final int MAX=7;
    static long a[]=new long[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,n;
        long m;
        String[]s;
        t=Integer.parseInt(br.readLine());
        while (t-->0){
            s=br.readLine().split("\\s");

            n=Integer.parseInt(s[0]);
            m=Long.parseLong(s[1]);

            s=br.readLine().split("\\s");
            for (int i = 0; i < n; i++) {
                a[i]=Long.parseLong(s[i]);
            }

            System.out.println(solve(a,n,m));
        }

    }
    private static int solve(long[] a, int n,long m) {
        Arrays.sort(a,0,n);
        int cnt=0;
        long sum=0;
        for (int i =n-1; i>=0 ; i--) {
            sum+=a[i];
            cnt++;
            if (sum>=m)return cnt;
        }
        return -1;
    }


}
