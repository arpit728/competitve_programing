package problems.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Created by arpit on 19/5/17.
 */
public class HelpAshu {

    static int tree[]=new int[262145];
    static int a[]=new int[131073];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n,q,x,y,l,r,t,end;
        String[]s;
        n = Integer.parseInt(br.readLine());
        s = br.readLine().split("\\s");
        //Arrays.fill(a,-1);
        for (int i = 0; i < n; i++) {
            a[i]=Integer.parseInt(s[i]);
        }
        end = n;
        //end = (int) pow(2,Math.ceil(log(n) / log(2)));
        constructTree(0, 0, end);
        q=Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {

            s = br.readLine().split("\\s");
            if ("0".equals(s[0])) {
                x = Integer.parseInt(s[1])-1;
                y = Integer.parseInt(s[2]);
                update(0, 0, end, x, y);
            }
            else if ("1".equals(s[0])) {
                l = Integer.parseInt(s[1])-1;
                r = Integer.parseInt(s[2])-1;
                System.out.println(query(0, 0, end, l, r, 1));
            }
            else {
                l = Integer.parseInt(s[1])-1;
                r = Integer.parseInt(s[2])-1;
                System.out.println(query(0, 0, end, l, r, 2));
            }
        }
    }

    private static int query(int node, int start, int end, int l, int r, int type) {

        if (l > end || start > r) {
            return 0;
        }
        if (start == end) {
            if (type == 1) {
                return tree[node];
            }
            return 1 - tree[node];
        }
        if (start >= l && end <= r) {
            if (type == 1) {
                return tree[node];
            }
            else return (end - start + 1) - tree[node];

        }
        int mid = (start + end)/2;

        return query(2 * node + 1, start, mid, l, r, type) + query(2 * node + 2, mid + 1, end, l, r, type);
    }

    private static void update(int node, int start, int end, int x, int y) {

        if (start == end) {
            if (start==x) {

                if (y % 2 == 0) {
                    tree[node] = 1;
                } else
                    tree[node] = 0;
            }
            return;
        }
        int mid = (start + end)/2,left=2 * node + 1,right=2 * node + 2;
        if (x <= mid) {
            update(left, start, mid, x, y);
        }
        else update(right, mid + 1, end, x, y);
        tree[node] = tree[left] + tree[right];
    }

    private static void constructTree(int node, int start, int end) {
        if (start==end){
            if (a[start]%2==0 && a[start]>0){
                tree[node]=1;
            }
            return;
        }
        int mid = (start + end)/2,left=2 * node + 1,right=2 * node + 2;
        constructTree(2 * node + 1, start, mid);
        constructTree(2 * node + 2, mid+1, end);
        tree[node] = tree[left] + tree[right];

    }
}
