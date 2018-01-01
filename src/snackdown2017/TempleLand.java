package snackdown2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 21/5/17.
 */
public class TempleLand {

    static int[] a = new int[100];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s,n;
        String[]inp;
        s = Integer.parseInt(br.readLine());
        while (s-- > 0) {
            n = Integer.parseInt(br.readLine());
            inp = br.readLine().split("\\s");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inp[i]);
            }
            System.out.println(solve(a,n));
        }
    }

    private static String solve(int[] a, int n) {

        if (a[0] != 1 || a[n - 1] != 1 || n % 2 == 0) return "no";
        int mid = n / 2;

        for (int i = 0; i < n; i++) {

            if (i <= mid) {
                if (a[i] != i + 1) {
                    return "no";
                }
            }
            else {
                if (a[i] != n - i) {
                    return "no";
                }
            }
        }
        return "yes";
    }
}
