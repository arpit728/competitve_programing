package algo.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by hardCode on 4/14/2016.
 */
public class MaximumSumContagiousSubsequence {



    public static void main(String[] args) throws IOException {
        int n,a[];
        String s[];
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        s=br.readLine().split("\\s");
        a=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=Integer.parseInt(s[i]);
        }
        System.out.println(solve(a,n));
        System.out.println(solveUsingDp(a, n));
        System.out.println(solveUsingDp1(a,n));
    }

    //This function is the dynamic programming solution to problem Maximum sum contagious sub sequence
    private static int solveUsingDp(int a[],int n){
        int dp[]=new int[n];
        dp[0]=a[0];
        int big=dp[0];
        for (int i = 1; i < n; i++) {
            dp[i]=max(dp[i-1]+a[i],a[i]);
            if (dp[i]>big)big=dp[i];
        }
        return big;
    }

    //This function is the derived from the above dynamic programming solution but it requires O(1)space complexity
    private static int solveUsingDp1(int a[],int n){
        int m,big;
        m=big=a[0];
        for (int i = 1; i < n; i++){
            m = max(m + a[i], a[i]);
            if (m>big)big=m;
        }
        return big;
    }


    private static int max(int i, int i1) {
        return i>i1?i:i1;
    }


    private static int solve(int[] a, int n) {
        int sum1,sum;
        sum=sum1=0;

        for (int i = 0; i < n; i++) {

            sum=0;
            for (int j = i; j>=0 ; j--) {
                sum+=a[j];
                if (sum>sum1)sum1=sum;
            }
            //System.out.print(sum+" ");
        }
        return sum1;
    }
}
