package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by bugkiller on 8/20/2017.
 */
public class ChefAndRainbowArray {

    static int a[]=new int[100];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int n;
        String[]s;
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            s = br.readLine().split("\\s");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(s[i]);
            }
            System.out.println(solve(a,n));
        }
    }

    private static String solve(int[] a, int n) {

        if (n%2==0) return "no";
        if (a[n/2]!=7)return "no";
        if (n<13) return "no";

        int k=1;
        for (int i = 0; i < n / 2; i++) {
            if (a[i]>7) return "no";
            if (a[i] == a[n - i-1]) {
                if (a[i]!=k && a[i]!=k+1)
                    return "no";
                if (a[i]==k+1)
                {
                    k++;
                }
            }
        }
        return "yes";
    }

}
