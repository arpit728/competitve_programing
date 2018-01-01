package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by bugkiller on 8/27/2017.
 */
public class MinNoOfFlips {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        String s;
        while (t-- > 0) {
            s = br.readLine();
            System.out.println(solve(s,s.length()));
        }
    }

    private static int solve(String s, int n) {
        int cnt1 = 0, cnt2 = 0;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) == '0') {
                    cnt2++;
                }
                else cnt1++;
            }
            else {
                if (s.charAt(i) == '1') {
                    cnt2++;
                }
                else cnt1++;
            }
        }
        return Integer.min(cnt1, cnt2);
    }
}
