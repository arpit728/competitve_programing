package hiringchallenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by hardCode on 2/26/2017.
 */
public class GameOfXor {

    final static int MAX = 100000;
    static int[] a = new int[MAX];
    static BufferedReader br;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        int t, n;
        String[] s;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            readArray(a, n);
            System.out.println(solve(a,n));
        }
    }

    private static int solve(int[] a, int n) {

        int ans=0;
        if ((n & 1) != 1) {
            return 0;
        }
        else
            for (int i = 0; i < n; i+=2)
            ans ^= a[i];

        return ans;
    }

    private static void readArray(int[] a, int n) throws IOException {
        String[] s;
        s = br.readLine().split("\\s");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
    }
}

