package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 23/12/16.
 *
 * problem link:- http://www.geeksforgeeks.org/count-number-of-occurrences-in-a-sorted-array/
 */
public class OccurrencesInSortedArray {


    //This program counts the occurence of element k in the sorted array using binary search
    static int[]a=new int[300];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,n,k;
        t=Integer.parseInt(br.readLine());
        String[]s;
        while (t-->0){
            s=br.readLine().split("\\s");
            n=Integer.parseInt(s[0]);
            k=Integer.parseInt(s[1]);
            s=br.readLine().split("\\s");
            for (int i = 0; i < n; i++) {
                a[i]=Integer.parseInt(s[i]);
            }
            System.out.println(solve(a,n,k));
        }
    }

    private static int solve(int[] a, int n, int k) {

        int l=first(a,0,n-1,k);
        int r=last(a,0,n-1,k);

        if (l<0 || r<0)return -1;
        return r-l+1;
    }

    private static int last(int[] a, int start, int end, int k) {

        if (start<=end){
            int mid=(start+end)/2;
            if (mid==end && a[mid]==k)return mid;
            if (mid!=end && a[mid]<a[mid+1] && a[mid]==k)return mid;

            if (a[mid]<=k)return last(a,mid+1,end,k);

            return last(a,start,mid-1,k);
        }
        return -1;
    }

    private static int first(int[] a, int start, int end, int k) {

        int mid=(start+end)/2;
        if (start<=end){
            if (mid==0 && a[mid]==k)return mid;

            if (mid!=0 && a[mid]>a[mid-1] && a[mid]==k)return mid;

            if (a[mid]>=k)
                return first(a,start,mid-1,k);

            return first(a,mid+1,end,k);

        }
        return -1;
    }
}
