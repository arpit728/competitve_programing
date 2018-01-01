package hiringchallenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by bugkiller on 7/29/2017.
 */
public class LowesKilljeeAndBaseX {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t,k;
        long n;
        String[]s;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            s = br.readLine().split("\\s");
            n = Long.parseLong(s[0]);
            k = Integer.parseInt(s[1]);
            System.out.println(solve(n,k));
        }
    }

    static long solve(long n, int k) {

        long prev = 0, next = k, ans = 0, p = 1, q;

        q = (long) (Math.log(n) / Math.log(k));
        for (int i = 0; i <= q; i++) {
            if (n >= next - 1) {
                ans+=(next-prev)*p;
                p++;
                prev=next;
                next*=k;
            }
            else {
                ans += (n - prev + 1) * p;
            }
        }

        return ans;
    }
}
