package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by arpit on 10/12/16.
 */
public class CutRibbon {

    static int dp[][]=new int[4][40001];
    static int[]a=new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String s[];
        int n;
        s=br.readLine().split("\\s");
        n=Integer.parseInt(s[0]);
        a[0]=Integer.parseInt(s[1]);
        a[1]=Integer.parseInt(s[2]);
        a[2]=Integer.parseInt(s[3]);
        System.out.println(solve(n));
    }

    private static int solve(int n) {
        initDP(n);
        for (int i = 1,k=0; i<=3 ; i++,k++) {
            for (int j = 1; j <=n; j++) {
                dp[i][j]=dp[i-1][j];

                if (j==a[k])dp[i][j]=1;
                if (j>a[k] && dp[i][j-a[k]]>0){
                    dp[i][j]=Integer.max(dp[i][j],dp[i][j-a[k]]+1);
                }
            }
        }
        return dp[3][n];
    }

    private static void initDP(int n) {
        for (int i = 0; i < 4; i++) {
            Arrays.fill(dp[i],0,n+1,-1);
        }
    }
}
