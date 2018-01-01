package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by hardCode on 3/3/2017.
 */
public class BearAndExtraNumber {

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
        Arrays.sort(a,0,n);
        if (a[1]-a[0]>1) return a[0];

        if (a[n-1]-a[n-2]>1)return a[n-1];

        for (int i =1; i < n; i++) {
            if (a[i]-a[i-1]==0)return a[i];
        }

        return 0;
    }

    private static void readArray(int[] a, int n) throws IOException {
        String[] s;
        s = br.readLine().split("\\s");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
    }
}
