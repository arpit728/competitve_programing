package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by arpit on 26/12/16.
 */
public class NikitoshAndXor2{
    static final int MAX=400011;
    static int a[]=new int[MAX];
    static int maxPrefix[]=new int[MAX];
    static int maxSuffix[]=new int[MAX];
    static int t0[]=new int[10000000];
    static int t1[]=new int[10000000];
    static int idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        int n;
        String s[];
        n=Integer.parseInt(br.readLine());
        s=br.readLine().split("\\s");

        for (int i = 0; i < n; i++) {
            a[i]=Integer.parseInt(s[i]);
           /* maxPrefix[i]=xenny[i];
            maxSuffix[i]=xenny[i];*/
        }

        System.out.println(solve(n));
    }

    private static long solve(int n) {
        maxPrefix[0]=a[0];
        maxSuffix[n-1]=a[n-1];

        fillMaxPrefix(n);
        Arrays.fill(t0,0);
        Arrays.fill(t1,0);
        idx=0;
        fillMaxSuffix(n);
        long ans=Integer.MIN_VALUE;

        for (int i = 0; i < (n - 1); i++)
            ans = Long.max(ans, maxPrefix[i] + maxSuffix[i + 1]);

        return ans;
    }

    private static void fillMaxSuffix(int n) {
        int suff=a[n-1];
        insert(0);
        insert(a[n - 1]);
        for (int i = n-2; i>=0; i--) {
            suff^=a[i];
            maxSuffix[i]=Integer.max(maxSuffix[i + 1], query(suff));
            insert(suff);
        }
    }

    private static void fillMaxPrefix(int n) {
        int pre=a[0];
        insert(0);
        insert(a[0]);
        for (int i = 1; i < n; i++) {
            pre^=a[i];
            //System.out.println(prefixTrie.query(pre));
            maxPrefix[i]=Integer.max(maxPrefix[i-1],query(pre));
            insert(pre);
        }
    }

    private static int query(int pre) {

        int r=0,result=0;
        for (int i =31; i>=0; i--) {
            int currBit=0;
            if (((1<<i)&pre)>=1)currBit=1;

            if (currBit==1){
                if (t0[r]>0)r=t0[r];

                else if (t1[r]>0){
                    r=t1[r];
                    result+=(1<<i);
                }
            }
            else if (currBit==0){
                if (t1[r]>0){
                    result+=(1<<i);
                    r=t1[r];
                }
                else if (t0[r]>0)r=t0[r];
            }
        }
        return result^pre;
    }

    private static void insert(int key) {

        int r=0;
        for (int i =31  ; i>=0 ; i--) {
            int currBit=0;

            if (((1<<i)&key)>=1)
                currBit=1;

            if (currBit==1){
                if (t1[r]>0)r=t1[r];

                else {
                    idx++;
                    t1[r]=idx;
                    r=idx;
                }
            }
            else if (currBit==0){

                if (t0[r]>0)r=t0[r];
                else {
                    idx++;
                    t0[r]=idx;
                    r=idx;
                }
            }
        }
    }


}
