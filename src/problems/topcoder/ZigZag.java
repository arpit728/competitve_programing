package problems.topcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by hardCode on 6/2/2016.
 */
public class ZigZag {

    static int a[],n;
    public static final int MAX=50;

    public static void main(String[] args) throws IOException {
        a=new int[MAX];
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        String s[]=br.readLine().split("\\s");
        for (int i = 0; i < n; i++) {
            a[i]=Integer.parseInt(s[i]);
        }
        System.out.println(new ZigZag().longestZigZag(a));

    }
    int longestZigZag(int[] sequence){
        int dp[]=new int[n],sign[]=new int[n],temp=0;
        if (n==1 || n==2)return n;
        Arrays.fill(dp,1);
        sign[0]=1;
        sign[1]=Integer.signum(sequence[1]-sequence[0]);
        dp[1]=2;
        for (int i = 1; i < n; i++) {
            for (int j = i-1; j>=0; j--) {
                temp=dp[j];
                if (sign[j]*Integer.signum(sequence[i]-sequence[j])<0){

                    if (dp[j]+1>dp[i]){
                        dp[i]=dp[j]+1;
                        sign[i]=Integer.signum(sequence[i]-sequence[j]);
                    }
                }
            }
        }
        System.out.println(Arrays.toString(dp)+" "+Arrays.toString(sign));
        int big=dp[0];
        for (int i = 1; i < n; i++) {
            if (dp[i]>big)big=dp[i];
        }
        return big;
    }
}
