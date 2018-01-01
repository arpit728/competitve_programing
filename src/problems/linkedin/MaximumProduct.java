package linkedin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by arpit on 11/11/16.
 */
public class MaximumProduct {

    public static final int MAX=100001, MAX1 =1000001;

    static int a[]=new int[MAX];

    static int freq[]=new int[MAX1];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int t,n;
        String s[];

        t= Integer.parseInt(br.readLine());
        while (t-->0){
            n=Integer.parseInt(br.readLine());
            s=br.readLine().split("\\s");

            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(s[i]);

            System.out.println(solve(n));
        }
    }

    private static long solve(int n) {

        for (int i = 0; i < n; i++) {
            freq[a[i]]++;
        }

        Arrays.sort(a,0,n);

        long max=0;
        for (int i = 0; i < n; i++) {
            if (freq[i] > 0)

            {
                for (int j = 2 * a[i]; j <= a[n - 1]; j += i)

                {
                    if (freq[j] > 0) {

                        int num = j / i;

                        if (num == i) {
                            if (freq[i] > 1) {
                                max = Long.max(j, max);
                            }

                            else if (freq[num] > 0) {
                                max = Long.max(j, max);
                            }
                        }
                    }
                }
            }
        }


        return max;
    }
}
