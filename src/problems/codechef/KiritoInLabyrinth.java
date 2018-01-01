package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by hardCode on 12/2/2016.
 */
public class KiritoInLabyrinth {

    static final int MAX=100001;
    static int a[]=new int[MAX];
    static int dp[]=new int[MAX];
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,n;
        String s[];
        t=Integer.parseInt(br.readLine());
        while (t-->0){
            n=Integer.parseInt(br.readLine());
            Arrays.fill(dp,0,n,1);//initialize the array
            s=br.readLine().split("\\s");
            for (int i = 0; i < n; i++) {
                a[i]=Integer.parseInt(s[i]);
            }
            System.out.println(solve(n));
        }
    }

    private static int solve(int n) {

        return  lisGCD(n);
    }

    //This is the function calculates the longest increasing subsequence with gcd
    private static int lisGCD(int n) {

        int res=1;
        for (int i = 1; i <n ; i++) {
            for (int j = i-1; j>=0 ; j--) {
                if (gcd(a[i],a[j])>1){
                    dp[i]=Integer.max(dp[i],dp[j]+1);
                }
            }
            res=Integer.max(res,dp[i]);
        }
        return res;
    }

    static int gcd(int p, int q) {
        if (q == 0) return p;
        if (p == 0) return q;

        // p and q even
        if ((p & 1) == 0 && (q & 1) == 0) return gcd(p >> 1, q >> 1) << 1;

            // p is even, q is odd
        else if ((p & 1) == 0) return gcd(p >> 1, q);

            // p is odd, q is even
        else if ((q & 1) == 0) return gcd(p, q >> 1);

            // p and q odd, p >= q
        else if (p >= q) return gcd((p-q) >> 1, q);

            // p and q odd, p < q
        else return gcd(p, (q-p) >> 1);
    }
}
