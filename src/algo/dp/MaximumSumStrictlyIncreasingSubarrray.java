package algo.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 9/12/16.
 */
public class MaximumSumStrictlyIncreasingSubarrray {

    static int a[]=new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[]s;
        int t,n;
        t= Integer.parseInt(br.readLine());
        while (t-->0){
            n=Integer.parseInt(br.readLine());
            s=br.readLine().split("\\s");
            for (int i = 0; i < n; i++) {
                a[i]=Integer.parseInt(s[i]);
            }
            System.out.println(solve(n));
        }

    }

    private static int solve(int n) {
        int maxSum=a[0],currSum=a[0];
        for (int i = 1; i < n; i++) {

            if (a[i]>a[i-1]){
                currSum+=a[i];
            }

            else {
                maxSum=Integer.max(maxSum,currSum);
                currSum=a[i];
            }
        }
        return Integer.max(maxSum,currSum);
    }
}
