package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by bugkiller on 9/3/2017.
 */
public class Stone {

    static long[] a = new long[100000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n,k;
        String[] s;
        s = br.readLine().split("\\s");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        s = br.readLine().split("\\s");
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(s[i]);
        }

        System.out.println(solve(a, n, k));

    }

    private static String solve(long[] a, int n, int k) {

        int m=2;
        long MAX;
        StringBuilder sbr=new StringBuilder();
        if ((k&1)==1){
            m = 1;
        }
        if (k>0)
            for (int i = 0; i < m; i++) {
                MAX = Arrays.stream(a, 0, n).max().getAsLong();
                /*Arrays.stream(a, n, k).map((s) -> MAX - s);*/
                for (int j = 0; j < n; j++) {
                    a[j] = MAX - a[j];
                }
            }
        for (int i = 0; i < n; i++) {
            sbr.append(a[i]).append(" ");
        }
        sbr.deleteCharAt(sbr.length() - 1);
        return sbr.toString();
    }
}
