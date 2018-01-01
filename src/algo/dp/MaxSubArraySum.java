package algo.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by bugkiller on 8/28/2017.
 */
public class MaxSubArraySum {

    static int[] a = new int[1000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t,n;
        String[]s;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            s = br.readLine().split("\\s");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(s[i]);
            }
            System.out.println(solve(a,n));
        }
    }

    private static int solve(int[] a, int n) {
        int maxSum = Integer.MIN_VALUE, currentSum = 0;
        for (int i = 0; i < n; i++) {
            currentSum += a[i];
            currentSum = Integer.max(currentSum, a[i]);
            maxSum = Integer.max(maxSum, currentSum);
        }


        return maxSum;
    }
}
