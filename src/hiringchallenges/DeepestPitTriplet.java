package hiringchallenges;

import java.util.Arrays;

/**
 * Created by hardCode on 3/6/2017.
 */
public class DeepestPitTriplet {

    static int inc[]=new int[1000000];
    static int dec[]=new int[1000000];
    public static void main(String[] args) {

        System.out.println(solution(new int[]{0, 1, 3, -2, 0, 1, 0, -3, 2, 3}));

    }
    public static int solution(int[] A) {
        int n=A.length;
        int ans=Integer.MIN_VALUE;
        if (n<3)return -1;
        boolean flag=false;
        Arrays.fill(inc,0,n,1);
        Arrays.fill(dec,0,n,1);
        calculateDecPrefix(A, n);
        calculateIncSuffix(A,n);

        for (int i = 0; i < n; i++) {
            if (inc[i]!=1 && dec[i]!=1){
                int left=A[i-dec[i]+1]-A[i];
                int right=A[i+inc[i]-1]-A[i];
                ans=Integer.max(ans,Integer.min(left,right));
                flag=true;
            }
        }
        if (!flag)return -1;
        return ans;
    }

    private static void calculateIncSuffix(int[] a, int n) {
        for (int i = n-2; i>=0 ; i--) {
            if (a[i]<a[i+1])
                dec[i]=dec[i+1]+1;
        }
    }

    private static void calculateDecPrefix(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            if (a[i-1]>a[i])
                inc[i]=inc[i-1]+1;
        }
    }
}
