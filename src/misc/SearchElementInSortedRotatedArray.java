package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by hardCode on 4/11/2017.
 */
public class SearchElementInSortedRotatedArray {

    final static int MAX = 100000, M = 1000000007;
    static int[] a = new int[MAX];
    static BufferedReader br;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        int t, n,key;
        String[] s;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            readArray(a, n);
            key = Integer.parseInt(br.readLine());
            System.out.println(search(a,n,key));
        }
    }

    private static int search(int[] a, int n, int key) {

        int pivot=findPivot(a,n);
        if (pivot==-1)
            return binarySearch(a,0,n-1,key);
        int x;
        if ((x=binarySearch(a,0,pivot-1,key))>-1)
            return x;

        return binarySearch(a, pivot,n-1,key);
    }

    private static int binarySearch(int[] a, int start, int end, int key) {
        if (start<=end){
            int mid=(start+end)/2;
            if (a[mid]==key)
                return mid;

            if (a[mid]<key)
                return binarySearch(a,mid+1,end,key);

            return binarySearch(a,start,mid-1,key);
        }
        return -1;
    }

    private static int findPivot(int[] a, int n) {

        int start=0,end=n-1,mid;
        if (start==end)return start;

        while (start<end) {

            mid = (start + end) / 2;
            if (mid < end && a[mid] > a[mid + 1])
                return mid + 1;

            if (mid > start && a[mid - 1] > a[mid])
                return mid;

            if (a[mid] > a[start])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }

    private static void readArray(int[] a, int n) throws IOException {
        String[] s;
        s = br.readLine().split("\\s");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
    }
}
