package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * Created by arpit on 10/2/17.
 */
public class ChefAndTriangles {

    static int a[]=new int[100];
    static long ans;
    HashSet<Integer>set=new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n,l,r;
        String[]s;
        s=br.readLine().split("\\s");
        n=Integer.parseInt(s[0]);
        if (n>100){
            System.out.println(0);return;
        }
        l=Integer.parseInt(s[1]);
        r=Integer.parseInt(s[2]);
        s=br.readLine().split("\\s");
        for (int i = 0; i < n; i++) {
            a[i]=Integer.parseInt(s[i]);
        }
        System.out.println(solve(a,n,l,r));

    }

    private static long solve(int[] a, int n, int l, int r) {

        for (int i = 0; i <n-1; i++) {
            for (int j =i+1; j <n ; j++) {
                ans=0;
                binarySearch(a[i],a[j],l,r);
                
            }
        }
        return ans;
    }

    private static void binarySearch(long x, long y, long start, long end) {
        long mid=(start+end)/2;
        long a[]=new long[3];
        a[0]=x;
        a[1]=y;
        a[2]=mid;

        if (start<=end){
            if (a[0]+a[1]>a[2]){
                ans=mid;
                binarySearch(x,y,start,mid-1);
            }
            else binarySearch(x,y,mid+1,end);
        }
    }
}
