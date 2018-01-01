package hiringchallenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by arpit on 9/2/17.
 */

public class SumOfSumOfDigits {
    static final int MAX=100000;
    static long a[]=new long[MAX];
    static BufferedReader br;

    public static void main(String[] args) throws IOException {

        br=new BufferedReader(new InputStreamReader(System.in));
        int n,q;
        String[]s;
        s=br.readLine().split("\\s");
        n=Integer.parseInt(s[0]);
        q=Integer.parseInt(s[1]);
        s=br.readLine().split("\\s");
        for (int i = 0; i < n; i++) {
            a[i]=Long.parseLong(s[i]);
            a[i]=digitValue(a[i]);
        }
        solve(a,n,q);
    }

    private static void solve(long[] a, int n, int q) throws IOException {
        Arrays.sort(a,0,n);
        convertArrayToPrefixSum(a,n);
        String[]s;
        int k,type;
        StringBuilder sbr=new StringBuilder();
        for (int i = 0; i < q; i++) {
            s=br.readLine().split("\\s");
            type=Integer.parseInt(s[0]);
            k=Integer.parseInt(s[1]);
            if (type==1){
                if (n==k)sbr.append(a[n-1]+"\n");
                else sbr.append(a[n-1]-a[n-k-1]+"\n");
            }
            else {
                sbr.append(a[k-1]+"\n");
            }
        }
        System.out.println(sbr);
    }

    private static void convertArrayToPrefixSum(long[] a, int n) {
        for (int i = 1; i < n; i++) {
            a[i]+=a[i-1];
        }
    }

    private static long digitValue(long n) {

        if (n<10)return n;

        return digitValue(digitSum(n,0));
    }


    private static long digitSum(long n, int sum) {

        if (n==0)return sum;

        sum+=n%10;
        n/=10;

        return digitSum(n,sum);

    }
}
