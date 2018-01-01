package meetup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by bugkiller on 8/18/2017.
 */
public class DuplicateNo {

    static int a[] = new int[1000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        String[]s;
        n = Integer.parseInt(br.readLine());
        s = br.readLine().split("\\s");
        for (int i = 0; i <n; i++) {
            a[i]=Integer.parseInt(s[i]);
        }
        System.out.println(solve(a,n));
    }

    private static int solve(int[] a, int n) {
        Arrays.sort(a,0,n);

        if (n==1)
            return a[0];
        for (int i = 0; i < n - 1; i+=2) {
            if (a[i]!=a[i+1]){
                return a[i];
            }
        }
        return a[n-1];
    }
}
