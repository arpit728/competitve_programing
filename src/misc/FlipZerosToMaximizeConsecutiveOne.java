package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by hardCode on 3/31/2017
 * problem link :- http://www.geeksforgeeks.org/find-zeroes-to-be-flipped-so-that-number-of-consecutive-1s-is-maximized/
 */
public class FlipZerosToMaximizeConsecutiveOne {


    static int  a[]=new int [100];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,n,m;
        String[]s;
        t=Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n=Integer.parseInt(br.readLine());
            s=br.readLine().split("\\s");
            m=Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i]=Integer.parseInt(s[i]);
            }
            System.out.println(solve1(a, n, m));
        }
    }

    static int solve1(int []a,int n,int m){

        int count=0,bestWindow=0,j;
        for (int i = 0; i < n; i++) {
            count =0;
            for (j = i; j < n && count<=m; j++)
            {
                if (a[j]==0)
                    count++;
            }
            if (count>m)j--;
            bestWindow=Integer.max(bestWindow,j-i);
            //System.out.println(bestWindow);
        }
        return bestWindow;
    }

    private static int solve(int[] a, int n,int m) {
        int r=0,l=0,zeros=0,bestWindowLength=0;

        while (r<n){
            if (zeros<=m)
            {
                if (a[r]==0)
                    zeros++;
                r++;
            }
            if (zeros>m){
                if (a[l]==0)
                    zeros--;
                l++;
            }

            bestWindowLength=Integer.max(bestWindowLength,r-l);
        }
        return bestWindowLength;
    }

}
