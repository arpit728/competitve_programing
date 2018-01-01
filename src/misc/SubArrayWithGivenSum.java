package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by bugkiller on 9/12/2017.
 */
public class SubArrayWithGivenSum {

    static int[] a = new int[100];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t, n, sum;
        String[] s;
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            s = br.readLine().split("\\s");
            n= Integer.parseInt(s[0]);
            sum = Integer.parseInt(s[1]);

            s = br.readLine().split("\\s");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(s[i]);
            }
            System.out.println(solve(a, n,sum));
        }
    }

    private static String solve(int[] a, int n, int sum) {

        int sum_so_for = 0, start = 0, end = 0;
        StringBuilder sbr = new StringBuilder();

        while (start<= end) {

            if (sum_so_for == sum) {
                return sbr.append((start + 1)+" " + end).toString();
            }

            else if (start == 0 && end == n && sum_so_for < sum) {
                return sbr.append("-1").toString();
            }
            else if (sum_so_for > sum) {
                sum_so_for -= a[start];
                start++;
            }
            else {
                sum_so_for += a[end];
                end++;
            }

        }
        return "-1";
    }

}
