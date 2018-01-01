package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by hardCode on 2/26/2017.
 */
public class ZeroSumTriplet {

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
            solve(a,n);
        }
    }

    private static void solve(int[] a, int n) {

        Arrays.sort(a,0,n);
        for (int i = 0; i < n; i++) {
            int start=i+1,end=n-1;
            while (start < end) {
                if (a[start]+a[end]+a[i]==0)
                    System.out.println(a[i]+" "+a[start++]+" "+a[end--]);
                else if (a[start]+a[end]>-a[i])
                    end--;
                else
                    start++;
            }
        }
    }

    private static void readArray(int[] a, int n) throws IOException {
        String[] s;
        s = br.readLine().split("\\s");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
    }
}
