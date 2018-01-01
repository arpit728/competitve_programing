package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 21/12/16.
 */
public class TrappingRainWater {

    static int a[]=new int[100];

    //left[i] stores the highest value to the left of i.
    //right[i] stores the highest value to the left of i.
    static int left[]=new int[100],right[]=new int[100];

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,n;
        String[]s;
        t=Integer.parseInt(br.readLine());
        while (t-->0){
            n=Integer.parseInt(br.readLine());
            s=br.readLine().split("\\s");
            for (int i = 0; i < n; i++) {
                a[i]=Integer.parseInt(s[i]);
            }
            System.out.println(maxWaterWithoutExtraSpace(a,n));
        }
    }

    private static int solve(int[] a, int n) {

        //return maxWater(a,n);
        return maxWaterOptimized(a,n);
    }

    static int maxWaterWithoutExtraSpace(int []a,int n){

        int  maxIndex=0,maxElement=0,maxLeft=0,totalWater=0,maxRight=0;
        for (int i = 0; i < n; i++) {
           if (a[i]>maxElement){
               maxIndex=i;
               maxElement=a[i];
           }
        }

        maxLeft=a[0];
        for (int i = 1; i <maxIndex ; i++) {
            maxLeft=Integer.max(a[i],maxLeft);
            totalWater+=Math.abs(Integer.min(maxLeft,maxElement)-a[i]);
        }

        maxRight=a[n-1];
        for (int i = n-2; i>maxIndex ; i--) {
            maxRight=Integer.max(maxRight,a[i]);
            totalWater+=Math.abs(Integer.min(maxRight,maxElement)-a[i]);
        }
        return totalWater;
    }

    private static int maxWaterOptimized(int[]a,int n){
        int ans=0;
        calLeft(a,n);
        calRight(a,n);

        for (int i = 1; i < (n - 1); i++) {
            int temp=Integer.min(left[i], right[i]);
            if (temp>a[i])
                ans+=temp-a[i];
        }
        return ans;
    }

    private static void calRight(int[] a, int n) {
        right[n-1]=0;
        for (int i=n-2;i>=0;i--){
            right[i]=Integer.max(right[i+1],a[i+1]);
        }
    }

    private static void calLeft(int[] a, int n) {
        left[0]=0;
        for (int i = 1; i < n; i++) {
            left[i]=Integer.max(left[i-1],a[i-1]);
        }
    }

    private static int maxWater(int[] a, int n) {

        int ans=0;
        for (int i = 1; i < n - 1; i++) {
            int l=findL(a,n,i),r=findR(a,n,i);
            int temp=Integer.min(l,r);
            System.out.println(l+" "+r+" "+temp);
            if (temp>a[i])
                ans+=temp-a[i];
        }
        return ans;
    }

    private static int findR(int[] a,int n,int i) {
        int big=0;
        for (int j =i+1; j <n; j++) {
            big=Integer.max(big,a[j]);
        }
        return big;
    }

    private static int findL(int[] a,int n,int i) {
        int big=0;
        for (int j =i-1; j>=0; j--) {
            big=Integer.max(big,a[j]);
        }
        return big;
    }
}
