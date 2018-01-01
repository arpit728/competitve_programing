package linkedin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 1/11/16.
 */
public class DivisiblePairsSum {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n,k,a[]=new int[101];
        String s[];
        s=br.readLine().split("\\s");
        n=Integer.parseInt(s[0]);
        k=Integer.parseInt(s[1]);
        s=br.readLine().split("\\s");

        for (int i = 0; i < n; i++)
            a[i]=Integer.parseInt(s[i]);

        System.out.println(solve(a,n,k));


    }

    private static int solve(int[] a, int n, int k) {

        int sum=0,count=0;

        for (int i = 0; i < n; i++)

            for (int j = i + 1; j < n; j++) {
                sum = a[i] + a[j];

                if (sum % k == 0)
                    count++;
            }

        return count;
    }
}
