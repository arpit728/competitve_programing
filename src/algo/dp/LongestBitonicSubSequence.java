package algo.dp;

import java.util.Arrays;

/**
 * Created by arpit on 6/12/16.
 */
public class LongestBitonicSubSequence {

    static int a[]={80, 60, 30, 40, 20, 10};
    static int lis[]=new int[a.length];
    static int lds[]=new int[a.length];

    public static void main(String[] args) {

        System.out.println(solve(a,a.length));
    }

    private static int solve(int[] a, int n) {

        Arrays.fill(lis,0,n,1);
        Arrays.fill(lds,0,n,1);
        calLIS(a,n);
        calLDS(a, n);

        return lbs(lis,lds,n);
    }

    private static int lbs(int[] lis, int[] lds, int n) {
        int lbsLength=0;

        for (int i = 0; i < n; i++) {
            lbsLength=Integer.max(lbsLength,lis[i]+lds[i]-1);
        }
        return lbsLength;
    }

    private static void calLDS(int[] a, int n) {

        for (int i = n-2; i>=0; i--) {
            for (int j =i+1; j<n ; j++) {
                if (a[i]>a[j])lds[i]=Integer.max(lds[i],lds[j]+1);
            }
        }
    }

    private static void calLIS(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            for (int j = i-1; j>=0 ; j--) {
                if (a[j]<a[i])lis[i]=Integer.max(lis[j]+1,lis[i]);
            }
        }
    }
}
