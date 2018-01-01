package problems.codechef.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by hardCode on 3/20/2016.
 */
public class AlternatingSubArrayPrefix {

    static final int MAX=100001;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine()),n;
        String s[];
        int a[]=new int[MAX];
        int dp[]=new int[MAX];
        while (t-->0){
            n=Integer.parseInt(br.readLine());
            s=br.readLine().split("\\s");
            Arrays.fill(dp,0,n,1);
            //System.out.println(Arrays.toString(dp));
            for (int i = 0; i < n; i++) {
                a[i]=Integer.parseInt(s[i]);
            }
            for (int i = n-1; i>0; i--) {
                //System.out.println(i);
                if (a[i]>0){
                    if (a[i-1]<0)
                        dp[i-1]=dp[i]+1;
                }
                else if (a[i]<0){
                    if (a[i-1]>0)
                        dp[i-1]=dp[i]+1;
                }
            }
            for (int i = 0; i < n; i++) {
                System.out.print(dp[i] + " ");
            }
            System.out.println();
        }
    }
}
