package meetup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by bugkiller on 8/19/2017.
 */
public class TripletProduct {

    static int[] a = new int[100000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[]s=br.readLine().split("\\s");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }

        System.out.println(solve(a,n));
    }

    private static int solve(int[] a, int n) {

        Arrays.sort(a, 0, n);

        return Integer.max(a[n-1]*a[n-1]*a[n-3],a[0]*a[1]*a[n-1]);
    }
}
