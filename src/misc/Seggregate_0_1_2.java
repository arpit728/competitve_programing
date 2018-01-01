package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by bugkiller on 9/13/2017.
 */
public class Seggregate_0_1_2 {

    static int[] a = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t, n, sum;
        String[] s;
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            n= Integer.parseInt(br.readLine());
            s = br.readLine().split("\\s");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(s[i]);
            }
            System.out.println(solve(a, n));
        }
    }

    private static String solve(int[] a, int n) {

        int i = 0, j = 0;
        StringBuilder sbr = new StringBuilder();

        //move all zeros in start
        for (;j<n;j++) {
            if (a[j] == 0) {
                swap(a, i, j);
                i++;
            }
        }

/*
        System.out.println(Arrays.toString(a)+" "+i+" "+j);
*/
        //move all twos in end.

        for (j=i;j<n;j++) {

            if (a[j] == 1) {
                swap(a, i, j);
                i++;
            }
        }
        for (int k = 0; k < n; k++) {
            sbr.append(a[k]).append(" ");
        }
        sbr.deleteCharAt(sbr.length() - 1);
        return sbr.toString();
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
