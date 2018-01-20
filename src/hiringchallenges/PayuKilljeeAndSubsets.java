package hiringchallenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.max;

/**
 * Created by bugkiller on 12/01/18.
 */

public class PayuKilljeeAndSubsets {

    static int[][] dp = new int[10001][2048];
    static int a[] = new int[10000];
    static final long M = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        String s[];
        n = Integer.parseInt(br.readLine());
        s = br.readLine().split("\\s");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        System.out.println(solve(a, n));
    }

    private static long solve(int[] a, int n) {
        int l = 0;
        long ans = 0;
        for (int i = 0; i <n; i++) {
            l = max(a[i], l);
        }
        fillDp(n, l);
        for (int i = 0; i <= l; i++) {
            ans = (ans + (dp[n][i] * exp(31, i))) % M;
        }
        return ans;
    }
    static long exp(int a, int n) {
        long ans;
        if (n > 0) {
            long temp = exp(a, n / 2) % M;
            ans = (temp * temp) % M;
            if (n % 2 == 1) {
                return (a * ans) % M;
            }
            return ans;
        }
        return 1;
    }

    private static void fillDp(int n, int l) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <=1023; j++) {
                if (dp[i-1][j ^ a[i - 1]] > 0) {
                    dp[i][j] = max(dp[i - 1][j], 1 + dp[i - 1][j ^ a[i - 1]]);
                } else {
                    if (j == a[i - 1]) {
                        dp[i][j] = max(dp[i - 1][j], 1);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
    }
}
