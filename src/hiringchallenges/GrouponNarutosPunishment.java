package hiringchallenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by bugkiller on 7/25/2017.
 */
public class GrouponNarutosPunishment {

    static long a[]=new long[41];
    static long pre[]=new long[41];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n,k;
        String[]s;
        n = Integer.parseInt(br.readLine());
        s = br.readLine().split("\\s");
        for (int i = 0; i < n; i++) {
            a[i + 1] = Integer.parseInt(s[i]);
        }
        k = Integer.parseInt(br.readLine());

        System.out.println(solve(a,n,k));
    }

    private static int solve(long[] a, int n, int k) {
        int cnt=0;
        calculatePrefix(a,n);
        for (int i = 1; i <= n; i++) {
            for (int j = i  ; j <=n ; j++) {

                if ((pre[j] - pre[i - 1]) >= k)
                    cnt++;
            }
        }
        return cnt;
    }

    private static void calculatePrefix(long[] a, int n) {
        for (int i = 1; i <= n; i++) {
            pre[i]=pre[i-1]+a[i];
        }
    }
}
