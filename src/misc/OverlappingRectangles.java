package misc;


/**
 * Created by arpit on 9/9/16.
 */

public class OverlappingRectangles {

    public static void main(String[] args) {

        int a[]={-4,1,2,6,0,-1,4,3};
        System.out.println(solve(a[0],a[1],a[2],a[3],a[4],a[5],a[6],a[7]));
    }

    private static int solve(int k, int l, int m, int n, int p, int q, int r, int s) {
        long area=((long)(m-k)*(n-l))+(r-p)*(s-q);

        if (area>Integer.MAX_VALUE)return -1;

        if ((q > n) || (l > s))return (int) area;
        if ((p > m) || (r < k))return (int) area;

        int left=Integer.max(k,p);
        int right=Integer.min(m,r);
        int top=Integer.min(n,s);
        int bottom=Integer.max(l,q);
        return (int)area-((right-left)*(top-bottom));
    }
}
