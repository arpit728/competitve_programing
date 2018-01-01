package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 22/1/17.
 */
public class DigitLongestIncreasingSubsequences2 {

    static int a[]=new int[9];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,n;
        String[]s;
        t=Integer.parseInt(br.readLine());
        while (t-- > 0) {

            n=Integer.parseInt(br.readLine());
            s=br.readLine().split("\\s");
            for (int i = 0; i < n; i++) {
                a[i]=Integer.parseInt(s[i]);
            }
            System.out.println(solve(a,n));
        }
    }

    private static int solve(int[] a, int n) {
        int ans=0;
        for (int i = 0; i < n; i++) {
            ans=ans*10+a[i];
        }
        return ans;
    }
}
