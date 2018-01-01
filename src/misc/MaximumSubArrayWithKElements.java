package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by hardCode on 2/28/2017.
 */
public class MaximumSubArrayWithKElements {


    public static void main(String[] args) throws IOException {

        int a[]={-1,-2, 5, -1, -1};
        int n=a.length;
        int k=3;
        System.out.println(solve(a,n, k));

    }

    private static int solve(int[] a, int n, int k) {
        convertArrayToPrefixSum(a,n);
        int max=a[k-1];
        for (int i =k; i <n ; i++) {
            max=Integer.max(a[i]-a[i-k],max);
        }
        return max;
    }

    private static void convertArrayToPrefixSum(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            a[i]+=a[i-1];
        }
    }
}
