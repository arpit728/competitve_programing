package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by arpit on 23/4/17.
 */
public class BearAndXorOfSums {

    static byte a[]=new byte[300000];
    static int prefix[]=new int[300000];
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int t,n;
        String[]s;
        n = Integer.parseInt(br.readLine());
        s=br.readLine().split("\\s");
        for (int i = 0; i < n; i++) {
            a[i]=Byte.parseByte(s[i]);
        }

        System.out.println(solve(a,n));

    }

    private static int solve(byte[] a, int n) {
        calPrefix(a,n);

        /*for (int i = 0; i < n; i++) {
            System.out.print(prefix[i] + " ");
        }
        System.out.println();*/
        int result=0,diff,sum;
        for (int i = 0; i < n; i++) {
            diff=0;
            for (int j = 0; j <= i; j++) {
                sum = prefix[i]-diff;
                result ^= sum;
                diff = prefix[j];
            }
        }
        return result;
    }

    private static void calPrefix(byte[] a, int n) {

        prefix[0]=a[0];
        for (int i = 1; i <n; i++) {
            prefix[i] = prefix[i - 1] + a[i];
        }
    }
}
