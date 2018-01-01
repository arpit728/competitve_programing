package algo.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by arpit on 10/12/16.
 *
 * Problem link:-http://www.geeksforgeeks.org/count-ways-reach-nth-stair/
 */
public class WaysToReachNthStair {

    static final int M=1000000007;

    static int dp[]=new int[102];
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(br.readLine()),n;
        //Arrays.fill(dp,0);

        while (t-->0){
            n=Integer.parseInt(br.readLine());
            System.out.println(countWaysDP(n+1,2));
            //System.out.println(Arrays.toString(dp));
        }

    }

    static int countWaysDP(int n, int m) {
/*

        if (n<=1)return n;
*/
        dp[0]=0;dp[1]=1;
        int res=0;
        for (int i = 2; i<=n ; i++) {
            res=0;
            for (int j = 1; j<=m && j<=i; j++) {
                res=((res%M)+(dp[i-j]%M))%M;
            }
            dp[i]=res;
        }

        /*int sum=0;

        if (dp[n]!=-1)return dp[n];

        for (int i = 1; i<=m && i<=n; i++) {
            dp[n]+=countWays(n-i,m);
            //dp[n]++;
           // s//um+=dp[n-i];
            //sum=((sum%M)+(countWays(n-i,m)%M))%M;
        }
        //dp[n]=sum;*/
        return dp[n];
    }

    static int countWays(int n, int m) {

        if (n<=1)return n;
        int sum=0;

        for (int i = 1; i<=m && i<=n; i++) {
            sum+=countWays(n-i,m);
        }

        return sum;
    }
}
