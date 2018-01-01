package misc;

import java.util.Arrays;

/**
 * Created by hardCode on 8/27/2016.
 */
public class Segregate01 {

    public static void main(String[] args) {

        int a[]={1,0,1};
        int n=2;
        segregate(a,n);
        System.out.println(Arrays.toString(a));
    }

    private static void segregate(int[] a, int n) {
        int l=0,r=n-1;
        while (l<r){

            if (a[l]==1 && a[r]==0){
                a[l]=0;
                a[r]=1;
                l++;
                r--;
                continue;
            }
            if (a[l]==0)l++;
            if (a[r]==1)r--;
        }

    }
}
