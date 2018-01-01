package misc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by hardCode on 2/14/2017.
 * problem link:-
 */
public class ThreeWayPartitioning {

    public static void main(String[] args) {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int low=4,high=7;
        int a[]={3,4,1,2,6,8,1,7,4,9,6,7,6,9,8};
        solve(a,a.length,low,high);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    private static void solve(int[] a, int n  , int low, int high) {

        int i=0,j=0;
        for (; j <n; j++) {
            if (a[j]<low){
                swap(a,i,j);
                i++;
            }
        }
        for (j=i;j<n; j++) {
            if (a[j]<=high){
                swap(a,i,j);
                i++;
            }
        }
    }
    static void swap(int[]a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
