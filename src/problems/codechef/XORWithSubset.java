package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by arpit on 21/12/16.
 */
public class XORWithSubset {

    static int a[]=new int[1001];
    static boolean dp[][]=new boolean[1001][1024];
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,n,k;
        String[]s;
        t=Integer.parseInt(br.readLine());
        while (t-->0){
            s=br.readLine().split("\\s");

            n=Integer.parseInt(s[0]);
            k=Integer.parseInt(s[1]);

            s=br.readLine().split("\\s");
            for (int i = 1; i <= n; i++) {
                a[i]=Integer.parseInt(s[i-1]);
            }
            fllDp(n);
            System.out.println(solve(a,n,k));
        }
    }

    private static int solve(int[] a, int n, int k) {
        return maxXorDp(a, n, k);
    }

    static int maxXorDp(int ap[],int n,int k){

        dp[0][0]=true;
        for (int i = 1; i <=n; i++) {
            for (int j = 0; j<= 1023; j++) {
                dp[i][j]=dp[i-1][j]||dp[i-1][j^a[i]];
            }
        }
        int ans=0;
        for (int j = 0; j<=1023; j++) {
            if (dp[n][j]) {
                ans = Integer.max(ans, j ^ k);
            }
        }
        return ans;
    }

    private static void fllDp(int n) {
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i],0,1024,false);
        }
    }

    private static int maxXor(int[] a, int n, int k, int xor) {

        if (n==0)return xor^k;

        return Integer.max(maxXor(a,n-1,k,xor),maxXor(a,n-1,k,xor^a[n-1]));
    }
}
