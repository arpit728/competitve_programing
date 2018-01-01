package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by arpit on 19/8/16.
 */
public class MaximumXorPrefixSuffix {

    static long prefix[]=new long[100002];
    static long suffix[]=new long[100002];
    static long a[]=new long[100001];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n;
        String[]s;

        n=Integer.parseInt(br.readLine());
        s=br.readLine().split("\\s");

        for (int i = 1; i <=n; i++)
            a[i]= Integer.parseInt(s[i-1]);

        System.out.println(solve(n));

        System.out.println(Arrays.toString(prefix));

        System.out.println(Arrays.toString(suffix));

    }


    private static long solve(int n) {

        for (int i =n; i>0; i--) suffix[i]=suffix[i+1]^a[i];

        for (int i = 1; i <=n ; i++) prefix[i]=prefix[i-1]^a[i];

        long result=0;

        for (int i = 0; i<=n; i++)
            for (int j = i + 1; j <= n + 1; j++)
                result = max(result, prefix[i] ^ suffix[j]);

        return result;
    }

    private static long max(long result, long l) {
        return result>l?result:l;
    }


}
