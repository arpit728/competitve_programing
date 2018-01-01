package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by bugkiller on 9/12/2017.
 */

public class NumberOfJumpsForAThiefToCrossWalls {

    static int[] a = new int[100];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t, n, x, y;
        String[] s;
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            s = br.readLine().split("\\s");
            x = Integer.parseInt(s[0]);
            y = Integer.parseInt(s[1]);
            n = Integer.parseInt(s[2]);
            s = br.readLine().split("\\s");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(s[i]);
            }
            System.out.println(solve(a, n, x, y));
        }
    }

    private static int solve(int[] a, int n, int x, int y) {

        return countJumps(a, n, x, y);
    }

    private static int countJumps(int[] a, int n, int x, int y) {

        int ans = 0, total = x - y;
        for (int i = 0; i < n; i++) {
            int temp = a[i] / total-1;

            if (a[i] <= x) {
                ans++;
            } else {
                if (((temp * total) <= a[i]) && (a[i] <= ((temp * total) + x))) {
                    ans += temp+1;
                } else {
                    ans += temp + 2;
                }
            }
        }
        return ans;
    }

}
