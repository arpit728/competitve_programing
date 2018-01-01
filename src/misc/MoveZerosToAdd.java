package misc;

import java.util.Arrays;

/**
 * Created by arpit on 4/12/16.
 */
public class MoveZerosToAdd {

    public static void main(String[] args) {
        int a[]=new int[]{1,2,0,1,0,0,0,1};
        solve(a, a.length);
        System.out.println(Arrays.toString(a));
    }

    private static void solve(int[] a, int n) {

        //shiftZerosToRight(a,n);//O(N^2) Approach
        shiftZerosToRight1(a, n);

    }

    //This approach takes O(N) time but exploits the relative ordering of non-zero elements.
    private static void shiftZerosToRight1(int[] a, int n) {

        int start=0,end=n-1;
        while (start<end){
            if (a[start]>0){
                start++;
                continue;
            }
            if (a[end]==0){
                end--;
                continue;
            }
            swap(a,start,end);
        }
    }


    //This function takes O(N^2) time and also maintains the relative ordering of non-zero elements.
    static void shiftZerosToRight(int a[],int n){
        int i=0,zero;
        while (i<n)
        {
            if (a[i]==0){
                zero=i;
                i++;
                while (i<n && a[i]==0)i++;
                if (i<n && a[i]!=0){
                    swap(a,zero,i);
                    i=zero+1;
                }
            }
            while (i<n && a[i]!=0)i++;
        }
    }



    private static void swap(int[] a, int zero, int i) {
        int temp;
        temp=a[zero];
        a[zero]=a[i];
        a[i]=temp;
    }
}
