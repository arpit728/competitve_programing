package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 15/5/17.
 */
public class FlippingCoins {

    static int MAX=400000;
    static int[]a=new int[100000],tree=new int[MAX];
    static boolean[]lazy=new boolean[MAX];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n,q;
        String[]s;
        s=br.readLine().split("\\s");
        n=Integer.parseInt(s[0]);
        q=Integer.parseInt(s[1]);

        int end= (int) Math.ceil(Math.log(n) / Math.log(2));
        end=(1<<end)-1;
        constructTree(0,0,end);
        for (int i = 0; i < q; i++) {
            s=br.readLine().split("\\s");
            int l=Integer.parseInt(s[1]);
            int r=Integer.parseInt(s[2]);
            if ("0".equals(s[0])){
                flipCoins(0,0,end,l,r);
            }
            else {
                System.out.println(queryHeads(0, 0, end, l, r));
            }
        }
    }

    private static int queryHeads(int node, int start, int end, int l, int r) {
        if (end<l || r<start)
            return 0;

        int left,right,mid;
        left=2*node+1;
        right=2*node+2;
        mid=(start+end)/2;
        if (lazy[node]){
            tree[node]=(end-start+1)-tree[node];
            if (start!=end){
                lazy[left]=true;
                lazy[right]=true;
            }
            lazy[node]=false;
        }

        if (start>=l && end<=r){
            return tree[node];
        }
        return queryHeads(left,start,mid,l,r)+queryHeads(right,mid+1,end,l,r);

    }

    private static void flipCoins(int node, int start, int end, int l, int r) {
        if (r < start || end < l) {
            return;
        }

        if (start==end){
            if (lazy[node]){
                tree[node]=(end-start+1)-tree[node];
                lazy[node]=false;
            }
            tree[node]=(end-start+1)-tree[node];

            return;
        }
        int left,right,mid;
        left=2*node+1;
        right=2*node+2;
        mid=(start+end)/2;

        if (lazy[node]){
            tree[node]=(end-start+1)-tree[node];
            lazy[left]=true;
            lazy[right]=true;
            lazy[node]=false;
        }
        if (start>=l && end<=r)
        {
            tree[node]=end-start+1-tree[node];
            lazy[left] = true;
            lazy[right]=true;
            return;
        }
        flipCoins(left,start,mid,l,r);
        flipCoins(right,mid+1,end,l,r);
        tree[node]=tree[left]+tree[right];
    }

    private static void constructTree(int node, int start, int end) {

        if (start==end){
            tree[node]=a[start];
            return;
        }
        int mid=(start+end)/2;
        constructTree(2*node+1,start,mid);
        constructTree(2*node+2,mid+1,end);
        tree[node]=tree[2*node+1]+tree[2*node+2];
    }
}
/*
4 7
1 0 3
0 1 2
1 0 1
1 0 0
0 0 3
1 0 3
1 3 3
*/
