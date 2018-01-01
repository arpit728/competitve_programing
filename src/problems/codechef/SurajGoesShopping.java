package problems.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by arpit on 10/1/17.
 */
public class SurajGoesShopping {

    static final int MAX=1001;
    static int a[]=new int[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,n;
        String[]s;
        t=Integer.parseInt(br.readLine());
        while (t-->0){
            n=Integer.parseInt(br.readLine());
            s=br.readLine().split("\\s");
            for (int i = 0; i < n; i++) {
                a[i+1]=Integer.parseInt(s[i]);
            }
            System.out.println(solve(a, n));
        }
    }

    private static int solve(int[] a, int n) {
        int ans=0;
        if (n==1)return a[1];
        Arrays.sort(a,0,n);
        for (int i = n; i>0 ; i-=4) {
            ans+=a[i]+a[i-1];
        }
        return ans;
    }
}
