package algo.dp;

import java.util.Arrays;

/**
 * Created by arpit on 3/12/16.
 * Uber interview question.
 */

//Problem link:- http://blog.gainlo.co/index.php/2016/12/02/uber-interview-question-maximum-sum-non-adjacent-elements/?utm_source=email&utm_campaign=email&utm_medium=email
public class    MaxNonAdjacentSum {

    static int dp[]=new int[10];

    public static void main(String[] args) {

        int a[]=new int[]{5,  5, 10, 40, 50, 35};
        Arrays.fill(dp,Integer.MIN_VALUE);

        /*System.out.println(solve(a,5));
        System.out.println(maxSumTopDown(a,5));*/
        System.out.println(maxSumBottomUp(a, a.length));

    }

    private static int solve(int[] a, int n) {

        return maxSum(a, n);
    }


    //This is recursive(top down without memoization) implementation of maximum sum of non-adjacent elements problem.
    private static int maxSum(int[] a, int n) {

        if (n==0)return a[0];
        if (n==1)return Integer.max(a[0],a[1]);

        return Integer.max(maxSum(a, n-1),a[n-1] + maxSum(a,n-2));

    }

    //This is the memoized version of top down dp
    private static int maxSumTopDown(int[]a,int n){
        if (n==0)return a[0];
        if (n==1)return Integer.max(a[0],a[1]);

        if (dp[n-1]!=Integer.MIN_VALUE)return dp[n-1];

        return Integer.max(maxSumTopDown(a,n-1),a[n-1]+maxSumTopDown(a,n-2));
    }

    private static int maxSumBottomUp(int a[],int n){

        int excl=0,exclNew=0,incl=0;

        for (int i = 0; i < n; i++) {

            exclNew=incl;
            incl=Integer.max(excl+a[i],incl);
            excl=exclNew;
            System.out.println("incl = "+incl+" excl = "+excl);
        }
        //return Integer.max(incl,exclNew);
        return incl;
    }


}
