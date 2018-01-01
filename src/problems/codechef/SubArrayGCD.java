package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by arpit on 12/1/17.
 */
public class SubArrayGCD {

    static int a[]=new int[100000];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,n;
        String[]s;
        t=Integer.parseInt(br.readLine());
        while (t-->0){
            n=Integer.parseInt(br.readLine());
            s=br.readLine().split("\\s");
            for (int i = 0; i < n; i++) {
                a[i]=Integer.parseInt(s[i]);
            }
            System.out.println(solve(a,n));
        }
    }

    private static int solve(int[] a, int n) {
        int ans=0;
        for (int i = 0; i < n; i++) {
            ans=binaryGCD(ans, a[i]);
        }

        if (ans==1)return n;
        return -1;
    }

    static int binaryGCD(int u,int v){

        if (u==v)return u;
        if (u==0)return v;
        if (v==0)return u;

        if ((u&1)==0 && (v&1)==0)return binaryGCD(u>>1,v>>1)<<1;

        if ((u&1)==0)return binaryGCD(u>>1,v);
        if ((v&1)==0)return binaryGCD(u,v>>1);
        if (u>v)return binaryGCD((u-v)>>1,v);

        return binaryGCD(u,(v-u)>>1);
    }
}
