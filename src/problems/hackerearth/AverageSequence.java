package problems.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Arpit on 18-Dec-15.
 */
public class AverageSequence {
    public static void main(String[] args) {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        try {
            int n= Integer.parseInt(br.readLine());
            String[]s=br.readLine().split("\\s");
            int dp[]=new int[n];
            int b[]=new int[n],multiplier=2,a[]=new int[n];
            b[0]=Integer.parseInt(s[0]);
            a[0]=dp[0]=b[0];
            System.out.print(a[0]+" ");
            for (int i = 1; i < n; i++) {
                b[i]=Integer.parseInt(s[i]);
                a[i]=b[i]*multiplier-dp[i-1];
                dp[i]=a[i]+dp[i-1];
                multiplier++;
                System.out.print(a[i]+" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
